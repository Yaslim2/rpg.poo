package rpg.utility;

import java.io.File;
import java.util.Scanner;

import rpg.personagens.Assassino;
import rpg.personagens.Lutador;
import rpg.personagens.Mago;
import rpg.personagens.Personagem;
import rpg.personagens.Tanque;
import rpg.personagens.TiposDePersonagem;

public class Carregar {
	@SuppressWarnings("resource")
	public Personagem load(String nomeArquivo){
        
        //Substituir endereço aqui
        String arquivo = "C:\\Users\\T-Gamer\\Desktop\\Yaslim\\" + nomeArquivo + ".txt";

        try{
            File arq = new File(arquivo);
            Scanner s = new Scanner(arq);
            String tipo = s.nextLine();
            String nome = s.nextLine();
            
            if(TiposDePersonagem.valueOf(tipo).equals(TiposDePersonagem.MAGO)) {
            	 System.out.println("\nPersonagem carregado!\n");
                 System.out.println("Pressione ENTER para continuar...");
                 new java.util.Scanner(System.in).nextLine();
                 s.close();
            	 return new Mago(nome);
            } else if(TiposDePersonagem.valueOf(tipo).equals(TiposDePersonagem.ASSASSINO)) {
            	 System.out.println("\nPersonagem carregado!\n");
                 System.out.println("Pressione ENTER para continuar...");
                 new java.util.Scanner(System.in).nextLine();
                 s.close();
            	 return new Assassino(nome);
            } else if(TiposDePersonagem.valueOf(tipo).equals(TiposDePersonagem.LUTADOR)) {
            	 System.out.println("\nPersonagem carregado!\n");
                 System.out.println("Pressione ENTER para continuar...");
                 new java.util.Scanner(System.in).nextLine();
                 s.close();
            	 return new Lutador(nome);
            } else if(TiposDePersonagem.valueOf(tipo).equals(TiposDePersonagem.TANQUE)) {
            	 System.out.println("\nPersonagem carregado!\n");
                 System.out.println("Pressione ENTER para continuar...");
                 new java.util.Scanner(System.in).nextLine();
                 s.close();
            	 return new Tanque(nome);
            } else {
            	s.close();
            	return null;
            }
            
        }
        catch(Exception e){
            System.out.println("Erro ao carregar personagem!\n");
            System.out.println("Pressione ENTER para continuar...");
            new java.util.Scanner(System.in).nextLine();
        }
		return null;
    }

    @SuppressWarnings("resource")
	public void listarPersonagens(){
        try{

            //Substituir endereço aqui
            String listaPersonagens = "C:\\Users\\T-Gamer\\Desktop\\Yaslim\\" + "Lista de Personagens.txt";

            File lista = new File(listaPersonagens);
			Scanner s = new Scanner(lista);
            System.out.println("\n***Lista de personagens***\n\n");
            while(s.hasNextLine()){
                System.out.println(" - " + s.nextLine());
            }
            System.out.println("\n\n");

            System.out.println("Pressione ENTER para continuar...");
            new java.util.Scanner(System.in).nextLine();
            s.close();
        }
        catch(Exception e){
            System.out.println("Erro ao ler lista de personagens!\n");
            System.out.println("Pressione ENTER para continuar...");
            new java.util.Scanner(System.in).nextLine();
        }
    }
}
