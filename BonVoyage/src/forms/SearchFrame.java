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
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.SystemColor;

public class SearchFrame extends JFrame { 

	private JPanel contentPane;
	private JTextField txtDoveVuoiAndare;
	private JLabel lblLogo;

	/**
	 * Create the frame.
	 */
	public SearchFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,250,240));
		contentPane.setToolTipText("Hotel");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDoveVuoiAndare = new JTextField();
		txtDoveVuoiAndare.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDoveVuoiAndare.setText("Dove vuoi andare?");
		txtDoveVuoiAndare.setBounds(216, 216, 371, 27);
		contentPane.add(txtDoveVuoiAndare);
		txtDoveVuoiAndare.setColumns(10);
		
		lblLogo = new JLabel();
		lblLogo.setBounds(234, 47, 353, 116);
		contentPane.add(lblLogo);
		
		try {
		    BufferedImage logo = ImageIO.read(new URL("https://raw.githubusercontent.com/silgreen/BonVoyageRepo/master/BonVoyage/Images/LogoMBon.png?token=AL7WGAEA2DVRUH6DMH3VKVK6FAVWO"));
		    lblLogo.setIcon(new javax.swing.ImageIcon(logo));
		    
		    JRadioButton rdbtnHotel = new JRadioButton("Hotel");
		    rdbtnHotel.setBackground(new Color(255, 250, 240));
		    rdbtnHotel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		    rdbtnHotel.setBounds(216, 249, 63, 21);
		    contentPane.add(rdbtnHotel);
		    
		    JRadioButton rdbtnRistoranti = new JRadioButton("Ristoranti");
		    rdbtnRistoranti.setBackground(new Color(255, 250, 240));
		    rdbtnRistoranti.setFont(new Font("Tahoma", Font.PLAIN, 16));
		    rdbtnRistoranti.setBounds(281, 249, 93, 21);
		    contentPane.add(rdbtnRistoranti);
		    
		    JRadioButton rdbtnAttivita = new JRadioButton("Attivit\u00E0");
		    rdbtnAttivita.setBackground(new Color(255, 250, 240));
		    rdbtnAttivita.setFont(new Font("Tahoma", Font.PLAIN, 16));
		    rdbtnAttivita.setBounds(376, 249, 77, 21);
		    contentPane.add(rdbtnAttivita);
		    
		    JButton btnCerca = new JButton("Cerca");
		    btnCerca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		    btnCerca.setBounds(350, 340, 103, 27);
		    contentPane.add(btnCerca);
		    
		    JLabel lblLogin = new JLabel("Login");
		    lblLogin.setForeground(new Color(0, 0, 205));
		    lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		    lblLogin.setBounds(652, 18, 46, 27);
		    contentPane.add(lblLogin);
		    
		    JLabel lblRegistrati = new JLabel("Registrati");
		    lblRegistrati.setForeground(new Color(0, 0, 205));
		    lblRegistrati.setFont(new Font("Tahoma", Font.PLAIN, 16));
		    lblRegistrati.setBounds(697, 21, 68, 20);
		    contentPane.add(lblRegistrati);
		    
		    JLabel lblSeparatore = new JLabel("/");
		    lblSeparatore.setFont(new Font("Tahoma", Font.PLAIN, 16));
		    lblSeparatore.setBounds(690, 18, 7, 27);
		    contentPane.add(lblSeparatore);
		}
		catch(IOException ex) { 
		}
	}
}
