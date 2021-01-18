package rpg.personagens;

import java.util.ArrayList;
import java.util.List;
import rpg.ataquesespeciais.Ataques;
import rpg.ataquesespeciais.TipoDoAtaque;

public class Lutador extends Personagem{
	private Ataques attSp = new Ataques("FÚRIA", TipoDoAtaque.valueOf("AD"));
	private Ataques attBasics = new Ataques("AUTO-ATAQUE", TipoDoAtaque.valueOf("AD"));
	public List <Integer> attEspecial = new ArrayList<>();
        
	public Lutador(String nomeChar) {
		super(nomeChar);
		pontosDeVida = 250;
		poderDeHabilidade = 0;
		poderAtaqueFisico = 30;
		armadura = 45;
		resistenciaMagica = 45;
		ataqueEspecial = attSp;
		ataqueBasico = attBasics;
        pontosHabilidade = 0;
		tipo = TiposDePersonagem.valueOf("LUTADOR");
	}
        
        
	@Override
	public void ataqueEspecial() {
            
            if(pontosHabilidade == 1){
                pontosHabilidade = 0;
                int aux = (int) (0.15 * poderAtaqueFisico);
                pontosDeVida += 0.15 * pontosDeVida;
                        
		int poderAtaqueFisicoEspecial = aux + poderAtaqueFisico;
		//int pontosDeVidaEspecial = aux2 * pontosDeVida + pontosDeVida;
                //int armaduraEspecial = 0;
               // int resistenciaMagicaEspecial = 0;
                int poderDeHabilidadeEspecial = 0;
                attEspecial.clear();
                attEspecial.add(poderAtaqueFisicoEspecial);
                //attEspecial.add(pontosDeVidaEspecial);
                //attEspecial.add(armaduraEspecial);
                //attEspecial.add(resistenciaMagicaEspecial);
                attEspecial.add(poderDeHabilidadeEspecial);
            } else {
                System.out.println("Sua habilidade especial ainda não está pronta.\n");
            }
                
	}
        
        @Override
        public List<Integer> getAtaqueDoAtaqueEspecial(){
            return attEspecial;
        }
	
        @Override
	public void powerUp() {
		poderAtaqueFisico += 0.08 * poderAtaqueFisico;
		armadura += 0.08 * armadura;
		resistenciaMagica += 0.08 * resistenciaMagica;
		poderDeHabilidade += 0.08 * poderDeHabilidade;
                pontosHabilidade += 1;
	}
	
	@Override
	public void mostrarDados() {
		System.out.println(nomeChar +" - " + "Lutador" + "\nPontos de Vida: " + pontosDeVida + "\nPoder de Habilidade: " + poderDeHabilidade 
				+ "\nPoder do Ataque Físico: " + poderAtaqueFisico + "\nArmadura: " + armadura + "\nResistência MÃ¡gica: " + resistenciaMagica + 
				"\nAtaque Especial: " + ataqueEspecial + "\nPontos de habilidade: " + pontosHabilidade);
	}
}
