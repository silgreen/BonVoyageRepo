package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JTextField textFieldEmail;
	private JTextField textFieldCity;
	private JTextField textFieldRegion;
	private JPasswordField passwordFieldRegister;
	private JPasswordField passwordFieldConfirm;

	/**
	 * Create the frame.
	 */
	public RegisterFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(318, 163, 167, 19);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(318, 215, 167, 19);
		contentPane.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		textFieldCity = new JTextField();
		textFieldCity.setBounds(318, 383, 167, 19);
		contentPane.add(textFieldCity);
		textFieldCity.setColumns(10);
		
		textFieldRegion = new JTextField();
		textFieldRegion.setBounds(318, 443, 167, 19);
		contentPane.add(textFieldRegion);
		textFieldRegion.setColumns(10);
		
		JButton btnRegister = new JButton("Registrati");
		btnRegister.setFont(new Font("Arial", Font.PLAIN, 18));
		btnRegister.setBounds(338, 532, 112, 21);
		contentPane.add(btnRegister);
		
		JLabel lblSeiGi‡Registrato = new JLabel("Gi\u00E0 registrato?");
		lblSeiGi‡Registrato.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSeiGi‡Registrato.setBounds(318, 496, 104, 26);
		contentPane.add(lblSeiGi‡Registrato);
		
		JLabel lblAccess = new JLabel("Accedi");
		lblAccess.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAccess.setBounds(432, 503, 89, 13);
		contentPane.add(lblAccess);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(318, 140, 50, 13);
		contentPane.add(lblEmail);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setBounds(318, 192, 89, 13);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(318, 244, 76, 13);
		contentPane.add(lblPassword);
		
		passwordFieldRegister = new JPasswordField();
		passwordFieldRegister.setBounds(318, 267, 167, 19);
		contentPane.add(passwordFieldRegister);
		
		JLabel lblConfermaPassword = new JLabel("Conferma password");
		lblConfermaPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConfermaPassword.setBounds(319, 296, 184, 19);
		contentPane.add(lblConfermaPassword);
		
		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setBounds(318, 325, 167, 19);
		contentPane.add(passwordFieldConfirm);
		
		JLabel lblCity = new JLabel("Citt\u00E0");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCity.setBounds(318, 354, 50, 19);
		contentPane.add(lblCity);
		
		JLabel lblRegione = new JLabel("Regione");
		lblRegione.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRegione.setBounds(318, 412, 112, 21);
		contentPane.add(lblRegione);
	}
}
