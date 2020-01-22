package forms;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Cursor;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.ImageIcon;

public class ResultsFrame extends JFrame {

	private JPanel contentPane;
	private Controller control;
	private ResultPanel res;
	ArrayList<ResultPanel> a1 = new ArrayList<ResultPanel>();


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
	    lblLogo.setIcon(new ImageIcon(ResultsFrame.class.getResource("/images/logoXSBon.png")));
	    lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    lblLogo.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
				control.emptyPosts();	
	    		control.toOpenAndCloseFrame(control.getSearch(), control.getResults());
	    		control.getSearch().setVisible(true);
	    		
				for(int i = 0; i<a1.size(); i++) {
					if(!a1.isEmpty()) {
						panelFilter.remove(a1.get(i));
						panelFilter.setPreferredSize(new Dimension(0, 0));
					}
				}
				a1.clear();
	    	}
	    });
	    lblLogo.setBounds(10, 11, 170, 65);
	    panelFilter.add(lblLogo);

	    
	    JLabel lblUser = new JLabel("Ciao, name");
	    lblUser.setBounds(629, 26, 79, 20);
	    lblUser.setVisible(false);
	    
	    
	    JLabel lblLogin = new JLabel("Login");
	    lblLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    lblLogin.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		lblLogin.setText("<HTML><U>Login</U></HTML>");
	    		lblLogin.setForeground(new Color(30, 144, 255));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		lblLogin.setText("Login");
	    		lblLogin.setForeground(new Color(0, 0, 205));
	    	}
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		control.toOpenAndCloseFrame(control.getLogin(),control.getResults());
	    	}
	    });
	    lblLogin.setBounds(629, 26, 39, 20);
	    lblLogin.setForeground(new Color(0, 0, 205));
	    lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    panelFilter.add(lblLogin);
	    
	    JLabel lblRegistrati = new JLabel("Registrati");
	    lblRegistrati.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		lblRegistrati.setText("<HTML><U>Registrati</U></HTML>");
	    		lblRegistrati.setForeground(new Color(30,144,255));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		lblRegistrati.setText("Registrati");
	    		lblRegistrati.setForeground(new Color(0,0,205));	
	    	}
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		control.toOpenAndCloseFrame(control.getRegister(),control.getResults());
	    	}
	    });
	    lblRegistrati.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    lblRegistrati.setBounds(683, 26, 81, 20);
	    lblRegistrati.setForeground(new Color(0, 0, 205));
	    lblRegistrati.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    panelFilter.add(lblRegistrati);
	    
	    JLabel lblSeparatore = new JLabel("/");
	    lblSeparatore.setBounds(673, 26, 6, 20);
	    lblSeparatore.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    panelFilter.add(lblSeparatore);
	    lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    panelFilter.add(lblUser);
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				Thread t1 = new Thread();
				ArrayList<Post> a = control.getPosts();

				
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
					}
					else if (i>0) {
						(a1.get(i)).setBounds(0, (a1.get(i-1)).getY()+173+20, 757, 173);
						panelFilter.add(a1.get(i));
						panelFilter.setPreferredSize(new Dimension(0,(193*a1.size())+60));
					}
				}
			}
		});
		
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
	}
}
