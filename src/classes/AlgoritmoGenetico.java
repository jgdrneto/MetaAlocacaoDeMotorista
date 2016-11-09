package classes;

import java.util.ArrayList;
import java.util.List;

import util.Algoritmo;

public class AlgoritmoGenetico{
	
	Geracao geracao;							//Geracao de individuos
	
	protected List<Gene> genes;					//Lista com os genes a serem colocados nos cromossomos
	protected int quantCromossomos;				//Quantidade de cromossosmos distintos que o indivíduo pode ter
	protected Individuo solucaoHeuristica;		//Solução encontrada pelo método heurístico
	/*
	 * Construtor da classe
	 */
	public AlgoritmoGenetico(List<Gene>  genes, int quantCrom) {
		//Iniciando atributos
		genes = new ArrayList<Gene>(genes);
		quantCromossomos=quantCrom;
		
	}
	
	/*
	 *	Descrição: Método para execução principal do algoritmo
	 */
	public void executar() {
		
		//-------------------------------------------------------------------------
		
		//Área para execução principal do algoritmo
		
		//-------------------------------------------------------------------------
		System.out.println("Instâncias");
		System.out.println("--------------------------------------------");
		
		System.out.println("Quantidade de motoristas: "+ quantCromossomos);
		System.out.println("Quantidade de percursos: "+ genes.size());
		System.out.println("Percursos : " + genes);
		
		System.out.println("--------------------------------------------");
		
		System.out.println("Soluções");
		
		System.out.println("--------------------------------------------");
		
		//Definindo tempo de execução
		
		//Tempo de inicio de execução da heurística
 		long inicio = System.currentTimeMillis();
		
		//Realizar método que retorna uma boa solução(nem sempre a melhor) para o problema.
		solucaoHeuristica = Algoritmo.solucaoHeuristica(new Individuo(quantCromossomos, genes));
		
		//Tempo total de execução da heurística
		long tempoExecucao = System.currentTimeMillis() - inicio;
		
		//Imprimindo uma solução boa para o problema com as instâncias informadas
		System.out.println("Solução Boa: " + solucaoHeuristica.toString() + " Custo: " + solucaoHeuristica.custo()) ;
		
		System.out.println("Tempo de execução em milisegundos: " + tempoExecucao);
		
		System.out.println("--------------------------------------------");
		
		//Tempo de inicio de execução da solução ótima
 		inicio = System.currentTimeMillis();
 		
 		//Algoritmo metaheurístico para tentar encontrar a melhor solução
 		Individuo  solucaoMetaheuristica = algoritmoGenetico();
 		 		
 		//Tempo total de execução da solução ótima
 		tempoExecucao = System.currentTimeMillis() - inicio;
 			
 		//Imprimindo a solução encontrada na busca tabu
		System.out.println("Solução encontrada na metaheurística: " + solucaoMetaheuristica.toString() + " Custo: " + solucaoMetaheuristica.custo()) ;
 		
 		System.out.println("Tempo de execução em milisegundos: " + tempoExecucao);

		System.out.println("--------------------------------------------");
	}
	
	/*
	 * Código do algoritmo genérico
	 * 
	 * @return List<Integer>: Lista com o melhor indivíduo encontrado
	 */
	private Individuo algoritmoGenetico() {
		
		//Condição para criar novas gerações
		while(!geracao.estagnada()){
			
			//Criando uma nova geração
			geracao.novaGeracao();
		}
		
		//Retorna o melhor indivíduo da geração estagnada
		return melhorIndividuo(geracao);
	}

	private Individuo melhorIndividuo(Geracao geracao) {
		
		Individuo lista = geracao.getIndividuos().get(0);
		
		for(int l=0;l<Geracao.CONSTANTES.NUMINDIVIDUOS.VALOR;l++){
			for(int c=0;c<10;c++){
					
			}
		}
		
		return lista;
	}
	
}
