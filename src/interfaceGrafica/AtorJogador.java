package interfaceGrafica;

import negocio.ImagemDeTabuleiro;
import negocio.Lance;
import negocio.Tabuleiro;
import rede.AtorNetGames;

public class AtorJogador {

	protected Tabuleiro tab;
	protected AtorNetGames rede;
	protected InterfaceSesqui janela;
	protected String idUsuario;

	public AtorJogador (InterfaceSesqui jan){
		super();
		rede = new AtorNetGames(this);
		janela = jan;
		tab = new Tabuleiro();
		tab.iniciar();
	}

	public int conectar() {
		boolean conectado = tab.verificarStatusConectado();
		if (!conectado){
			String servidor = this.obterDadosConexao();
			boolean exito = rede.conectar(servidor, idUsuario);
			if (exito){
				tab.definirStausConexao(true);
				return 0;
			}else{
				return 2;
			}			
		}else{
			return 1;
		}		
	}

	public InterfaceSesqui informarJanela() {
		return janela;
	}

	public String obterDadosConexao() {
		idUsuario = janela.obterIdJogador();
		String servidor = janela.obterIdServidor();
		return servidor;
	}

	public int desconectar() {
		boolean conectado = tab.verificarStatusConectado();
		if (conectado){
			boolean exito = rede.desconectar();
			if (exito){
				tab.definirStausConexao(false);
				return 3;
			}else{
				return 5;
			}			
		}else{
			return 4;
		}			
	}

	public int iniciarPartida() {
		boolean conectado = false;
		boolean interromper = false;
		boolean emAndamento = tab.informarEmAndamento();
		if (emAndamento){
			interromper = this.avaliarInterrupcao();
		}else{
			conectado = tab.verificarStatusConectado();
		}
		if (interromper || ((!emAndamento) && conectado)){
			rede.iniciarPartida();
			return 6;
		}
		if (!conectado) {
			return 7;
		}
		return 13;
	}

	public boolean avaliarInterrupcao() {
		return true;
	}
	
	public int obterTipoJogada(int resultado){		
		switch(resultado){
		case 10:
			return 3;
		case 14:
			return 2;
		case 15:
			return 1;
		case 16:
			return 4;
		default:
			return 0;		
		}		
	}

	public int click(int linha, int coluna) {
		int resultado = 0;
		resultado = tab.click(linha, coluna);
		int tpJogada = obterTipoJogada(resultado);
		if ((resultado == 10) || (resultado == 9) || (resultado == 14) || (resultado == 15) || (resultado == 16)){
			this.enviarJogada(linha, coluna, tpJogada);		
		}
		return resultado;
	}

	public void enviarJogada(int linha, int coluna, int tpJogada) {
		Lance lance = tab.informarJogada(linha, coluna, tpJogada);
		rede.enviarJogada(lance);
	}

	public ImagemDeTabuleiro informarEstado() {
		ImagemDeTabuleiro estado = tab.informarEstado();
		return estado;
	}
	
	public void tratarIniciarPartida(Integer posicao) {
		tab.esvaziar();
		tab.criarJogador(idUsuario);
		String idJogador = rede.informarNomeAdversario(idUsuario);
		tab.criarJogador(idJogador);
		tab.habilitar(posicao);
		janela.exibirEstado();		
	}

	public void receberJogada(Lance jogada) {
		tab.receberJogada(jogada);
		janela.exibirEstado();
	}

}