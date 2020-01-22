package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Scrollbar;
import javax.swing.border.LineBorder;

import classi.Post;
import controller.Controller;

import javax.swing.JSeparator;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class PostFrame extends JFrame {

	private JPanel contentPane;
	private Controller control;
	private Post p;

	/**
	 * Create the frame. 
	 */
	public PostFrame(Controller ctrl) {

		control = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panelFilter = new JPanel();
		panelFilter.setBackground(new Color(255, 250, 240));
		scrollPane.setViewportView(panelFilter);
		panelFilter.setLayout(null);
		panelFilter.setPreferredSize(new Dimension(panelFilter.getWidth(),600));
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(255, 250, 240));
		topPanel.setBounds(0, 0, 755, 65);
		panelFilter.add(topPanel);
		topPanel.setLayout(null);
		
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon(PostFrame.class.getResource("/images/logoXSBon.png")));
		lblLogo.setBounds(20, 20, 164, 43);
		topPanel.add(lblLogo);
		
	    JPanel panelLogin = new JPanel();
	    panelLogin.setBackground(new Color(255, 250, 240));
	    panelLogin.setBounds(622, 30, 133, 27);
	    topPanel.add(panelLogin);
	    panelLogin.setLayout(null);
	    
	    JLabel lblLogin = new JLabel("Login");
	    lblLogin.setBounds(0, 0, 46, 27);
	    panelLogin.add(lblLogin);
	    lblLogin.setForeground(new Color(0, 0, 205));
	    lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    
	    JLabel lblRegister = new JLabel("Registrati");
	    lblRegister.setBounds(45, 3, 68, 20);
	    panelLogin.add(lblRegister);
	    lblRegister.setForeground(new Color(0, 0, 205));
	    lblRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    
	    JLabel label_2 = new JLabel("/");
	    label_2.setBounds(38, 0, 7, 27);
	    panelLogin.add(label_2);
	    label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    
	    JLabel lblRegistedUser = new JLabel("Ciao, Name");
	    lblRegistedUser.setVisible(false);
	    lblRegistedUser.setBounds(20, 13, 113, 14);
	    panelLogin.add(lblRegistedUser);
	    lblRegistedUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
	    
	    JPanel midPanel = new JPanel();
	    midPanel.setBackground(new Color(255, 250, 240));
	    midPanel.setBounds(10, 66, 735, 353);
	    panelFilter.add(midPanel);
	    midPanel.setLayout(null);
	    
	    JLabel lblImmagine = new JLabel("New label");
	    lblImmagine.setIcon(new ImageIcon("C:\\Users\\chris\\Desktop\\img-20171230-wa0090-01-240x240.jpg"));
	    lblImmagine.setBounds(22, 26, 200, 200);
	    midPanel.add(lblImmagine);
	    
	    JLabel lblCategory = new JLabel("Category, Subcategory");
	    lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblCategory.setBounds(10, 0, 175, 33);
	    midPanel.add(lblCategory);
	    
	    JLabel lblSiTrovaA = new JLabel("Si trova a");
	    lblSiTrovaA.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lblSiTrovaA.setBounds(249, 38, 70, 14);
	    midPanel.add(lblSiTrovaA);
	    
	    JLabel lblPosition = new JLabel("Roma, Lazio");
	    lblPosition.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblPosition.setBounds(318, 37, 124, 16);
	    midPanel.add(lblPosition);
	    
	    JTextPane textPanePostName = new JTextPane();
	    textPanePostName.setBackground(new Color(255, 250, 240));
	    textPanePostName.setFont(new Font("Tahoma", Font.BOLD, 20));
	    textPanePostName.setText("Name");
	    textPanePostName.setBounds(259, 48, 224, 56);
	    midPanel.add(textPanePostName);
	    
	    JLabel lblStars = new JLabel("* * * * * ");
	    lblStars.setFont(new Font("Tahoma", Font.BOLD, 27));
	    lblStars.setBounds(483, 48, 140, 40);
	    midPanel.add(lblStars);
	    
	    JLabel lblnReviews = new JLabel("12.345");
	    lblnReviews.setFont(new Font("Tahoma", Font.PLAIN, 13));
	    lblnReviews.setBounds(610, 42, 48, 46);
	    midPanel.add(lblnReviews);
	    
	    JTextPane textPaneDescription = new JTextPane();
	    textPaneDescription.setBackground(new Color(255, 250, 240));
	    textPaneDescription.setEditable(false);
	    textPaneDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    textPaneDescription.setText("Il Colosseo, originariamente conosciuto come Amphitheatrum Flavium (in italiano: Anfiteatro Flavio) o semplicemente come Amphitheatrum, è il più grande anfiteatro del mondo[1], situato nel centro della città di Roma. In grado di contenere un numero di spettatori stimato tra 50.000 e 87.000 unità, è il più importante anfiteatro romano, nonché il più imponente monumento dell'antica Roma che sia giunto fino a noi[2], conosciuto in tutto il mondo come simbolo della città di Roma e uno dei simboli d'Italia.");
	    textPaneDescription.setBounds(269, 104, 456, 122);
	    midPanel.add(textPaneDescription);
	    
	    JLabel lblUlterioriInfo = new JLabel("Ulteriori Info");
	    lblUlterioriInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lblUlterioriInfo.setBounds(22, 230, 91, 14);
	    midPanel.add(lblUlterioriInfo);
	    
	    JTextPane textPaneInfo = new JTextPane();
	    textPaneInfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    textPaneInfo.setText("Orari: \nDal lunedì alla domenica\ndalle 8:30 alle 19:00");
	    textPaneInfo.setBackground(new Color(255, 250, 240));
	    textPaneInfo.setBounds(22, 247, 200, 106);
	    midPanel.add(textPaneInfo);
	    
	    JButton btnNewButton = new JButton("Scrivi una recensione...");
	    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {

	    	}
	    });
	    btnNewButton.setBounds(538, 319, 175, 23);
	    midPanel.add(btnNewButton);
	    
	    
	    JPanel bottomPanel = new JPanel();
	    bottomPanel.setBorder(null);
	    bottomPanel.setBackground(new Color(255, 250, 240));
	    bottomPanel.setBounds(20, 432, 714, 200);
	    panelFilter.add(bottomPanel);
	    bottomPanel.setLayout(null);
	    
	    JScrollPane scrollPaneReview = new JScrollPane();
	    scrollPaneReview.setBorder(new LineBorder(new Color(0, 0, 0)));
	    scrollPaneReview.setBackground(new Color(255, 250, 240));
	    scrollPaneReview.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollPaneReview.setMaximumSize(new Dimension(23, 23));
	    scrollPaneReview.setMinimumSize(new Dimension(32767, 32767));
	    scrollPaneReview.setBounds(0, 70, 714, 130);
	    bottomPanel.add(scrollPaneReview);
	    
	    JTextPane txtpnIlColosseoOriginariamente = new JTextPane();
	    txtpnIlColosseoOriginariamente.setBackground(new Color(255, 250, 250));
	    txtpnIlColosseoOriginariamente.setText("Il Colosseo, originariamente conosciuto come Amphitheatrum Flavium (in italiano: Anfiteatro Flavio) o semplicemente come Amphitheatrum, è il più grande anfiteatro del mondo[1], situato nel centro della città di Roma. In grado di contenere un numero di spettatori stimato tra 50.000 e 87.000 unità, è il più importante anfiteatro romano, nonché il più imponente monumento dell'antica Roma che sia giunto fino a noi[2], conosciuto in tutto il mondo come simbolo della città di Roma e uno dei simboli d'Italia.\r\n\r\nInserito nel 1980 nella lista dei Patrimoni dell'umanità dall'UNESCO, assieme a tutto il Centro storico di Roma, le Zone extraterritoriali della Santa Sede in Italia e la Basilica di San Paolo fuori le mura, nel 2007 il complesso, unico monumento europeo, è stato anche inserito fra le Nuove sette meraviglie del mondo, a seguito di un concorso organizzato da New Open World Corporation (NOWC).\r\n\r\nL'anfiteatro è stato edificato in epoca Flavia su un'area al limite orientale del Foro Romano. La sua costruzione fu iniziata da Vespasiano nel 71 d.C. ed inaugurato da Tito nell'80, con ulteriori modifiche apportate durante l'impero di Domiziano nel 90. L'edificio forma una ellisse di 527 m di perimetro, con assi che misurano 187,5 e 156,5 m. L'arena all'interno misura 86 × 54 m, con una superficie di 3.357 m². L'altezza attuale raggiunge 48,5 m, ma originariamente arrivava a 52 m. La struttura esprime con chiarezza le concezioni architettoniche e costruttive romane della prima Età imperiale, basate rispettivamente sulla linea curva e avvolgente offerta dalla pianta ellittica e sulla complessità dei sistemi costruttivi. Archi e volte sono concatenati tra loro in un serrato rapporto strutturale.\r\n\r\nIl nome \"Colosseo\" si diffuse solo nel Medioevo e deriva dalla deformazione popolare dell'aggettivo latino \"colosseum\" (traducibile in \"colossale\", come appariva nell'Alto Medioevo tra le casette a uno o due piani)[3] o, più probabilmente, dalla vicinanza della colossale statua bronzea di Nerone che sorgeva nei pressi.[4] Presto l'edificio divenne simbolo della città imperiale, espressione di un'ideologia in cui la volontà celebrativa giunge a definire modelli per lo svago e il divertimento del popolo.\r\n\r\nAnticamente era usato per gli spettacoli di gladiatori e altre manifestazioni pubbliche (spettacoli di caccia, rievocazioni di battaglie famose, e drammi basati sulla mitologia classica). La tradizione che lo vuole luogo di martirio di cristiani è destituita di fondamento[5]. Non più in uso dopo il VI secolo, l'enorme struttura venne variamente riutilizzata nei secoli, anche come cava di materiale. Oggi è un simbolo della città di Roma e una delle sue maggiori attrazioni turistiche sotto forma di monumento archeologico regolarmente visitabile.\r\n\r\nOggi le sue condizioni di salute destano preoccupazione, visto che studi sulla sua struttura hanno evidenziato oltre 3.000 lesioni e un esteso stato fessurativo[6]. Inoltre, nel 2012 è avvenuta la scoperta di un'inclinazione di 40 cm della struttura, probabilmente a causa di un cedimento della platea di fondazione su cui poggia[7].\r\n\r\nNel 2018 il circuito archeologico Colosseo, Foro Romano e Palatino ha ottenuto 7 650 519 visitatori, risultando il secondo sito museale statale italiano più visitato (il primo tra quelli a pagamento), alle spalle del Pantheon[8].");
	    txtpnIlColosseoOriginariamente.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    scrollPaneReview.setViewportView(txtpnIlColosseoOriginariamente);
	    
	    JTextPane txtpnTitoloReview = new JTextPane();
	    txtpnTitoloReview.setBackground(new Color(255, 250, 240));
	    txtpnTitoloReview.setText("Stupendo");
	    txtpnTitoloReview.setFont(new Font("Tahoma", Font.BOLD, 16));
	    txtpnTitoloReview.setBounds(0, 39, 388, 20);
	    bottomPanel.add(txtpnTitoloReview);
	    
	    JLabel lblUserName = new JLabel("Nome Utente");
	    lblUserName.setBackground(new Color(255, 250, 240));
	    lblUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblUserName.setBounds(0, 14, 109, 26);
	    bottomPanel.add(lblUserName);
	    
	    JLabel label = new JLabel("* * * * * ");
	    label.setFont(new Font("Tahoma", Font.BOLD, 27));
	    label.setBounds(574, 14, 140, 40);
	    bottomPanel.add(label);
	    
	    JSeparator separator = new JSeparator();
	    separator.setForeground(new Color(128, 128, 128));
	    separator.setBackground(new Color(0, 0, 0));
	    separator.setBounds(0, 11, 714, 1);
	    bottomPanel.add(separator);
	    
	    scrollPane.getVerticalScrollBar().setUnitIncrement(14);
	    
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
	    		p = control.getPostPost();
	    		textPanePostName.setText(p.getName());
			}
		});
	}
}
