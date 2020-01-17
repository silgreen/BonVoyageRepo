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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.Controller;

import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;

public class SearchFrame extends JFrame { 
	
	private Controller control;
	private JPanel contentPane;
	private JTextField textFieldSearch;
	private JLabel lblLogo;
	private JPanel panel;
	private JLabel lblRegistrati;

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
		contentPane.setToolTipText("");
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
		lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblLogo.setBounds(234, 47, 353, 116);
		contentPane.add(lblLogo);
		
		ButtonGroup radioButtonGroup = new ButtonGroup();
	    
	    JRadioButton rdbtnHotel = new JRadioButton("Hotel");
	    rdbtnHotel.setFocusPainted(false);
	    rdbtnHotel.setContentAreaFilled(false);
	    rdbtnHotel.setBorder(null);
	    rdbtnHotel.setBackground(new Color(255, 250, 240));
	    rdbtnHotel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    rdbtnHotel.setBounds(285, 249, 63, 21);
	    contentPane.add(rdbtnHotel);
	    radioButtonGroup.add(rdbtnHotel);
	    
	    JRadioButton rdbtnRistoranti = new JRadioButton("Ristoranti");
	    rdbtnRistoranti.setFocusPainted(false);
	    rdbtnRistoranti.setBorder(null);
	    rdbtnRistoranti.setContentAreaFilled(false);
	    rdbtnRistoranti.setBackground(new Color(255, 250, 240));
	    rdbtnRistoranti.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    rdbtnRistoranti.setBounds(350, 249, 93, 21);
	    contentPane.add(rdbtnRistoranti);
	    radioButtonGroup.add(rdbtnRistoranti);
	    
	    JRadioButton rdbtnAttivita = new JRadioButton("Attivit\u00E0");
	    rdbtnAttivita.setFocusPainted(false);
	    rdbtnAttivita.setBorder(null);
	    rdbtnAttivita.setContentAreaFilled(false);
	    rdbtnAttivita.setBackground(new Color(255, 250, 240));
	    rdbtnAttivita.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    rdbtnAttivita.setBounds(445, 249, 77, 21);
	    contentPane.add(rdbtnAttivita);
	    radioButtonGroup.add(rdbtnAttivita);
	    
	    JButton btnCerca = new JButton("Cerca");
	    btnCerca.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    btnCerca.setBounds(350, 340, 103, 27);
	    contentPane.add(btnCerca);
	    
	    JLabel lblDoveVuoiAndare = new JLabel("Dove vuoi andare?");
	    lblDoveVuoiAndare.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblDoveVuoiAndare.setBounds(314, 179, 158, 27);
	    contentPane.add(lblDoveVuoiAndare);
	    
	    JLabel lblLogin = new JLabel("Login");
	    lblLogin.setBounds(646, 21, 46, 27);
	    contentPane.add(lblLogin);
	    lblLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    lblLogin.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		control.toOpenAndCloseFrame(control.getLogin(),control.getSearch());
	    	}
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		lblLogin.setText("<HTML><U>Login</U></HTML>");
	    		lblLogin.setForeground(new Color(30, 144, 255));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		lblLogin.setText("Login");
	    		lblLogin.setForeground(new Color(0, 0, 205));
	    	}
	    });
	    
	    lblLogin.setForeground(new Color(0, 0, 205));
	    lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    
	    JLabel lblRegistrati_1 = new JLabel("Registrati");
	    lblRegistrati_1.setBounds(706, 23, 68, 20);
	    contentPane.add(lblRegistrati_1);
	    lblRegistrati_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    lblRegistrati_1.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		control.toOpenAndCloseFrame(control.getRegister(),control.getSearch());
	    	}
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		lblRegistrati_1.setText("<HTML><U>Registrati</U></HTML>");
	    		lblRegistrati_1.setForeground(new Color(30,144,255));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		lblRegistrati_1.setText("Registrati");
	    		lblRegistrati_1.setForeground(new Color(0,0,205));
	    	}
	    });
	    lblRegistrati_1.setForeground(new Color(0, 0, 205));
	    lblRegistrati_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    
	    JLabel lblSeparatore = new JLabel("/");
	    lblSeparatore.setBounds(692, 21, 7, 27);
	    contentPane.add(lblSeparatore);
	    lblSeparatore.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    
	    JTextPane txtpnCiaoGiggi = new JTextPane();
	    txtpnCiaoGiggi.setVisible(false);
	    txtpnCiaoGiggi.setText("ciao, giggi");
	    txtpnCiaoGiggi.setBounds(603, 387, 96, 20);
	    contentPane.add(txtpnCiaoGiggi);
	    
		try {
		    BufferedImage logo = ImageIO.read(new URL("https://raw.githubusercontent.com/silgreen/BonVoyageRepo/master/BonVoyage/Images/LogoMBon.png?token=AL7WGAEA2DVRUH6DMH3VKVK6FAVWO"));
		    lblLogo.setIcon(new javax.swing.ImageIcon(logo));
		}
		catch(IOException ex) { 
		}	
		
		
	}
}
