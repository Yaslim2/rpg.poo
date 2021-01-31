package rpg.utility;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Apagar {
	// instanciando um atributo do tipo Carregar para utilizar durante o metodo de apagar o arquivo.
	private Carregar load = new Carregar();
	
	@SuppressWarnings("resource")
	// será passado como metodo o nome de um personagem e esse será excluido, tanto seu arquivo com seus atributos, tanto quanto seu nome na lista de personagens.
	public void apagarArquivo(String nome) {
		String arquivo = nome + ".txt";
		File arq = new File(arquivo);
		String listaPersonagens = "Lista de Personagens.txt";
		File lista = new File(listaPersonagens);
		// verificando a existencia de personagens salvos para realizar a açao
		if(load.personagensSalvos() != null) {
			// verificando a existencia do arquivo com o nome do personagem, e verificando se existe algo na lista de personagens
			if(arq.exists() && lista.length() > 0) {
				int pos = 0;
				try {
						// instanciando uma lista para os personagens salvos, e apos isso atribuindo a variavel pos, a posiçao do nome que sera retirado
						List<String> personagens = load.personagensSalvos();
						for(int i = 0; i<personagens.size(); i++) {
							if(personagens.get(i).equals(nome)) {
								pos = i;
							}
						}

						personagens.remove(pos);
						
						FileWriter alimentarLista = new FileWriter(lista);
						Scanner s = new Scanner(lista);
						
						// limpando o arquivo lista de personagens
						while(s.hasNextLine()) {
							alimentarLista.write("");
						}
						
						// reescrevendo o arquivo lista de personagens com os personagens remanescentes
						for(String p: personagens) {
							alimentarLista.write(p + "\n");
						}
		    
						alimentarLista.close();
						s.close();
						arq.delete();
						
						System.out.println("\nPersonagem deletado!\n");
						System.out.println("Pressione ENTER para continuar...");
			            new java.util.Scanner(System.in).nextLine();
			            
				}
				catch(Exception e) {
					System.out.println("\nErro ao deletar personagem!\n");
					System.out.println("Pressione ENTER para continuar...");
		            new java.util.Scanner(System.in).nextLine();
				}
			} else {
				System.out.println("\nNao existe personagens para deletar!!!\n");
				System.out.println("Pressione ENTER para continuar...");
	            new java.util.Scanner(System.in).nextLine();
			}
		}
	}
		
	
	@SuppressWarnings("resource")
	// Iremos acessar o arquivo ja criado "Lista de Personagens.txt" e iremos listar todos os nomes, para que o usuário possa escolher qual personagem sera apagado
	public String pegarNome() {
		String listaPersonagens = "Lista de Personagens.txt";
    	File lista = new File(listaPersonagens);
    	int pers;
    	// Verificando se a lista existe, e se existir se ela contem algo escrito nela, que seria o nome de algum personagem.
    	if(lista.exists() && lista.length() > 0) {
    		try {
    			// utilizando stringbuilder para reexibir os dados na tela, caso o usuario digite algum número inesperado.
    			StringBuilder sb = new StringBuilder();
        		Scanner ler = new Scanner(System.in);
        		List <String> nomesPersonagens = new ArrayList<>();
        		String aux;
    			Scanner s = new Scanner(lista);
    			int cond = 1;
    			System.out.println("\n----------------------------------------\n");
    			while(s.hasNextLine()) {
    				aux = s.nextLine();
    				System.out.println(cond + " - " + aux);
    				sb.append(cond + " - " + aux + "\n");
    				nomesPersonagens.add(aux);
    				cond += 1;
    			}
    			System.out.println("\n----------------------------------------\n");
    			System.out.print("\nSelecione qual personagem voce deseja excluir com base nos numeros: ");
    			pers = ler.nextInt();
    			while(true) {
    				if((pers-1) < 0 || (pers-1) > nomesPersonagens.size()) {
    					System.out.println("\nValor invalido. Digite um valor valido!\n");
    					System.out.println("\n----------------------------------------\n");
    					System.out.println(sb.toString());
    					System.out.println("----------------------------------------\n");
    	    			System.out.print("\nSelecione qual personagem você deseja excluir com base nos numeros: ");
    	    			pers = ler.nextInt();
    				} else {
    					break;
    				}
    			}
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
