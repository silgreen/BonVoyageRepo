package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.Controller;
import except.NoResultsException;
import except.NoUserReviewException;

import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

public class SearchFrame extends JFrame { 
	
	private Controller control;
	private JPanel contentPane;
	private JTextField textFieldSearch;
	private JLabel lblLogo;
	private JPanel panel;
	private JLabel lblRegistrati;
	private JRadioButton rdbtnHotel;
	private JRadioButton rdbtnRistoranti;
	private JRadioButton rdbtnAttivita;
	private JRadioButton rdbtnAll;
	private JButton btnCerca;
	private JLabel lblRegistrati_1;
	private JLabel lblLogin;
	private JLabel lblUser;

	/**
	 * Create the frame.
	 */
	public SearchFrame(Controller ctrl) {
		setResizable(false);
		Color bg = Color.decode("#4d92c2");
		Color bginner = Color.decode("#046490");
		setTitle("BonVoyage!");
		control = ctrl;
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,255,255));
		contentPane.setToolTipText("");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBorder(new MatteBorder(1, 1, 1, 1, (Color) UIManager.getColor("RadioButtonMenuItem.selectionBackground")));
		textFieldSearch.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSearch.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textFieldSearch.setFont(new Font("Nirmala UI", Font.PLAIN, 19));
		textFieldSearch.setBounds(312, 330, 371, 27);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		lblLogo = new JLabel();
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(SearchFrame.class.getResource("/images/logo_login_frame.png")));
		lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblLogo.setBounds(365, 61, 266, 222);
		contentPane.add(lblLogo);
		
		ButtonGroup radioButtonGroup = new ButtonGroup();
	    
	    rdbtnHotel = new JRadioButton("Hotel");
	    rdbtnHotel.setFocusPainted(false);
	    rdbtnHotel.setContentAreaFilled(false);
	    rdbtnHotel.setBorder(null);
	    rdbtnHotel.setBackground(new Color(255, 250, 240));
	    rdbtnHotel.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
	    rdbtnHotel.setBounds(408, 362, 75, 21);
	    contentPane.add(rdbtnHotel);
	    radioButtonGroup.add(rdbtnHotel);
	    
	    rdbtnRistoranti = new JRadioButton("Ristoranti");
	    rdbtnRistoranti.setFocusPainted(false);
	    rdbtnRistoranti.setBorder(null);
	    rdbtnRistoranti.setContentAreaFilled(false);
	    rdbtnRistoranti.setBackground(new Color(255, 250, 240));
	    rdbtnRistoranti.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
	    rdbtnRistoranti.setBounds(486, 362, 104, 21);
	    contentPane.add(rdbtnRistoranti);
	    radioButtonGroup.add(rdbtnRistoranti);
	    
	    rdbtnAttivita = new JRadioButton("Attivit\u00E0");
	    rdbtnAttivita.setFocusPainted(false);
	    rdbtnAttivita.setBorder(null);
	    rdbtnAttivita.setContentAreaFilled(false);
	    rdbtnAttivita.setBackground(new Color(255, 250, 240));
	    rdbtnAttivita.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
	    rdbtnAttivita.setBounds(600, 362, 83, 21);
	    contentPane.add(rdbtnAttivita);
	    radioButtonGroup.add(rdbtnAttivita);
	    
	    rdbtnAll = new JRadioButton("Tutto");
	    rdbtnAll.setSelected(true);
	    rdbtnAll.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
	    rdbtnAll.setFocusPainted(false);
	    rdbtnAll.setContentAreaFilled(false);
	    rdbtnAll.setBorder(null);
	    rdbtnAll.setBackground(new Color(255, 250, 240));
	    rdbtnAll.setBounds(311, 362, 63, 21);
	    contentPane.add(rdbtnAll);
	    radioButtonGroup.add(rdbtnAll);
	    rdbtnAll.setSelected(true);
	    
	    btnCerca = new JButton("");
	    btnCerca.setIcon(new ImageIcon(SearchFrame.class.getResource("/images/button_il-tuo-testo-qui_2.png")));
	    btnCerca.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btnCerca.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		btnCerca.setIcon(new ImageIcon(SearchFrame.class.getResource("/images/button_il-tuo-testo-qui_4.png")));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		btnCerca.setIcon(new ImageIcon(SearchFrame.class.getResource("/images/button_il-tuo-testo-qui_2.png")));
	    	}
	    });
	    btnCerca.setOpaque(false);
	    btnCerca.setContentAreaFilled(false);
	    btnCerca.setBorderPainted(false);
	    btnCerca.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
		    		if(!textFieldSearch.getText().isEmpty()) {
			    		if(rdbtnRistoranti.isSelected()) {
								control.toShowResultsByPositionAndCategory(textFieldSearch.getText(), "Ristorante");
								control.toOpenAndCloseFrame(control.getResults(), control.getSearch());
								control.setSearchDatas(textFieldSearch.getText(), "Ristorante");
								control.setSearchType(1);
			    		}
			    		else if(rdbtnHotel.isSelected()) {
			    			control.toShowResultsByPositionAndCategory(textFieldSearch.getText(), "Struttura Ricettiva");
			    			control.toOpenAndCloseFrame(control.getResults(), control.getSearch());
			    			control.setSearchDatas(textFieldSearch.getText(), "Struttura Ricettiva");
			    			control.setSearchType(1);
			    		}
			    		else if(rdbtnAttivita.isSelected()) {
			    			control.toShowResultsByPositionAndCategory(textFieldSearch.getText(), "Attrazione Turistica");
			    			control.toOpenAndCloseFrame(control.getResults(), control.getSearch());
			    			control.setSearchDatas(textFieldSearch.getText(), "Attrazione Turistica");
			    			control.setSearchType(1);
			    		}
			    		else if(rdbtnAll.isSelected()) {
			    			control.toShowAllResultsByPosition(textFieldSearch.getText());
			    			control.toOpenAndCloseFrame(control.getResults(), control.getSearch());
			    			control.setSearchDataCity(textFieldSearch.getText());
			    			control.setSearchType(2);
			    		}
		    		} else {
			    		if(rdbtnAttivita.isSelected()) {
			    			control.toShowResultsByCategory("Attrazione Turistica");
			    			control.toOpenAndCloseFrame(control.getResults(), control.getSearch());
			    			control.setSearchDataCategory("Attrazione Turistica");
			    			control.setSearchType(3);
			    		}
			    		else if(rdbtnHotel.isSelected()) {
			    			control.toShowResultsByCategory("Struttura Ricettiva");
			    			control.toOpenAndCloseFrame(control.getResults(), control.getSearch());
			    			control.setSearchDataCategory("Struttura Ricettiva");
			    			control.setSearchType(3);
			    		}
			    		else if(rdbtnRistoranti.isSelected()) {
			    			control.toShowResultsByCategory("Ristorante");
			    			control.toOpenAndCloseFrame(control.getResults(), control.getSearch());
			    			control.setSearchDataCategory("Ristorante");
			    			control.setSearchType(3);
			    		}
			    		else if(rdbtnAll.isSelected()) {
			    			control.toShowAllResults();
			    			control.toOpenAndCloseFrame(control.getResults(), control.getSearch());
			    			control.setSearchType(4);
			    		}
		    		}
	    		}catch(NoResultsException f) {
		        	JOptionPane.showInternalMessageDialog(contentPane, "La ricerca non ha prodotto risultati", "BonVoyage!", JOptionPane.ERROR_MESSAGE);
	    		}
	    	}
	    });
	    btnCerca.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    btnCerca.setBounds(419, 417, 157, 40);
	    contentPane.add(btnCerca);
	    
	    JLabel lblDoveVuoiAndare = new JLabel("Dove vuoi andare?");
	    lblDoveVuoiAndare.setHorizontalAlignment(SwingConstants.CENTER);
	    lblDoveVuoiAndare.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
	    lblDoveVuoiAndare.setBounds(408, 293, 197, 27);
	    contentPane.add(lblDoveVuoiAndare);
	    
	    JPanel topPanel = new JPanel();
	    topPanel.setBounds(0, 0, 996, 51);
	    topPanel.setBackground(bg);
	    contentPane.add(topPanel);
	    topPanel.setLayout(null);
	    
	    JPanel innerPanel = new JPanel();
	    innerPanel.setBounds(0, 0, 996, 16);
	    innerPanel.setBackground(bginner);
	    topPanel.add(innerPanel);
	    innerPanel.setLayout(null);
	    
	    lblRegistrati_1 = new JLabel("Registrati");
	    lblRegistrati_1.setBounds(880, 20, 95, 27);
	    topPanel.add(lblRegistrati_1);
	    lblRegistrati_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    lblRegistrati_1.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		control.toOpenAndCloseFrame(control.getRegister(),control.getSearch());
	    	}
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		lblRegistrati_1.setText("<HTML><U>Registrati</U></HTML>");
	    		lblRegistrati_1.setForeground(new Color(255,255,255));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		lblRegistrati_1.setText("Registrati");
	    		lblRegistrati_1.setForeground(new Color(0,0,0));
	    	}
	    });
	    lblRegistrati_1.setForeground(Color.BLACK);
	    lblRegistrati_1.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
	    
	    lblLogin = new JLabel("Login");
	    lblLogin.setBounds(820, 20, 58, 27);
	    topPanel.add(lblLogin);
	    lblLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    lblLogin.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		control.toOpenAndCloseFrame(control.getLogin(),control.getSearch());
	    	}
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		lblLogin.setText("<HTML><U>Login</U></HTML>");
	    		lblLogin.setForeground(new Color(255, 255, 255));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		lblLogin.setText("Login");
	    		lblLogin.setForeground(new Color(0, 0, 0));
	    	}
	    });
	    
	    lblLogin.setForeground(Color.BLACK);
	    lblLogin.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
	    
	    JLabel lblSeparatore = new JLabel("|");
	    lblSeparatore.setBounds(872, 20, 7, 27);
	    topPanel.add(lblSeparatore);
	    lblSeparatore.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    
	    JLabel lblCiao = new JLabel("Ciao,");
	    lblCiao.setBounds(10, 20, 45, 22);
	    topPanel.add(lblCiao);
	    lblCiao.setVisible(false);
	    lblCiao.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
	    
	    lblUser = new JLabel("");
	    lblUser.setBounds(56, 20, 156, 22);
	    topPanel.add(lblUser);
	    lblUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    lblUser.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		control.toOpenAndCloseFrame(control.getProfile(), control.getSearch());
	    		control.setStory(control.StoryFrame(control.getSearch()));
	    		
	    	}
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		lblUser.setForeground(new Color(255, 255, 255));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		lblUser.setForeground(new Color(0, 0, 0));
	    	}
	    });
	    lblUser.setVisible(false);
	    lblUser.setFont(new Font("Nirmala UI", Font.BOLD, 20));
	    
	    lblUser.addComponentListener(new ComponentAdapter() {
	    	@Override
	    	public void componentShown(ComponentEvent e) {
	    		lblUser.setText(control.getUser().getUsername());
	        	JOptionPane.showInternalMessageDialog(contentPane, "Accesso Effettuato", "BonVoyage!", JOptionPane.INFORMATION_MESSAGE);
	    	}
	    });
	    
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				textFieldSearch.setText("");
				rdbtnAll.setSelected(true);
	    	    if(control.getUser().isLogged()) {
					lblRegistrati_1.setVisible(false);
					lblLogin.setVisible(false);
					lblSeparatore.setVisible(false);
					lblCiao.setVisible(true);
					lblUser.setText(control.getUser().getUsername());
					lblUser.setVisible(true);
				} 
	    	    else {
					lblRegistrati_1.setVisible(true);
					lblLogin.setVisible(true);
					lblSeparatore.setVisible(true);
					lblCiao.setVisible(false);
					lblUser.setVisible(false);
				}
			}
		});		
	}
	
	public JLabel getlblLogin() {
		return lblLogin;
	}
}
