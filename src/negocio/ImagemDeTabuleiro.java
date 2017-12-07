package negocio;

public class ImagemDeTabuleiro {

	protected String mensagem;
	protected String placar;
	protected int mapa[][] = new int [8][8];
	
	public void assumirMensagem(String umaMensagem) {
		mensagem = umaMensagem;
	}
	
	public String informarMensagem() {
		return mensagem;
	}

	public void assumirValor(int linha, int coluna, int valor) {
		mapa [linha-1] [coluna-1] = valor;
	}
	
	public int informarValor(int linha, int coluna) {
		return mapa [linha-1] [coluna-1];
	}

	public void assumirPlacar(String valorPlacar) {
		placar = valorPlacar;
	}
	
	public String informarPlacar() {
		return placar;
	}

}