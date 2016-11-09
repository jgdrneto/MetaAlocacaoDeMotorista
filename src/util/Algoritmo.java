package util;

import java.util.ArrayList;
import java.util.List;

import classes.Cromossomo;
import classes.Gene;
import classes.Individuo;

public class Algoritmo {
	
	/*
	 *	Descrição			: Algoritmo para encontrar uma solução muito boa para o problema
	 *	
	 *	@param Individuo	: Individuo que se deseja completar para obter 
	 *	@param int			: Quantidade de cromossomos existentes
	 *	@param List<Genes>	: Lista com os genes a serem colocados nos cromossomos 	
	 *
	 *	@return Individuo	: Individuo com todos os cromossomos
	 */
	public static Individuo solucaoHeuristica(Individuo ind){

		//Lista que será retornada com a solução
		Individuo individuo = new Individuo(ind);
				
		//Lista de precedência(	Quanto menor o valor, maior a precedência)
		List<Double> precedencia;
		
		//Adiciona a carga genética aos cromossomos
		List<Cromossomo> cromossomos = individuo.getCargaGenetica(); 

		//Enquanto eu não obter uma solução 
		while(individuo.getIdCs().size() !=individuo.getGenes().size()){
			
			//Verifica a precedência dos candidatos a realizar o percurso
			precedencia = denotarPrecedencia(cromossomos,individuo.getGenes().get(individuo.getIdCs().size()));
			
			int id = encontrarIndiceComMenorValor(precedencia);
			
			//Adiciona o cromossomo ao indivíduo
			individuo.getIdCs().add(id);
			
			//Atualiza a lista de cromossomos com a nova carga genética
			cromossomos.get(id).addCargaGenetica(individuo.getGenes().get(individuo.getIdCs().size()-1).getNumNucleotideos());
			
		}
		
		return individuo;
	}
	
	/*
	 *	Descrição			: Algoritmo para encontrar o indice do cromossomo com o menor valor (Maior precedência)
	 *
	 *	@param List<Double> : Lista com as precedências de cada cromossomo
	 *
	 *	@return int 		: Indice do cromossomo que tem maior precedência (menor valor na lista de entrada)
	 */
	private static int encontrarIndiceComMenorValor(List<Double> precedencia) {
		
		//Iniciando variáveis
		double valor=Double.MAX_VALUE;
		int indice=-1;
		
		//Encontrando o indice de maior precedência
		for(int i=0;i<precedencia.size();i++){
			if(precedencia.get(i)<valor){
				valor = precedencia.get(i);
				indice = i;
			}
		}
		
		return indice;
	}
	
	/*
	 *	Descrição:
	 *
	 *	@param List<Cromossomo>	: Lista com todos os tipos de cromossomos possíveis
	 *	@param Gene				: Gene a ser colocado em um dos cromossomos 
	 *
	 *	@return List<Double>	: As precedências de cada cromossomo para receber o gene
	 */
	private static List<Double> denotarPrecedencia(List<Cromossomo> cromossomos, Gene gene) {
		
		//Lista com as precedencias de cada motorista para receber o percurso
		List<Double> precedencia = new ArrayList<Double>(cromossomos.size());
		
		//Verifica para cada motorista
		for(Cromossomo c : cromossomos){

			//Se a distancia do percurso + a distância já feita pelo motorista dê igual a quantidade de distância máxima sem custos extras, esse motorista tem precedência em relação aos outros
			if(c.getCargaGenetica()+gene.getNumNucleotideos() == Motorista.CONSTANTES.DISTMAXTRABMOT.VALOR){
				precedencia.add(0.0);
			}else{
				//Valores significa o quanto falta/excede para o motorista percorrer a distância máxima 
				precedencia.add((double)(c.getCargaGenetica()+gene.getNumNucleotideos())/Motorista.CONSTANTES.DISTMAXTRABMOT.VALOR);
			}
		}
			
		//Retornando precedencia (Neste caso, maior precedencia é definida pelo menor valor)
		return precedencia;
	}
	
}
