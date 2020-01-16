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

import controller.Controller;

import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SearchFrame extends JFrame { 
	
	private Controller control;
	private JPanel contentPane;
	private JTextField textFieldSearch;
	private JLabel lblLogo;

	/**
	 * Create the frame.
	 */
	public SearchFrame(Controller ctrl) {
		setTitle("BonVoyage!");
		control = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,250,240));
		contentPane.setToolTipText("Hotel");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textFieldSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldSearch.setBounds(216, 216, 371, 27);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		lblLogo = new JLabel();
		lblLogo.setBounds(234, 47, 353, 116);
		contentPane.add(lblLogo);
		
	    
	    JRadioButton rdbtnHotel = new JRadioButton("Hotel");
	    rdbtnHotel.setBackground(new Color(255, 250, 240));
	    rdbtnHotel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    rdbtnHotel.setBounds(285, 249, 63, 21);
	    contentPane.add(rdbtnHotel);
	    
	    JRadioButton rdbtnRistoranti = new JRadioButton("Ristoranti");
	    rdbtnRistoranti.setBackground(new Color(255, 250, 240));
	    rdbtnRistoranti.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    rdbtnRistoranti.setBounds(350, 249, 93, 21);
	    contentPane.add(rdbtnRistoranti);
	    
	    JRadioButton rdbtnAttivita = new JRadioButton("Attivit\u00E0");
	    rdbtnAttivita.setBackground(new Color(255, 250, 240));
	    rdbtnAttivita.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    rdbtnAttivita.setBounds(445, 249, 77, 21);
	    contentPane.add(rdbtnAttivita);
	    
	    JButton btnCerca = new JButton("Cerca");
	    btnCerca.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    btnCerca.setBounds(350, 340, 103, 27);
	    contentPane.add(btnCerca);
	    
	    JLabel lblLogin = new JLabel("Login");
	    lblLogin.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		control.toShowLogin();
	    	}
	    });
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
	    
	    JLabel lblDoveVuoiAndare = new JLabel("Dove vuoi andare?");
	    lblDoveVuoiAndare.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblDoveVuoiAndare.setBounds(314, 179, 158, 27);
	    contentPane.add(lblDoveVuoiAndare);
	    
	    JLabel lblUser = new JLabel("Ciao, name");
	    lblUser.setVisible(false);
	    lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    lblUser.setBounds(628, 20, 158, 22);
	    contentPane.add(lblUser);
		
		try {
		    BufferedImage logo = ImageIO.read(new URL("https://raw.githubusercontent.com/silgreen/BonVoyageRepo/master/BonVoyage/Images/LogoMBon.png?token=AL7WGAEA2DVRUH6DMH3VKVK6FAVWO"));
		    lblLogo.setIcon(new javax.swing.ImageIcon(logo));
		}
		catch(IOException ex) { 
		}
	}
}
