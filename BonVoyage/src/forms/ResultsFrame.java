package forms;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import classi.Post;
import controller.Controller;
import except.NoResultsException;
import panel.ResultPanel;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.ImageIcon;

public class ResultsFrame extends JFrame {

	private JPanel contentPane;
	private Controller control;
	private ArrayList<ResultPanel> a1 = new ArrayList<ResultPanel>();
	private JScrollPane scrollPane;
	private JPanel panelFilter;
	private JLabel lblLogo;
	private JLabel lblUser;
	private JLabel lblLogin;
	private JLabel lblRegistrati;
	private JLabel lblLoading;

	public ResultsFrame(Controller ctrl) {
		setResizable(false);

		Color bg = Color.decode("#4d92c2");
		Color inner = Color.decode("#046490");
		control = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		panelFilter = new JPanel();
		panelFilter.setBackground(bg);

		

		scrollPane.setViewportView(panelFilter);
	    panelFilter.setLayout(null);
	    
	    lblLogo = new JLabel("");
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
	    
	    lblUser = new JLabel();
	    lblUser.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		control.toOpenAndCloseFrame(control.getProfile(), control.getResults());
	    		control.setPreviousOpenedFrame(control.StoryFrame(control.getResults()));
	    		
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
	    lblUser.setFont(new Font("Nirmala UI", Font.BOLD, 20));
	    lblUser.setBounds(55, 26, 150, 20);
	    panelFilter.add(lblUser);
	    lblLogo.setBounds(895, 0, 70, 65);
	    panelFilter.add(lblLogo);

	    
	    JLabel lblCiao = new JLabel("Ciao,");
	    lblCiao.setVisible(false);
	    lblCiao.setBounds(10, 26, 79, 20);
	    
	    
	    lblLogin = new JLabel("Login");
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
	    
	    lblRegistrati = new JLabel("Registrati");
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
	    		control.emptyResultsList();
	    	}
	    });
	    lblRegistrati.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    lblRegistrati.setBounds(80, 20, 92, 30);
	    lblRegistrati.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
	    panelFilter.add(lblRegistrati);
	    
	    JLabel lblSeparatore = new JLabel("|");
	    lblSeparatore.setBounds(73, 26, 6, 20);
	    lblSeparatore.setFont(new Font("Montserrat", Font.PLAIN, 18));
	    panelFilter.add(lblSeparatore);
	    
	    JPanel panel = new JPanel();
	    panel.setBackground(inner);
	    panel.setBounds(0, 0, 982, 16);
	    panelFilter.add(panel);
	    lblCiao.setFont(new Font("Nirmala UI", Font.PLAIN, 21));
	    panelFilter.add(lblCiao);
	    
	    lblLoading = new JLabel("");
	    lblLoading.setIcon(new ImageIcon(ResultsFrame.class.getResource("/images/loading.png")));
	    lblLoading.setBounds(294, 210, 394, 138);
	    panelFilter.add(lblLoading);
	    
		
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
				} else {
					lblRegistrati.setVisible(true);
					lblLogin.setVisible(true);
					lblSeparatore.setVisible(true);
					lblCiao.setVisible(false);
					lblUser.setVisible(false);
				}				
				toShowPanels(panelFilter);
				lblLoading.setVisible(false);

			}
		});
		
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);

	}
	
	private void toShowPanels(JPanel panelFilter) {
		try {
			control.setResultsList();
		} catch (NoResultsException e1) {
			e1.printStackTrace();
		}
		
		a1.clear();
		
		ArrayList<Post> a = control.getResultsList();

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
		control.emptyResultsList();
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
		control.emptyResultsList();
	}
}
