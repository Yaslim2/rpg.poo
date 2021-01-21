package rpg.personagens;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import rpg.ataquesespeciais.Ataques;

public abstract class Personagem implements Interface{
	
	protected String nomeChar;
	protected int pontosDeVida;
	protected int poderDeHabilidade;
	protected int poderAtaqueFisico;
	protected Ataques ataqueEspecial;
	protected Ataques ataqueBasico;
	protected int armadura;
	protected int resistenciaMagica;
	protected TiposDePersonagem tipo;
        protected int pontosHabilidade;
        protected List <Integer> erro = new ArrayList<>();
        
        


	public Personagem(String nomeChar) {
		this.nomeChar = nomeChar;
	}
        
        @Override
        public void setPontosDeVida(int pontosDeVida) {
            this.pontosDeVida = pontosDeVida;
        }

        @Override
        public void setArmadura(int armadura) {
            this.armadura = armadura;
        }

        @Override
        public void setResistenciaMagica(int resistenciaMagica) {
            this.resistenciaMagica = resistenciaMagica;
        }
	
        @Override
	public TiposDePersonagem getTipo() {
		return tipo;
	}
        @Override
	public void setTipo(TiposDePersonagem tipo) {
		this.tipo = tipo;
	}
        @Override    
	public int getPontosDeVida() {
		return pontosDeVida;
	}
        @Override
	public int getPoderDeHabilidade() {
		return poderDeHabilidade;
	}
        @Override
	public int getPoderAtaqueFisico() {
		return poderAtaqueFisico;
	}
        @Override
	public String getNomeChar() {
		return nomeChar;
	}
        @Override
	public void setNomeChar(String nomeChar) {
		this.nomeChar = nomeChar;
	}
        @Override    
	public Ataques getAtaqueEspecial() {
		return ataqueEspecial;
	}
        @Override
	public Ataques getAtaqueBasico() {
		return ataqueBasico;
	}
        @Override
	public int getArmadura() {
		return armadura;
	}
        @Override
	public int getResistenciaMagica() {
		return resistenciaMagica;
	}
        @Override
	public void powerUp() {}
        @Override
	public void mostrarDados() {}
        
	@Override
	public void ataqueEspecial(Personagem atacado, int verif) {}   
        
        @Override
        public List<Integer> getAtaqueDoAtaqueEspecial(){return null;}
        
        @Override
        public void ataquePadrao(Personagem atacado, int verif){
        }
        
        @Override
        public void aprimorarDefesa(Personagem defensor, int defesa){
            
        }
        @Override
        public void aprimorarArmadura(Personagem defensor, int defesa){
            
        }
       
    
}
