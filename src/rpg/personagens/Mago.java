package rpg.personagens;

import java.util.ArrayList;
import java.util.List;
import rpg.ataquesespeciais.Ataques;
import rpg.ataquesespeciais.TipoDoAtaque;

public class Mago extends Personagem{
	
	private Ataques attSp = new Ataques("CONCENTRA��O LUNAR", TipoDoAtaque.valueOf("AP"));
	private Ataques attBasics = new Ataques("AUTO-ATAQUE", TipoDoAtaque.valueOf("AP"));
	public List <Integer> attEspecial = new ArrayList<>();
        private boolean auxiliar;
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
	public void ataqueEspecial(Personagem atacado, int verif) {
            
            
            if(pontosHabilidade >= 1){
               
               // atacado.setPontosDeVida(atacado.getPontosDeVida() - verif);
                
                int aux = (int) (0.15 * poderDeHabilidade);
                pontosDeVida += 0.15 * pontosDeVida;
                
                
                
                int poderAtaqueFisicoEspecial = 0;
                int poderDeHabilidadeEspecial = aux + poderDeHabilidade;
                attEspecial.clear();
                attEspecial.add(poderAtaqueFisicoEspecial);
                attEspecial.add(poderDeHabilidadeEspecial);
                auxiliar = true;
                pontosHabilidade = 0;
                
            } else {
                 auxiliar = false;
            }
                
	}
        
        @Override
        public List<Integer> getAtaqueDoAtaqueEspecial(){
            if(auxiliar){
                 return attEspecial;
             } else {
                 return erro;
             }
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
				+ "\nPoder do Ataque F�sico: " + poderAtaqueFisico + "\nArmadura: " + armadura + "\nResist�ncia M�gica: " + resistenciaMagica + 
				"\nAtaque Especial: " + ataqueEspecial + "\nPontos de habilidade: " + pontosHabilidade);
	}
        
        @Override
        public void ataquePadrao(Personagem atacado, int verif){
            atacado.setPontosDeVida(atacado.getPontosDeVida() - verif);
        }
        
        @Override
        public void aprimorarDefesa(Personagem defensor, int defesa){
        defensor.setResistenciaMagica(defesa + 5);
        }
        
        @Override
        public void aprimorarArmadura(Personagem defensor, int defesa){
        defensor.setArmadura(defesa + 5);
        }
}
