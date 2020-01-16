package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.Controller;

import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private Controller control;

	/**
	 * Create the frame.
	 */
	public LoginFrame(Controller ctrl) {
		control = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldUsername.setBounds(258, 230, 264, 27);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(258, 331, 264, 27);
		contentPane.add(textFieldPassword);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 18));
		lblUsername.setBounds(258, 202, 103, 34);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPassword.setBounds(258, 305, 103, 34);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(337, 427, 108, 43);
		contentPane.add(btnLogin);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(221, 44, 338, 147);
		contentPane.add(lblLogo);
		
	    JLabel lblNonSeiRegistrato = new JLabel("Non sei Registrato?");
	    lblNonSeiRegistrato.setBounds(342, 369, 103, 14);
	    contentPane.add(lblNonSeiRegistrato);
	    //commento
		
		try {
		    BufferedImage logo = ImageIO.read(new URL("https://raw.githubusercontent.com/silgreen/BonVoyageRepo/master/BonVoyage/Images/LogoBonvoyagesmall.png?token=AMCLLPHEJIAKCCXSBQ3YGZ26E47ZG"));
		    lblLogo.setIcon(new javax.swing.ImageIcon(logo));
		    
		}
		catch(IOException ex) {
		}
	}
}
