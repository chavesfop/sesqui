package negocio;

public class Jogador {
	
	protected String nome;
	protected boolean simbolo;
	protected int qtPecas;
	protected boolean daVez;
	protected boolean vencedor;
	protected int tipoJogada;  // 1 = primeiroTurno; 2 = selecionou; 3 = colocou; 4 = movimentou
	protected boolean completouTurno;	
	
	protected boolean colocou;
	protected boolean movimentou;
	
	
	public int informarQtPecas(){
		return qtPecas;
	}
	
	public void definirTipoJogada(int tp) {
		tipoJogada = tp;
	}
	
	public int obterTipoJogada() {
		return tipoJogada;
	}

	public boolean informarDaVez() {
		return daVez;
	}

	public String informarNome() {
		return nome;
	}

	public boolean informarVencedor() {
		return vencedor;
	}

	public boolean informarSimbolo() {
		return simbolo;
	}

	public void iniciar() {
		daVez = false;
		vencedor = false;
		movimentou = false;
		colocou = false;
		qtPecas = 30;
		tipoJogada = 1;
	}

	public void assumirNome(String idJogador) {
		nome = idJogador;
	}

	public void habilitar() {
		daVez = true;
	}

	public void assumirSimbolo(boolean umSimbolo) {
		simbolo = umSimbolo;
	}

	public void desabilitar() {
		daVez = false;
	}

	public void assumirVencedor() {
		vencedor = true;
	}

}
