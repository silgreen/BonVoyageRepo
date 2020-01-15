package forms;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class PostFrame extends JFrame {

	private JPanel contentPane;
	
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
		contentPane.setLayout(null);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(255, 250, 240));
		topPanel.setBounds(10, 11, 764, 119);
		contentPane.add(topPanel);
		topPanel.setLayout(null);
		
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setBounds(10, 9, 170, 55);
		topPanel.add(lblLogo);
		
		try {
		    BufferedImage logo = ImageIO.read(new URL("https://raw.githubusercontent.com/silgreen/BonVoyageRepo/master/BonVoyage/Images/logoXSBon.png?token=AMCLLPEJ5YPJL2HJ6TUUJBK6FAVUM"));
		    lblLogo.setIcon(new javax.swing.ImageIcon(logo));  
		    
	    JLabel lblLogin = new JLabel("Login");
	    lblLogin.setBounds(641, 22, 46, 27);
	    topPanel.add(lblLogin);
	    lblLogin.setForeground(new Color(0, 0, 205));
	    lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    
	    JLabel lblRegistrati = new JLabel("Registrati");
	    lblRegistrati.setBounds(686, 25, 68, 20);
	    topPanel.add(lblRegistrati);
	    lblRegistrati.setForeground(new Color(0, 0, 205));
	    lblRegistrati.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    
	    JLabel lblSeparatore = new JLabel("/");
	    lblSeparatore.setBounds(679, 22, 7, 27);
	    topPanel.add(lblSeparatore);
	    lblSeparatore.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		catch(IOException ex) {
		}
	}
}
