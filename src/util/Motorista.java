package util;

/*
 *	Classe que representa os motoristas
 */
public class Motorista {
	
	/*
	 *	ENUM com constantes definidas para realizar o algoritmo
	 *	
	 *	@Const CUSTOKMNORMAL : Custo dado a cada KM realizado pelo motorista
	 *	@Const CUSTOKMEXTRA : Custo dado a cada KM realizado pelo motorista quando este excede o máximo de distância permitido
	 *	@Comst DISTMAXTRABMOT :	Distância máxima em KM que o motorista pode executar sem que seja contado como extra.
	 */
	public static enum CONSTANTES{
		CUSTOKMNORMAL(1),
		CUSTOKMEXTRA(2),
		DISTMAXTRABMOT(90);
		
		public int VALOR;
		
		CONSTANTES(int nValor){
			this.VALOR=nValor;
		}
	}
	
	//Atributos
	private int indice;
	private int distPercorrida;
	
	/*
	 *	Descrição: Construtor da classe
	 *	
	 *	@params int : Indice do motoristas
	 */
	protected Motorista(int nIndice) {
		this.indice = nIndice;
		this.distPercorrida=0;
	}
	
	/*
	 *	Descrição: Método para ter acesso a distância percorrida pelo motorista
	 *	
	 *	@return int : Distância percorrida pelo motorista
	 */
	protected int getDistPercorrida() {
		return distPercorrida;
	}
	
	/*
	 *	Descrição: Método para mudar a distância percorrida pelo motorista
	 *	
	 *	@params int : Nova distância percorrida pelo motorista
	 */
	protected void setDistPercorrida(int distPercorrida) {
		this.distPercorrida = distPercorrida;
	}
	
	/*
	 *	Descrição: Método que retorna o índice do motorista
	 *
	 *	@return int : Indice do motorista
	 */
	protected int getIndice() {
		return indice;
	}
	
	/*
	 *	Descrição: Método que defini o custo para o motorista
	 *
	 *	@return int : Custo total do motorista 
	 */
	public int getCusto(){
		if(this.distPercorrida > Motorista.CONSTANTES.DISTMAXTRABMOT.VALOR){
			return Motorista.CONSTANTES.CUSTOKMNORMAL.VALOR * Motorista.CONSTANTES.DISTMAXTRABMOT.VALOR +
				   Motorista.CONSTANTES.CUSTOKMEXTRA.VALOR *(this.distPercorrida-Motorista.CONSTANTES.DISTMAXTRABMOT.VALOR);
		}else{
			return Motorista.CONSTANTES.CUSTOKMNORMAL.VALOR*this.distPercorrida;
		}
	}
	
}
