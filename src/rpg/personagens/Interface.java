package rpg.personagens;

import rpg.ataquesespeciais.Ataques;

public interface Interface {
	public TiposDePersonagem getTipo();
	public int getPontosDeVida();
	public void setPontosDeVida(int pontosDeVida);
	public int getPoderDeHabilidade();
	public int getPoderAtaqueFisico();
	public String getNomeChar();
	public void setNomeChar(String nomeChar);
	public Ataques getAtaqueEspecial();
	public Ataques getAtaqueBasico();
	public int getArmadura();
	public void setArmadura(int armadura);
	public int getResistenciaMagica();
	public void setResistenciaMagica(int resistenciaMagica);
	public void mostrarDados();
	public void ataqueEspecial();
    public void powerUp();
}
