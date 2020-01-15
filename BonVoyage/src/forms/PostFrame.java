package forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class PostFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostFrame frame = new PostFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PostFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255,250,240));
		setContentPane(contentPane);
	    
		
		try {
		    BufferedImage logo = ImageIO.read(new URL("https://raw.githubusercontent.com/silgreen/BonVoyageRepo/master/BonVoyage/Images/logoXSBon.png?token=AMCLLPEJ5YPJL2HJ6TUUJBK6FAVUM"));
		    
		    BufferedImage immagine = ImageIO.read(new URL("https://www.ammappalitalia.it/wp-content/uploads/2018/05/img-20171230-wa0090-01-240x240.jpeg"));
		    contentPane.setLayout(null);
		    
		    JPanel midPanel = new JPanel();
		    midPanel.setBounds(10, 87, 764, 306);
		    midPanel.setBackground(new Color(255, 250, 240));
		    contentPane.add(midPanel);
		    midPanel.setLayout(null);
		    
		    JLabel lblImmagine = new JLabel("New label");
		    lblImmagine.setBounds(20, 21, 200, 200);
		    midPanel.add(lblImmagine);
		    lblImmagine.setIcon(new javax.swing.ImageIcon(immagine));  
		    
		    JLabel lblCategory = new JLabel("Attrazione Turistica");
		    lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		    lblCategory.setBounds(10, 0, 117, 14);
		    midPanel.add(lblCategory);
		    
		    JLabel label = new JLabel(",");
		    label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		    label.setBounds(128, -1, 48, 17);
		    midPanel.add(label);
		    
		    JLabel lblSubCategory = new JLabel("Sito Archeologico");
		    lblSubCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		    lblSubCategory.setBounds(137, 0, 106, 14);
		    midPanel.add(lblSubCategory);
		    
		    JLabel lblSiTrovaA = new JLabel("Si trova a");
		    lblSiTrovaA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		    lblSiTrovaA.setBounds(253, 21, 63, 28);
		    midPanel.add(lblSiTrovaA);
		    
		    JLabel lblCity = new JLabel("Roma");
		    lblCity.setFont(new Font("Tahoma", Font.BOLD, 14));
		    lblCity.setBounds(316, 21, 48, 28);
		    midPanel.add(lblCity);
		    
		    JLabel label_1 = new JLabel(",");
		    label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		    label_1.setBounds(358, 21, 63, 28);
		    midPanel.add(label_1);
		    
		    JLabel lblRegion = new JLabel("Lazio");
		    lblRegion.setFont(new Font("Tahoma", Font.BOLD, 14));
		    lblRegion.setBounds(371, 21, 63, 28);
		    midPanel.add(lblRegion);
		    
		    JLabel lblName = new JLabel("Catapecchia");
		    lblName.setFont(new Font("Tahoma", Font.BOLD, 26));
		    lblName.setBounds(253, 49, 168, 28);
		    midPanel.add(lblName);
		    
		    JTextPane txtDescription = new JTextPane();
		    txtDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		    txtDescription.setText("Il Colosseo, originariamente conosciuto come Amphitheatrum Flavium o semplicemente come Amphitheatrum, è il più grande anfiteatro del mondo, situato nel centro della città di Roma.");
		    txtDescription.setBackground(new Color(255, 250, 240));
		    txtDescription.setBounds(253, 88, 473, 133);
		    midPanel.add(txtDescription);
		    
		    JLabel lblUlterioriInformazioni = new JLabel("Ulteriori informazioni");
		    lblUlterioriInformazioni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		    lblUlterioriInformazioni.setBounds(20, 227, 157, 17);
		    midPanel.add(lblUlterioriInformazioni);
		    
		    JTextPane txtpnMoreInfo = new JTextPane();
		    txtpnMoreInfo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		    txtpnMoreInfo.setText("Orari: Dal lunedì alla domenica dalle 8:30 alle 19:00");
		    txtpnMoreInfo.setBackground(new Color(255, 250, 240));
		    txtpnMoreInfo.setBounds(20, 243, 434, 61);
		    midPanel.add(txtpnMoreInfo);
		    
		    JLabel lblStars = new JLabel("⭐⭐⭐⭐⭐");
		    lblStars.setFont(new Font("Tahoma", Font.PLAIN, 15));
		    lblStars.setBounds(431, 54, 75, 27);
		    midPanel.add(lblStars);
		    
		    JLabel lblNreviews = new JLabel("12.345");
		    lblNreviews.setBounds(516, 62, 48, 14);
		    midPanel.add(lblNreviews);
		    
		    JButton btnScriviUnaRecensione = new JButton("Scrivi una recensione...");
		    btnScriviUnaRecensione.setBounds(597, 272, 157, 23);
		    midPanel.add(btnScriviUnaRecensione);
		    
		    JPanel topPanel = new JPanel();
		    topPanel.setBounds(10, 11, 764, 61);
		    topPanel.setBackground(new Color(255, 250, 240));
		    contentPane.add(topPanel);
		    topPanel.setLayout(null);
		    
		    JLabel lblLogo = new JLabel("New label");
		    lblLogo.setBounds(10, 9, 170, 55);
		    topPanel.add(lblLogo);
		    lblLogo.setIcon(new javax.swing.ImageIcon(logo));
		    
		    JMenu mnNewMenu = new JMenu("");
		    mnNewMenu.setBounds(433, 18, 101, 26);
		    topPanel.add(mnNewMenu);
		    
		    JButton btnProfile = new JButton("Profilo");
		    btnProfile.setFont(new Font("Tahoma", Font.PLAIN, 12));
		    mnNewMenu.add(btnProfile);
		    
		    JButton btnLogout = new JButton("Logout");
		    mnNewMenu.add(btnLogout);
		    
		    	    JLabel lblLoggedUser = new JLabel("Ciao, Gianluca");
		    	    lblLoggedUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		    	    lblLoggedUser.setBounds(641, 24, 101, 20);
		    	    topPanel.add(lblLoggedUser);
		    	    
	    JLabel lblLogin = new JLabel("Login");
	    lblLogin.setBounds(629, 17, 46, 27);
	    topPanel.add(lblLogin);
	    lblLogin.setForeground(new Color(0, 0, 205));
	    lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    
	    JLabel lblRegistrati = new JLabel("Registrati");
	    lblRegistrati.setBounds(674, 20, 68, 20);
	    topPanel.add(lblRegistrati);
	    lblRegistrati.setForeground(new Color(0, 0, 205));
	    lblRegistrati.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    
	    JLabel lblSeparatore = new JLabel("/");
	    lblSeparatore.setBounds(667, 17, 7, 27);
	    topPanel.add(lblSeparatore);
	    lblSeparatore.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setAutoscrolls(true);
	    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollPane.setBounds(10, 404, 764, 146);
	    scrollPane.setBackground(new Color(255, 250, 240));
	    contentPane.add(scrollPane);
	    
	    JPanel panel = new JPanel();
	    scrollPane.setViewportView(panel); 
	    panel.setPreferredSize(new Dimension (panel.getWidth(),200));
	    
	    JLabel lblNewLabel = new JLabel("New label");
	    lblNewLabel.setBounds(72, 35, 48, 14);
	    panel.add(lblNewLabel);
	    
	    textField = new JTextField();
	    textField.setBounds(37, 83, 96, 143);
	    panel.add(textField);
	    textField.setColumns(10);
	    
		    
		
	    
		}
		catch(IOException ex) {
		}
	}
}
