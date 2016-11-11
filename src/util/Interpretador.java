package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import classes.Gene;

public class Interpretador {
	
	List<Gene> genes;				//Lista com os genes a serem usados
	int quantCromossomos;			//Quantidade de cromossomos distintos que podem ter no máximo em cada indivíduo
	
	/*
	 *	Descrição		: Construtor da classe
	 *	
	 *	@param String	: String com o caminho do arquivo a ser aberto
	 */
	public Interpretador(String arq) {
		
		//Criando o arquivo
		File arquivo = new File(arq);
		
		List<String> valores = new ArrayList<String>();
		
		//Tratamento de erros na abertura de arquivo
		if(possivelInterpretar(arquivo) && analiseSintatica(arquivo, valores)){
			
			interpretarArquivo(valores);
			
		}else{
			System.exit(0);
		}
	}
	/*
	 *	Descrição			: Método que interpreta as string do arquivo
	 *
	 *	@param List<String>	: Lista com as string com as instâncias obtidas do arquivo	
	 */
	private void interpretarArquivo(List<String> valores) {
		
		//Criando lista com as instâncias
		List<Integer> instancias = analiseSemantica(valores);
		
		//Criando lista de genes
		genes = new ArrayList<Gene>(valores.size()-1);
		
		//Definindo quantidade de cromossomos
		this.quantCromossomos = instancias.get(0);
		
		//
		for(int i=1;i<instancias.size();i++){
			genes.add(new Gene(instancias.get(i)));
		}
		
	}
	
	/*
	 *	Descrição				: Método para trasnformar as informações obtidas de String para inteiros 
	 *	
	 *	@param List<String>		: Lista com as string das linhas obtidas do arquivo
	 *
	 *	@return List<Integer> 	: Lista com as instâncias que serão usadas no problema	
	 */
	private List<Integer> analiseSemantica(List<String> valores) {
		
		//Lista com as instâncias a serem usadas no problema
		List<Integer> instancias = new ArrayList<Integer>(valores.size());
		
		//Booleano para se ter apenas um valor da quantidade de motorista
		boolean numMotorista=false;
		
		//Interando em cada string
		for(String s : valores){
			//Se a opção for de motoristas
			if(s.contains("Motoristas: ") && !numMotorista){
				//Adicionando valor do arquivo
				instancias.add(new Integer(s.substring("Motoristas: ".length())));
				
				//Setando para verdadeiro que já se tem o número de motoristas
				numMotorista=true;
				
			}else{
				//Se a opção for de motoristas
				if(s.contains("Percurso: ")){
					//Adicionando valor do arquivo
					instancias.add(new Integer(s.substring("Percurso: ".length())));
				}else{
					//Caso a string não atenda as condições acimas
					System.out.println("ERRO FATAL: Arquivo com string não permitidas");
					System.exit(0);
				}
			}
		}
		
		return instancias;
	}

	/*
	 *	Descrição		: Método para comunicar o usuário o erro, caso ocorra, ao abrir o arquivo.
	 *	
	 *	@param File		: Arquivo para ser verificado se vai ser possível interpretar o arquivo 
	 */
	private boolean possivelInterpretar(File arquivo) {
		
		//Verifica se o arquivo existe
		if(!arquivo.exists()){
			System.out.println("ERRO FATAL: Arquivo de instâncias não encontrado");
			return false;
		}else{
			//Verificar se o arquivo pode ser lido
			if(!arquivo.canRead()){
				System.out.println("ERRO FATAL: Caminho especificado não permite leitura");
				return false;
			}else{
				//Verifica se o arquivo é um diretório
				if(arquivo.isDirectory()){
					System.out.println("ERRO FATAL: Caminho especificado é de um diretório");
					return false;
				}
			}
		}
		
		return true;
	
	}
	
	/*
	 *	Descrição			: Método que faz a análise sintática
	 *
	 *	@param File			: Arquivo a ser análisado
	 *	@param List<String> : Lista em que seram colocados as string obtidas no arquivo
	 */
	public boolean analiseSintatica(File arquivo, List<String> valores){

		//Tentando ler o arquivo
		try {
			//Abrindo canal de comunicação para leitura do arquivo
			BufferedReader arquivoLeitura = new BufferedReader(new FileReader(arquivo));
			
			String s;
			
			//Enquanto não tiver no final
			while(arquivoLeitura.ready()){
				
				//Ler a string da linha
				s = arquivoLeitura.readLine();
				
				//Se a linha não for vazia adiciona string correspondente na lista de string
				if(!s.equals("")){
					valores.add(s);
				}
				
			}
			
			//Fechando canal de comunicação
			arquivoLeitura.close();
			
			//Verificando se o arquivo tem alguma string
			if(!valores.isEmpty()){
				return true;
			}else{
				return false;
			}
			
		} catch (IOException e) {
			return false;
		}
		
	} 
	
	public List<Gene> getGenes() {
		return new ArrayList<Gene>(genes);
	}

	public int getQuantCromossomos() {
		return quantCromossomos;
	}

}
