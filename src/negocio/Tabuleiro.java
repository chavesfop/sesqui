package negocio;

import java.util.Vector;

public class Tabuleiro {
	protected Posicao posicoes[][] = new Posicao[8][8];
	protected Jogador jogador1;
	protected Jogador jogador2;
	protected boolean partidaEmAndamento;
	protected boolean conectado;
	protected Vector<Lance> turno = new Vector<Lance>(); // cada turno completo possui 3 lances
														 //	(selecionar+mover); colocar

	public void resetarTurno() {
		this.turno = new Vector<Lance>();
	}

	public boolean verificarStatusConectado() {
		return conectado;
	}

	public void definirStausConexao(boolean valor) {
		conectado = valor;
	}

	public boolean informarEmAndamento() {
		return partidaEmAndamento;
	}

	public boolean isTabuleiroVazio() {
		int count = 0;
		for (int i = 0; i < posicoes.length; i++) {
			for (int j = 0; j < posicoes[i].length; j++) {
				Posicao pos = posicoes[i][j];
				if (pos.informarOcupada()) {
					count++;
				}
			}
		}
		return count == 0;
	}

	public int tratarPrimeiroTurno(int linha, int coluna, Jogador jogador) {
		if (isTabuleiroVazio()) {
			this.colocarPeca(jogador, linha, coluna);
			if (jogador.equals(jogador1)) {
				jogador1.desabilitar();
				jogador2.habilitar();
			} else {
				jogador2.desabilitar();
				jogador1.habilitar();
			}

		} else {

			if (jogador.informarQtPecas() < 30) {

				if (!jogador.informarDaVez()) {
					return 8;
				}
				if (this.verificarOcupada(linha, coluna)) {
					return 11;
				}
				this.colocarPeca(jogador, linha, coluna);
				if (jogador.equals(jogador1)) {
					jogador1.desabilitar();
					jogador2.habilitar();					
				} else {
					jogador2.desabilitar();
					jogador1.habilitar();					
				}
				jogador1.definirTipoJogada(0);
				jogador2.definirTipoJogada(0);
			} else {
				this.colocarPeca(jogador, linha, coluna);				
			}
		}
		return 15;
	}

	public Jogador obterJogadorDaVez() {
		return jogador1.informarDaVez() ? jogador1 : jogador2;
	}

	public void mudarVezJogador(Jogador jogador) {
		if (jogador.equals(jogador1)) {
			jogador1.desabilitar();
			jogador2.habilitar();
		} else {
			jogador2.desabilitar();
			jogador1.habilitar();
		}
	}

	// se o jogador executou uma colocação e uma movimentação
	// é a vez do outro jogador
	public boolean completouTurno() {
		int tipoJogada = 0;
		if (turno.size() > 0) {
			for (int i = 0; i < turno.size(); i++) {
				Lance lance = turno.get(i);
				tipoJogada += lance.informarTipoJogada();
			}
		}
		return tipoJogada == 9; // colocar + selecionar + mover
	}

	public int click(int linha, int coluna) {
		int resultado;
		if (!this.informarEmAndamento()) {
			resultado = 9;
			return resultado;
		}
		boolean vez = jogador1.informarDaVez();
		if (!vez) {
			resultado = 8;
			return resultado;
		}

		int tipoJogada = jogador1.obterTipoJogada();
		if (tipoJogada == 1) {
			resultado = tratarPrimeiroTurno(linha, coluna, jogador1);
		} else {
			resultado = this.tratarLance(jogador1, linha, coluna);
		}
		return resultado;
	}

	public Lance informarJogada(int linha, int coluna, int tpJogada) {
		Lance lance = new Lance();
		lance.assumir(linha, coluna, tpJogada);
		return lance;
	}

	public ImagemDeTabuleiro informarEstado() {
		ImagemDeTabuleiro estado = new ImagemDeTabuleiro();
		String mensagem;
		boolean vencedor;
		String nomeVencedor = "";
		int valor = 0;
		String placarBranco = "" ;
		String placarPreto = "" ;
		// COMPOSICAO DA MENSAGEM
		if (partidaEmAndamento) {
			boolean vez = jogador1.informarDaVez();
			if (vez) {
				if (jogador1.informarSimbolo()) {
					mensagem = ("Vez do jogador " + jogador1.informarNome() + " (peças brancas)");
					placarBranco = jogador1.informarQtPecas()+"";
					placarPreto = jogador2.informarQtPecas()+"";
					
				} else {
					mensagem = ("Vez do jogador " + jogador1.informarNome() + " (peças pretas)");
					placarPreto = jogador1.informarQtPecas()+"";
					placarBranco = jogador2.informarQtPecas()+"";
				}
			} else {
				if (jogador2.informarSimbolo()) {
					mensagem = ("Vez do jogador " + jogador2.informarNome() + " (peças brancas)");
					placarBranco = jogador2.informarQtPecas()+"";
					placarPreto = jogador1.informarQtPecas()+"";
				} else {
					mensagem = ("Vez do jogador " + jogador2.informarNome() + " (peças pretas)");
					placarPreto = jogador2.informarQtPecas()+"";
					placarBranco = jogador1.informarQtPecas()+"";
				}
			}
		} else {
			vencedor = jogador1.informarVencedor();
			if (vencedor) {
				nomeVencedor = jogador1.informarNome();
			} else {
				vencedor = jogador2.informarVencedor();
				if (vencedor) {
					nomeVencedor = jogador2.informarNome();
				}
			}
			if (vencedor) {
				mensagem = ("VENCEDOR:  " + nomeVencedor);
			} else {
				mensagem = ("Partida encerrada com empate");
			}
			if (jogador1.informarSimbolo()) {				
				placarBranco = jogador1.informarQtPecas()+"";
				placarPreto = jogador2.informarQtPecas()+"";				
			} else {				
				placarPreto = jogador1.informarQtPecas()+"";
				placarBranco = jogador2.informarQtPecas()+"";
			}
		}
		estado.assumirMensagem(mensagem);
		// COMPOSICAO DO MAPA E DO PLACAR
		for (int linha = 1; linha < 9; linha++) {
			for (int coluna = 1; coluna < 9; coluna++) {
				Posicao posicao = this.recuperarPosicao(linha, coluna);
				if (posicao.informarOcupada()) {

					Jogador jog = posicao.informarOcupante();

					if (jog.informarSimbolo()) { // se for branco
						Lance lance = obterTipoJogadaSelecaoTurno();
						if (lance != null && lance.informarLinha() == linha
								&& lance.informarColuna() == coluna & lance.informarTipoJogada() == 2) {
							valor = 4;
						} else {
							valor = 1;
						}
						
					} else {
						Lance lance = obterTipoJogadaSelecaoTurno();
						if (lance != null && lance.informarLinha() == linha
								&& lance.informarColuna() == coluna & lance.informarTipoJogada() == 2) {
							valor = 3;
						} else {
							valor = 2;
						}
						
					}

				} else {
					valor = 0;
				}
				estado.assumirValor(linha, coluna, valor);

				String textoPlacar = ("(branco):  " + placarBranco + "   /   " + "(preto):  "
						+ placarPreto );  

				estado.assumirPlacar("Nº Peças:   " + textoPlacar);
			}
			;
		}
		;
		return estado;
	}

	private Posicao recuperarPosicao(int linha, int coluna) {
		return (posicoes[(linha - 1)][(coluna - 1)]);
	}

	public void iniciar() {
		for (int linha = 1; linha < 9; linha++) {
			for (int coluna = 1; coluna < 9; coluna++) {
				posicoes[(linha - 1)][(coluna - 1)] = new Posicao();
			}			
		}
	}

	public void criarJogador(String idJogador) {
		if (jogador1 == null) {
			jogador1 = new Jogador();
			jogador1.iniciar();
			jogador1.assumirNome(idJogador);
		} else {
			jogador2 = new Jogador();
			jogador2.iniciar();
			jogador2.assumirNome(idJogador);
		}
	}

	public void habilitar(Integer posicao) {
		partidaEmAndamento = true;
		if (posicao == 1) {
			jogador1.habilitar();
			jogador1.assumirSimbolo(true);
			jogador2.assumirSimbolo(false);
		} else {
			jogador2.habilitar();
			jogador2.assumirSimbolo(true);
			jogador1.assumirSimbolo(false);
		}
	}

	public void esvaziar() {
		for (int linha = 1; linha < 9; linha++) {
			for (int coluna = 1; coluna < 9; coluna++) {
				posicoes[(linha - 1)][(coluna - 1)].esvaziar();
			}			
		}		
		jogador1 = null;
		jogador2 = null;
		partidaEmAndamento = false;
		resetarTurno();
	}

	public void receberJogada(Lance jogada) {
		int linha = jogada.informarLinha();
		int coluna = jogada.informarColuna();
		int tpJogada = jogada.informarTipoJogada();
		int resultado;
		Jogador jog = obterJogadorDaVez();
		if (tpJogada == 1) {
			resultado = tratarPrimeiroTurno(linha, coluna, jog);
			return;
		}
		resultado = this.tratarLance(jog, linha, coluna);
		if (resultado == 9) {
			this.finalizarPartida();
		}
	}

	// 2 = selecionar
	// 3 = colocar
	// 4 = mover

	public int definirTipoJogada(Jogador jogador, int linha, int coluna) {
		int tipoJogadaAnterior = jogador.obterTipoJogada();
		boolean vez = jogador.informarDaVez();
		boolean ocupada = this.verificarOcupada(linha, coluna);
		Posicao posicaoAtual = this.recuperarPosicao(linha, coluna);

		if (vez) {
			if (tipoJogadaAnterior == 2) {
				return 4;
			} else if (ocupada && jogador.equals(posicaoAtual.informarOcupante())) {
				return 2;
		
			
			} else {
				return 3;
			}
		} else {
			return tipoJogadaAnterior;
		}
	}

	public void mover(Jogador jogador, int linha, int coluna) {
		Lance lanceAnterior = obterTipoJogadaSelecaoTurno();
		Posicao posicaoAnterior = this.recuperarPosicao(lanceAnterior.informarLinha(), lanceAnterior.informarColuna());
		posicaoAnterior.esvaziar();
		jogador.qtPecas++;
		colocarPeca(jogador, linha, coluna);
	}

	public Lance obterTipoJogadaSelecaoTurno() {
		Lance lance = null;
		if (turno.size() > 0) {
			for (int i = 0; i < turno.size(); i++) {
				lance = turno.get(i);
				if (lance.informarTipoJogada() == 2) {
					return lance;
				}
			}
		}
		return lance;
	}

	public void deselecionar() {
		for (int i = 0; i < turno.size(); i++) {
			turno.get(i);
			if (turno.get(i).informarTipoJogada() == 2) {
				turno.remove(i);
			}
		}
	}

	public int validarMover(Jogador jogador, int linha, int coluna) {
		boolean ocupada = this.verificarOcupada(linha, coluna);
		Posicao posicaoAtual = this.recuperarPosicao(linha, coluna);
		Lance lanceAnterior = obterTipoJogadaSelecaoTurno();
		if (lanceAnterior.informarLinha() == linha && lanceAnterior.informarColuna() == coluna) {
			deselecionar();
			return 10;
		}
		if (ocupada && !jogador.equals(posicaoAtual.informarOcupante())) {
			return 11;
		} else if (!validarPosicaoMover(jogador, linha, coluna)) {
			return 12;
		} else {
			return 0;
		}

	}

	public int tratarLance(Jogador jogador, int linha, int coluna) {		
		boolean vez = jogador.informarDaVez();
		int tipoJogada = definirTipoJogada(jogador, linha, coluna);

		if (tipoJogada == 2) {
			if (vez) {
				if (!turno.isEmpty()) {
					Lance lanceAnterior = turno.get(turno.size() - 1);
					if (lanceAnterior.informarTipoJogada() == 4) {
						return 17; // Jogada não permitida // mover 2x no mesmo
									// turno
					}
				}

				jogador.definirTipoJogada(tipoJogada);
				Lance lance = informarJogada(linha, coluna, tipoJogada);
				turno.add(lance);
			}
			return 14; // jogador continua com a vez e faz novo lance para mover
						// a peça
			
		} else if (tipoJogada == 4) {
			if (vez) {
				int resultado = validarMover(jogador, linha, coluna); 
				if (resultado != 0) {
					return resultado;
				}
				mover(jogador, linha, coluna);
			}
			jogador.definirTipoJogada(tipoJogada);
			Lance lance = informarJogada(linha, coluna, tipoJogada);
			turno.add(lance);

			if (completouTurno()) {
				mudarVezJogador(jogador);
				resetarTurno();
			}
			if (avaliarTerminoPartida(jogador)) {
				this.finalizarPartida();
				return 9;
			}
			;
			return 16;
			
		} else if (tipoJogada == 3) {
			int resultado = this.validarColocar(jogador, linha, coluna);

			if (resultado == 0) {
				colocarPeca(jogador, linha, coluna);
				jogador.definirTipoJogada(tipoJogada);
				Lance lance = informarJogada(linha, coluna, tipoJogada);
				turno.add(lance);
				if (completouTurno()) {
					mudarVezJogador(jogador);
					resetarTurno();
				}				
				if (avaliarTerminoPartida(jogador)) {
					this.finalizarPartida();
					return 9;
				}else
				return 10;
				
			} else {
				return  resultado;
			}
			
		} else {
			if (avaliarTerminoPartida(jogador)) {
				return 9;
			} else {
				return 0;
			}
		}
	}
	
	public int validarColocar(Jogador jogador, int linha, int coluna) {
		boolean ocupada = this.verificarOcupada(linha, coluna);
		Posicao posicaoAtual = this.recuperarPosicao(linha, coluna);
		int resultado = 0;
		if (ocupada && !jogador.equals(posicaoAtual.informarOcupante())) {
			return 11;
		}
		if (!turno.isEmpty()) {
			Lance lanceAnterior = turno.get(turno.size() - 1);
			if (lanceAnterior.informarTipoJogada() == 3) {
				return 17; // Jogada não permitida // colocar 2x no mesmo
							// turno
			}
		}
		boolean lancePossivel = this.validarPosicaoColocar(jogador, linha, coluna);
		if (!lancePossivel) {
			return 12;
		}
		return resultado;
	}

	public boolean avaliarTerminoPartida(Jogador jogador) {
		if (avaliarVencedor(jogador)) {
			return true;
		}
		if (jogador.informarQtPecas() == 0) {
			partidaEmAndamento = false;
			return true;
		}
		return false;
	}
	
	public boolean avaliarVencedor(Jogador jogador) {
		Posicao auxPosicao;
		if (jogador.informarSimbolo()) { // true é branco
			for (int linha = 1; linha < 9; linha++) {
				int contador = 0;
				for (int coluna = 1; coluna < 9; coluna++) {
					auxPosicao = this.recuperarPosicao(linha, coluna);
					if ((auxPosicao.informarOcupada())) {
						if (auxPosicao.informarOcupante() == jogador) {
							contador++;
						}
					}
				}
				if (contador == 8) {
					jogador.assumirVencedor();
					partidaEmAndamento = false;
					return true;
				}
			}
		} else { // preto
			for (int coluna = 1; coluna < 9; coluna++) {
				int contador = 0;

				for (int linha = 1; linha < 9; linha++) {
					auxPosicao = this.recuperarPosicao(linha, coluna);
					if ((auxPosicao.informarOcupada())) {
						if (auxPosicao.informarOcupante() == jogador) {
							contador++;
						}
					}
				}
				if (contador == 8) {
					jogador.assumirVencedor();
					partidaEmAndamento = false;
					return true;
				}
			}
		}
		return false;
	}

	public void colocarPeca(Jogador jogador, int linha, int coluna) {
		Posicao posicao = this.recuperarPosicao(linha, coluna);
		posicao.alocar(jogador);
		jogador.qtPecas--;
	}

	public boolean verificarOcupada(int linha, int coluna) {
		Posicao posicao = this.recuperarPosicao(linha, coluna);
		return (posicao.informarOcupada());
	}

	public boolean validarPosicaoMover(Jogador jogador, int linha, int coluna) {
		boolean posicaoValida = false;
		Lance lanceAnterior = obterTipoJogadaSelecaoTurno();
		int linhaAnterior = lanceAnterior.informarLinha();
		int colunaAnterior = lanceAnterior.informarColuna();

		for (int direcao = 1; direcao < 9; direcao++) {
			Lance lanceAux;
			int vLinha = linha;
			int vColuna = coluna;
			boolean continuar = true;
			while (continuar) {
				lanceAux = this.informarProximaPosicaoMover(vLinha, vColuna, direcao);

				vLinha = this.incrementarLinha(vLinha, direcao);
				vColuna = this.incrementarColuna(vColuna, direcao);
				if (lanceAux != null) {
					if (lanceAux.informarLinha() == linhaAnterior && lanceAux.informarColuna() == colunaAnterior) {
						posicaoValida = true;
						break;
					}
				} else {
					continuar = false;
				}
			}
		}
		return posicaoValida;
	}

	public Lance informarProximaPosicaoMover(int linha, int coluna, int direcao) {
		int vLinha = linha;
		int vColuna = coluna;
		switch (direcao) {
		case 1:
			vLinha--;
			break; /* Norte */
		case 2: {
			vLinha--;
			vColuna++;
		}
			;
			break; /* Nordeste */
		case 3:
			vColuna++;
			break; /* Leste */
		case 4: {
			vColuna++;
			vLinha++;
		}
			;
			break; /* Sudeste */
		case 5:
			vLinha++;
			break; /* Sul */
		case 6: {
			vColuna--;
			vLinha++;
		}
			;
			break; /* Sudoeste */
		case 7:
			vColuna--;
			break; /* Oeste */
		case 8: {
			vColuna--;
			vLinha--;
		}
			;
			break; /* Noroeste */
		}
		;
		if ((vLinha > 0 && vLinha < 9) && (vColuna > 0 && vColuna < 9)) {
			Lance retorno = this.informarJogada(vLinha, vColuna, 0);
			return retorno;
		} else {
			return null;
		}
	}

	public boolean validarPosicaoColocar(Jogador jogador, int linha, int coluna) {
		boolean posicaoValida = false;

		for (int direcao = 1; direcao < 5; direcao++) {

			int vLinha = linha;
			int vColuna = coluna;
			Posicao auxPosicao;
			boolean continuar = true;
			while (continuar) {
				auxPosicao = this.informarProximaPosicaoColocarPeca(vLinha, vColuna, direcao);
				if (auxPosicao != null) {
					if (auxPosicao.informarOcupada()) {
						if (auxPosicao.informarOcupante().equals(jogador)) {
							posicaoValida = true;
							break;
						} else {
							continuar = false;
						}
						;
					} else {
						continuar = false;
					}
					;
				} else {
					continuar = false;
				}
				;
			}
			;
		}
		return posicaoValida;
	}

	public Posicao informarProximaPosicaoColocarPeca(int linha, int coluna, int direcao) {
		int vLinha = linha;
		int vColuna = coluna;
		switch (direcao) {
		case 1:
			vLinha--;
			break; /* Norte */
		case 2:
			vColuna++;
			break; /* Leste */
		case 3:
			vLinha++;
			break; /* Sul */
		case 4:
			vColuna--;
			break; /* Oeste */
		}
		;
		if ((vLinha > 0 && vLinha < 9) && (vColuna > 0 && vColuna < 9)) {
			Posicao posRetorno = this.recuperarPosicao(vLinha, vColuna);
			return posRetorno;
		} else {
			return null;
		}
	}

	public int incrementarColuna(int coluna, int direcao) {
		int vColuna = coluna;
		switch (direcao) {
		case 1:
			break; /* Norte */
		case 2:
			vColuna++;
			break; /* Nordeste */
		case 3:
			vColuna++;
			break; /* Leste */
		case 4:
			vColuna++;
			break; /* Sudeste */
		case 5:
			break; /* Sul */
		case 6:
			vColuna--;
			break; /* Sudoeste */
		case 7:
			vColuna--;
			break; /* Oeste */
		case 8:
			vColuna--;
			break; /* Noroeste */
		}
		;
		return vColuna;
	}

	public int incrementarLinha(int linha, int direcao) {
		int vLinha = linha;
		switch (direcao) {
		case 1:
			vLinha--;
			break; /* Norte */
		case 2:
			vLinha--;
			break; /* Nordeste */
		case 3:
			break; /* Leste */
		case 4:
			vLinha++;
			break; /* Sudeste */
		case 5:
			vLinha++;
			break; /* Sul */
		case 6:
			vLinha++;
			break; /* Sudoeste */
		case 7:
			break; /* Oeste */
		case 8:
			vLinha--;
			break; /* Noroeste */
		}
		;
		return vLinha;
	}

	public void finalizarPartida() {
		partidaEmAndamento = false;
		jogador1.desabilitar();
		jogador2.desabilitar();
	}

}
