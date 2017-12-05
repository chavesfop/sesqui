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
	
	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;
	
	protected boolean emRede = false;
	protected String idJ1 = "";
	
	private JLabel vPosicao11 = null;
	private JLabel vPosicao12 = null;
	private JLabel vPosicao13 = null;	
	private JLabel vPosicao14 = null;
	private JLabel vPosicao15 = null;
	private JLabel vPosicao16 = null;
	private JLabel vPosicao17 = null;
	private JLabel vPosicao18 = null;

	private JLabel vPosicao21 = null;
	private JLabel vPosicao22 = null;
	private JLabel vPosicao23 = null;	
	private JLabel vPosicao24 = null;
	private JLabel vPosicao25 = null;
	private JLabel vPosicao26 = null;
	private JLabel vPosicao27 = null;
	private JLabel vPosicao28 = null;
	
	private JLabel vPosicao31 = null;
	private JLabel vPosicao32 = null;
	private JLabel vPosicao33 = null;	
	private JLabel vPosicao34 = null;
	private JLabel vPosicao35 = null;
	private JLabel vPosicao36 = null;
	private JLabel vPosicao37 = null;
	private JLabel vPosicao38 = null;
	
	private JLabel vPosicao41 = null;
	private JLabel vPosicao42 = null;
	private JLabel vPosicao43 = null;	
	private JLabel vPosicao44 = null;
	private JLabel vPosicao45 = null;
	private JLabel vPosicao46 = null;
	private JLabel vPosicao47 = null;
	private JLabel vPosicao48 = null;
	
	private JLabel vPosicao51 = null;
	private JLabel vPosicao52 = null;
	private JLabel vPosicao53 = null;	
	private JLabel vPosicao54 = null;
	private JLabel vPosicao55 = null;
	private JLabel vPosicao56 = null;
	private JLabel vPosicao57 = null;
	private JLabel vPosicao58 = null;
	
	private JLabel vPosicao61 = null;
	private JLabel vPosicao62 = null;
	private JLabel vPosicao63 = null;	
	private JLabel vPosicao64 = null;
	private JLabel vPosicao65 = null;
	private JLabel vPosicao66 = null;
	private JLabel vPosicao67 = null;
	private JLabel vPosicao68 = null;
	
	private JLabel vPosicao71 = null;
	private JLabel vPosicao72 = null;
	private JLabel vPosicao73 = null;	
	private JLabel vPosicao74 = null;
	private JLabel vPosicao75 = null;
	private JLabel vPosicao76 = null;
	private JLabel vPosicao77 = null;
	private JLabel vPosicao78 = null;
	
	private JLabel vPosicao81 = null;
	private JLabel vPosicao82 = null;
	private JLabel vPosicao83 = null;	
	private JLabel vPosicao84 = null;
	private JLabel vPosicao85 = null;
	private JLabel vPosicao86 = null;
	private JLabel vPosicao87 = null;
	private JLabel vPosicao88 = null;
	
	protected JLabel mapaVPosicao[][] = new JLabel[8][8];

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
		this.setSize(620, 680);
		this.setContentPane(getJContentPane());
		this.setLocation(200,100);
		this.setTitle("Sesqui");
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
			vPlacar.setText("Número de peças:");
			
			vPosicao11 = new JLabel();
			vPosicao11.setBounds(new Rectangle(20, 40, 70, 70));
			vPosicao11.setIcon(vazia);				
			vPosicao11.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(1,1); 
				}
			});
			
			vPosicao12 = new JLabel();
			vPosicao12.setBounds(new Rectangle(90, 40, 70, 70));
			vPosicao12.setIcon(vazia);
			vPosicao12.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(1,2); 
				}
			});
			
			vPosicao13 = new JLabel();
			vPosicao13.setIcon(vazia);
			vPosicao13.setBounds(new Rectangle(160, 40, 70, 70));
			vPosicao13.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(1,3); 
				}
			});
			
			vPosicao14 = new JLabel();
			vPosicao14.setIcon(vazia);
			vPosicao14.setBounds(new Rectangle(230, 40, 70, 70));
			vPosicao14.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(1,4); 
				}
			});
			
			vPosicao15 = new JLabel();
			vPosicao15.setIcon(vazia);
			vPosicao15.setBounds(new Rectangle(300, 40, 70, 70));
			vPosicao15.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(1,5); 
				}
			});

			vPosicao16 = new JLabel();
			vPosicao16.setIcon(vazia);
			vPosicao16.setBounds(new Rectangle(370, 40, 70, 70));
			vPosicao16.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(1,6); 
				}
			});

			vPosicao17 = new JLabel();
			vPosicao17.setIcon(vazia);
			vPosicao17.setBounds(new Rectangle(440, 40, 70, 70));
			vPosicao17.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(1,7); 
				}
			});

			vPosicao18 = new JLabel();
			vPosicao18.setIcon(vazia);
			vPosicao18.setBounds(new Rectangle(510, 40, 70, 70));
			vPosicao18.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(1,8); 
				}
			});
	
			vPosicao21 = new JLabel();
			vPosicao21.setBounds(new Rectangle(20, 110, 70, 70));
			vPosicao21.setIcon(vazia);
			vPosicao21.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(2,1); 
				}
			});
			
			vPosicao22 = new JLabel();
			vPosicao22.setBounds(new Rectangle(90, 110, 70, 70));
			vPosicao22.setIcon(vazia);
			vPosicao22.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(2,2); 
				}
			});
			
			vPosicao23 = new JLabel();
			vPosicao23.setBounds(new Rectangle(160, 110, 70, 70));
			vPosicao23.setIcon(vazia);
			vPosicao23.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(2,3); 
				}
			});
			
			vPosicao24 = new JLabel();
			vPosicao24.setIcon(vazia);
			vPosicao24.setBounds(new Rectangle(230, 110, 70, 70));
			vPosicao24.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(2,4); 
				}
			});
			
			vPosicao25 = new JLabel();
			vPosicao25.setIcon(vazia);
			vPosicao25.setBounds(new Rectangle(300, 110, 70, 70));
			vPosicao25.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(2,5); 
				}
			});

			vPosicao26 = new JLabel();
			vPosicao26.setIcon(vazia);
			vPosicao26.setBounds(new Rectangle(370, 110, 70, 70));
			vPosicao26.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(2,6); 
				}
			});

			vPosicao27 = new JLabel();
			vPosicao27.setIcon(vazia);
			vPosicao27.setBounds(new Rectangle(440, 110, 70, 70));
			vPosicao27.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(2,7); 
				}
			});

			vPosicao28 = new JLabel();
			vPosicao28.setIcon(vazia);
			vPosicao28.setBounds(new Rectangle(510, 110, 70, 70));
			vPosicao28.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(2,8); 
				}
			});
			
			vPosicao31 = new JLabel();
			vPosicao31.setBounds(new Rectangle(20, 180, 70, 70));
			vPosicao31.setIcon(vazia);
			vPosicao31.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(3,1);
				}
			});
			
			vPosicao32 = new JLabel();
			vPosicao32.setBounds(new Rectangle(90, 180, 70, 70));
			vPosicao32.setIcon(vazia);
			vPosicao32.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(3,2); 
				}
			});
			
			vPosicao33 = new JLabel();
			vPosicao33.setBounds(new Rectangle(160, 180, 70, 70));
			vPosicao33.setIcon(vazia);
			vPosicao33.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(3,3); 
				}
			});
			
			vPosicao34 = new JLabel();
			vPosicao34.setIcon(vazia);
			vPosicao34.setBounds(new Rectangle(230, 180, 70, 70));
			vPosicao34.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(3,4); 
				}
			});
			
			vPosicao35 = new JLabel();
			vPosicao35.setIcon(vazia);
			vPosicao35.setBounds(new Rectangle(300, 180, 70, 70));
			vPosicao35.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(3,5); 
				}
			});

			vPosicao36 = new JLabel();
			vPosicao36.setIcon(vazia);
			vPosicao36.setBounds(new Rectangle(370, 180, 70, 70));
			vPosicao36.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(3,6); 
				}
			});

			vPosicao37 = new JLabel();
			vPosicao37.setIcon(vazia);
			vPosicao37.setBounds(new Rectangle(440, 180, 70, 70));
			vPosicao37.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(3,7); 
				}
			});

			vPosicao38 = new JLabel();
			vPosicao38.setIcon(vazia);
			vPosicao38.setBounds(new Rectangle(510, 180, 70, 70));
			vPosicao38.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(3,8); 
				}
			});
			
			vPosicao41 = new JLabel();
			vPosicao41.setBounds(new Rectangle(20, 250, 70, 70));
			vPosicao41.setIcon(vazia);
			vPosicao41.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(4,1);
				}
			});
			
			vPosicao42 = new JLabel();
			vPosicao42.setBounds(new Rectangle(90, 250, 70, 70));
			vPosicao42.setIcon(vazia);
			vPosicao42.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(4,2); 
				}
			});
			
			vPosicao43 = new JLabel();
			vPosicao43.setBounds(new Rectangle(160, 250, 70, 70));
			vPosicao43.setIcon(vazia);
			vPosicao43.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(4,3); 
				}
			});
			
			vPosicao44 = new JLabel();
			vPosicao44.setIcon(vazia);
			vPosicao44.setBounds(new Rectangle(230, 250, 70, 70));
			vPosicao44.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(4,4); 
				}
			});
			
			vPosicao45 = new JLabel();
			vPosicao45.setIcon(vazia);
			vPosicao45.setBounds(new Rectangle(300, 250, 70, 70));
			vPosicao45.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(4,5); 
				}
			});

			vPosicao46 = new JLabel();
			vPosicao46.setIcon(vazia);
			vPosicao46.setBounds(new Rectangle(370, 250, 70, 70));
			vPosicao46.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(4,6); 
				}
			});

			vPosicao47 = new JLabel();
			vPosicao47.setIcon(vazia);
			vPosicao47.setBounds(new Rectangle(440, 250, 70, 70));
			vPosicao47.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(4,7); 
				}
			});

			vPosicao48 = new JLabel();
			vPosicao48.setIcon(vazia);
			vPosicao48.setBounds(new Rectangle(510, 250, 70, 70));
			vPosicao48.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(4,8); 
				}
			});
			
			vPosicao51 = new JLabel();
			vPosicao51.setBounds(new Rectangle(20, 320, 70, 70));
			vPosicao51.setIcon(vazia);
			vPosicao51.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(5,1);
				}
			});
			
			vPosicao52 = new JLabel();
			vPosicao52.setBounds(new Rectangle(90, 320, 70, 70));
			vPosicao52.setIcon(vazia);
			vPosicao52.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(5,2); 
				}
			});
			
			vPosicao53 = new JLabel();
			vPosicao53.setBounds(new Rectangle(160, 320, 70, 70));
			vPosicao53.setIcon(vazia);
			vPosicao53.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(5,3); 
				}
			});
			
			vPosicao54 = new JLabel();
			vPosicao54.setIcon(vazia);
			vPosicao54.setBounds(new Rectangle(230, 320, 70, 70));
			vPosicao54.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(5,4); 
				}
			});
			
			vPosicao55 = new JLabel();
			vPosicao55.setIcon(vazia);
			vPosicao55.setBounds(new Rectangle(300, 320, 70, 70));
			vPosicao55.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(5,5); 
				}
			});

			vPosicao56 = new JLabel();
			vPosicao56.setIcon(vazia);
			vPosicao56.setBounds(new Rectangle(370, 320, 70, 70));
			vPosicao56.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(5,6); 
				}
			});

			vPosicao57 = new JLabel();
			vPosicao57.setIcon(vazia);
			vPosicao57.setBounds(new Rectangle(440, 320, 70, 70));
			vPosicao57.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(5,7); 
				}
			});

			vPosicao58 = new JLabel();
			vPosicao58.setIcon(vazia);
			vPosicao58.setBounds(new Rectangle(510, 320, 70, 70));
			vPosicao58.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(5,8); 
				}
			});
			
			vPosicao61 = new JLabel();
			vPosicao61.setBounds(new Rectangle(20, 390, 70, 70));
			vPosicao61.setIcon(vazia);
			vPosicao61.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(6,1);
				}
			});
			
			vPosicao62 = new JLabel();
			vPosicao62.setBounds(new Rectangle(90, 390, 70, 70));
			vPosicao62.setIcon(vazia);
			vPosicao62.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(6,2); 
				}
			});
			
			vPosicao63 = new JLabel();
			vPosicao63.setBounds(new Rectangle(160, 390, 70, 70));
			vPosicao63.setIcon(vazia);
			vPosicao63.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(6,3); 
				}
			});
			
			vPosicao64 = new JLabel();
			vPosicao64.setIcon(vazia);
			vPosicao64.setBounds(new Rectangle(230, 390, 70, 70));
			vPosicao64.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(6,4); 
				}
			});
			
			vPosicao65 = new JLabel();
			vPosicao65.setIcon(vazia);
			vPosicao65.setBounds(new Rectangle(300, 390, 70, 70));
			vPosicao65.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(6,5); 
				}
			});

			vPosicao66 = new JLabel();
			vPosicao66.setIcon(vazia);
			vPosicao66.setBounds(new Rectangle(370, 390, 70, 70));
			vPosicao66.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(6,6); 
				}
			});

			vPosicao67 = new JLabel();
			vPosicao67.setIcon(vazia);
			vPosicao67.setBounds(new Rectangle(440, 390, 70, 70));
			vPosicao67.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(6,7); 
				}
			});

			vPosicao68 = new JLabel();
			vPosicao68.setIcon(vazia);
			vPosicao68.setBounds(new Rectangle(510, 390, 70, 70));
			vPosicao68.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(6,8); 
				}
			});
			
			
			
			vPosicao71 = new JLabel();
			vPosicao71.setBounds(new Rectangle(20, 460, 70, 70));
			vPosicao71.setIcon(vazia);
			vPosicao71.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(7,1);
				}
			});
			
			vPosicao72 = new JLabel();
			vPosicao72.setBounds(new Rectangle(90, 460, 70, 70));
			vPosicao72.setIcon(vazia);
			vPosicao72.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(7,2); 
				}
			});
			
			vPosicao73 = new JLabel();
			vPosicao73.setBounds(new Rectangle(160, 460, 70, 70));
			vPosicao73.setIcon(vazia);
			vPosicao73.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(7,3); 
				}
			});
			
			vPosicao74 = new JLabel();
			vPosicao74.setIcon(vazia);
			vPosicao74.setBounds(new Rectangle(230, 460, 70, 70));
			vPosicao74.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(7,4); 
				}
			});
			
			vPosicao75 = new JLabel();
			vPosicao75.setIcon(vazia);
			vPosicao75.setBounds(new Rectangle(300, 460, 70, 70));
			vPosicao75.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(7,5); 
				}
			});

			vPosicao76 = new JLabel();
			vPosicao76.setIcon(vazia);
			vPosicao76.setBounds(new Rectangle(370, 460, 70, 70));
			vPosicao76.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(7,6); 
				}
			});

			vPosicao77 = new JLabel();
			vPosicao77.setIcon(vazia);
			vPosicao77.setBounds(new Rectangle(440, 460, 70, 70));
			vPosicao77.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(7,7); 
				}
			});

			vPosicao78 = new JLabel();
			vPosicao78.setIcon(vazia);
			vPosicao78.setBounds(new Rectangle(510, 460, 70, 70));
			vPosicao78.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(7,8); 
				}
			});		
			
			vPosicao81 = new JLabel();
			vPosicao81.setBounds(new Rectangle(20, 530, 70, 70));
			vPosicao81.setIcon(vazia);
			vPosicao81.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(8,1); 
				}
			});
			
			vPosicao82 = new JLabel();
			vPosicao82.setBounds(new Rectangle(90, 530, 70, 70));
			vPosicao82.setIcon(vazia);
			vPosicao82.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(8,2); 
				}
			});
			
			vPosicao83 = new JLabel();
			vPosicao83.setBounds(new Rectangle(160, 530, 70, 70));
			vPosicao83.setIcon(vazia);
			vPosicao83.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(8,3); 
				}
			});
			
			vPosicao84 = new JLabel();
			vPosicao84.setIcon(vazia);
			vPosicao84.setBounds(new Rectangle(230, 530, 70, 70));
			vPosicao84.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(8,4); 
				}
			});
			
			vPosicao85 = new JLabel();
			vPosicao85.setIcon(vazia);
			vPosicao85.setBounds(new Rectangle(300, 530, 70, 70));
			vPosicao85.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(8,5); 
				}
			});

			vPosicao86 = new JLabel();
			vPosicao86.setIcon(vazia);
			vPosicao86.setBounds(new Rectangle(370, 530, 70, 70));
			vPosicao86.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(8,6); 
				}
			});

			vPosicao87 = new JLabel();
			vPosicao87.setIcon(vazia);
			vPosicao87.setBounds(new Rectangle(440, 530, 70, 70));
			vPosicao87.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(8,7); 
				}
			});

			vPosicao88 = new JLabel();
			vPosicao88.setIcon(vazia);
			vPosicao88.setBounds(new Rectangle(510, 530, 70, 70));
			vPosicao88.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(8,8); 
				}
			});
			
			jMenuBar1 = new JMenuBar();
			jMenuBar1.add(getMenu());
		    this.setJMenuBar(jMenuBar1);

			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(vPosicao11, null);
			jContentPane.add(vPosicao12, null);
			jContentPane.add(vPosicao13, null);
			jContentPane.add(vPosicao14, null);
			jContentPane.add(vPosicao15, null);
			jContentPane.add(vPosicao16, null);
			jContentPane.add(vPosicao17, null);
			jContentPane.add(vPosicao18, null);
			
			jContentPane.add(vPosicao21, null);
			jContentPane.add(vPosicao22, null);
			jContentPane.add(vPosicao23, null);
			jContentPane.add(vPosicao24, null);
			jContentPane.add(vPosicao25, null);
			jContentPane.add(vPosicao26, null);
			jContentPane.add(vPosicao27, null);
			jContentPane.add(vPosicao28, null);
			
			jContentPane.add(vPosicao31, null);
			jContentPane.add(vPosicao32, null);
			jContentPane.add(vPosicao33, null);
			jContentPane.add(vPosicao34, null);
			jContentPane.add(vPosicao35, null);
			jContentPane.add(vPosicao36, null);
			jContentPane.add(vPosicao37, null);
			jContentPane.add(vPosicao38, null);
			
			jContentPane.add(vPosicao41, null);
			jContentPane.add(vPosicao42, null);
			jContentPane.add(vPosicao43, null);
			jContentPane.add(vPosicao44, null);
			jContentPane.add(vPosicao45, null);
			jContentPane.add(vPosicao46, null);
			jContentPane.add(vPosicao47, null);
			jContentPane.add(vPosicao48, null);
			
			jContentPane.add(vPosicao51, null);
			jContentPane.add(vPosicao52, null);
			jContentPane.add(vPosicao53, null);
			jContentPane.add(vPosicao54, null);
			jContentPane.add(vPosicao55, null);
			jContentPane.add(vPosicao56, null);
			jContentPane.add(vPosicao57, null);
			jContentPane.add(vPosicao58, null);
			
			jContentPane.add(vPosicao61, null);
			jContentPane.add(vPosicao62, null);
			jContentPane.add(vPosicao63, null);
			jContentPane.add(vPosicao64, null);
			jContentPane.add(vPosicao65, null);
			jContentPane.add(vPosicao66, null);
			jContentPane.add(vPosicao67, null);
			jContentPane.add(vPosicao68, null);
			
			jContentPane.add(vPosicao71, null);
			jContentPane.add(vPosicao72, null);
			jContentPane.add(vPosicao73, null);
			jContentPane.add(vPosicao74, null);
			jContentPane.add(vPosicao75, null);
			jContentPane.add(vPosicao76, null);
			jContentPane.add(vPosicao77, null);
			jContentPane.add(vPosicao78, null);
			
			jContentPane.add(vPosicao81, null);
			jContentPane.add(vPosicao82, null);
			jContentPane.add(vPosicao83, null);
			jContentPane.add(vPosicao84, null);
			jContentPane.add(vPosicao85, null);
			jContentPane.add(vPosicao86, null);
			jContentPane.add(vPosicao87, null);
			jContentPane.add(vPosicao88, null);
			
			mapaVPosicao[0][0] = vPosicao11;
			mapaVPosicao[0][1] = vPosicao12;
			mapaVPosicao[0][2] = vPosicao13;
			mapaVPosicao[0][3] = vPosicao14;
			mapaVPosicao[0][4] = vPosicao15;
			mapaVPosicao[0][5] = vPosicao16;
			mapaVPosicao[0][6] = vPosicao17;
			mapaVPosicao[0][7] = vPosicao18;
						
			mapaVPosicao[1][0] = vPosicao21;
			mapaVPosicao[1][1] = vPosicao22;
			mapaVPosicao[1][2] = vPosicao23;
			mapaVPosicao[1][3] = vPosicao24;
			mapaVPosicao[1][4] = vPosicao25;
			mapaVPosicao[1][5] = vPosicao26;
			mapaVPosicao[1][6] = vPosicao27;
			mapaVPosicao[1][7] = vPosicao28;
			
			mapaVPosicao[2][0] = vPosicao31;
			mapaVPosicao[2][1] = vPosicao32;
			mapaVPosicao[2][2] = vPosicao33;
			mapaVPosicao[2][3] = vPosicao34;
			mapaVPosicao[2][4] = vPosicao35;
			mapaVPosicao[2][5] = vPosicao36;
			mapaVPosicao[2][6] = vPosicao37;
			mapaVPosicao[2][7] = vPosicao38;
			
			mapaVPosicao[3][0] = vPosicao41;
			mapaVPosicao[3][1] = vPosicao42;
			mapaVPosicao[3][2] = vPosicao43;
			mapaVPosicao[3][3] = vPosicao44;
			mapaVPosicao[3][4] = vPosicao45;
			mapaVPosicao[3][5] = vPosicao46;
			mapaVPosicao[3][6] = vPosicao47;
			mapaVPosicao[3][7] = vPosicao48;
			
			mapaVPosicao[4][0] = vPosicao51;
			mapaVPosicao[4][1] = vPosicao52;
			mapaVPosicao[4][2] = vPosicao53;
			mapaVPosicao[4][3] = vPosicao54;
			mapaVPosicao[4][4] = vPosicao55;
			mapaVPosicao[4][5] = vPosicao56;
			mapaVPosicao[4][6] = vPosicao57;
			mapaVPosicao[4][7] = vPosicao58;
			
			mapaVPosicao[5][0] = vPosicao61;
			mapaVPosicao[5][1] = vPosicao62;
			mapaVPosicao[5][2] = vPosicao63;
			mapaVPosicao[5][3] = vPosicao64;
			mapaVPosicao[5][4] = vPosicao65;
			mapaVPosicao[5][5] = vPosicao66;
			mapaVPosicao[5][6] = vPosicao67;
			mapaVPosicao[5][7] = vPosicao68;
			
			mapaVPosicao[6][0] = vPosicao71;
			mapaVPosicao[6][1] = vPosicao72;
			mapaVPosicao[6][2] = vPosicao73;
			mapaVPosicao[6][3] = vPosicao74;
			mapaVPosicao[6][4] = vPosicao75;
			mapaVPosicao[6][5] = vPosicao76;
			mapaVPosicao[6][6] = vPosicao77;
			mapaVPosicao[6][7] = vPosicao78;
			
			mapaVPosicao[7][0] = vPosicao81;
			mapaVPosicao[7][1] = vPosicao82;
			mapaVPosicao[7][2] = vPosicao83;
			mapaVPosicao[7][3] = vPosicao84;
			mapaVPosicao[7][4] = vPosicao85;
			mapaVPosicao[7][5] = vPosicao86;
			mapaVPosicao[7][6] = vPosicao87;
			mapaVPosicao[7][7] = vPosicao88;

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
		vMensagem.setText("Jogador: "+idJogador);
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
		
		if ((resultado == 10) || (resultado == 9) || (resultado == 14)|| (resultado == 15) || (resultado == 16)){
			this.exibirEstado();
			if(resultado == 9){
				this.notificarResultado(resultado);
			}
		}else{
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
		for (int linha=1; linha<9; linha++){
			for (int coluna=1; coluna<9; coluna++){
				valor = estado.informarValor(linha, coluna);
				switch (valor){
				case 0: mapaVPosicao[(linha-1)][(coluna-1)].setIcon(vazia);
				break;
				case 1: mapaVPosicao[(linha-1)][(coluna-1)].setIcon(branco);
				break;
				case 2: mapaVPosicao[(linha-1)][(coluna-1)].setIcon(preto);
				break;
				case 3: mapaVPosicao[(linha-1)][(coluna-1)].setIcon(selectPreto);
				break;
				case 4: mapaVPosicao[(linha-1)][(coluna-1)].setIcon(selectBranco);
				break;
				}
			};
		};
	}		
	
	public void notificarResultado(int codigo) {
		switch (codigo) {
    		case 0:  JOptionPane.showMessageDialog(this, "Conexão efetuada com exito"); break;        	
    		case 1:  JOptionPane.showMessageDialog(this, "Tentativa de conexão com conexão previamente estabelecida"); break;
        	case 2:  JOptionPane.showMessageDialog(this, "Tentativa de conexao falhou"); break;
        	case 3:  JOptionPane.showMessageDialog(this, "Desconexão efetuada com exito"); break;
        	case 4:  JOptionPane.showMessageDialog(this, "Tentativa de desconexao sem conexao previamente estabelecida"); break;
        	case 5:  JOptionPane.showMessageDialog(this, "Tentativa de desconexao falhou"); break;
        	case 6:  JOptionPane.showMessageDialog(this, "Solicitação de inicio procedida com êxito"); break;
        	case 7:  JOptionPane.showMessageDialog(this, "Tentativa de inicio sem conexao previamente estabelecida"); break;
        	case 8:  JOptionPane.showMessageDialog(this, "Não é a sua vez"); break;
        	case 9:  JOptionPane.showMessageDialog(this, "Partida encerrada"); break;
        	case 10: JOptionPane.showMessageDialog(this, "Lance OK"); break;
        	case 11: JOptionPane.showMessageDialog(this, "Posição ocupada"); break;
        	case 12: JOptionPane.showMessageDialog(this, "Posição ilegal"); break;
        	case 13: JOptionPane.showMessageDialog(this, "Partida corrente não interrompida"); break;        	
        	case 17: JOptionPane.showMessageDialog(this, "Jogada não permitida"); break;
		};
	}
	
	
	
}
