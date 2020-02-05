package panel;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import classi.Review;
import controller.Controller;

import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class ReviewPanel extends JPanel {
	Controller control;

	public ReviewPanel(Controller ctrl,Review r) {
		Color inner = Color.decode("#046490");
		Color bg = Color.decode("#4d92c2");
		control = ctrl;
		Integer rating = r.getRating();
		setBounds(0,0,960,200);
		
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(bg);
		panel.setBounds(0, 0, 960, 200);
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setMinimumSize(new Dimension(32767, 32767));
		scrollPane.setMaximumSize(new Dimension(23, 23));
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBackground(new Color(255, 250, 240));
		scrollPane.setBounds(0, 70, 960, 130);
		panel.add(scrollPane);
		
		JTextPane textPaneReview = new JTextPane();
		textPaneReview.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		textPaneReview.setText(r.getText());
		textPaneReview.setEditable(false);
		scrollPane.setViewportView(textPaneReview);
		
		JTextPane textPaneTitle = new JTextPane();
		textPaneTitle.setText(r.getTitle());
		textPaneTitle.setFont(new Font("Nirmala UI", Font.BOLD, 18));
		textPaneTitle.setBackground(bg);
		textPaneTitle.setBounds(0, 39, 700, 33);
		panel.add(textPaneTitle);
		
		JLabel lblUsername = new JLabel();
		lblUsername.setText(r.getUsername());
		lblUsername.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		lblUsername.setBackground(new Color(255, 250, 240));
		lblUsername.setBounds(0, 14, 109, 26);
		panel.add(lblUsername);
		
		JLabel lblRating = new JLabel();
		lblRating.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblRating.setBounds(767, 27, 180, 33);
		control.toShowStars(lblRating, Float.parseFloat(rating.toString()));
		panel.add(lblRating);
		
		JPanel innerPanel = new JPanel();
		innerPanel.setBounds(0, 0, 1000, 16);
		innerPanel.setBackground(inner);
		panel.add(innerPanel);

	}
}
