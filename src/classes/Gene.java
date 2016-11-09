package classes;

import util.Percurso;

public class Gene extends Percurso{
	
	/*
	 *	Descrição			: Construtor da classe
	 *	
	 *	@param int			: Quantidade de nucleotídeos que tem o gene  
	 */
	public Gene(int nucleotideos) {
		super(nucleotideos);
	}
	
	/*
	 *	Descrição			: Método que retorna a quantidade de nucleotídeos do gene
	 *	
	 *	@return int			: Quantidade de nucleotídeos do gene
	 */
	public int getNumNucleotideos(){
		return getDistancia();
	}
	
	/*
	 *	Descrição		: Sobrecarga do método toString();
	 * 	
	 * 	@return String	: String representadno o objeto 
	 */
	@Override
	public String toString() {
		
		return "Número de Nucledtídeos : " + super.getDistancia();
		
	}
	
}
