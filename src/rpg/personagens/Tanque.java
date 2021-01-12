package rpg.personagens;

import rpg.ataquesespeciais.Ataques;
import rpg.ataquesespeciais.TipoDoAtaque;

public class Tanque extends Personagem{
	private Ataques attSp = new Ataques("Força Excessiva", TipoDoAtaque.valueOf("AD"));
	private Ataques attBasics = new Ataques("Auto-Ataque", TipoDoAtaque.valueOf("AD"));
	
	public Tanque(String nomeChar) {
		super(nomeChar);
		pontosDeVida = 300;
		poderDeHabilidade = 0;
		poderAtaqueFisico = 15;
		armadura = 50;
		resistenciaMagica = 50;
		ataqueEspecial = attSp;
		ataqueBasico = attBasics;
		tipo = TiposDePersonagem.valueOf("TANQUE");
	}
	
	public void ataqueEspecial() {
		poderAtaqueFisico += 0.15 * poderAtaqueFisico;
		pontosDeVida += 0.15 * pontosDeVida;
		armadura += 0.15 * armadura;
		resistenciaMagica += 0.15 * resistenciaMagica;
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
		System.out.println(nomeChar +" - " + "Tanque" + "\nPontos de Vida: " + pontosDeVida + "\nPoder de Habilidade: " + poderDeHabilidade 
				+ "\nPoder do Ataque Físico: " + poderAtaqueFisico + "\nArmadura: " + armadura + "\nResistência Mágica: " + resistenciaMagica + 
				"\nAtaque Especial: " + ataqueEspecial);
	}
}
