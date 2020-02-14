package forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTextField;
import java.awt.GridLayout;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import classi.Position;
import controller.Controller;
import dao.PositionDao;
import except.EmailAlreadyExistException;
import except.PasswordDismatchException;
import except.UserAlreadyExistException;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import java.awt.Event;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class RegisterFrame extends JFrame {
	
	
	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JTextField textFieldEmail;
	private JTextField textFieldRegion;
	private JPasswordField passwordFieldRegister;
	private JPasswordField passwordFieldConfirm;
	private Controller control;
	private JComboBox comboBox;
	private JButton btnRegister;
	/**
	 * Create the frame.
	 */
	public RegisterFrame(Controller ctrl) {
		setResizable(false);
		Color bg = Color.decode("#81c1f4");
		control = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldEmail.setBounds(656, 129, 264, 26);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldUserName.setBounds(656, 184, 264, 26);
		contentPane.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		JLabel lblSeiGiaRegistrato = new JLabel("Gi\u00E0 registrato?");
		lblSeiGiaRegistrato.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		lblSeiGiaRegistrato.setBounds(708, 462, 124, 26);
		contentPane.add(lblSeiGiaRegistrato);
		
		JLabel lblAccess = new JLabel("Accedi");
		lblAccess.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAccess.setText("<HTML><U>Accedi</U></HTML>");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAccess.setText("Accedi");
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			control.toOpenAndCloseFrame(control.getLogin(),control.getRegister());
			}
		});
		lblAccess.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAccess.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		lblAccess.setBounds(833, 466, 63, 19);
		contentPane.add(lblAccess);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Nirmala UI", Font.PLAIN, 21));
		lblEmail.setBounds(750, 107, 76, 20);
		contentPane.add(lblEmail);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Nirmala UI", Font.PLAIN, 21));
		lblUsername.setBounds(736, 162, 104, 20);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Nirmala UI", Font.PLAIN, 21));
		lblPassword.setBounds(736, 210, 104, 31);
		contentPane.add(lblPassword);
		
		passwordFieldRegister = new JPasswordField();
		passwordFieldRegister.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		passwordFieldRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordFieldRegister.setBounds(656, 238, 264, 26);
		contentPane.add(passwordFieldRegister);
		
		JLabel lblConfermaPassword = new JLabel("Conferma password");
		lblConfermaPassword.setFont(new Font("Nirmala UI", Font.PLAIN, 21));
		lblConfermaPassword.setBounds(694, 270, 188, 23);
		contentPane.add(lblConfermaPassword);
		
		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordFieldConfirm.setBounds(656, 297, 264, 26);
		contentPane.add(passwordFieldConfirm);
		
		JLabel lblCity = new JLabel("Citta'");
		lblCity.setFont(new Font("Nirmala UI", Font.PLAIN, 22));
		lblCity.setBounds(758, 333, 57, 19);
		contentPane.add(lblCity);
		
		JLabel lblRegione = new JLabel("Regione");
		lblRegione.setFont(new Font("Nirmala UI", Font.PLAIN, 21));
		lblRegione.setBounds(747, 385, 104, 28);
		contentPane.add(lblRegione);
		
		Icon Logo = new ImageIcon("/BonVoyage/Images/LogoBonvoyagesmall.png");
	    
	   comboBox = new JComboBox();

	   comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
	   comboBox.addItem("Aosta");
	   comboBox.addItem("L'Aquila");
	   comboBox.addItem("Potenza");
	   comboBox.addItem("Catanzaro");
	   comboBox.addItem("Napoli");
	   comboBox.addItem("Bologna");
	   comboBox.addItem("Trieste");
	   comboBox.addItem("Torino");
	   comboBox.addItem("Roma");
	   comboBox.addItem("Genova");
	   comboBox.addItem("Milano");
	   comboBox.addItem("Ancona");
	   comboBox.addItem("Campobasso");
	   comboBox.addItem("Bari");
	   comboBox.addItem("Cagliari");
	   comboBox.addItem("Palermo");
	   comboBox.addItem("Firenze");
	   comboBox.addItem("Trento");
	   comboBox.addItem("Perugia");
	   comboBox.addItem("Venezia");
	   comboBox.setSelectedItem(null);
	   comboBox.setBounds(656, 357, 264, 26);
	   contentPane.add(comboBox);
	    
		textFieldRegion = new JTextField();

		textFieldRegion.setEditable(false);
		textFieldRegion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldRegion.setBounds(656, 415, 264, 26);
		contentPane.add(textFieldRegion);
		textFieldRegion.setColumns(10);
		
	    btnRegister = new JButton("");
	    btnRegister.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		btnRegister.setIcon(new ImageIcon(SearchFrame.class.getResource("/images/btn_register_light.png")));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		btnRegister.setIcon(new ImageIcon(SearchFrame.class.getResource("/images/btn_register.png")));
	    	}
	    });
	    btnRegister.setIcon(new ImageIcon(RegisterFrame.class.getResource("/images/btn_register.png")));
	    btnRegister.setEnabled(false);
	    btnRegister.setOpaque(false);
	    btnRegister.setContentAreaFilled(false);
	    btnRegister.setBorderPainted(false);
	    btnRegister.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
					control.RegisterUser(textFieldEmail.getText(), textFieldUserName.getText(), passwordFieldRegister.getText(), passwordFieldConfirm.getText(), textFieldRegion.getText(), comboBox.getSelectedItem().toString());
		    		JOptionPane.showInternalMessageDialog(contentPane, "Registrazione Effettuata!", "BonVoyage!",JOptionPane.INFORMATION_MESSAGE);
		    		control.toOpenAndCloseFrame(control.getLogin(), control.getRegister());
		    		textFieldEmail.setText("");
		    		textFieldUserName.setText("");
		    		passwordFieldRegister.setText("");
		    		passwordFieldConfirm.setText("");
		    		textFieldRegion.setText("");
		    		comboBox.setSelectedItem(null);
				} catch (PasswordDismatchException e1) {
					JOptionPane.showInternalMessageDialog(contentPane, "La Password non corrisponde!", "BonVoyage!", JOptionPane.ERROR_MESSAGE);
				} catch (UserAlreadyExistException e2) {
					JOptionPane.showInternalMessageDialog(contentPane, "Username non disponibile!", "BonVoyage!", JOptionPane.ERROR_MESSAGE);
				} catch (EmailAlreadyExistException e3) {
					JOptionPane.showInternalMessageDialog(contentPane, "Email già esistente!", "BonVoyage!", JOptionPane.ERROR_MESSAGE);
				}
	    	}
	    });
	    btnRegister.setFont(new Font("Arial", Font.PLAIN, 18));
	    btnRegister.setBounds(714, 498, 160, 43);
	    contentPane.add(btnRegister);
	    
	    JPanel panel = new JPanel();
	    panel.setBounds(0, 0, 600, 600);
	    contentPane.add(panel);
	    panel.setLayout(null);
	    
	    JLabel lblMotto = new JLabel("We Stay At Place");
	    lblMotto.setFont(new Font("Montserrat", Font.ITALIC, 24));
	    lblMotto.setHorizontalAlignment(SwingConstants.CENTER);
	    lblMotto.setBounds(147, 333, 286, 44);
	    panel.add(lblMotto);
	    JLabel lblLogo = new JLabel();
	    lblLogo.setBounds(168, 76, 264, 234);
	    panel.add(lblLogo);
	    lblLogo.setIcon(new ImageIcon(RegisterFrame.class.getResource("/images/logo_progetto_bonvoyage_nero.png")));
	    lblLogo.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		control.toOpenAndCloseFrame(control.getSearch(), control.getRegister());
	    	}
		});
		lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	    JLabel lblNewLabel = new JLabel("");
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/images/bg_register_2.png")));
	    lblNewLabel.setBounds(0, 0, 600, 600);
	    panel.add(lblNewLabel);
	    
	    JLabel lblVincoliTextFields = new JLabel("Tutti i campi sono obbligatori");
	    lblVincoliTextFields.setVisible(false);
	    lblVincoliTextFields.setForeground(Color.RED);
	    lblVincoliTextFields.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
	    lblVincoliTextFields.setBounds(708, 11, 299, 14);
	    contentPane.add(lblVincoliTextFields);
	    
	    JLabel lblVincoliPw = new JLabel("La password deve essere compresa tra 8 e 16 caratteri");
	    lblVincoliPw.setVisible(false);
	    lblVincoliPw.setForeground(Color.RED);
	    lblVincoliPw.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
	    lblVincoliPw.setBounds(656, 36, 276, 14);
	    contentPane.add(lblVincoliPw);
	    
	    DocumentListener doclistener = new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				changed();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				changed();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				changed();
				
			}
			
			private void changed() {
				if(passwordFieldRegister.getText().length() < 8 || passwordFieldRegister.getText().length() > 16) {
					btnRegister.setEnabled(false);
					passwordFieldRegister.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.RED));
					lblVincoliPw.setVisible(true);
				}
				else {
					btnRegister.setEnabled(true);
					passwordFieldRegister.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
					lblVincoliPw.setVisible(false);
				}
				
				if(passwordFieldRegister.getText().isEmpty()) {
					passwordFieldRegister.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					lblVincoliPw.setVisible(false);
				}
				
				if(textFieldEmail.getText().isEmpty() || textFieldRegion.getText().isEmpty() || textFieldUserName.getText().isEmpty() || passwordFieldConfirm.getText().isEmpty()) {
					lblVincoliTextFields.setVisible(true);
					btnRegister.setEnabled(false);
				}
				else {
					lblVincoliTextFields.setVisible(false);
					btnRegister.setEnabled(true);
				}
			}
		};
		
		passwordFieldRegister.getDocument().addDocumentListener(doclistener);
		textFieldEmail.getDocument().addDocumentListener(doclistener);
		textFieldRegion.getDocument().addDocumentListener(doclistener);
		textFieldUserName.getDocument().addDocumentListener(doclistener);
		passwordFieldConfirm.getDocument().addDocumentListener(doclistener);
		
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				textFieldRegion.setText(control.MatchRegion(comboBox.getSelectedItem().toString()));
				
			}
		});
	}
}
