package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import classes.Gene;

public class Interpretador {
	
	List<Gene> genes;
	int quantCromossomos;
	
	public Interpretador(String arq) {
		
		File arquivo = new File(arq);
		
		tratamentoDeErros(arquivo);
		
	}
	
	private void tratamentoDeErros(File arquivo) {
		
		if(!arquivo.exists()){
			System.out.println("ERRO FATAL: Arquivo de instâncias não encontrado");
			System.exit(0);
		}
		
		if(arquivo.isDirectory()){
			System.out.println("ERRO FATAL: Caminho especificado é de um diretório");
			System.exit(0);
		}
		
		if(arquivo.canRead()){
			System.out.println("ERRO FATAL: Caminho especificado não permite leitura");
			System.exit(0);
		}
		
	}

	public List<Gene> getGenes() {
		return new ArrayList<Gene>(genes);
	}

	public int getQuantCromossomos() {
		return quantCromossomos;
	}

}
