package rpg.personagens;

import rpg.ataquesespeciais.Ataques;
import rpg.ataquesespeciais.TipoDoAtaque;

public class Assassino extends Personagem{
	private Ataques attSp = new Ataques("Finalização", TipoDoAtaque.valueOf("AD"));
	private Ataques attBasics = new Ataques("Auto-Ataque", TipoDoAtaque.valueOf("AD"));
	
	public Assassino(String nomeChar) {
		super(nomeChar);
		pontosDeVida = 150;
		poderDeHabilidade = 0;
		poderAtaqueFisico = 40;
		armadura = 20;
		resistenciaMagica = 15;
		ataqueEspecial = attSp;
		ataqueBasico = attBasics;
		tipo = TiposDePersonagem.valueOf("ASSASSINO");
	}
	
	public void ataqueEspecial() {
		poderAtaqueFisico += 0.5 * poderAtaqueFisico;
	}
	
	@Override
	public void powerUp() {
		poderAtaqueFisico += 0.08 * poderAtaqueFisico;
		armadura += 0.08 * armadura;
		resistenciaMagica += 0.08 * resistenciaMagica;
		poderDeHabilidade += 0.08 * poderDeHabilidade;
	}
	
	@Override
	public void mostrarDados() {
		System.out.println(nomeChar +" - " + "Assassino" + "\nPontos de Vida: " + pontosDeVida + "\nPoder de Habilidade: " + poderDeHabilidade 
				+ "\nPoder do Ataque Físico: " + poderAtaqueFisico + "\nArmadura: " + armadura + "\nResistência Mágica: " + resistenciaMagica + 
				"\nAtaque Especial: " + ataqueEspecial);
	}
}
