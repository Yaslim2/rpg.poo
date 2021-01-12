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
                System.out.println("\nQual personagem você deseja criar:\n\n1-Mago\n2-Tanque\n3-Lutador\n4-Assassino\n");
                int operation = s.nextInt();
                switch(operation) {
                	case 1:
                		System.out.println("Nome do Personagem: ");
                		s.nextLine();
                		personagens.add(new Mago(s.nextLine()));
                		System.out.println("Personagem criado!\n");
                		System.out.println("Pressione ENTER para continuar...");
                        new java.util.Scanner(System.in).nextLine();
                		break;
                	case 2:
                		System.out.println("Nome do Personagem: ");
                		s.nextLine();
                		personagens.add(new Tanque(s.nextLine()));
                		System.out.println("Personagem criado!\n");
                		System.out.println("Pressione ENTER para continuar...");
                        new java.util.Scanner(System.in).nextLine();
                		break;
                	case 3:
                		System.out.println("Nome do Personagem: ");
                		s.nextLine();
                		personagens.add(new Lutador(s.nextLine()));
                		System.out.println("Personagem criado!\n");
                		System.out.println("Pressione ENTER para continuar...");
                        new java.util.Scanner(System.in).nextLine();
                		break;
                	case 4:
                		System.out.println("Nome do Personagem: ");
                		s.nextLine();
                		personagens.add(new Assassino(s.nextLine()));
                		System.out.println("Personagem criado!\n");
                		System.out.println("Pressione ENTER para continuar...");
                        new java.util.Scanner(System.in).nextLine();
                		break;
                	default:
                		System.out.println("Erro");
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
            	System.out.println("\nPersonagem salvo!\n");
	    		System.out.println("Pressione ENTER para continuar...");
	    		new java.util.Scanner(System.in).nextLine();
                break;

            case 4:
                System.out.println("\nQual personagem deseja carregar?\n");
                String nomeArquivo = s.nextLine();
                nomeArquivo = s.nextLine();
                personagens.add(load.load(nomeArquivo));
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
