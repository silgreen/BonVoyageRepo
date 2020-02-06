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
import except.NoResultsException;
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
import javax.swing.JProgressBar;

public class ResultsFrame extends JFrame {

	private JPanel contentPane;
	private Controller control;
	private ResultPanel res;
	ArrayList<ResultPanel> a1 = new ArrayList<ResultPanel>();

	/**
	 * Create the frame.
	 */
	public ResultsFrame(Controller ctrl) {

		Color bg = Color.decode("#4d92c2");
		control = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panelFilter = new JPanel();
		panelFilter.setBackground(bg);

		

		scrollPane.setViewportView(panelFilter);
	    panelFilter.setLayout(null);
	    
	    JLabel lblLogo = new JLabel("");
	    lblLogo.setIcon(new ImageIcon(ResultsFrame.class.getResource("/images/logo_mini_png.png")));
	    lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    lblLogo.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {

	    		control.toOpenAndCloseFrame(control.getSearch(), control.getResults());
				toRemovePanels(panelFilter);	
				a1.clear();
	    	}
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    	lblLogo.setIcon(new ImageIcon(SearchFrame.class.getResource("/images/logo_mini_png_light.png")));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    	lblLogo.setIcon(new ImageIcon(SearchFrame.class.getResource("/images/logo_mini_png.png")));
	    	}
	    });
	    
	    JLabel lblUser = new JLabel();
	    lblUser.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		control.toOpenAndCloseFrame(control.getProfile(), control.getResults());
	    		control.setStory(control.StoryFrame(control.getResults()));
	    		
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
	    lblUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    lblUser.setVisible(false);
	    lblUser.setFont(new Font("Nirmala UI", Font.PLAIN, 21));
	    lblUser.setBounds(55, 26, 109, 20);
	    panelFilter.add(lblUser);
	    lblLogo.setBounds(900, -2, 70, 65);
	    panelFilter.add(lblLogo);

	    
	    JLabel lblCiao = new JLabel("Ciao,");
	    lblCiao.setVisible(false);
	    lblCiao.setBounds(10, 26, 79, 20);
	    
	    
	    JLabel lblLogin = new JLabel("Login");
	    lblLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    lblLogin.addMouseListener(new MouseAdapter() {
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
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		control.toOpenAndCloseFrame(control.getLogin(),control.getResults());
				toRemovePanels(panelFilter);
				a1.clear();
	    	}
	    });
	    lblLogin.setBounds(20, 20, 55, 30);
	    lblLogin.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
	    panelFilter.add(lblLogin);
	    
	    JLabel lblRegistrati = new JLabel("Registrati");
	    lblRegistrati.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		lblRegistrati.setText("<HTML><U>Registrati</U></HTML>");
	    		lblRegistrati.setForeground(new Color(255,255,255));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		lblRegistrati.setText("Registrati");
	    		lblRegistrati.setForeground(new Color(0,0,0));	
	    	}
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		control.toOpenAndCloseFrame(control.getRegister(),control.getResults());
	    		control.emptyPosts();
	    	}
	    });
	    lblRegistrati.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    lblRegistrati.setBounds(80, 20, 92, 30);
	    lblRegistrati.setFont(new Font("Nirmala UI", Font.PLAIN, 21));
	    panelFilter.add(lblRegistrati);
	    
	    JLabel lblSeparatore = new JLabel("|");
	    lblSeparatore.setBounds(73, 26, 6, 20);
	    lblSeparatore.setFont(new Font("Montserrat", Font.PLAIN, 18));
	    panelFilter.add(lblSeparatore);
	    lblCiao.setFont(new Font("Nirmala UI", Font.PLAIN, 21));
	    panelFilter.add(lblCiao);
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				toRemovePanels(panelFilter);
				
				if(control.getUser().isLogged()) {
					lblRegistrati.setVisible(false);
					lblLogin.setVisible(false);
					lblSeparatore.setVisible(false);
					lblCiao.setVisible(true);
					lblUser.setText(control.getUser().getUsername());
					lblUser.setVisible(true);
				}				
				toShowPanels(panelFilter);
			}
		});
		
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
	}
	
	private void toShowPanels(JPanel panelFilter) {
		try {
			control.setPostsArrayList();
		} catch (NoResultsException e1) {
			e1.printStackTrace();
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
				(a1.get(i)).setBounds(0, 80, 1000, 173);
				panelFilter.add(a1.get(i));
			}
			else if (i>0) {
				(a1.get(i)).setBounds(0, (a1.get(i-1)).getY()+173+20, 1000, 173);
				panelFilter.add(a1.get(i));
				panelFilter.setPreferredSize(new Dimension(0,(193*a1.size())+60));
			}
		}
		control.emptyPosts();
		revalidate();
		repaint();
	}
	
	private void toRemovePanels(JPanel panelFilter) {
		if(!a1.isEmpty()) {
			for(int i=0; i<a1.size(); i++) {
					panelFilter.remove(a1.get(i));;
					panelFilter.setPreferredSize(new Dimension(0,0));
			}
		}
		control.emptyPosts();
	}
}
