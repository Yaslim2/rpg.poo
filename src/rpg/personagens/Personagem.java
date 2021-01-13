package rpg.personagens;

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


	public Personagem(String nomeChar) {
		this.nomeChar = nomeChar;
	}
	
        @Override
	public TiposDePersonagem getTipo() {
		return tipo;
	}

		@Override    
	public int getPontosDeVida() {
		return pontosDeVida;
	}
		@Override
	public void setPontosDeVida(int pontosDeVida) {
		this.pontosDeVida = pontosDeVida;
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
	public void ataqueEspecial() {}
	

}