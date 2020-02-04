package forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import controller.Controller;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JTextArea;

public class ReviewFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTitolo;
	private Controller control;
	private int Rating = 1;

	/**
	 * Create the frame.
	 */
	public ReviewFrame(Controller ctrl) {

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
		
	    textFieldTitolo = new JTextField();
	    textFieldTitolo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
	    textFieldTitolo.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    textFieldTitolo.setBounds(318, 134, 350, 27);
	    contentPane.add(textFieldTitolo);
	    textFieldTitolo.setColumns(10);
	    
	    JEditorPane editorPaneReview = new JEditorPane();
	    editorPaneReview.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
	    editorPaneReview.setBounds(243, 244, 500, 200);
	    contentPane.add(editorPaneReview);
	    
	    JLabel lblRecensione = new JLabel("Recensione");
	    lblRecensione.setFont(new Font("Montserrat", Font.PLAIN, 18));
	    lblRecensione.setBounds(440, 207, 106, 27);
	    contentPane.add(lblRecensione);
	    
	    JLabel lblTitolo = new JLabel("Titolo");
	    lblTitolo.setFont(new Font("Montserrat", Font.PLAIN, 18));
	    lblTitolo.setBounds(318, 105, 53, 19);
	    contentPane.add(lblTitolo);
	    
	    JButton btnNewPubblicaReview = new JButton("");
	    btnNewPubblicaReview.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btnNewPubblicaReview.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		btnNewPubblicaReview.setIcon(new ImageIcon(SearchFrame.class.getResource("/images/button_pubblica-recensione_light.png")));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		btnNewPubblicaReview.setIcon(new ImageIcon(SearchFrame.class.getResource("/images/button_pubblica-recensione.png")));
	    	}
	    });
	    btnNewPubblicaReview.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/button_pubblica-recensione.png")));
	    btnNewPubblicaReview.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnNewPubblicaReview.setBounds(359, 468, 267, 49);
	    btnNewPubblicaReview.setOpaque(false);
	    btnNewPubblicaReview.setContentAreaFilled(false);
	    btnNewPubblicaReview.setBorderPainted(false);
	    contentPane.add(btnNewPubblicaReview);
	    
	    ButtonGroup radioButtonGroup = new ButtonGroup();
	    
	    JRadioButton rdbtnStar1 = new JRadioButton("");


	    rdbtnStar1.setBackground(Color.WHITE);
	    rdbtnStar1.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    rdbtnStar1.setBounds(469, 96, 38, 32);
	    contentPane.add(rdbtnStar1);
	    
	    JRadioButton rdbtnStar2 = new JRadioButton("");


	    rdbtnStar2.setBackground(Color.WHITE);
	    rdbtnStar2.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    rdbtnStar2.setBounds(509, 96, 38, 32);
	    contentPane.add(rdbtnStar2);
	    
	    JRadioButton rdbtnStar3 = new JRadioButton("");


	    rdbtnStar3.setBackground(Color.WHITE);
	    rdbtnStar3.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    rdbtnStar3.setBounds(549, 96, 38, 32);
	    contentPane.add(rdbtnStar3);
	    
	    JRadioButton rdbtnStar4 = new JRadioButton("");


	    rdbtnStar4.setBackground(Color.WHITE);
	    rdbtnStar4.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    rdbtnStar4.setBounds(590, 96, 38, 32);
	    contentPane.add(rdbtnStar4);
	    
	    JRadioButton rdbtnStar5 = new JRadioButton("");


	    rdbtnStar5.setBackground(Color.WHITE);
	    rdbtnStar5.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    rdbtnStar5.setBounds(630, 96, 38, 32);
	    contentPane.add(rdbtnStar5);
	    
	    radioButtonGroup.add(rdbtnStar1);
	    radioButtonGroup.add(rdbtnStar2);
	    radioButtonGroup.add(rdbtnStar3);
	    radioButtonGroup.add(rdbtnStar4);
	    radioButtonGroup.add(rdbtnStar5);
	    
	    JLabel lblGiudizio = new JLabel("");
	    lblGiudizio.setHorizontalAlignment(SwingConstants.CENTER);
	    lblGiudizio.setFont(new Font("Montserrat", Font.PLAIN, 12));
	    lblGiudizio.setAutoscrolls(true);
	    lblGiudizio.setBounds(492, 71, 151, 29);
	    contentPane.add(lblGiudizio);
	    
	    JLabel lblLogo = new JLabel("");
	    lblLogo.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		lblLogo.setIcon(new ImageIcon(SearchFrame.class.getResource("/images/logo_mini_png_light.png")));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		lblLogo.setIcon(new ImageIcon(SearchFrame.class.getResource("/images/logo_mini_png.png")));
	    	}
	    });
	    lblLogo.setBounds(900, -2, 65, 55);
	    contentPane.add(lblLogo);
	    lblLogo.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/logo_mini_png.png")));
	    lblLogo.setFont(new Font("Montserrat", Font.PLAIN, 27));
	    
	    JPanel topPanel = new JPanel();
	    topPanel.setBounds(0, 0, 1000, 51);
	    topPanel.setBackground(bg);
	    contentPane.add(topPanel);
	    topPanel.setLayout(null);
	    
	    JPanel innerPanel = new JPanel();
	    innerPanel.setBounds(0, 0, 1000, 16);
	    innerPanel.setBackground(bginner);
	    topPanel.add(innerPanel);
	    
	    JButton btnNewBack = new JButton("");
	    btnNewBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btnNewBack.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		btnNewBack.setIcon(new ImageIcon(SearchFrame.class.getResource("/images/btn_indietro_light.png")));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		btnNewBack.setIcon(new ImageIcon(SearchFrame.class.getResource("/images/btn_indietro.png")));
	    	}
	    });
	    btnNewBack.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/btn_indietro.png")));
	    btnNewBack.setBounds(20, 17, 100, 32);
	    topPanel.add(btnNewBack);
	    btnNewBack.setOpaque(false);
	    btnNewBack.setContentAreaFilled(false);
	    btnNewBack.setBorderPainted(false);
	    btnNewBack.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		int input = JOptionPane.showConfirmDialog(null, "sei sicuro di voler tornare indietro? le tue modifiche andranno perdute", "Attenzione!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
	    		if (input == 0)
	    			control.toOpenAndCloseFrame(control.getPostFrame(), control.getReview());
	    	}
	    });
	    btnNewBack.setFont(new Font("Tahoma", Font.PLAIN, 14));

	    
	    rdbtnStar1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		lblGiudizio.setText("Pessimo!");
    			rdbtnStar1.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar2.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		rdbtnStar3.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		rdbtnStar4.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		rdbtnStar5.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		Rating = 1;
	    	}
	    });
	    
	    rdbtnStar2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		lblGiudizio.setText("Mediocre");
	    		rdbtnStar1.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar2.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar3.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		rdbtnStar4.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		rdbtnStar5.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		Rating = 2;
	    	}
	    });
	    
	    rdbtnStar3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		lblGiudizio.setText("Buono");
	    		rdbtnStar1.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar2.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar3.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar4.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		rdbtnStar5.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		Rating = 3;
	    	}
	    });
	    
	    rdbtnStar4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		lblGiudizio.setText("Ottimo");
	    		rdbtnStar1.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar2.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar3.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar4.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar5.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		Rating = 4;
	    	}
	    });
	    
	    rdbtnStar5.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		lblGiudizio.setText("Eccellente!");
	    		rdbtnStar1.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar2.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar3.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar4.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar5.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		Rating = 5;
	    	}
	    });
	    
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
			    rdbtnStar1.setSelected(true);
			    lblGiudizio.setText("Pessimo!");
			    rdbtnStar1.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar2.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		rdbtnStar3.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		rdbtnStar4.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		rdbtnStar5.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
			}
		});
		
	    btnNewPubblicaReview.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
		    	control.createReview(control.getUser().getIduser(), control.getPost().getIdpost(), textFieldTitolo.getText(), editorPaneReview.getText(), Rating);
		    	JOptionPane.showInternalMessageDialog(null, "Recensione pubblicata con successo!", "BonVoyage!", JOptionPane.INFORMATION_MESSAGE);
		    	control.toOpenAndCloseFrame(control.getPostFrame(), control.getReview());
		    	textFieldTitolo.setText(null);
		    	editorPaneReview.setText(null);
	    	}
	    });
	}
}
