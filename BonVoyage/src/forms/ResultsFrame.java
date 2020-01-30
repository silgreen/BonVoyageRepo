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
import panel.ResultPanel;

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

	    		control.toOpenAndCloseFrame(control.getSearch(), control.getResults());
	    		
				for(int i = 0; i<a1.size(); i++) {
					if(!a1.isEmpty()) {
						panelFilter.remove(a1.get(i));
						panelFilter.setPreferredSize(new Dimension(0, 0));
					}
				}
				control.emptyPosts();	
				a1.clear();
	    	}
	    });
	    
	    JLabel lblUser = new JLabel();
	    lblUser.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		control.toOpenAndCloseFrame(control.getProfile(), control.getResults());
	    		control.setStory(control.StoryFrame(control.getResults()));
	    		
	    	}
	    });
	    lblUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    lblUser.setVisible(false);
	    lblUser.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblUser.setBounds(653, 33, 109, 14);
	    panelFilter.add(lblUser);
	    lblLogo.setBounds(10, 11, 170, 65);
	    panelFilter.add(lblLogo);

	    
	    JLabel lblCiao = new JLabel("Ciao,");
	    lblCiao.setVisible(false);
	    lblCiao.setBounds(613, 30, 79, 20);
	    
	    
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
				for(int i = 0; i<a1.size(); i++) {
					if(!a1.isEmpty()) {
						panelFilter.remove(a1.get(i));
						panelFilter.setPreferredSize(new Dimension(0, 0));
					}
				}
				control.emptyPosts();	
				a1.clear();
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
	    		control.emptyPosts();
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
	    lblCiao.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    panelFilter.add(lblCiao);
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				if(control.getUser().isLogged()) {
					lblRegistrati.setVisible(false);
					lblLogin.setVisible(false);
					lblSeparatore.setVisible(false);
					lblCiao.setVisible(true);
					lblUser.setText(control.getUser().getUsername());
					lblUser.setVisible(true);
				}
				
				a1.clear();
				
				ArrayList<Post> a = control.getPostsArrayList();

				for(int i=0; i<a.size(); i++) {
					Post p = new Post();
					p = a.get(i);
					ResultPanel rp = new ResultPanel(p,control);
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
				control.emptyPosts();
				revalidate();
				repaint();
			}
		});
		
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
	}
}
