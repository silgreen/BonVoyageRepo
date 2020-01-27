package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Scrollbar;
import javax.swing.border.LineBorder;

import classi.Post;
import classi.Review;
import controller.Controller;
import panel.ReviewPanel;

import javax.swing.JSeparator;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class PostFrame extends JFrame {

	ArrayList<ReviewPanel> reviewsPanels = new ArrayList<ReviewPanel>();
	private JPanel contentPane;
	private Controller control;
	private Post p;


	/**
	 * Create the frame.
	 */
	public PostFrame(Controller ctrl) {

		control = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panelFilter = new JPanel();
		panelFilter.setBackground(new Color(255, 250, 240));
		scrollPane.setViewportView(panelFilter);
		panelFilter.setLayout(null);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(255, 250, 240));
		topPanel.setBounds(0, 0, 755, 65);
		panelFilter.add(topPanel);
		topPanel.setLayout(null);
		
		JLabel lblLogo = new JLabel("New label");
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				control.toOpenAndCloseFrame(control.getSearch(), control.getPostFrame());
			}
		});
		lblLogo.setIcon(new ImageIcon(PostFrame.class.getResource("/images/logoXSBon.png")));
		lblLogo.setBounds(20, 20, 164, 43);
		topPanel.add(lblLogo);
		
	    JPanel panelLogin = new JPanel();
	    panelLogin.setBackground(new Color(255, 250, 240));
	    panelLogin.setBounds(622, 30, 133, 27);
	    topPanel.add(panelLogin);
	    panelLogin.setLayout(null);
	    
	    JLabel lblCiao = new JLabel("Ciao,");
	    lblCiao.setVisible(false);
	    lblCiao.setBounds(0, 0, 46, 17);
	    panelLogin.add(lblCiao);
	    lblCiao.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    
	    JLabel lblLogin = new JLabel("Login");
	    lblLogin.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		control.toOpenAndCloseFrame(control.getLogin(),control.getSearch());

	    	}
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
	    });
	    lblLogin.setBounds(-1, 0, 46, 27);
	    panelLogin.add(lblLogin);
	    lblLogin.setForeground(new Color(0, 0, 205));
	    lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    
	    JLabel lblRegistrati = new JLabel("Registrati");
	    lblRegistrati.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    lblRegistrati.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		control.toOpenAndCloseFrame(control.getRegister(),control.getSearch());

	    	}
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
	    });
	    lblRegistrati.setBounds(45, 3, 68, 20);
	    panelLogin.add(lblRegistrati);
	    lblRegistrati.setForeground(new Color(0, 0, 205));
	    lblRegistrati.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    
	    JLabel lblUser = new JLabel("");
	    lblUser.setVisible(false);
	    lblUser.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		control.toOpenAndCloseFrame(control.getProfile(), control.getPostFrame());
	    		control.setStory(control.StoryFrame(control.getPostFrame()));
	    	}
	    });
	    lblUser.setBounds(40, -3, 77, 29);
	    panelLogin.add(lblUser);
	    lblUser.setFont(new Font("Tahoma", Font.BOLD, 16));
	    
	    JLabel lblSeparatore = new JLabel("/");
	    lblSeparatore.setBounds(38, 0, 7, 27);
	    panelLogin.add(lblSeparatore);
	    lblSeparatore.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    
	    JButton btnback = new JButton("Indietro");
	    btnback.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		control.toOpenAndCloseFrame(control.getResults(), control.getPostFrame());
				for(int i = 0; i<reviewsPanels.size(); i++) {
					if(!reviewsPanels.isEmpty()) {
						panelFilter.remove(reviewsPanels.get(i));
						panelFilter.setPreferredSize(new Dimension(0, 0));
					}
				}
				control.emptyReviewsList();;	
				reviewsPanels.clear();
	    	}
	    });
	    btnback.setBounds(194, 30, 89, 23);
	    topPanel.add(btnback);
		
	    
	    JPanel midPanel = new JPanel();
	    midPanel.setBackground(new Color(255, 250, 240));
	    midPanel.setBounds(10, 66, 735, 353);
	    panelFilter.add(midPanel);
	    midPanel.setLayout(null);
	    
	    JLabel lblImmagine = new JLabel("New label");
	    lblImmagine.setIcon(new ImageIcon("C:\\Users\\chris\\Desktop\\img-20171230-wa0090-01-240x240.jpg"));
	    lblImmagine.setBounds(22, 26, 200, 200);
	    midPanel.add(lblImmagine);
	    
	    JLabel lblCategory = new JLabel();
	    lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblCategory.setBounds(22, 0, 175, 33);
	    midPanel.add(lblCategory);
	    
	    JLabel lblSiTrovaA = new JLabel("Si trova a");
	    lblSiTrovaA.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lblSiTrovaA.setBounds(248, 26, 70, 14);
	    midPanel.add(lblSiTrovaA);
	    
	    JLabel lblPosition = new JLabel();
	    lblPosition.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblPosition.setBounds(316, 18, 155, 30);
	    midPanel.add(lblPosition);
	    
	    JTextPane textPanePostName = new JTextPane();
	    textPanePostName.setEditable(false);
	    textPanePostName.setBackground(new Color(255, 250, 240));
	    textPanePostName.setFont(new Font("Tahoma", Font.BOLD, 20));
	    textPanePostName.setBounds(259, 58, 224, 46);
	    midPanel.add(textPanePostName);
	    
	    JLabel lblStars = new JLabel();
	    lblStars.setFont(new Font("Tahoma", Font.BOLD, 27));
	    lblStars.setBounds(483, 48, 140, 40);
	    midPanel.add(lblStars);
	    
	    JLabel lblnReviews = new JLabel();
	    lblnReviews.setFont(new Font("Tahoma", Font.PLAIN, 13));
	    lblnReviews.setBounds(634, 42, 48, 46);
	    midPanel.add(lblnReviews);
	    
	    JTextPane textPaneDescription = new JTextPane();
	    textPaneDescription.setBackground(new Color(255, 250, 240));
	    textPaneDescription.setEditable(false);
	    textPaneDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    textPaneDescription.setBounds(269, 104, 456, 122);
	    midPanel.add(textPaneDescription);
	    
	    JLabel lblUlterioriInfo = new JLabel("Ulteriori Info:");
	    lblUlterioriInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lblUlterioriInfo.setBounds(22, 230, 91, 14);
	    midPanel.add(lblUlterioriInfo);
	    
	    JTextPane textPaneInfo = new JTextPane();
	    textPaneInfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    textPaneInfo.setText("Orari: \nDal lun alla dom\ndalle 8:30 alle 19:00");
	    textPaneInfo.setBackground(new Color(255, 250, 240));
	    textPaneInfo.setBounds(22, 247, 200, 106);
	    midPanel.add(textPaneInfo);
	    
	    JButton btnScriviRecensione = new JButton("Scrivi una recensione...");
	    btnScriviRecensione.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnScriviRecensione.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		control.getReview().setVisible(true);
	    	}
	    });
	    btnScriviRecensione.setBounds(538, 319, 175, 23);
	    midPanel.add(btnScriviRecensione);
	    
	    scrollPane.getVerticalScrollBar().setUnitIncrement(14);
	    
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
	    		p = control.getPost();
	    		textPanePostName.setText(p.getName());
	    		lblPosition.setText(p.getCity() + ","+ p.getRegion());
	    	    textPaneDescription.setText(p.getInfo());
	    	    lblnReviews.setText(p.getNreviews());
	    	    lblStars.setText(p.getRating_avg());
	    	    lblCategory.setText(p.getCategory() + "," + p.getSub_category());
	    	    
	    	    if(!control.getUser().isLogged()) {
	    	    	btnScriviRecensione.setVisible(false);
	    	    }
				
	    	    if(control.getUser().isLogged()) {
					lblRegistrati.setVisible(false);
					lblLogin.setVisible(false);
					lblSeparatore.setVisible(false);
					lblCiao.setVisible(true);
					lblUser.setText(control.getUser().getUsername());
					lblUser.setVisible(true);
				}
	    	    
	    	    control.toShowReview(control.getPost().getIdpost());
	    	    reviewsPanels.clear();
	    	    ArrayList<Review> ar = control.getReviewList();
	    	    
	    	    for(int i = 0; i < ar.size(); i++) {
	    	    	Review r = new Review();
	    	    	r = ar.get(i);
	    	    	ReviewPanel rp = new ReviewPanel(control, r);
	    	    	reviewsPanels.add(rp);
	    	    }
	    	    
	    	    for (int i = 0; i < reviewsPanels.size(); i++) {
	    	    	if(i == 0) {
	    	    		reviewsPanels.get(i).setBounds(20,432,714,200);
	    	    		panelFilter.add(reviewsPanels.get(i));
	    	    		panelFilter.setPreferredSize(new Dimension(0,435+200));
	    	    	} else if (i > 0) {
	    	    		reviewsPanels.get(i).setBounds(20,reviewsPanels.get(i-1).getY() + 200, 714, 200);
	    	    		panelFilter.add(reviewsPanels.get(i));
	    	    		panelFilter.setPreferredSize(new Dimension(0,435+(200*reviewsPanels.size())));
	    	    	}
	    	    }
	    	    
	    	    if(control.controlIfExistsReviewInPostWithLoggedIduser()) {
	    	    	System.out.println("trovato");
	    	    }
	    	    
	    	    
	    	    control.emptyReviewsList();
			}
		});
	}
}
