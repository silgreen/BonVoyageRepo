package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classi.Review;
import controller.Controller;
import panel.UserReviewPanel;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
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

public class UserReviewsFrame extends JFrame {

	private JPanel contentPane;
	Controller control;
	ArrayList<UserReviewPanel> ListUrp = new ArrayList<UserReviewPanel>();
	
	public UserReviewsFrame(Controller ctrl) {
		control = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 786, 563);
		contentPane.add(scrollPane);
		
		JPanel panelFilter = new JPanel();
		scrollPane.setViewportView(panelFilter);
		panelFilter.setLayout(null);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				control.toOpenAndCloseFrame(control.getSearch(), control.getUserReview());
			}
		});
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setIcon(new ImageIcon(UserReviewsFrame.class.getResource("/images/logoXSBon.png")));
		label.setBounds(20, 20, 170, 55);
		panelFilter.add(label);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				for(int i = 0; i < ListUrp.size(); i++) {
//					if(!ListUrp.isEmpty()) {
//						panelFilter.remove(ListUrp.get(i));
//						panelFilter.setPreferredSize(new Dimension(0,0));
//					}
//				}
				ListUrp.clear();
				validate();
				repaint();
			}
		});
		btnIndietro.setBounds(689, 35, 85, 21);
		panelFilter.add(btnIndietro);
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				ArrayList<Review> ar = control.getUser().getWritedReviews();
				
				for (Review review : ar) {
					UserReviewPanel urp = new UserReviewPanel(control,review);
					ListUrp.add(urp);
				}
				
				for(int i = 0; i < ListUrp.size(); i++) {
					if(i == 0) {
						ListUrp.get(i).setBounds(20,100,714,250);
						panelFilter.add(ListUrp.get(i));
						panelFilter.setPreferredSize(new Dimension(0,350));
					} else {
						ListUrp.get(i).setBounds(20,ListUrp.get(i-1).getY()+250,714,250);
						panelFilter.add(ListUrp.get(i));
						panelFilter.setPreferredSize(new Dimension(0,100+(250*ListUrp.size())));
					}
				} 
				ListUrp.clear();
			}
		});
	}
}
