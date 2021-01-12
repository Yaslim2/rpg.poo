package rpg.utility;

import java.util.ArrayList;
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

	public void criarPersonagem() {
		String nome;
    	int condition;
        System.out.println("\nQual personagem você deseja criar:\n\n1 - Mago\n2 - Tanque\n3 - Lutador\n4 - Assassino\n");
        int operation = s.nextInt();
        switch(operation) {
        	case 1:
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
        			personagens.add(new Mago(nome));
            		System.out.println("Personagem criado!\n");
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
		for(Personagem p : personagens) {
        	save.save(p);
        }
    	System.out.println("\nPersonagem(s) salvo(s)!\n");
		System.out.println("Pressione ENTER para continuar...");
		new java.util.Scanner(System.in).nextLine();
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
}
