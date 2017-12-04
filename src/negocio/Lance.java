package negocio;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Lance implements Jogada {

	protected int linha;
	protected int coluna;
	protected int tipoJogada; // 1 = primeiroTurno; 2 = selecionou; 3 = colocou; 4 = movimentou

	public void assumir(int valLinha, int valColuna, int valTipoJogada ) {
		linha = valLinha;
		coluna = valColuna;	
		tipoJogada = valTipoJogada;
	}
	
	public void setTipoJogada(int tpJogada){
		this.tipoJogada = tpJogada;
	}

	public int informarLinha() {
		return linha;
	}

	public int informarColuna() {
		return coluna;
	}
	
	public int informarTipoJogada() {
		return tipoJogada;
	}

}