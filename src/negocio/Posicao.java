package negocio;

public class Posicao {
	protected Jogador ocupante;
	
	public boolean informarOcupada() {
		return (ocupante != null);
	}

	public Jogador informarOcupante() {
		return ocupante;
	}

	public void esvaziar() {
		ocupante = null;
	}
	
	public void alocar(Jogador umJogador) {
		ocupante = umJogador;
	}

}
