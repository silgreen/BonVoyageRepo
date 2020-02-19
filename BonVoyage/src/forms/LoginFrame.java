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
import except.NoUserReviewException;

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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.SwingConstants;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JPasswordField textFieldPassword;
	private Controller control;
	private JLabel lblLogo;

	/**
	 * Create the frame.
	 */
	public LoginFrame(Controller ctrl) {
		setTitle("BonVoyage!");
		setResizable(false);
		Color bg = Color.decode("#4d92c2");
		Color bginner = Color.decode("#046490");
		control = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldUsername.setBounds(363, 322, 264, 27);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(363, 403, 264, 27);
		contentPane.add(textFieldPassword);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Nirmala UI", Font.PLAIN, 21));
		lblUsername.setBounds(446, 290, 103, 34);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Nirmala UI", Font.PLAIN, 21));
		lblPassword.setBounds(446, 371, 103, 34);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("");
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
	    		btnLogin.setIcon(new ImageIcon(SearchFrame.class.getResource("/images/login_btn2.png")));

			}
			@Override
			public void mouseExited(MouseEvent e) {
	    		btnLogin.setIcon(new ImageIcon(SearchFrame.class.getResource("/images/login_btn1.png")));

			}
		});
		btnLogin.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/login_btn1.png")));
		btnLogin.setFont(new Font("Montserrat", Font.PLAIN, 14));
	    btnLogin.setOpaque(false);
	    btnLogin.setContentAreaFilled(false);
	    btnLogin.setBorderPainted(false);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					control.LoginUser(textFieldUsername.getText(), textFieldPassword.getText());
					if(control.getUser().isLogged()) {
						control.toOpenAndCloseFrame(control.getSearch(),control.getLogin());
					}
				} catch (LoginException e1) {
					JOptionPane.showInternalMessageDialog(contentPane, "Nome utente o password errati", "BonVoyage!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnLogin.setBounds(419, 486, 157, 34);
		contentPane.add(btnLogin);
		
		lblLogo = new JLabel("");
		lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBackground(Color.WHITE);
		lblLogo.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/logo_login_frame.png")));
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				control.toOpenAndCloseFrame(control.getSearch(), control.getLogin());
			}
		});
		lblLogo.setBounds(364, 61, 266, 222);
		contentPane.add(lblLogo);
		
	    JLabel lblNonSeiRegistrato = new JLabel("Non sei Registrato?");
	    lblNonSeiRegistrato.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
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
	    
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				textFieldUsername.setText(null);
				textFieldPassword.setText(null);
			}
		});
	    
	    lblNonSeiRegistrato.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    lblNonSeiRegistrato.setBounds(441, 449, 116, 27);
	    contentPane.add(lblNonSeiRegistrato);
	    
	    lblNonSeiRegistrato.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    
	    JPanel topPanel = new JPanel();
	    topPanel.setBounds(0, 0, 996, 51);
	    topPanel.setBackground(bg);
	    contentPane.add(topPanel);
	    topPanel.setLayout(null);
	    
	    JPanel innerPanel = new JPanel();
	    innerPanel.setBounds(0, 0, 996, 16);
	    innerPanel.setBackground(bginner);
	    topPanel.add(innerPanel);
	}
}
