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

public class RegisterFrame extends JFrame {
	
	
	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JTextField textFieldEmail;
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
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldEmail.setBounds(261, 163, 264, 26);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldUserName.setBounds(261, 218, 264, 26);
		contentPane.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		JLabel lblSeiGiaRegistrato = new JLabel("Già registrato?");
		lblSeiGiaRegistrato.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSeiGiaRegistrato.setBounds(318, 496, 104, 26);
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
		lblAccess.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAccess.setBounds(432, 500, 63, 19);
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
		lblPassword.setBounds(261, 244, 76, 31);
		contentPane.add(lblPassword);
		
		passwordFieldRegister = new JPasswordField();
		passwordFieldRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordFieldRegister.setBounds(261, 272, 264, 26);
		contentPane.add(passwordFieldRegister);
		
		JLabel lblConfermaPassword = new JLabel("Conferma password");
		lblConfermaPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfermaPassword.setBounds(261, 308, 151, 19);
		contentPane.add(lblConfermaPassword);
		
		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordFieldConfirm.setBounds(261, 331, 264, 26);
		contentPane.add(passwordFieldConfirm);
		
		JLabel lblCity = new JLabel("Città");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCity.setBounds(261, 367, 41, 19);
		contentPane.add(lblCity);
		
		JLabel lblRegione = new JLabel("Regione");
		lblRegione.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRegione.setBounds(261, 422, 63, 21);
		contentPane.add(lblRegione);
		
		Icon Logo = new ImageIcon("/BonVoyage/Images/LogoBonvoyagesmall.png");
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(RegisterFrame.class.getResource("/images/LogoBonvoyagesmall.png")));
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				control.toOpenAndCloseFrame(control.getSearch(), control.getRegister());
			}
		});
		lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogo.setBounds(207, 10, 372, 109);
		contentPane.add(lblLogo);
	    
	   JComboBox comboBox = new JComboBox();

	   comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
	   comboBox.addItem("Aosta");
	   comboBox.addItem("L’Aquila");
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
	   comboBox.setBounds(261, 391, 264, 26);
	   contentPane.add(comboBox);
	    
		textFieldRegion = new JTextField();

		textFieldRegion.setEditable(false);
		textFieldRegion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldRegion.setBounds(261, 443, 264, 26);
		contentPane.add(textFieldRegion);
		textFieldRegion.setColumns(10);
		
	    JButton btnRegister = new JButton("Registrati");
	    btnRegister.setEnabled(false);
	    btnRegister.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
					control.RegisterUser(textFieldEmail.getText(), textFieldUserName.getText(), passwordFieldRegister.getText(), passwordFieldConfirm.getText(), textFieldRegion.getText(), comboBox.getSelectedItem().toString());
				} catch (PasswordDismatchException e1) {
					JOptionPane.showInternalMessageDialog(contentPane, "La Password non corrisponde!", "BonVoyage!", JOptionPane.ERROR_MESSAGE);
				} catch (UserAlreadyExistException e2) {
					JOptionPane.showInternalMessageDialog(contentPane, "L'Username non è disponibile!", "BonVoyage!", JOptionPane.ERROR_MESSAGE);
				} catch (EmailAlreadyExistException e3) {
					JOptionPane.showInternalMessageDialog(contentPane, "l'Email è già stata utilizzata!", "BonVoyage!", JOptionPane.ERROR_MESSAGE);
				}
	    		
	    		JOptionPane.showInternalMessageDialog(contentPane, "Registrazione Effettuata!", "BonVoyage!",JOptionPane.INFORMATION_MESSAGE);
	    		control.toOpenAndCloseFrame(control.getLogin(), control.getRegister());
	    	}
	    });
	    btnRegister.setFont(new Font("Arial", Font.PLAIN, 18));
	    btnRegister.setBounds(337, 532, 112, 21);
	    contentPane.add(btnRegister);
	    
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
			
			public void changed() {
				if(passwordFieldRegister.getText().length() < 8 || passwordFieldRegister.getText().length() > 16)
					btnRegister.setEnabled(false);
				else btnRegister.setEnabled(true);
			}
		};
		
		passwordFieldRegister.getDocument().addDocumentListener(doclistener);
		
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				textFieldRegion.setText(control.MatchRegion(comboBox.getSelectedItem().toString()));
				
			}
		});
	}
}
