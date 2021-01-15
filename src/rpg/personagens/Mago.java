package rpg.personagens;

import java.util.ArrayList;
import java.util.List;
import rpg.ataquesespeciais.Ataques;
import rpg.ataquesespeciais.TipoDoAtaque;

public class Mago extends Personagem{
	
	private Ataques attSp = new Ataques("Embrazar", TipoDoAtaque.valueOf("AP"));
	private Ataques attBasics = new Ataques("Auto-Ataque", TipoDoAtaque.valueOf("AP"));
	public List <Integer> attEspecial = new ArrayList<>();
	public Mago(String nomeChar) {
		super(nomeChar);
		pontosDeVida = 150;
		poderDeHabilidade = 30;
		poderAtaqueFisico = 0;
		armadura = 20;
		resistenciaMagica = 20;
		ataqueEspecial = attSp;
		ataqueBasico = attBasics;
                pontosHabilidade = 0;
		tipo = TiposDePersonagem.valueOf("MAGO");
	}
	
        @Override
	public void ataqueEspecial() {
            
            
            if(pontosHabilidade == 1){
                pontosHabilidade = 0;
                int aux = (int) (0.15 * poderDeHabilidade);
                pontosDeVida += 0.15 * pontosDeVida;
                
                
                
                int poderAtaqueFisicoEspecial = 0;
                //int pontosDeVidaEspecial = aux2 * pontosDeVida + pontosDeVida;
                //int armaduraEspecial = 0;
		//int resistenciaMagicaEspecial = 0;
                int poderDeHabilidadeEspecial = aux + poderDeHabilidade;
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
		poderDeHabilidade += 0.08 * poderDeHabilidade;
		poderAtaqueFisico += 0.08 * poderAtaqueFisico;
		armadura += 0.08 * armadura;
		resistenciaMagica += 0.08 * resistenciaMagica;
                pontosHabilidade += 1;
	}
	
	@Override
	public void mostrarDados() {
		System.out.println(nomeChar +" - " + "Lutador" + "\nPontos de Vida: " + pontosDeVida + "\nPoder de Habilidade: " + poderDeHabilidade 
				+ "\nPoder do Ataque Físico: " + poderAtaqueFisico + "\nArmadura: " + armadura + "\nResistência Mágica: " + resistenciaMagica + 
				"\nAtaque Especial: " + ataqueEspecial + "\nPontos de habilidade: " + pontosHabilidade);
	}
}
