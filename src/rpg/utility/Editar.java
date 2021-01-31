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
	private Carregar load = new Carregar();
	private Salvar save = new Salvar();
	
	@SuppressWarnings("resource")
	// metodo utilizado para saber qual personagem sera editado, mostrando todos os personagens salvos na tela, e apos isso pedindo para que o usuario informe qual personagem sera editado
	public Personagem pegarPersonagem() {
		String listaPersonagens = "Lista de Personagens.txt";
    	File lista = new File(listaPersonagens);
    	// verificando a existencia do arquivo de lista de personagens e se existe algo escrito nele
    	if(lista.exists() && lista.length() > 0) {
    		try {
    			StringBuilder sb = new StringBuilder();
        		Scanner ler = new Scanner(System.in);
        		Personagem p;
        		List <String> nomesPersonagens = new ArrayList<>();
        		String aux;
    			Scanner s = new Scanner(lista);
    			int cond = 1;
    			System.out.println("\n----------------------------------------\n");
    			
    			// mostrando os personagens disponiveis para ediçao
    			
    			while(s.hasNextLine()) {
    				aux = s.nextLine();
    				System.out.println(cond + " - " + aux);
    				sb.append(cond + " - " + aux + "\n");
    				nomesPersonagens.add(aux);
    				cond += 1;
    			}
    			System.out.println("\n----------------------------------------\n");
    			System.out.print("\nSelecione qual personagem voce deseja editar com base nos numeros: ");
    			int pers = ler.nextInt();
    			// tratando uma exceçao
    			while(true) {
    				if((pers-1) < 0 || (pers-1) > nomesPersonagens.size()) {
        				System.out.println("\nValor invalido... Insira um valor que esteja dentro do intervalo!\n");
        				System.out.println("\n----------------------------------------\n");
        				System.out.println(sb.toString());
        				System.out.println("----------------------------------------\n");
            			System.out.print("\nSelecione qual personagem você deseja editar com base nos numeros: ");
            			pers = ler.nextInt();
        			} else {
        				break;
        			}
    			}
    			// capturando o personagem selecionado e retornando ele para a funçao
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
	// metodo responsavel por editar o personagem, apagando o seu arquivo original e criando outro de acordo com as especificaçoes do usuario
	
	public Personagem editarPersonagem(Personagem P) {
		String listaPersonagens = "Lista de Personagens.txt";
		File lista = new File(listaPersonagens);
		// verificando se existe personagens salvos
		
		if(load.personagensSalvos() != null) {
			// verificando a existencia do arquivo Lista de Personagens e se existe algo escrito nele
			
			if(lista.exists() && lista.length() > 0) {
				// verificando se o personagem nao retornou nenhum valor nulo, por conta da funcao anterior
				
				if(P!=null) {
					try {
						
						// acessando o arquivo do personagem que sera editado
						String arquivo = P.getNomeChar() + ".txt";
						File arq = new File(arquivo);
						
						int cont = 0;
						Personagem aux = null;
						String nomeAntigo = P.getNomeChar();
						List <String> nomePersonagens = new ArrayList<>();
						Scanner ler = new Scanner(System.in);
						nomePersonagens = load.personagensSalvos();
						
						System.out.print("\nDigite um novo nome para o personagem: ");
						String name = ler.nextLine();
						
						for(int i = 0; i<nomePersonagens.size(); i++) {
							if(nomePersonagens.get(i).equals(nomeAntigo)) {
								cont = i;
							}
						}
						
						// retirando o personagem com o nome antigo e adicionando com o novo nome no mesmo local que foi retirado
						
						nomePersonagens.remove(cont);
						
						nomePersonagens.add(cont, name);
						
						FileWriter alimentarLista = new FileWriter(lista);
						Scanner s = new Scanner(lista);
						
						// limpando o arquivo lista de personagens
						while(s.hasNextLine()) {
							alimentarLista.write("");
						}
						
						// reescrevendo o arquivo com o personagem que foi editado
						for(String p: nomePersonagens) {
							alimentarLista.write(p + "\n");
						}
						
						alimentarLista.close();
						s.close();
						
						// excluindo seu arquivo individual
						arq.delete();
						
						System.out.println("\nEscolha uma nova classe com base nos numeros:\n1 - Mago\n2 - Tanque\n3 - Lutador\n4 - Assassino");
						int choice = ler.nextInt();
						while(true) {
							if(choice < 1 || choice > 4) {
								System.out.println("\nValor invalido. Digite um valor valido!\n");
								System.out.println("\nEscolha uma nova classe com base nos números:\n1 - Mago\n2 - Tanque\n3 - Lutador\n4 - Assassino");
								choice = ler.nextInt();
							} else {
								break;
							}
						}
						
						// criando um novo arquivo para o personagem editado com o auxilio da funçao saveEspecial
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
						
						System.out.println("\nPersonagem modificado!\n");
						System.out.println("Pressione ENTER para continuar...");
						new java.util.Scanner(System.in).nextLine();
						return aux;
			            
					} catch (InputMismatchException e) {
						System.out.println("\nErro ao editar personagem! Digite um caractere valido!\n");
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
	// metodo que edita a lista que contem os personagens carregados, caso o personagem editado esteja nessa lista
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
			System.out.println("Erro inesperado!");
			System.out.println("Pressione ENTER para continuar...");
            new java.util.Scanner(System.in).nextLine();
		} catch (Exception e) {
			System.out.println("Erro inesperado!");
			System.out.println("Pressione ENTER para continuar...");
            new java.util.Scanner(System.in).nextLine();
		}
	}
}
