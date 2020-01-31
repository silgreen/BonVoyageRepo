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

public class ReviewFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTitolo;
	private Controller control;
	private int Rating = 0;

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
	    btnNewBack.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		int input = JOptionPane.showConfirmDialog(null, "sei sicuro di voler tornare indietro? le tue modifiche andranno perdute", "Attenzione!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
	    		if (input == 0)
	    			control.toOpenAndCloseFrame(control.getPostFrame(), control.getReview());
	    	}
	    });
	    btnNewBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnNewBack.setBounds(46, 526, 85, 27);
	    contentPane.add(btnNewBack);
	    
	    ButtonGroup radioButtonGroup = new ButtonGroup();
	    
	    JRadioButton rdbtnStar1 = new JRadioButton("");


	    rdbtnStar1.setBackground(new Color(255, 250, 240));
	    rdbtnStar1.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    rdbtnStar1.setBounds(513, 134, 38, 32);
	    contentPane.add(rdbtnStar1);
	    
	    JRadioButton rdbtnStar2 = new JRadioButton("");


	    rdbtnStar2.setBackground(new Color(255, 250, 240));
	    rdbtnStar2.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    rdbtnStar2.setBounds(553, 134, 38, 32);
	    contentPane.add(rdbtnStar2);
	    
	    JRadioButton rdbtnStar3 = new JRadioButton("");


	    rdbtnStar3.setBackground(new Color(255, 250, 240));
	    rdbtnStar3.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    rdbtnStar3.setBounds(593, 134, 38, 32);
	    contentPane.add(rdbtnStar3);
	    
	    JRadioButton rdbtnStar4 = new JRadioButton("");


	    rdbtnStar4.setBackground(new Color(255, 250, 240));
	    rdbtnStar4.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    rdbtnStar4.setBounds(634, 134, 38, 32);
	    contentPane.add(rdbtnStar4);
	    
	    JRadioButton rdbtnStar5 = new JRadioButton("");


	    rdbtnStar5.setBackground(new Color(255, 250, 240));
	    rdbtnStar5.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    rdbtnStar5.setBounds(674, 134, 38, 32);
	    contentPane.add(rdbtnStar5);
	    
	    radioButtonGroup.add(rdbtnStar1);
	    radioButtonGroup.add(rdbtnStar2);
	    radioButtonGroup.add(rdbtnStar3);
	    radioButtonGroup.add(rdbtnStar4);
	    radioButtonGroup.add(rdbtnStar5);
	    rdbtnStar1.setSelected(true);
	    rdbtnStar1.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    
	    rdbtnStar1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
    			rdbtnStar1.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar2.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		rdbtnStar3.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		rdbtnStar4.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		rdbtnStar5.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    	}
	    });
	    
	    rdbtnStar2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
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
	    		rdbtnStar1.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar2.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar3.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar4.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar5.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		Rating = 5;
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
