package rpg.personagens;

import java.util.ArrayList;
import java.util.List;
import rpg.ataquesespeciais.Ataques;
import rpg.ataquesespeciais.TipoDoAtaque;

public class Mago extends Personagem{
	
	private Ataques attSp = new Ataques("CONCENTRA«√O LUNAR", TipoDoAtaque.valueOf("AP"));
	private Ataques attBasics = new Ataques("AUTO-ATAQUE", TipoDoAtaque.valueOf("AP"));
	public List <Integer> attEspecial = new ArrayList<>();
	public Mago(String nomeChar) {
		super(nomeChar);
		pontosDeVida = 175;
		poderDeHabilidade = 40;
		poderAtaqueFisico = 0;
		armadura = 35;
		resistenciaMagica = 35;
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
                 System.out.println("Sua habilidade especial ainda n√£o est√° pronta.\n");
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
		System.out.println(nomeChar +" - " + "Mago" + "\nPontos de Vida: " + pontosDeVida + "\nPoder de Habilidade: " + poderDeHabilidade 
				+ "\nPoder do Ataque FÌsico: " + poderAtaqueFisico + "\nArmadura: " + armadura + "\nResistÍncia M√°gica: " + resistenciaMagica + 
				"\nAtaque Especial: " + ataqueEspecial + "\nPontos de habilidade: " + pontosHabilidade);
	}
}
