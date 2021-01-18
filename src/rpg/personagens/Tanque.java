package rpg.personagens;

import java.util.ArrayList;
import java.util.List;
import rpg.ataquesespeciais.Ataques;
import rpg.ataquesespeciais.TipoDoAtaque;

public class Tanque extends Personagem{
	private Ataques attSp = new Ataques("DURO COMO PEDRA", TipoDoAtaque.valueOf("AD"));
	private Ataques attBasics = new Ataques("AUTO-ATAQUE", TipoDoAtaque.valueOf("AD"));
	public List <Integer> attEspecial = new ArrayList<>();
        
	public Tanque(String nomeChar) {
		super(nomeChar);
		pontosDeVida = 325;
		poderDeHabilidade = 0;
		poderAtaqueFisico = 25;
		armadura = 60;
		resistenciaMagica = 60;
		ataqueEspecial = attSp;
		ataqueBasico = attBasics;
                pontosHabilidade = 0;
		tipo = TiposDePersonagem.valueOf("TANQUE");
	}
	
        @Override
	public void ataqueEspecial() {
                if(pontosHabilidade == 1){
                    pontosHabilidade = 0;
                    int aux = (int) (0.15 * poderAtaqueFisico);
                    pontosDeVida += 0.15 * pontosDeVida;
                    armadura += 0.15 * armadura;
                    resistenciaMagica += 0.15 * resistenciaMagica;

                    int poderAtaqueFisicoEspecial = aux + poderAtaqueFisico;
                    //int pontosDeVidaEspecial = aux2 * pontosDeVida + pontosDeVida;
                    //int armaduraEspecial = aux3 * armadura + armadura;
                    //int resistenciaMagicaEspecial = aux4 * resistenciaMagica + resistenciaMagica;
                    int poderDeHabilidadeEspecial = 0;

                    attEspecial.clear();
                    attEspecial.add(poderAtaqueFisicoEspecial);
                    //attEspecial.add(pontosDeVidaEspecial);
                    //attEspecial.add(armaduraEspecial);
                    //attEspecial.add(resistenciaMagicaEspecial);
                    attEspecial.add(poderDeHabilidadeEspecial);
                } else {
                     System.out.println("Sua habilidade especial ainda n√£o est√° pronta.\n");
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
		System.out.println(nomeChar +" - " + "Tanque" + "\nPontos de Vida: " + pontosDeVida + "\nPoder de Habilidade: " + poderDeHabilidade 
				+ "\nPoder do Ataque FÌsico: " + poderAtaqueFisico + "\nArmadura: " + armadura + "\nResistÍncia M·gica: " + resistenciaMagica + 
				"\nAtaque Especial: " + ataqueEspecial + "\nPontos de habilidade: " + pontosHabilidade);
	}
}
