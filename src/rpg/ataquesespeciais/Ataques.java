package rpg.ataquesespeciais;

public class Ataques {
	private String nomeDoAtaque;
	private TipoDoAtaque tipo;
	
	public Ataques(String nomeDoAtaque, TipoDoAtaque tipo) {
		this.nomeDoAtaque = nomeDoAtaque;
		this.tipo = tipo;
	}

	public TipoDoAtaque getTipo() {
		return tipo;
	}

	public String getNomeDoAtaque() {
		return nomeDoAtaque;
	}

	public String toString() {
		return nomeDoAtaque;
	}
}
