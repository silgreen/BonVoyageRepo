package forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReviewFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTitolo;
	private Controller control;
	private int Rating;

	/**
	 * Create the frame.
	 */
	public ReviewFrame(Controller ctrl) {
		control = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,250,240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/logoXSBon.png")));
		lblLogo.setBounds(20, 20, 170, 55);
		contentPane.add(lblLogo);
		
	    textFieldTitolo = new JTextField();
	    textFieldTitolo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
	    textFieldTitolo.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    textFieldTitolo.setBounds(46, 134, 350, 27);
	    contentPane.add(textFieldTitolo);
	    textFieldTitolo.setColumns(10);
	    
	    JEditorPane editorPaneReview = new JEditorPane();
	    editorPaneReview.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
	    editorPaneReview.setBounds(46, 220, 500, 200);
	    contentPane.add(editorPaneReview);
	    
	    JLabel lblRecensione = new JLabel("Recensione");
	    lblRecensione.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblRecensione.setBounds(46, 193, 96, 27);
	    contentPane.add(lblRecensione);
	    
	    JLabel lblTitolo = new JLabel("Titolo");
	    lblTitolo.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblTitolo.setBounds(46, 110, 53, 19);
	    contentPane.add(lblTitolo);
	    
	    JButton btnNewPubblicaReview = new JButton("Pubblica recensione");
	    btnNewPubblicaReview.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnNewPubblicaReview.setBounds(572, 526, 170, 27);
	    contentPane.add(btnNewPubblicaReview);
	    
	    JButton btnNewBack = new JButton("Indietro");
	    btnNewBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnNewBack.setBounds(46, 526, 85, 27);
	    contentPane.add(btnNewBack);
	    
	    JButton btn1Star = new JButton("1");
	    btn1Star.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Rating = 1;
	    	}
	    });
	    btn1Star.setBounds(560, 134, 25, 25);
	    contentPane.add(btn1Star);
	    
	    JButton btn2Star = new JButton("2");
	    btn2Star.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Rating = 2;
	    	}
	    });
	    btn2Star.setBounds(595, 134, 25, 25);
	    contentPane.add(btn2Star);
	    
	    JButton btn3Star = new JButton("3");
	    btn3Star.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Rating = 3;
	    	}
	    });
	    btn3Star.setBounds(630, 134, 25, 25);
	    contentPane.add(btn3Star);
	    
	    JButton Btn4Star = new JButton("4");
	    Btn4Star.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Rating = 4;
	    	}
	    });
	    Btn4Star.setBounds(665, 134, 25, 25);
	    contentPane.add(Btn4Star);
	    
	    JButton btn5Star = new JButton("5");
	    btn5Star.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Rating = 5;
	    		System.out.println(control.getUser().getIduser());
	    		System.out.println(control.getPost().getIdpost());

	    	}
	    });
	    btn5Star.setBounds(700, 134, 25, 25);
	    contentPane.add(btn5Star);
	    
	    btnNewPubblicaReview.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		control.createReview(control.getUser().getIduser(), control.getPost().getIdpost(), textFieldTitolo.getText(), editorPaneReview.getText(), Rating);
	    	}
	    });
	}
}
