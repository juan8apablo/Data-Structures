package defaultP;

import java.io.*;

public class Main {
	static Lista sequences = new Lista();
	int max_ocurr = Integer.MIN_VALUE;
	String motif_ganador = "";
	
	
	
	public void compararMotif(String motif_candidato) {
		int counter = contarOcurr(motif_candidato);
		if(counter > max_ocurr) {
			max_ocurr = counter;
			motif_ganador = motif_candidato;
		}
	}
	
	public int contarOcurr(String motif_candidato) {
		int counter = 0;
		String gen_sequence;
		
		Sequence temp = sequences.cabeza;
		while (temp != null) {
			
			gen_sequence = temp.sequence;
			
			for (int i = 0; i <= (gen_sequence.length() - motif_candidato.length()); i++) {
				if 
				(gen_sequence.substring(i, i + motif_candidato.length()).equals(motif_candidato)) {
					counter += 1;
					i += motif_candidato.length() - 1;
				}
			}
			
			temp =temp.next;
		}
		return counter;
	}
	
	
	public void generateCombinations(String subsequence, int size) {
		if(size == 1) {
			compararMotif(subsequence + "A");
			compararMotif(subsequence + "C");
			compararMotif(subsequence + "G");
			compararMotif(subsequence + "T");
			
			
		}
		else{
			generateCombinations(subsequence + "A", size -1);
			generateCombinations(subsequence + "C", size -1);
			generateCombinations(subsequence + "G", size -1);
			generateCombinations(subsequence + "T", size -1);
		}
	}
	
	
	public void countChromosomes() throws IOException {
		int [] chromosomes = new int[23];
		String cromosoma;
		int index;
		Sequence temp = sequences.cabeza;
		while(temp != null) {
			
			if(temp.sequence.contains(motif_ganador)) {
				//chromosomes[Integer.parseInt(temp.chromosome.replace("chr", "")) -1] += 1;
				cromosoma = temp.chromosome;
				cromosoma.replace("chr", "");
				index = Integer.parseInt(cromosoma)-1;
				chromosomes[index] += 1;
			}
				
			
			temp = temp.next;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < 23; i++) {
			bw.write("Cromosoma "+ (i+1) + ": " + chromosomes[i] + "\n");
		}
		bw.flush();
		
	}
	
	public static void main(String[] args) {
		try
		{
			FileReader fr = new FileReader("archivo.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String input = br.readLine();
			while(input != null)
			{
				String[] data = input.split(",");
				sequences.insertarFinal(new Sequence(data[0],data[1],Integer.parseInt(data[2])
						,Integer.parseInt(data[3])));
				input = br.readLine();
			}
			//sequences.imprimirLista();
			run.generateCombinations("",4);
			System.out.println("Motif Ganador: " + run.motif_ganador + "\t Ocurrencias: " + run.max_ocurr);
			
			run.countChromosomes();
		}catch(IOException e){
			
		}
	}

}
