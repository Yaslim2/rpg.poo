package rpg.personagens;

import rpg.ataquesespeciais.Ataques;

public abstract class Personagem {
	
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
	
	public TiposDePersonagem getTipo() {
		return tipo;
	}

	public void setTipo(TiposDePersonagem tipo) {
		this.tipo = tipo;
	}
	
	public int getPontosDeVida() {
		return pontosDeVida;
	}

	public int getPoderDeHabilidade() {
		return poderDeHabilidade;
	}


	public int getPoderAtaqueFisico() {
		return poderAtaqueFisico;
	}

	public String getNomeChar() {
		return nomeChar;
	}

	public void setNomeChar(String nomeChar) {
		this.nomeChar = nomeChar;
	}
	
	public Ataques getAtaqueEspecial() {
		return ataqueEspecial;
	}

	public Ataques getAtaqueBasico() {
		return ataqueBasico;
	}

	public int getArmadura() {
		return armadura;
	}

	public int getResistenciaMagica() {
		return resistenciaMagica;
	}
	
	public void setPontosDeVida(int pontosDeVida) {
		this.pontosDeVida = pontosDeVida;
	}

	public void setPoderDeHabilidade(int poderDeHabilidade) {
		this.poderDeHabilidade = poderDeHabilidade;
	}

	public void setPoderAtaqueFisico(int poderAtaqueFisico) {
		this.poderAtaqueFisico = poderAtaqueFisico;
	}

	public void setAtaqueEspecial(Ataques ataqueEspecial) {
		this.ataqueEspecial = ataqueEspecial;
	}

	public void setAtaqueBasico(Ataques ataqueBasico) {
		this.ataqueBasico = ataqueBasico;
	}

	public void setArmadura(int armadura) {
		this.armadura = armadura;
	}

	public void setResistenciaMagica(int resistenciaMagica) {
		this.resistenciaMagica = resistenciaMagica;
	}
	
	public void powerUp() {}
	
	public void mostrarDados() {}
	
	public void ataqueEspecial() {}
	

}
