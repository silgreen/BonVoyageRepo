package forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.Controller;
import except.PasswordDismatchException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JTextField textFieldEmail;
	private JTextField textFieldCity;
	private JTextField textFieldRegion;
	private JPasswordField passwordFieldRegister;
	private JPasswordField passwordFieldConfirm;
	private Controller control;

	/**
	 * Create the frame.
	 */
	public RegisterFrame(Controller ctrl) {
		control = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,250,240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(261, 163, 264, 21);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(261, 215, 264, 21);
		contentPane.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		textFieldCity = new JTextField();
		textFieldCity.setBounds(261, 383, 264, 21);
		contentPane.add(textFieldCity);
		textFieldCity.setColumns(10);
		
		textFieldRegion = new JTextField();
		textFieldRegion.setBounds(261, 443, 264, 21);
		contentPane.add(textFieldRegion);
		textFieldRegion.setColumns(10);
		
		JLabel lblSeiGiaRegistrato = new JLabel("Gi\u00E0 registrato?");
		lblSeiGiaRegistrato.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSeiGiaRegistrato.setBounds(318, 496, 104, 26);
		contentPane.add(lblSeiGiaRegistrato);
		
		JLabel lblAccess = new JLabel("Accedi");
		lblAccess.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAccess.setBounds(432, 503, 89, 13);
		contentPane.add(lblAccess);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(261, 148, 50, 13);
		contentPane.add(lblEmail);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(261, 203, 89, 13);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(261, 255, 76, 13);
		contentPane.add(lblPassword);
		
		passwordFieldRegister = new JPasswordField();
		passwordFieldRegister.setBounds(261, 267, 264, 21);
		contentPane.add(passwordFieldRegister);
		
		JLabel lblConfermaPassword = new JLabel("Conferma password");
		lblConfermaPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfermaPassword.setBounds(261, 308, 151, 19);
		contentPane.add(lblConfermaPassword);
		
		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setBounds(261, 325, 264, 21);
		contentPane.add(passwordFieldConfirm);
		
		JLabel lblCity = new JLabel("Citt\u00E0");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCity.setBounds(261, 367, 41, 19);
		contentPane.add(lblCity);
		
		JLabel lblRegione = new JLabel("Regione");
		lblRegione.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRegione.setBounds(261, 422, 63, 21);
		contentPane.add(lblRegione);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				control.toShowSearchByRegister();
			}
		});
		lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogo.setBounds(207, 10, 372, 109);
		contentPane.add(lblLogo);
		
	    JButton btnRegister = new JButton("Registrati");
	    btnRegister.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
					control.RegisterUser(textFieldEmail.getText(), textFieldUserName.getText(), passwordFieldRegister.getText(), passwordFieldConfirm.getText(), textFieldRegion.getText(), textFieldCity.getText());
				} catch (PasswordDismatchException e1) {
					JOptionPane.showInternalMessageDialog(contentPane, "La Password non corrisponde", "BonVoyage!", JOptionPane.ERROR_MESSAGE);
				}
	    	}
	    });
	    btnRegister.setFont(new Font("Arial", Font.PLAIN, 18));
	    btnRegister.setBounds(337, 532, 112, 21);
	    contentPane.add(btnRegister);
		
		try {
		    BufferedImage logo = ImageIO.read(new URL("https://raw.githubusercontent.com/silgreen/BonVoyageRepo/master/BonVoyage/Images/LogoBonvoyagesmall.png?token=AMCLLPHEJIAKCCXSBQ3YGZ26E47ZG"));
		    lblLogo.setIcon(new javax.swing.ImageIcon(logo));
		    
		}
		catch(IOException ex) {
		}
	}

}
