package rpg.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import rpg.personagens.Assassino;
import rpg.personagens.Lutador;
import rpg.personagens.Mago;
import rpg.personagens.Personagem;
import rpg.personagens.Tanque;
import rpg.utility.Carregar;
import rpg.utility.Salvar;


public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		List <Personagem> personagens = new ArrayList<>();
        Salvar save = new Salvar();
        Carregar load = new Carregar();
        Scanner s = new Scanner(System.in);
        Boolean pararPrograma = false;
        
        while(!pararPrograma){
            System.out.println("\n\n***MENU***\n\n1 - Criar personagem\n2 - Exibir todos os personagens carregados\n3 - Salvar todos os personagens\n4 - Carregar personagem\n5 - Lista de personagens salvos\n0 - Encerrar programa\n");
        int op = s.nextInt();

        switch(op){
            case 1:
            	String nome;
            	int condition;
                System.out.println("\nQual personagem você deseja criar:\n\n1-Mago\n2-Tanque\n3-Lutador\n4-Assassino\n");
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
                		System.out.println("\n1Personagem inexistente!!\n");
                		System.out.println("Pressione ENTER para continuar...");
                        new java.util.Scanner(System.in).nextLine();
                        break;
                }
                break;

            case 2:
            	System.out.println("---------------------------------------");
            	System.out.println("---------------------------------------");
            	for(Personagem p : personagens) {
            		p.mostrarDados();
            		System.out.println("---------------------------------------");
            	}
            	System.out.println("---------------------------------------");
                break;

            case 3:
            	for(Personagem p : personagens) {
                	save.save(p);
                }
            	System.out.println("\nPersonagem(s) salvo(s)!\n");
	    		System.out.println("Pressione ENTER para continuar...");
	    		new java.util.Scanner(System.in).nextLine();
                break;

            case 4:
                Personagem aux = load.selecaoPersonagem();
                int cond = load.nomeRepetido(personagens, aux);
                if(cond == 1) {
                	System.out.println("\nPERSONAGEM JÁ CARREGADO!!!!\n");
                	System.out.println("Pressione ENTER para continuar...");
                	new java.util.Scanner(System.in).nextLine();
                } else {
                	personagens.add(aux);
                	System.out.println("\nPersonagem carregado!\n");
                    System.out.println("Pressione ENTER para continuar...");
                    new java.util.Scanner(System.in).nextLine();
                }
                break;

            case 5:
                load.listarPersonagens();
                break;

            case 0:
                pararPrograma = true;
                s.close();
                break;
        }
    }
}

}