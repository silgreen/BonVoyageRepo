package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class ProfileFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldBio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileFrame frame = new ProfileFrame();
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
	public ProfileFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("New label");
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
		lblLevel.setBounds(408, 114, 66, 14);
		contentPane.add(lblLevel);
		
		JLabel lblDi = new JLabel("di");
		lblDi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDi.setBounds(40, 137, 48, 17);
		contentPane.add(lblDi);
		
		JLabel lblCity = new JLabel("Napoli");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCity.setBounds(61, 136, 88, 17);
		contentPane.add(lblCity);
		
		JLabel lblRegion = new JLabel("Campania");
		lblRegion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRegion.setBounds(159, 136, 125, 17);
		contentPane.add(lblRegion);
		
		JLabel lblemail = new JLabel("gianlucasavonarola@helle.com");
	    lblemail.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    lblemail.setBounds(470, 221, 304, 35);
	    contentPane.add(lblemail);
	    
	    JLabel lblBiografia = new JLabel("Biografia");
	    lblBiografia.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblBiografia.setBounds(42, 227, 77, 24);
	    contentPane.add(lblBiografia);
	    
	    textFieldBio = new JTextField();
	    textFieldBio.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    textFieldBio.setText("tytyty");
	    textFieldBio.setEnabled(false);
	    textFieldBio.setBounds(21, 260, 374, 150);
	    contentPane.add(textFieldBio);
	    textFieldBio.setColumns(10);
	    
	    JButton btnModifyBio = new JButton("");
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
		
		try {
		    BufferedImage logo = ImageIO.read(new URL("https://raw.githubusercontent.com/silgreen/BonVoyageRepo/master/BonVoyage/Images/logoXSBon.png?token=AMCLLPEJ5YPJL2HJ6TUUJBK6FAVUM"));
		    lblLogo.setIcon(new javax.swing.ImageIcon(logo));  
		}
		catch(IOException ex) {
		}
	}
}
