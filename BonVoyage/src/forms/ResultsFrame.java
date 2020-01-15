package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class ResultsFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultsFrame frame = new ResultsFrame();
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
	public ResultsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(20, 20, 170, 55);
		contentPane.add(lblLogo);
		
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setOpaque(false);
	    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    scrollPane.setBounds(766, 0, 20, 563);
	    contentPane.add(scrollPane);
	    
	    JPanel panelResult = new JPanel();
	    panelResult.setBounds(10, 85, 766, 180);
	    contentPane.add(panelResult);
	    panelResult.setLayout(null);
	    
	    JLabel lblFoto = new JLabel("Foto");
	    lblFoto.setBounds(10, 29, 151, 141);
	    panelResult.add(lblFoto);
	    
	    JLabel lblNomestruttura = new JLabel("NomeStruttura");
	    lblNomestruttura.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblNomestruttura.setBounds(171, 10, 119, 22);
	    panelResult.add(lblNomestruttura);
	    
	    JLabel lblStars = new JLabel("Stars");
	    lblStars.setBounds(300, 10, 151, 21);
	    panelResult.add(lblStars);
	    
	    JLabel lblNumerorecensioni = new JLabel("NumeroRecensioni");
	    lblNumerorecensioni.setBounds(461, 11, 95, 21);
	    panelResult.add(lblNumerorecensioni);
	    
	    JLabel lblPosizione = new JLabel("Posizione");
	    lblPosizione.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lblPosizione.setBounds(181, 29, 151, 13);
	    panelResult.add(lblPosizione);
	    
	    JTextPane txtpnInformazioni = new JTextPane();
	    txtpnInformazioni.setEditable(false);
	    txtpnInformazioni.setBounds(180, 58, 520, 83);
	    panelResult.add(txtpnInformazioni);
	    
	    JLabel lblTipologiacategoria = new JLabel("tipologia,categoria");
	    lblTipologiacategoria.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lblTipologiacategoria.setBounds(181, 151, 122, 19);
	    panelResult.add(lblTipologiacategoria);
		
		try {
		    BufferedImage logo = ImageIO.read(new URL("https://raw.githubusercontent.com/silgreen/BonVoyageRepo/master/BonVoyage/Images/logoXSBon.png?token=AMCLLPEJ5YPJL2HJ6TUUJBK6FAVUM"));
		    lblLogo.setIcon(new javax.swing.ImageIcon(logo));  
		}
		catch(IOException ex) {
		}
	}
}
