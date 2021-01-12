package rpg.personagens;

import rpg.ataquesespeciais.Ataques;
import rpg.ataquesespeciais.TipoDoAtaque;

public class Lutador extends Personagem{
	private Ataques attSp = new Ataques("Fúria", TipoDoAtaque.valueOf("AD"));
	private Ataques attBasics = new Ataques("Auto-Ataque", TipoDoAtaque.valueOf("AD"));
	
	public Lutador(String nomeChar) {
		super(nomeChar);
		pontosDeVida = 210;
		poderDeHabilidade = 0;
		poderAtaqueFisico = 30;
		armadura = 40;
		resistenciaMagica = 35;
		ataqueEspecial = attSp;
		ataqueBasico = attBasics;
		tipo = TiposDePersonagem.valueOf("LUTADOR");
	}
	
	public void ataqueEspecial() {
		poderAtaqueFisico += 0.15 * poderAtaqueFisico;
		pontosDeVida += 0.15 * pontosDeVida;
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
		System.out.println(nomeChar +" - " + "Lutador" + "\nPontos de Vida: " + pontosDeVida + "\nPoder de Habilidade: " + poderDeHabilidade 
				+ "\nPoder do Ataque Físico: " + poderAtaqueFisico + "\nArmadura: " + armadura + "\nResistência Mágica: " + resistenciaMagica + 
				"\nAtaque Especial: " + ataqueEspecial);
	}
}
