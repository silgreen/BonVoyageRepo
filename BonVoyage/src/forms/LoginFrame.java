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
import except.LoginException;

import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JPasswordField textFieldPassword;
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
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
				try {
					control.Login_User(textFieldUsername.getText(), textFieldPassword.getText());
					if(control.getUser().isLogged()) {
						control.toOpenAndCloseFrame(control.getSearch(),control.getLogin());
						control.SetLoginAndRegisterLabelVisible(false, true);
					}
				} catch (LoginException e1) {
					JOptionPane.showInternalMessageDialog(contentPane, "Utente non trovato", "BonVoyage!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnLogin.setBounds(337, 427, 108, 43);
		contentPane.add(btnLogin);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				control.toOpenAndCloseFrame(control.getSearch(), control.getLogin());
			}
		});
		lblLogo.setBounds(221, 44, 338, 147);
		contentPane.add(lblLogo);
		
	    JLabel lblNonSeiRegistrato = new JLabel("Non sei Registrato?");
	    lblNonSeiRegistrato.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		control.toOpenAndCloseFrame(control.getRegister(), control.getLogin());
	    	}
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		lblNonSeiRegistrato.setText("<HTML><U>Non sei Registrato?</U></HTML>");
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		lblNonSeiRegistrato.setText("Non sei Registrato?");
	    	}
	    });
	    lblNonSeiRegistrato.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    lblNonSeiRegistrato.setBounds(337, 369, 124, 27);
	    contentPane.add(lblNonSeiRegistrato);
	
		
		try {
		    BufferedImage logo = ImageIO.read(new URL("https://raw.githubusercontent.com/silgreen/BonVoyageRepo/master/BonVoyage/Images/LogoBonvoyagesmall.png?token=AMCLLPHEJIAKCCXSBQ3YGZ26E47ZG"));
		    lblLogo.setIcon(new javax.swing.ImageIcon(logo));
		    
		}
		catch(IOException ex) {
		}
	}
}
