package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfileFrame extends JFrame {

	private JPanel contentPane;
	private JTextPane textPaneBio;
	private Controller control;

	/**
	 * Create the frame.
	 */
	public ProfileFrame(Controller ctrl) {

		control = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();

		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("New label");
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				control.toOpenAndCloseFrame(control.getSearch(), control.getProfile());
			}
		});
		lblLogo.setBounds(20, 20, 170, 55);
		contentPane.add(lblLogo);
		
		JLabel lblUsername = new JLabel("Gianluca Savonarola");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblUsername.setBounds(20, 100, 291, 35);
		contentPane.add(lblUsername);
		
		JLabel lblLivello = new JLabel("Livello:");
		lblLivello.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLivello.setBounds(358, 114, 48, 14);
		contentPane.add(lblLivello); 
		
		JLabel lblLevel = new JLabel("1");
		lblLevel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLevel.setBounds(408, 114, 33, 14);
		contentPane.add(lblLevel);
		
		JLabel lblDi = new JLabel("di");
		lblDi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDi.setBounds(40, 137, 48, 17);
		contentPane.add(lblDi);
		
		JLabel lblPosition = new JLabel("Napoli");
		lblPosition.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPosition.setBounds(61, 136, 271, 17);
		contentPane.add(lblPosition);
		
		JLabel lblemail = new JLabel("gianlucasavonarola@helle.com");
	    lblemail.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    lblemail.setBounds(470, 221, 304, 35);
	    contentPane.add(lblemail);
	    
	    JLabel lblBiografia = new JLabel("Biografia");
	    lblBiografia.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblBiografia.setBounds(42, 227, 77, 24);
	    contentPane.add(lblBiografia);
	    
	    textPaneBio = new JTextPane();
	    textPaneBio.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textPaneBio.setBackground(new Color(255, 250, 240));
	    textPaneBio.setEditable(false);
	    textPaneBio.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    textPaneBio.setText("tytyty");
	    textPaneBio.setBounds(21, 260, 374, 150);
	    contentPane.add(textPaneBio);
	    
	    JButton btnModifyBio = new JButton("...");
	    btnModifyBio.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    	}
	    });
	    btnModifyBio.setBounds(362, 231, 33, 23);
	    contentPane.add(btnModifyBio);
	    
	    JButton btnIndietro = new JButton("Indietro");
	    btnIndietro.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnIndietro.setBounds(20, 510, 89, 29);
	    contentPane.add(btnIndietro);
	    
	    JButton btnEsci = new JButton("Esci");
	    btnEsci.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnEsci.setBounds(685, 510, 89, 29);
	    contentPane.add(btnEsci);
	    
	    JButton btnEliminaAccount = new JButton("Elimina Account");
	    btnEliminaAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnEliminaAccount.setBounds(542, 510, 133, 29);
	    contentPane.add(btnEliminaAccount);
	        
	    JLabel lblRecensioniScritte = new JLabel("Recensioni scritte:");
	    lblRecensioniScritte.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblRecensioniScritte.setBounds(457, 107, 111, 31);
	    contentPane.add(lblRecensioniScritte);
	    
	    JLabel lblNreviews = new JLabel("1");
	    lblNreviews.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblNreviews.setBounds(578, 115, 48, 14);
	    contentPane.add(lblNreviews);
	   
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				lblUsername.setText(control.getUser().getUsername());
				lblPosition.setText(control.getUser().getCity()+", "+control.getUser().getRegion());
				lblemail.setText(control.getUser().getEmail());
				lblLevel.setText(control.getUser().getRank());
				lblNreviews.setText(control.getUser().getNreviews());
			}
		});
		
		try {
		    BufferedImage logo = ImageIO.read(new URL("https://raw.githubusercontent.com/silgreen/BonVoyageRepo/master/BonVoyage/Images/logoXSBon.png?token=AMCLLPEJ5YPJL2HJ6TUUJBK6FAVUM"));
		    lblLogo.setIcon(new javax.swing.ImageIcon(logo));  

		}
		catch(IOException ex) {
		}
	}
}