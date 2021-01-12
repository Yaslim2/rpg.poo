package rpg.personagens;

import rpg.ataquesespeciais.Ataques;
import rpg.ataquesespeciais.TipoDoAtaque;

public class Mago extends Personagem{
	
	private Ataques attSp = new Ataques("Embrazar", TipoDoAtaque.valueOf("AP"));
	private Ataques attBasics = new Ataques("Auto-Ataque", TipoDoAtaque.valueOf("AP"));
	
	public Mago(String nomeChar) {
		super(nomeChar);
		pontosDeVida = 150;
		poderDeHabilidade = 30;
		poderAtaqueFisico = 0;
		armadura = 20;
		resistenciaMagica = 20;
		ataqueEspecial = attSp;
		ataqueBasico = attBasics;
		tipo = TiposDePersonagem.valueOf("MAGO");
	}
	
	public void ataqueEspecial() {
		poderDeHabilidade += 0.15 * poderDeHabilidade;
		pontosDeVida += 0.1 * pontosDeVida;
	}
	
	@Override
	public void powerUp() {
		poderDeHabilidade += 0.08 * poderDeHabilidade;
		poderAtaqueFisico += 0.08 * poderAtaqueFisico;
		armadura += 0.08 * armadura;
		resistenciaMagica += 0.08 * resistenciaMagica;
	}
	
	@Override
	public void mostrarDados() {
		System.out.println(nomeChar +" - " + "Mago" + "\nPontos de Vida: " + pontosDeVida + "\nPoder de Habilidade: " + poderDeHabilidade 
				+ "\nPoder do Ataque Físico: " + poderAtaqueFisico + "\nArmadura: " + armadura + "\nResistência Mágica: " + resistenciaMagica + 
				"\nAtaque Especial: " + ataqueEspecial);
		
	}
}
