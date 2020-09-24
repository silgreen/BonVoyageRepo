package forms;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import classi.Review;
import controller.Controller;
import except.NoUserReviewException;
import panel.UserReviewPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class UserReviewsFrame extends JFrame {

	private JPanel contentPane;
	private Controller control;
	private JScrollPane scrollPane;
	private JPanel panelFilter;
	private JLabel lblLogo;
	private JButton btnIndietro;
	private JButton btnRefresh;
	private ArrayList<UserReviewPanel> UserReviewsPanels = new ArrayList<UserReviewPanel>();
	
	public UserReviewsFrame(Controller ctrl) {
		Color bg = Color.decode("#4d92c2");
		Color bginner = Color.decode("#046490");
		setTitle("BonVoyage!");
		setResizable(false);
		setBackground(bg);
		control = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 987, 563);
		contentPane.add(scrollPane);
		
		panelFilter = new JPanel();
		panelFilter.setBackground(bg);
		scrollPane.setViewportView(panelFilter);
		panelFilter.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				control.toOpenAndCloseFrame(control.getSearch(), control.getUserReview());
				updatePanels(panelFilter);
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
		lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogo.setIcon(new ImageIcon(UserReviewsFrame.class.getResource("/images/logo_mini_png.png")));
		lblLogo.setBounds(895, 0, 65, 55);
		panelFilter.add(lblLogo);
		
		btnIndietro = new JButton("");
		btnIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIndietro.setIcon(new ImageIcon(UserReviewsFrame.class.getResource("/images/btn_indietro_light.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIndietro.setIcon(new ImageIcon(UserReviewsFrame.class.getResource("/images/btn_indietro.png")));
			}
		});
		btnIndietro.setIcon(new ImageIcon(UserReviewsFrame.class.getResource("/images/btn_indietro.png")));
	    btnIndietro.setOpaque(false);
	    btnIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btnIndietro.setContentAreaFilled(false);
	    btnIndietro.setBorderPainted(false);
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.toOpenAndCloseFrame(control.getProfile(), control.getUserReview());
				updatePanels(panelFilter);
			}
		});
		btnIndietro.setBounds(20, 17, 100, 32);
		panelFilter.add(btnIndietro);
		
		btnRefresh = new JButton("");
		btnRefresh.setForeground(new Color(255, 250, 240));
		btnRefresh.setBackground(new Color(255, 250, 240));
		btnRefresh.setOpaque(false);
		btnRefresh.setContentAreaFilled(false);
		btnRefresh.setBorderPainted(false);
		btnRefresh.setIcon(new ImageIcon(UserReviewsFrame.class.getResource("/images/Very-Basic-Refresh-icon.png")));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePanels(panelFilter);
				setVisible(false);
				setVisible(true);
			}
		});
		btnRefresh.setBounds(849, 8, 44, 41);
		panelFilter.add(btnRefresh);
		
		JPanel innerPanel = new JPanel();
		innerPanel.setBounds(0, 0, 1000, 16);
		innerPanel.setBackground(bginner);
		panelFilter.add(innerPanel);
		
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				toShowPanels(panelFilter);
			}
		});
	}
	
	private void toShowPanels(JPanel panelFilter) {
		UserReviewsPanels.clear();
		try {
			control.toShowUserReviews(control.getUser().getIduser());
		} catch (NoUserReviewException e1) {
			JOptionPane.showInternalMessageDialog(contentPane, "Non hai recensioni attive!", "BonVoyage!", JOptionPane.INFORMATION_MESSAGE);
		}
		ArrayList<Review> UserReviews = control.getUser().getWritedReviews();
		
		for(int i=0; i<UserReviews.size(); i++) {
			Review r = new Review();
			r = UserReviews.get(i);
			UserReviewPanel urp = new UserReviewPanel(control, r);
			UserReviewsPanels.add(urp);
		}
		
		for(int i=0; i<UserReviewsPanels.size(); i++) {
			if(i==0) {
				(UserReviewsPanels.get(i)).setBounds(0,60,980,205);
				panelFilter.add(UserReviewsPanels.get(i));
				panelFilter.setPreferredSize(new Dimension(0,300));
			}
			else {
				(UserReviewsPanels.get(i)).setBounds(0,UserReviewsPanels.get(i-1).getY()+225,980,205);
				panelFilter.add(UserReviewsPanels.get(i));
				panelFilter.setPreferredSize(new Dimension(0,60+(225*UserReviewsPanels.size())));
			}
		}
		control.emptyUserReviews();
		revalidate();
		repaint();
	}
	
	private void updatePanels(JPanel panelFilter) {
		if(!UserReviewsPanels.isEmpty()) {
			for(int i=0; i<UserReviewsPanels.size(); i++) {
					panelFilter.remove(UserReviewsPanels.get(i));;
					panelFilter.setPreferredSize(new Dimension(0,0));
			}
		}
		control.emptyUserReviews();
		UserReviewsPanels.clear();
	}
}