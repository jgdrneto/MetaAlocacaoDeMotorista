package principal;

import java.util.ArrayList;
import java.util.List;

import classes.Gene;
import classes.Individuo;
import util.Algoritmo;

public class TESTE {

	public static void main(String[] args) {
				
		List<Gene> genes = new ArrayList<Gene>(); 
		
		genes.add(new Gene(80)); 
		genes.add(new Gene(50)); 
		genes.add(new Gene(80)); 
		genes.add(new Gene(40)); 
		genes.add(new Gene(30));
		genes.add(new Gene(20));
		genes.add(new Gene(70));
		
		Individuo ind = new Individuo(4,genes);
		
		//ind.getIdCs().add(1);
		//ind.getIdCs().add(1);
		
		Individuo indCompleto = Algoritmo.solucaoHeuristica(ind);
		
		System.out.println(indCompleto.toString());
		
	}

}
