package rpg.utility;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import rpg.personagens.Assassino;
import rpg.personagens.Lutador;
import rpg.personagens.Mago;
import rpg.personagens.Personagem;
import rpg.personagens.Tanque;

public class Editar {
	Carregar load = new Carregar();
	Salvar save = new Salvar();
	
	@SuppressWarnings("resource")
	public Personagem pegarPersonagem() {
		String listaPersonagens = "C:\\Users\\T-Gamer\\Desktop\\Yaslim\\Arquivos - POO\\" + "Lista de Personagens.txt";
    	File lista = new File(listaPersonagens);
    	if(lista.exists() && lista.length() > 0) {
    		try {
        		Scanner ler = new Scanner(System.in);
        		Personagem p;
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
    			System.out.print("\nSelecione qual personagem você deseja editar com base nos números: ");
    			int pers = ler.nextInt();
    			String name = nomesPersonagens.get(pers-1);
    			p = load.load(name);
    			return p;
    		}
        	catch(Exception e) {
        		System.out.println("\nErro ao editar personagem!\n");
                System.out.println("Pressione ENTER para continuar...");
                new java.util.Scanner(System.in).nextLine();
        	}
    	} 
		return null;
	}
	@SuppressWarnings("resource")
	public Personagem editarPersonagem(Personagem P) {
		String listaPersonagens = "C:\\Users\\T-Gamer\\Desktop\\Yaslim\\Arquivos - POO\\" + "Lista de Personagens.txt";
		File lista = new File(listaPersonagens);
		if(load.personagensSalvos() != null) {
			if(lista.exists() && lista.length() > 0) {
				if(P!=null) {
					try {
						
						String arquivo = "C:\\Users\\T-Gamer\\Desktop\\Yaslim\\Arquivos - POO\\" + P.getNomeChar() + ".txt";
						File arq = new File(arquivo);
						
						int cont = 0;
						Personagem aux = null;
						String nomeAntigo = P.getNomeChar();
						List <String> nomePersonagens = new ArrayList<>();
						Scanner ler = new Scanner(System.in);
						nomePersonagens = load.personagensSalvos();
						
						System.out.print("Digite um novo nome para o personagem: ");
						String name = ler.nextLine();
						
						for(int i = 0; i<nomePersonagens.size(); i++) {
							if(nomePersonagens.get(i).equals(nomeAntigo)) {
								cont = i;
							}
						}
						
						nomePersonagens.remove(cont);
						if(!nomePersonagens.isEmpty()) {
							nomePersonagens.add(cont, name);
						} else {
							nomePersonagens.add(cont, name);
						}
						
						FileWriter alimentarLista = new FileWriter(lista);
						Scanner s = new Scanner(lista);
						
						while(s.hasNextLine()) {
							alimentarLista.write("");
						}
						for(String p: nomePersonagens) {
							alimentarLista.write(p + "\n");
						}
						
						alimentarLista.close();
						s.close();
						arq.delete();
						
						System.out.println("Escolha uma nova classe com base nos números:\n1 - Mago\n2 - Tanque\n3 - Lutador\n4 - Assassino");
						int choice = ler.nextInt();
						switch(choice) {
							case 1:
								aux = new Mago(name);
								save.saveEspecial(aux);
					    		break;
							case 2:
								aux = new Tanque(name);
								save.saveEspecial(aux);
					    		break;
							case 3:
								aux = new Lutador(name);
								save.saveEspecial(aux);
					    		break;
							case 4:
								aux = new Assassino(name);
								save.saveEspecial(aux);
					    		break;
						}
						
						System.out.println("\nPersonagem modificado!!\n");
						System.out.println("Pressione ENTER para continuar...");
						new java.util.Scanner(System.in).nextLine();
						return aux;
			            
					} catch (InputMismatchException e) {
						System.out.println("\nErro ao editar personagem! Digite um caractere válido!\n");
			            System.out.println("Pressione ENTER para continuar...");
			            new java.util.Scanner(System.in).nextLine();
					}
					catch (Exception e) {
						System.out.println("\nErro ao editar personagem!\n");
			            System.out.println("Pressione ENTER para continuar...");
			            new java.util.Scanner(System.in).nextLine();
					}
				}
			}
			return null;
			}
		return null;
		
	}
	
	@SuppressWarnings("resource")
	public void editarArray(List<Personagem> personagem, Personagem p1, Personagem p2) {
		try {
			int cond = -50;
			
			for(int i = 0; i <personagem.size(); i++) {
				if(p1.getNomeChar().equals(personagem.get(i).getNomeChar())) {
					cond = i;
				}
			}
			
			if(cond != -50) {
				personagem.remove(cond);
				if(!personagem.isEmpty()) {
					personagem.add(cond, p2);
				} else {
					personagem.add(cond, p2);
				}
			}
			
		} catch (InputMismatchException e) {
			System.out.println("Erro!");
			System.out.println("Pressione ENTER para continuar...");
            new java.util.Scanner(System.in).nextLine();
		} catch (Exception e) {
			System.out.println("Erro!");
			System.out.println("Pressione ENTER para continuar...");
            new java.util.Scanner(System.in).nextLine();
		}
	}
}
