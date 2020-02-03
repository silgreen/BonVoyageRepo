package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classi.Review;
import controller.Controller;
import except.NoUserReviewException;
import panel.ResultPanel;
import panel.UserReviewPanel;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
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
import javax.swing.SwingConstants;

public class UserReviewsFrame extends JFrame {

	private JPanel contentPane;
	Controller control;
	ArrayList<UserReviewPanel> UserReviewsPanels = new ArrayList<UserReviewPanel>();
	
	public UserReviewsFrame(Controller ctrl) {
		setTitle("BonVoyage!");
		setResizable(false);
		setBackground(new Color(255, 250, 240));
		control = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1000, 563);
		contentPane.add(scrollPane);
		
		JPanel panelFilter = new JPanel();
		panelFilter.setBackground(new Color(255, 250, 240));
		scrollPane.setViewportView(panelFilter);
		panelFilter.setLayout(null);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				control.toOpenAndCloseFrame(control.getSearch(), control.getUserReview());
				if(!UserReviewsPanels.isEmpty()) {
					for(int i=0; i<UserReviewsPanels.size(); i++) {
							panelFilter.remove(UserReviewsPanels.get(i));
							panelFilter.setPreferredSize(new Dimension(0,0));
					}
				}
				control.emptyReview();
				UserReviewsPanels.clear();
			}
		});
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setIcon(new ImageIcon(UserReviewsFrame.class.getResource("/images/logoXSBon.png")));
		label.setBounds(20, 20, 170, 55);
		panelFilter.add(label);
		
		JButton btnIndietro = new JButton("");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.toOpenAndCloseFrame(control.getProfile(), control.getUserReview());
				if(!UserReviewsPanels.isEmpty()) {
					for(int i=0; i<UserReviewsPanels.size(); i++) {
							panelFilter.remove(UserReviewsPanels.get(i));;
							panelFilter.setPreferredSize(new Dimension(0,0));
					}
				}
				control.emptyReview(); 
				UserReviewsPanels.clear();
			}
		});
		btnIndietro.setBounds(689, 35, 85, 21);
		panelFilter.add(btnIndietro);
		
		JButton btnRefresh = new JButton("");
		btnRefresh.setForeground(new Color(255, 250, 240));
		btnRefresh.setBackground(new Color(255, 250, 240));
		btnRefresh.setOpaque(false);
		btnRefresh.setContentAreaFilled(false);
		btnRefresh.setBorderPainted(false);
		btnRefresh.setIcon(new ImageIcon(UserReviewsFrame.class.getResource("/images/Very-Basic-Refresh-icon.png")));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!UserReviewsPanels.isEmpty()) {
					for(int i=0; i<UserReviewsPanels.size(); i++) {
							panelFilter.remove(UserReviewsPanels.get(i));;
							panelFilter.setPreferredSize(new Dimension(0,0));
					}
				}
				control.emptyReview();
				UserReviewsPanels.clear();
				setVisible(false);
				setVisible(true);
			}
		});
		btnRefresh.setBounds(645, 20, 44, 41);
		panelFilter.add(btnRefresh);
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				UserReviewsPanels.clear();
				try {
					control.toShowUserReview(control.getUser().getIduser());
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
						(UserReviewsPanels.get(i)).setBounds(20,100,714,250);
						panelFilter.add(UserReviewsPanels.get(i));
						panelFilter.setPreferredSize(new Dimension(0,350));
					}
					else {
						(UserReviewsPanels.get(i)).setBounds(20,UserReviewsPanels.get(i-1).getY()+250,714,250);
						panelFilter.add(UserReviewsPanels.get(i));
						panelFilter.setPreferredSize(new Dimension(0,100+(250*UserReviewsPanels.size())));
					}
				}
				control.emptyReview();
				revalidate();
				repaint();
			}
		});
	}
}