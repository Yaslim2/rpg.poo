package rpg.utility;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import rpg.personagens.Assassino;
import rpg.personagens.Lutador;
import rpg.personagens.Mago;
import rpg.personagens.Personagem;
import rpg.personagens.Tanque;

public class UX {
	private List <Personagem> personagens = new ArrayList<>();
	private Salvar save = new Salvar();
    private Carregar load = new Carregar();
    private Scanner s = new Scanner(System.in);
    private Boolean pararPrograma = false;
    private Apagar delete = new Apagar();
    private Editar edite = new Editar();
	
	public UX() {}

	public List<Personagem> getPersonagens() {
		return personagens;
	}

	public Salvar getSave() {
		return save;
	}

	public Carregar getLoad() {
		return load;
	}

	public Boolean getPararPrograma() {
		return pararPrograma;
	}

	@SuppressWarnings("resource")
	public void criarPersonagem() {
		String nome;
    	int condition;
    	int condition2;
        System.out.println("\nQual personagem você deseja criar:\n\n1 - Mago\n2 - Tanque\n3 - Lutador\n4 - Assassino\n");
        try {
        	int operation = s.nextInt();
        	switch(operation) {
        	case 1:
        		System.out.println("Nome do Personagem: ");
        		s.nextLine();
        		nome = s.nextLine();
        		condition = load.nomeJaCriado(nome);
        		condition2 = checaLista(nome);
        		if(condition == 1 || condition2 == 1) {
        			System.out.println("Nome já utilizado!\n");
            		System.out.println("Pressione ENTER para continuar...");
            		new java.util.Scanner(System.in).nextLine();
            		break;
        		} else {
        			personagens.add(new Mago(nome));
            		System.out.println("\nPersonagem criado!\n");
            		System.out.println("Pressione ENTER para continuar...");
                    new java.util.Scanner(System.in).nextLine();
            		break;
        		}
        	case 2:
        		System.out.println("Nome do Personagem: ");
        		s.nextLine();
        		nome = s.nextLine();
        		condition = load.nomeJaCriado(nome);
        		if(condition == 1) {
        			System.out.println("\n\nNome já utilizado!\n");
            		System.out.println("Pressione ENTER para continuar...");
            		new java.util.Scanner(System.in).nextLine();
            		break;
        		} else {
        			personagens.add(new Tanque(nome));
            		System.out.println("Personagem criado!\n");
            		System.out.println("Pressione ENTER para continuar...");
                    new java.util.Scanner(System.in).nextLine();
            		break;
        		}
        	case 3:
        		System.out.println("Nome do Personagem: ");
        		s.nextLine();
        		nome = s.nextLine();
        		condition = load.nomeJaCriado(nome);
        		if(condition == 1) {
        			System.out.println("Nome já utilizado!\n");
            		System.out.println("Pressione ENTER para continuar...");
            		new java.util.Scanner(System.in).nextLine();
            		break;
        		} else {
        			personagens.add(new Lutador(nome));
            		System.out.println("Personagem criado!\n");
            		System.out.println("Pressione ENTER para continuar...");
                    new java.util.Scanner(System.in).nextLine();
            		break;
        		}
        	case 4:
        		System.out.println("Nome do Personagem: ");
        		s.nextLine();
        		nome = s.nextLine();
        		condition = load.nomeJaCriado(nome);
        		if(condition == 1) {
        			System.out.println("Nome já utilizado!\n");
            		System.out.println("Pressione ENTER para continuar...");
            		new java.util.Scanner(System.in).nextLine();
            		break;
        		} else {
        			personagens.add(new Assassino(nome));
            		System.out.println("Personagem criado!\n");
            		System.out.println("Pressione ENTER para continuar...");
                    new java.util.Scanner(System.in).nextLine();
            		break;
        		}
        	default:
        		System.out.println("\nPersonagem inexistente!!\n");
        		System.out.println("Pressione ENTER para continuar...");
                new java.util.Scanner(System.in).nextLine();
                break;
        }
      }  catch(InputMismatchException e) {
    	  System.out.println("\nErro ao criar personagem!! Digite um caractere válido.\n");
    	  System.out.println("Pressione ENTER para continuar...");
    	  new java.util.Scanner(System.in).nextLine();
    	  s.nextLine();
      }
        catch(RuntimeException e) {
        	System.out.println("\nErro inesperado!\n");
      	  System.out.println("Pressione ENTER para continuar...");
      	  new java.util.Scanner(System.in).nextLine();
      	  s.nextLine();
        }
        }
        
	
	@SuppressWarnings("resource")
	public void exibirPersonagens() {
		if(personagens.isEmpty()) {
			System.out.println("\nNenhum personagem carregado!\n");
			System.out.println("Pressione ENTER para continuar...");
            new java.util.Scanner(System.in).nextLine();
		} else {
			System.out.println("---------------------------------------");
	    	System.out.println("---------------------------------------");
	    	for(Personagem p : personagens) {
	    		p.mostrarDados();
	    		System.out.println("---------------------------------------");
	    	}
	    	System.out.println("---------------------------------------");
		}
	}
	
	@SuppressWarnings("resource")
	public void salvarPersonagens() {
		if(personagens.isEmpty()) {
			System.out.println("\nSem personagens carregados para salvar!\n");
			System.out.println("Pressione ENTER para continuar...");
            new java.util.Scanner(System.in).nextLine();
		} else {
			for(Personagem p : personagens) {
	        	save.save(p);
	        }
	    	System.out.println("\nPersonagem(s) salvo(s)!\n");
			System.out.println("Pressione ENTER para continuar...");
			new java.util.Scanner(System.in).nextLine();
		}
	}
	
	@SuppressWarnings("resource")
	public void carregarPersonagem() {
		System.out.println();
        Personagem aux = load.selecaoPersonagem();
        if(aux != null) {
        	Integer cond = load.nomeRepetido(personagens, aux);
            if(cond == 1) {
            	System.out.println("\nPERSONAGEM JÁ CARREGADO!!!!\n");
            	System.out.println("Pressione ENTER para continuar...");
            	new java.util.Scanner(System.in).nextLine();
            } else if(cond == 0){
            	personagens.add(aux);
            	System.out.println("\nPersonagem carregado!\n");
                System.out.println("Pressione ENTER para continuar...");
                new java.util.Scanner(System.in).nextLine();
            }
        }
	}
	
	public void listarPersonagensSalvos() {
		load.listarPersonagens();
	}
	
	@SuppressWarnings("resource")
	public void encerrarPrograma() {
		pararPrograma = true;
		System.out.println("\nPrograma encerrado, volte sempre!\n");
		System.out.println("Pressione ENTER para continuar...");
        new java.util.Scanner(System.in).nextLine();
		s.close();
	}
	
	public void deletarPersonagens() {
		int aux = 0;
		String pers = delete.pegarNome();
		delete.apagarArquivo(pers);
		if(pers != null) {
			for(int i = 0; i<personagens.size(); i++) {
				if(personagens.get(i).getNomeChar().equals(pers)) {
					aux = i;
				}
			}
			if(!personagens.isEmpty()) {
				personagens.remove(aux);
			}
		}
	}
	
	public int checaLista(String nome) {
		int cond=0;
		for(int i = 0; i<personagens.size(); i++) {
			if(personagens.get(i).getNomeChar().equals(nome)) {
				cond = 1;
			}
		}
		return cond;
	}
	
	public void editarPersonagem() {
		Personagem p = edite.pegarPersonagem();
		
		Personagem aux = edite.editarPersonagem(p);
		
		edite.editarArray(personagens, p, aux);
	}
}
