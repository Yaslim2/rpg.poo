package rpg.utility;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Apagar {
	Carregar load = new Carregar();
	
	@SuppressWarnings("resource")
	public void apagarArquivo(String nome) {
		String arquivo = nome + ".txt";
		File arq = new File(arquivo);
		String listaPersonagens = "Lista de Personagens.txt";
		File lista = new File(listaPersonagens);
		if(load.personagensSalvos() != null) {
			if(arq.exists() && lista.length() > 0) {
				int pos = 0;
				try {
						List<String> personagens = load.personagensSalvos();
						for(int i = 0; i<personagens.size(); i++) {
							if(personagens.get(i).equals(nome)) {
								pos = i;
							}
						}

						personagens.remove(pos);
						
						FileWriter alimentarLista = new FileWriter(lista);
						Scanner s = new Scanner(lista);
						
						while(s.hasNextLine()) {
							alimentarLista.write("");
						}
						
						for(String p: personagens) {
							alimentarLista.write(p + "\n");
						}
		    
						alimentarLista.close();
						s.close();
						arq.delete();
						
						System.out.println("\nPersonagem deletado!!\n");
						System.out.println("Pressione ENTER para continuar...");
			            new java.util.Scanner(System.in).nextLine();
			            
				}
				catch(Exception e) {
					System.out.println("\nErro ao deletar personagem!\n");
					System.out.println("Pressione ENTER para continuar...");
		            new java.util.Scanner(System.in).nextLine();
				}
			} else {
				System.out.println("\nNão existe personagens para deletar!!!\n");
				System.out.println("Pressione ENTER para continuar...");
	            new java.util.Scanner(System.in).nextLine();
			}
		}
	}
		
	
	@SuppressWarnings("resource")
	public String pegarNome() {
		String listaPersonagens = "Lista de Personagens.txt";
    	File lista = new File(listaPersonagens);
    	int pers;
    	if(lista.exists() && lista.length() > 0) {
    		try {
        		Scanner ler = new Scanner(System.in);
        		List <String> nomesPersonagens = new ArrayList<>();
        		String aux;
    			Scanner s = new Scanner(lista);
    			int cond = 1;
    			while(s.hasNextLine()) {
    				aux = s.nextLine();
    				System.out.println(cond + " - " + aux);
    				nomesPersonagens.add(aux);
    				cond += 1;
    			}
    			System.out.print("\nSelecione qual personagem você deseja excluir com base nos números: ");
    			pers = ler.nextInt();
    			String name = nomesPersonagens.get(pers-1);
    			return name;
        	}
        	catch(Exception e) {
        		System.out.println("\nErro ao carregar personagem!\n");
                System.out.println("Pressione ENTER para continuar...");
                new java.util.Scanner(System.in).nextLine();
        	}
    	} 
		return null;
	}
}
