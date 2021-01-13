package rpg.main;

import java.util.Scanner;

import rpg.utility.UX;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UX ux = new UX();
        
        while(!(ux.getPararPrograma())){
        System.out.println("\n\n***MENU***\n\n1 - Criar personagem\n2 - Exibir todos os personagens carregados\n3 - Salvar todos os personagens\n4 - Carregar personagem\n5 - Lista de personagens salvos\n6 - Deletar personagem\n7 - Editar personagem\n0 - Encerrar programa\n");

        int op = sc.nextInt();
        switch(op){
            case 1:
            	ux.criarPersonagem();
            	break;
            case 2:
            	ux.exibirPersonagens();
                break;

            case 3:
            	ux.salvarPersonagens();
                break;

            case 4:
            	ux.carregarPersonagem();
                break;

            case 5:
                ux.listarPersonagensSalvos();
                break;
            
            case 6:
            	ux.deletarPersonagens();
            	break;
            case 7:
            	ux.editarPersonagem();
            	break;
            case 0:
                ux.encerrarPrograma();
                sc.close();
                break;
        	}
        }
	}
}
