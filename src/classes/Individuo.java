package classes;

import java.util.ArrayList;
import java.util.List;

public class Individuo {
	
	private List<Integer> idCs;				//Conjunto de indíces dos cromossomos cromossomos
	private List<Gene> genes;				//Lista dos genes que o individuo completo deve ter
	private int quantCromossomo;			//Quantidade de cromossomos distintos no indivíduo
	
	/*
	 *	Descrição			: Construtor da classe
	 *	
	 *	@param int			: Quantidade de cromossomos distintos permitidos no indivíduos	  
	 */
	public Individuo(int quantCromossomos, List<Gene> nGenes){
		idCs = new ArrayList<Integer>(nGenes.size());
		this.quantCromossomo = quantCromossomos;
		this.genes = nGenes;
		
	}
	
	/*
	 *	Descrição			: Construtor da classe (cópia)
	 *	
	 *	@param Individuo	: Individuo base para se obter as informações do novo indivíduo  
	 */
	public Individuo(Individuo ind){
		this.quantCromossomo = ind.quantCromossomo;
		idCs =  new ArrayList<Integer>(ind.idCs);
		genes = ind.genes;
	}
	
	/*
	 *	Descrição				: Método que retorna a lista dos cromossomos do indivíduo
	 *	
	 *	@return List<Integer>	: Lista com os indices dos cromossomos do indivíduo
	 */
	public List<Integer> getIdCs() {
		return idCs;
	}
	
	/*
	 *	Descrição					: Adiciona as cargas genéticas dos cromossomos de acordo com os cromossomos do indivíduo
	 *
	 *	@return List<Cromossomo>	: Lista com os cromossomos distintos com as suas respectivas cargas genéticas modifcadas
	 */
	
	public List<Gene> getGenes() {
		return genes;
	}

	public int getQuantCromossomo() {
		return quantCromossomo;
	}

	public List<Cromossomo> getCargaGenetica(){
		
		List<Cromossomo> cromossomos = criarListaCromossomos();
		
		//Percorrendo todos os cromossomos no indivíduo e preenchendo com as cargas genéticas
		for(int i=0;i<this.idCs.size();i++){
			
			//Adicionando carga genética aos cromossomos de mesmo indíces
			cromossomos.get(this.getIdCs().get(i)).addCargaGenetica(genes.get(i).getNumNucleotideos());
		}
			
		return cromossomos;
	}
	
	/*
	 *	Descrição				: Método que cria a quantidade de cromossomos
	 *
	 *	@return List<Cromossomo>: Lista com todos as opções de cromossomos possíveis 	
	 */
	public  List<Cromossomo> criarListaCromossomos(){
		
		//Criando lista
		List<Cromossomo> lista = new ArrayList<Cromossomo>();
		
		//Criando cada cromosssomo com seu respectivo indice
		for(int i=0;i<quantCromossomo;i++){
			lista.add(new Cromossomo(i,0));
		}
		
		return lista;
		
	}
	
	/*
	 *	Descrição		: Sobrecarga do método toString();
	 * 	
	 * 	@return String	: String representadno o objeto 
	 */
	@Override
	public String toString() {
		
		return "Individuo : " + idCs + " Custo: " + custo() + ";";
		
	}
	
	/*
	 *	Descrição			: Calculando custo do indivíduo
	 *
	 * 	@return int			: String representadno o objeto 
	 */
	public int custo(){
		
		//Variável que guardará o custo
		int custo=0;
		
		//Lista com a carga genética de cada cromossomo
		List<Cromossomo> cromossomos = getCargaGenetica();
		
		//Somando o custo da carga genética de cada cromossomo
		for(Cromossomo c : cromossomos){
			custo+=c.getCusto();
		}
		
		//Retornando valor do custo
		return custo;
		 
	}
	
}
