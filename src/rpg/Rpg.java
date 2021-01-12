package rpg;

import java.util.ArrayList;
import java.util.List;

import rpg.personagens.Assassino;
import rpg.personagens.Lutador;
import rpg.personagens.Mago;
import rpg.personagens.Personagem;
import rpg.personagens.Tanque;

public class Rpg {

	public static void main(String[] args) {
		List <Personagem> personagens = new ArrayList<>();
		Personagem p1 = new Assassino("Jardel");
		
		personagens.add(new Mago("Ze Pilintra"));
		personagens.add(new Assassino("Mestre das Facas"));
		personagens.add(new Tanque("Torugo"));
		personagens.add(new Lutador("Maguila"));
		personagens.add(p1);


		for(Personagem p: personagens) {
			p.mostrarDados();
			System.out.println("--------------------------------------");
		}
		
		for(Personagem p: personagens) {
			p.powerUp();
		}
		for(Personagem p: personagens) {
			p.mostrarDados();
			System.out.println("--------------------------------------");
		}
	}

}
