package rpg.main;

import java.util.Scanner;

import rpg.utility.UX;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UX ux = new UX();
        
        while(!(ux.getPararPrograma())){
        System.out.println("\n\n***MENU***\n\n1 - BATALHAR!\n2 - Personagens\n3 - Encerrar programa\n");

        int op = sc.nextInt();
        switch(op){
            case 1:
            	ux.Batalhar();
            	break;
            case 2:
            	int aux = -1;
            	while(aux != 0) {
            		System.out.println("\n\n***MENU DE PERSONAGENS***\n\n1 - Criar Personagem\n2 - Salvar personagens criados\n3 - Carregar personagem\n4 - Exibir personagens carregados\n5 - Personagens salvos\n6 - Editar personagem\n7 - Deletar personagem\n0 - Voltar ao menu principal\n\n");
                	aux = sc.nextInt();
                	switch(aux) {
                		case 1:
                			ux.criarPersonagem();
                			break;
                		case 2:
                			ux.salvarPersonagens();
                			break;
                		case 3:
                			ux.carregarPersonagem();
                			break;
                		case 4:
                			ux.exibirPersonagens();
                			break;
                		case 5:
                			ux.listarPersonagensSalvos();
                			break;
                		case 6:
                			ux.editarPersonagem();
                			break;
                		case 7:
                			ux.deletarPersonagens();
                			break;
                		case 0:
                			aux = 0;
                			break;
                	}
            	}
            	break;

            case 3:
            	ux.encerrarPrograma();
                sc.close();
                break;
        	}
        }
	}
}
