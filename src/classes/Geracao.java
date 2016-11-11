package classes;

import java.util.ArrayList;
import java.util.List;

public class Geracao {
	
	/*
	 * Enum com as constantes necessárias para as constantes
	 */
	public static enum CONSTANTES{
		NUMESTAGNACAO(10),
		NUMINDIVIDUOS(50);
		
		public int VALOR;
		
		CONSTANTES(int nValor){
			this.VALOR=nValor;
		}
	}
	
	List<Individuo> individuos;					// Matriz com os indivíduos e seus cromossomos
		
	int numEstagnacao;							// Número máximo entre gerações em que não se tem um indivíduo melhor que o anterior
	
	int quantM;
	
	/*
	 * Construtor da classe de geração
	 * 
	 * @param List<Motorista> : Lista com os motoristas que devem realizar os percursos
	 * @param List<Percurso>  : Lista de percursos a serem realizados  
	 */
	public Geracao(int nMot, int nPerc) {
		
		//Criando a matriz em que o número de linhas são a quantidade de indivíduos na geração
		// e o número de colunas é os cromossomos de cada indivíduo.
		individuos =  new ArrayList<Individuo>();
		
		quantM = nMot;
		
		individuos = criarIndividuos();		
	}
	
	private List<Individuo> criarIndividuos() {
		
		return null;
	}

	/*
	 * Gera uma nova geração
	 */
	public void novaGeracao(){
		
	}
	
	/*
	 * Define se a geração está estagnada, ou seja, não se produz nenhuma solução melhor á n gerações.
	 * 
	 * @return boolean : True caso esteja estagnada e FALSE caso constrário.
	 */
	public boolean estagnada(){
		return numEstagnacao==Geracao.CONSTANTES.NUMESTAGNACAO.VALOR;
	}
	
	/*
	 * Retorna matriz com todos os individuos da geração
	 * 
	 * @return int [][] : Matriz com todos os individuos da geração
	 */
	public List<Individuo> getIndividuos(){
		return individuos;
	}
	
	/*
	 * Código do algoritmo genérico
	 * 
	 * @return List<Integer>: Lista com o melhor indivíduo encontrado
	 */
	public Individuo melhorIndividuo() {
		
		Individuo melhorInd = individuos.get(0);
		
		int custoMelhor =individuos.get(0).custo();
		int custoCandidato=0;
		for(Individuo i :individuos){
			
			custoCandidato = i.custo();
			
			if(custoCandidato<custoMelhor || (custoCandidato==custoMelhor && i.quantCromDistintos()<melhorInd.quantCromDistintos()) ){
				melhorInd = i;
				custoMelhor = i.custo();
			}
		}
		
		return melhorInd;
	}

	public void criarGeracao() {
		
	}
	
}
