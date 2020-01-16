package forms;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.swing.JTextPane;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panelFilter = new JPanel();
		panelFilter.setBackground(new Color(255, 250, 240));
		scrollPane.setViewportView(panelFilter);
		panelFilter.setLayout(null);

		
		JPanel panelResult = new JPanel();
		panelResult.setLayout(null);
		panelResult.setPreferredSize(new Dimension(0, 600));
		panelResult.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelResult.setBackground(new Color(255, 250, 240));
		panelResult.setBounds(0, 94, 757, 173);
		panelFilter.add(panelResult);
		
		panelFilter.setPreferredSize(new Dimension(0, 0));
		
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
		
		JLabel lblNumeroRecensioni = new JLabel("NumeroRecensioni");
		lblNumeroRecensioni.setBounds(461, 11, 95, 21);
		panelResult.add(lblNumeroRecensioni);
		
		JLabel lblPosizione = new JLabel("Posizione");
		lblPosizione.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPosizione.setBounds(181, 29, 151, 13);
		panelResult.add(lblPosizione);
		
		JLabel lblTipologiaCategoria = new JLabel("tipologia,categoria");
		lblTipologiaCategoria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipologiaCategoria.setBounds(181, 151, 122, 19);
		panelResult.add(lblTipologiaCategoria);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBackground(new Color(255, 250, 240));
		textPane.setBounds(180, 58, 520, 83);
		panelResult.add(textPane);
		
		JLabel lblLogo = new JLabel("");
		panelFilter.add(lblLogo);
		lblLogo.setBounds(20, 20, 175, 52);  
		
		try {
		    BufferedImage logo = ImageIO.read(new URL("https://raw.githubusercontent.com/silgreen/BonVoyageRepo/master/BonVoyage/Images/logoXSBon.png?token=AMCLLPEJ5YPJL2HJ6TUUJBK6FAVUM"));
		    lblLogo.setIcon(new javax.swing.ImageIcon(logo));
		    
		    JLabel lblLogin = new JLabel("Login");
		    lblLogin.setForeground(new Color(0, 0, 205));
		    lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		    lblLogin.setBounds(652, 20, 46, 27);
		    panelFilter.add(lblLogin);
		    
		    JLabel lblRegistrati = new JLabel("Registrati");
		    lblRegistrati.setForeground(new Color(0, 0, 205));
		    lblRegistrati.setFont(new Font("Tahoma", Font.PLAIN, 16));
		    lblRegistrati.setBounds(697, 23, 68, 20);
		    panelFilter.add(lblRegistrati);
		    
		    JLabel lblSeparatore = new JLabel("/");
		    lblSeparatore.setFont(new Font("Tahoma", Font.PLAIN, 16));
		    lblSeparatore.setBounds(691, 20, 7, 27);
		    panelFilter.add(lblSeparatore);
		    
		    JLabel lblUser = new JLabel("Ciao, name");
		    lblUser.setVisible(false);
		    lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		    lblUser.setBounds(626, 20, 158, 22);
		    panelFilter.add(lblUser);
		}
		catch(IOException ex) {
		}
	}
}
