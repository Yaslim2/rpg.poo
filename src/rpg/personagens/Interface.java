package rpg.personagens;

import java.util.List;
import rpg.ataquesespeciais.Ataques;

public interface Interface {
	public TiposDePersonagem getTipo();
	public void setTipo(TiposDePersonagem tipo);
	public int getPontosDeVida();
	public int getPoderDeHabilidade();
	public int getPoderAtaqueFisico();
	public String getNomeChar();
	public void setNomeChar(String nomeChar);
	public Ataques getAtaqueEspecial();
	public Ataques getAtaqueBasico();
	public int getArmadura();
	public int getResistenciaMagica();
	public void mostrarDados();
	public void ataqueEspecial();
        public void setResistenciaMagica(int resistenciaMagica);
        public void setArmadura(int armadura);
        public void setPontosDeVida(int pontosDeVida);
        public List<Integer> getAtaqueDoAtaqueEspecial();
    public void powerUp();
}
