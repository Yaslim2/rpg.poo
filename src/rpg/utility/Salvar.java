package rpg.utility;

import java.io.File;
import java.io.FileWriter;

import rpg.personagens.Personagem;

public class Salvar {
	 @SuppressWarnings("resource")
		
	    public void save(Personagem P){

	        //Substituir endereço aqui
	    	String arquivo = "C:\\Users\\T-Gamer\\Desktop\\Yaslim\\" + P.getNomeChar() + ".txt";

	    	try{
	    		File arq = new File(arquivo);

	    		if(arq.createNewFile()){

	    			//Substituir endereço aqui
	    			String listaPersonagens = "C:\\Users\\T-Gamer\\Desktop\\Yaslim\\" + "Lista de Personagens.txt";

	    			File lista = new File(listaPersonagens);
	    			FileWriter alimentarLista = new FileWriter(lista, true);
	    			alimentarLista.write(P.getNomeChar() + "\n");
	    			alimentarLista.close();
	    		}

	    		FileWriter w = new FileWriter(arq);
	    		w.write(P.getTipo().toString() + "\n");
	    		w.write(P.getNomeChar() + "\n");
	    		w.write(P.getPontosDeVida() + "\n");
	    		w.write(P.getPoderDeHabilidade() + "\n");
	    		w.write(P.getPoderAtaqueFisico() + "\n");
	    		w.write(P.getArmadura() + "\n");
	    		w.write(P.getResistenciaMagica() + "\n");
	    		w.close();
	    	}
	    	catch(Exception e){
	    		System.out.println("Erro ao salvar personagem!\n");

	    		System.out.println("Pressione ENTER para continuar...");
	            new java.util.Scanner(System.in).nextLine();
	        }
	    }
}
