package forms;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;

import classi.Post;
import controller.Controller;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpringLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ResultsFrame extends JFrame {

	private JPanel contentPane;
	private Controller control;
	private ResultPanel res;


	/**
	 * Create the frame.
	 */
	public ResultsFrame(Controller ctrl) {

		control = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panelFilter = new JPanel();
		panelFilter.setBackground(new Color(240,240,240));

		

		scrollPane.setViewportView(panelFilter);
	    panelFilter.setLayout(null);
	    
	    JLabel lblLogo = new JLabel("");
	    lblLogo.setBounds(143, 5, 170, 65);
	    panelFilter.add(lblLogo);

	    
	    JLabel lblUser = new JLabel("Ciao, name");
	    lblUser.setBounds(444, 27, 79, 20);
	    lblUser.setVisible(false);
	    
	    
	    JLabel lblLogin = new JLabel("Login");
	    lblLogin.setBounds(318, 27, 39, 20);
	    lblLogin.setForeground(new Color(0, 0, 205));
	    lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    panelFilter.add(lblLogin);
	    
	    JLabel lblRegistrati = new JLabel("Registrati");
	    lblRegistrati.setBounds(362, 27, 66, 20);
	    lblRegistrati.setForeground(new Color(0, 0, 205));
	    lblRegistrati.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    panelFilter.add(lblRegistrati);
	    
	    JLabel lblSeparatore = new JLabel("/");
	    lblSeparatore.setBounds(433, 27, 6, 20);
	    lblSeparatore.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    panelFilter.add(lblSeparatore);
	    lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    panelFilter.add(lblUser);
	    
		JButton btnTest = new JButton("New button");
		btnTest.setBounds(528, 26, 89, 23);
		panelFilter.add(btnTest);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ArrayList<Post> a = control.getPosts();
				ArrayList<ResultPanel> a1 = new ArrayList<ResultPanel>();
				
				for(int i=0; i<a.size(); i++) {
					Post p = new Post();
					p = a.get(i);
					ResultPanel rp = new ResultPanel(p);
					a1.add(rp);
				}
				
				for(int i = 0; i<a1.size(); i++) {
					if(i==0) {
						(a1.get(i)).setBounds(0, 80, 757, 173);
						panelFilter.add(a1.get(i));
						panelFilter.setPreferredSize(new Dimension(0, 0));
					}
					else if (i>0) {
						(a1.get(i)).setBounds(0, (a1.get(i-1)).getY()+173+20, 757, 173);
						panelFilter.add(a1.get(i));
						panelFilter.setPreferredSize(new Dimension(0, 173+177*a1.size()));
					}
				}
				
				setVisible(false);
				setVisible(true);
			}
		});
	
		try {
		    BufferedImage logo = ImageIO.read(new URL("https://raw.githubusercontent.com/silgreen/BonVoyageRepo/master/BonVoyage/Images/logoXSBon.png?token=AMCLLPEJ5YPJL2HJ6TUUJBK6FAVUM"));
		    lblLogo.setIcon(new javax.swing.ImageIcon(logo));
		    

		}
		catch(IOException ex) {
		}
	}
}
