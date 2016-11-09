package classes;

import util.Motorista;

public class Cromossomo extends Motorista{
	
	/*
	 *	Descrição			: Construtor da classe
	 *	
	 *	@param int			: Indice de indentificação do cromossomo
	 *	@param int			: Quanitdade de genes presente no cromossomo	  
	 */
	public Cromossomo(int nIndice, int genes) {
		super(nIndice);
		setDistPercorrida(genes);
	}
	
	/*
	 *	Descrição			: Método que retorna o indice do cromossomo
	 *	
	 *	@return int			: Indice do cromossomo
	 */
	public Integer getIndiceCromossomo(){
		return super.getIndice();
	}
	
	/*
	 *	Descrição			: Método que retorna o indice do cromossomo
	 *	
	 *	@param int			: Indice do cromossomo
	 */
	public void setCargaGenetica(int valor){
		setDistPercorrida(valor);
	}
	
	/*
	 *	Descrição			: Método que adiciona carga genética ao cromossomo
	 *	
	 *	@param int			: Valor a ser adiciona no cromossomo
	 */
	public void addCargaGenetica(int valor){
		setDistPercorrida(getDistPercorrida() + valor);
	}

	/*
	 *	Descrição			: Método que retorna a carga genética do cromossomo
	 *	
	 *	@return int			: Valor de nucleotídeos presentes no cromossomo
	 */
	public int getCargaGenetica(){
		return super.getDistPercorrida();
	}
	
	/*
	 *	Descrição		: Sobrecarga do método toString();
	 * 	
	 * 	@return String	: String representadno o objeto 
	 */
	@Override
	public String toString() {
		return "[" + super.getIndice() + " : " + super.getDistPercorrida() + " ]";
	} 
	
}
