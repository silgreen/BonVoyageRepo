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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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
import panel.ResultPanel;
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
		setResizable(false);
		setTitle("BonVoyage!");

		Color bg = Color.decode("#4d92c2");
		Color inner = Color.decode("#046490");
		control = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(bg);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panelFilter = new JPanel();
		panelFilter.setBackground(Color.WHITE);
		scrollPane.setViewportView(panelFilter);
		panelFilter.setLayout(null);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(bg);
		topPanel.setBounds(0, 0, 987, 51);
		panelFilter.add(topPanel);
		topPanel.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				control.toOpenAndCloseFrame(control.getSearch(), control.getPostFrame());
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogo.setIcon(new ImageIcon(PostFrame.class.getResource("/images/logo_mini_png_light.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogo.setIcon(new ImageIcon(PostFrame.class.getResource("/images/logo_mini_png.png")));
			}
		});
		lblLogo.setIcon(new ImageIcon(PostFrame.class.getResource("/images/logo_mini_png.png")));
		lblLogo.setBounds(900, -7, 70, 65);
		topPanel.add(lblLogo);
	    
	    JLabel lblCiao = new JLabel("Ciao,");
	    lblCiao.setBounds(10, 18, 46, 27);
	    topPanel.add(lblCiao);
	    lblCiao.setVisible(false);
	    lblCiao.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
	    
	    JLabel lblLogin = new JLabel("Login");
	    lblLogin.setBounds(10, 20, 46, 27);
	    topPanel.add(lblLogin);
	    lblLogin.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		control.toOpenAndCloseFrame(control.getLogin(),control.getPostFrame());

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
	    lblLogin.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
	    
	    JLabel lblRegistrati = new JLabel("Registrati");
	    lblRegistrati.setBounds(61, 22, 89, 23);
	    topPanel.add(lblRegistrati);
	    lblRegistrati.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    lblRegistrati.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		control.toOpenAndCloseFrame(control.getRegister(),control.getPostFrame());

	    	}
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
	    });
	    lblRegistrati.setForeground(Color.BLACK);
	    lblRegistrati.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
	    
	    JLabel lblUser = new JLabel("");
	    lblUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    lblUser.setBounds(53, 15, 209, 29);
	    topPanel.add(lblUser);
	    lblUser.setVisible(false);
	    lblUser.setBackground(bg);
	    lblUser.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		control.toOpenAndCloseFrame(control.getProfile(), control.getPostFrame());
	    		control.setStory(control.StoryFrame(control.getPostFrame()));
	    	}
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		lblUser.setForeground(new Color(255,255,255));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		lblUser.setForeground(new Color(0,0,0));
	    	}
	    });
	    lblUser.setFont(new Font("Nirmala UI", Font.BOLD, 20));
	    
	    JLabel lblSeparatore = new JLabel("|");
	    lblSeparatore.setBounds(55, 20, 7, 27);
	    topPanel.add(lblSeparatore);
	    lblSeparatore.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    
	    JPanel bgInner = new JPanel();
	    bgInner.setBounds(0, 0, 987, 16);
	    bgInner.setBackground(inner);
	    topPanel.add(bgInner);
		
	    
	    JPanel midPanel = new JPanel();
	    midPanel.setBackground(Color.WHITE);
	    midPanel.setBounds(0, 66, 987, 353);
	    panelFilter.add(midPanel);
	    midPanel.setLayout(null);
	    

	    
	    JLabel lblCategory = new JLabel();
	    lblCategory.setFont(new Font("Nirmala UI", Font.PLAIN, 14));
	    lblCategory.setBounds(22, 0, 200, 33);
	    midPanel.add(lblCategory);
	    
	    JLabel lblSiTrovaA = new JLabel("Si trova a");
	    lblSiTrovaA.setFont(new Font("Nirmala UI", Font.PLAIN, 17));
	    lblSiTrovaA.setBounds(248, 26, 77, 16);
	    midPanel.add(lblSiTrovaA);
	    
	    JLabel lblPosition = new JLabel();
	    lblPosition.setFont(new Font("Nirmala UI", Font.BOLD, 16));
	    lblPosition.setBounds(324, 18, 180, 30);
	    midPanel.add(lblPosition);
	    
	    JTextPane textPanePostName = new JTextPane();
	    textPanePostName.setEditable(false);
	    textPanePostName.setBackground(Color.WHITE);
	    textPanePostName.setFont(new Font("Nirmala UI", Font.BOLD, 21));
	    textPanePostName.setBounds(259, 58, 287, 46);
	    midPanel.add(textPanePostName);
	    
	    JLabel lblStars = new JLabel();
	    lblStars.setFont(new Font("Tahoma", Font.BOLD, 27));
	    lblStars.setBounds(685, 71, 200, 33);
	    midPanel.add(lblStars);
	    
	    JLabel lblnReviews = new JLabel();
	    lblnReviews.setFont(new Font("Nirmala UI", Font.BOLD, 13));
	    lblnReviews.setBounds(895, 58, 48, 46);
	    midPanel.add(lblnReviews);
	    
	    JTextPane textPaneDescription = new JTextPane();
	    textPaneDescription.setBackground(Color.WHITE);
	    textPaneDescription.setEditable(false);
	    textPaneDescription.setFont(new Font("Nirmala UI", Font.PLAIN, 16));
	    textPaneDescription.setBounds(255, 104, 688, 181);
	    midPanel.add(textPaneDescription);
	    
	    JButton btnScriviRecensione = new JButton("");
	    btnScriviRecensione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btnScriviRecensione.setIcon(new ImageIcon(PostFrame.class.getResource("/images/button_pubblica-recensione.png")));
	    btnScriviRecensione.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		 btnScriviRecensione.setIcon(new ImageIcon(PostFrame.class.getResource("/images/button_pubblica-recensione_light.png")));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		 btnScriviRecensione.setIcon(new ImageIcon(PostFrame.class.getResource("/images/button_pubblica-recensione.png")));
	    	}
	    });
	    btnScriviRecensione.setOpaque(false);
	    btnScriviRecensione.setContentAreaFilled(false);
	    btnScriviRecensione.setBorderPainted(false);
	    btnScriviRecensione.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		control.toOpenAndCloseFrame(control.getReview(), control.getPostFrame());
	    	}
	    });
	    btnScriviRecensione.setBounds(673, 295, 270, 45);
	    midPanel.add(btnScriviRecensione);
	    
	    JButton btnback = new JButton("");
	    btnback.setBounds(54, 295, 111, 45);
	    midPanel.add(btnback);
	    btnback.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		btnback.setIcon(new ImageIcon(PostFrame.class.getResource("/images/btn_indietro_sublined.png")));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		btnback.setIcon(new ImageIcon(PostFrame.class.getResource("/images/btn_indietro.png")));
	    	}
	    });
	    btnback.setIcon(new ImageIcon(PostFrame.class.getResource("/images/btn_indietro.png")));
	    btnback.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btnback.setOpaque(false);
	    btnback.setContentAreaFilled(false);
	    btnback.setBorderPainted(false);
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
	    
	    scrollPane.getVerticalScrollBar().setUnitIncrement(16);
	    
	    JLabel lblImmagine = new JLabel();
		lblImmagine.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblImmagine.setBounds(22, 26, 200, 200);	
	    
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				

				String URL = "";
				p = control.toFetchSinglePost(control.getPost().getIdpost());
	    	    lblnReviews.setText(p.getNreviews());
	    		textPanePostName.setText(p.getName());
	    		lblPosition.setText(p.getCity() + ","+ p.getRegion());
	    	    textPaneDescription.setText(p.getInfo());
	    	    lblCategory.setText(p.getCategory() + "," + p.getSub_category());
	    	    URL = control.getPost().getURLMedia();
	    	    control.toShowStars(lblStars, Float.parseFloat(p.getRating_avg()));
	    	    

	    	    
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
	    	    		reviewsPanels.get(i).setBounds(0,430,960,200);
	    	    		panelFilter.add(reviewsPanels.get(i));
	    	    		panelFilter.setPreferredSize(new Dimension(0,430+200));
	    	    	} else if (i > 0) {
	    	    		reviewsPanels.get(i).setBounds(0,reviewsPanels.get(i-1).getY() + 200, 960, 200);
	    	    		panelFilter.add(reviewsPanels.get(i));
	    	    		panelFilter.setPreferredSize(new Dimension(0,430+(200*reviewsPanels.size())));
	    	    	}
	    	    }
	    	    if(control.controlIfExistsReviewInPostWithLoggedIduser() || !control.getUser().isLogged()) {
	    	    	btnScriviRecensione.setVisible(false);
	    	    } else {
	    	    	btnScriviRecensione.setVisible(true);
	    	    }
	    	    control.emptyReviewsList();
	    	    
	    	    revalidate();
	    	    repaint();    
	    	    
	    		try {	
	    			URL url = new URL(p.getURLMedia());
	    			BufferedImage image = ImageIO.read(url);
	    			ImageIcon icon = new ImageIcon(image);
	    			lblImmagine.setIcon(icon);
	    			midPanel.add(lblImmagine);
	    			icon.getImage().flush();
	    		}catch (Exception e1) {
	    			e1.printStackTrace();
	    		}
			}
		});
		

		

	}
}
