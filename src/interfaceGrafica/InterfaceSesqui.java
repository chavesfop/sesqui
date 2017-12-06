package interfaceGrafica;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import negocio.ImagemDeTabuleiro;

public class InterfaceSesqui extends JFrame {

    protected AtorJogador jogo;
    protected boolean emRede = false;
    protected String idJ1 = "";
    protected JLabel mapaVPosicao[][] = new JLabel[8][8];

    private static final long serialVersionUID = 1L;
    private int linha;
    private int coluna;

    private JPanel jContentPane = null;
    private JMenuBar jMenuBar1 = null;
    private JMenu menuJogo = null;
    private JMenuItem jMenuItem1 = null;
    private JMenuItem jMenuItem2 = null;
    private JMenuItem jMenuItem3 = null;
    private JLabel vMensagem = null;
    private JLabel vPlacar = null;

    public InterfaceSesqui() throws HeadlessException {
        super();
        initialize();
    }

    public InterfaceSesqui(GraphicsConfiguration arg0) {
        super(arg0);
        initialize();
    }

    public InterfaceSesqui(String arg0) throws HeadlessException {
        super(arg0);
        initialize();
    }

    public InterfaceSesqui(String arg0, GraphicsConfiguration arg1) {
        super(arg0, arg1);
        initialize();
    }

    private void initialize() {
        this.setSize(600, 680);
        this.setContentPane(getJContentPane());
        this.setLocation(200, 100);
        this.setTitle("UFSC - Sesqui");
        this.setResizable(false);
        jogo = new AtorJogador(this);
    }

    private JPanel getJContentPane() {
        if (jContentPane == null) {

            Icon vazia = new ImageIcon(getClass().getResource("vazio.gif"));

            vMensagem = new JLabel();
            vMensagem.setBounds(new Rectangle(25, 10, 250, 20));
            vMensagem.setText("Jogador: ");

            vPlacar = new JLabel();
            vPlacar.setBounds(new Rectangle(300, 10, 280, 20));
            vPlacar.setText("Numero de pecas:");

            jContentPane = new JPanel();
            jContentPane.setLayout(null);

            for (linha = 0; linha < 8; linha++) {
                for (coluna = 0; coluna < 8; coluna++) {
                    mapaVPosicao[linha][coluna] = new JLabel();
                    mapaVPosicao[linha][coluna].setBounds(new Rectangle(20 + (linha * 70), 40 + (coluna * 70), 70, 70));
                    mapaVPosicao[linha][coluna].setIcon(vazia);
                    mapaVPosicao[linha][coluna].addMouseListener(new java.awt.event.MouseAdapter() {
                        @Override
                        public void mouseClicked(java.awt.event.MouseEvent e) {
                            click(linha + 1, coluna + 1);
                        }
                    });
                    jContentPane.add(mapaVPosicao[linha][coluna], null);
                }
            }

            jMenuBar1 = new JMenuBar();
            jMenuBar1.add(getMenu());
            this.setJMenuBar(jMenuBar1);

            jContentPane.add(vMensagem, null);
            jContentPane.add(vPlacar, null);
        }
        return jContentPane;
    }

    private JMenu getMenu() {
        if (menuJogo == null) {
            menuJogo = new JMenu();
            menuJogo.setText("Jogo");
            menuJogo.setBounds(new Rectangle(1, 0, 57, 21));
            menuJogo.add(getJMenuItem1());
            menuJogo.add(getJMenuItem2());
            menuJogo.add(getJMenuItem3());

        }
        return menuJogo;
    }

    private JMenuItem getJMenuItem1() {
        if (jMenuItem1 == null) {
            jMenuItem1 = new JMenuItem();
            jMenuItem1.setText("iniciar nova partida");
            jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    iniciarPartida();
                }
            });
        }
        return jMenuItem1;
    }

    private JMenuItem getJMenuItem2() {
        if (jMenuItem2 == null) {
            jMenuItem2 = new JMenuItem();
            jMenuItem2.setText("conectar");
            jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    conectar();
                }
            });
        }
        return jMenuItem2;
    }

    private JMenuItem getJMenuItem3() {
        if (jMenuItem3 == null) {
            jMenuItem3 = new JMenuItem();
            jMenuItem3.setText("desconectar");
            jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    desconectar();
                }
            });
        }
        return jMenuItem3;
    }

    public void conectar() {
        int resultado = jogo.conectar();

        this.notificarResultado(resultado);
    }

    public void desconectar() {
        int resultado = jogo.desconectar();
        this.notificarResultado(resultado);
    }

    public void iniciarPartida() {
        int resultado = jogo.iniciarPartida();
        this.notificarResultado(resultado);
    }

    public String obterIdJogador() {
        String idJogador = ("jogador");
        idJogador = JOptionPane.showInputDialog(this, ("Insira o nome do jogador"));
        vMensagem.setBounds(new Rectangle(25, 10, 300, 20));
        vMensagem.setText("Jogador: " + idJogador);
        jContentPane.add(vMensagem, null);

        return idJogador;
    }

    public String obterIdServidor() {
        //String idServidor = ("venus.inf.ufsc.br");
        String idServidor = ("localhost");
        idServidor = JOptionPane.showInputDialog(this, ("Insira o endereço do servidor"), idServidor);
        return idServidor;
    }

    public void click(int linha, int coluna) {
        int resultado = 0;
        resultado = jogo.click(linha, coluna);

        if ((resultado == 10) || (resultado == 9) || (resultado == 14) || (resultado == 15) || (resultado == 16)) {
            this.exibirEstado();
            if (resultado == 9) {
                this.notificarResultado(resultado);
            }
        } else {
            this.notificarResultado(resultado);
        }
    }

    public void exibirEstado() {
        ImagemDeTabuleiro estado;
        estado = jogo.informarEstado();
        this.atualizarWidgets(estado);
    }

    public void atualizarWidgets(ImagemDeTabuleiro estado) {
        int valor = 0;
        Icon branco = new ImageIcon(getClass().getResource("branco.gif"));
        Icon preto = new ImageIcon(getClass().getResource("preto.gif"));
        Icon vazia = new ImageIcon(getClass().getResource("vazio.gif"));
        Icon selectPreto = new ImageIcon(getClass().getResource("preto_select.png"));
        Icon selectBranco = new ImageIcon(getClass().getResource("branco_select.png"));
        vMensagem.setText(estado.informarMensagem());
        vPlacar.setText(estado.informarPlacar());
        for (int linha = 1; linha < 9; linha++) {
            for (int coluna = 1; coluna < 9; coluna++) {
                valor = estado.informarValor(linha, coluna);
                switch (valor) {
                    case 0:
                        mapaVPosicao[(linha - 1)][(coluna - 1)].setIcon(vazia);
                        break;
                    case 1:
                        mapaVPosicao[(linha - 1)][(coluna - 1)].setIcon(branco);
                        break;
                    case 2:
                        mapaVPosicao[(linha - 1)][(coluna - 1)].setIcon(preto);
                        break;
                    case 3:
                        mapaVPosicao[(linha - 1)][(coluna - 1)].setIcon(selectPreto);
                        break;
                    case 4:
                        mapaVPosicao[(linha - 1)][(coluna - 1)].setIcon(selectBranco);
                        break;
                }
            };
        };
    }

    public void notificarResultado(int codigo) {
        switch (codigo) {
            case 0:
                JOptionPane.showMessageDialog(this, "Conexão efetuada com exito");
                break;
            case 1:
                JOptionPane.showMessageDialog(this, "Tentativa de conexão com conexão previamente estabelecida");
                break;
            case 2:
                JOptionPane.showMessageDialog(this, "Tentativa de conexao falhou");
                break;
            case 3:
                JOptionPane.showMessageDialog(this, "Desconexão efetuada com exito");
                break;
            case 4:
                JOptionPane.showMessageDialog(this, "Tentativa de desconexao sem conexao previamente estabelecida");
                break;
            case 5:
                JOptionPane.showMessageDialog(this, "Tentativa de desconexao falhou");
                break;
            case 6:
                JOptionPane.showMessageDialog(this, "Solicitação de inicio procedida com êxito");
                break;
            case 7:
                JOptionPane.showMessageDialog(this, "Tentativa de inicio sem conexao previamente estabelecida");
                break;
            case 8:
                JOptionPane.showMessageDialog(this, "Não é a sua vez");
                break;
            case 9:
                JOptionPane.showMessageDialog(this, "Partida encerrada");
                break;
            case 10:
                JOptionPane.showMessageDialog(this, "Lance OK");
                break;
            case 11:
                JOptionPane.showMessageDialog(this, "Posição ocupada");
                break;
            case 12:
                JOptionPane.showMessageDialog(this, "Posição ilegal");
                break;
            case 13:
                JOptionPane.showMessageDialog(this, "Partida corrente não interrompida");
                break;
            case 17:
                JOptionPane.showMessageDialog(this, "Jogada não permitida");
                break;
        };
    }

}
