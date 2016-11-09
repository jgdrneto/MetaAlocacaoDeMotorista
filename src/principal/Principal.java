package principal;

import classes.AlgoritmoGenetico;
import util.Interpretador;

/*
 *	Descrição: Classe principal do projeto
 */
public class Principal {
	
	/*
	 *	Descrição: Método de inicio do programa
	 *
	 *	@params String[] : Vetor com os argumentos presentes no terminal na hora da execução
	 */
	public static void main(String[] args) {
		
		String[] argumentos = new String[3] ;
		
		argumentos[1] = "programa";
		argumentos[2] = "texte.txt";
		argumentos[3] = "teste2.txt";
		
		Interpretador interpretador = new Interpretador(argumentos[2]);
		
		AlgoritmoGenetico algoritmoG =  new AlgoritmoGenetico(interpretador.getGenes(), interpretador.getQuantCromossomos());
		
		//Iniciando algoritmo
		algoritmoG.executar();
		
	}

}
