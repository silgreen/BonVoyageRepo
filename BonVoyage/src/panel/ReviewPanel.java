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
		control = ctrl;
		Integer rating = r.getRating();
		setBounds(0,0,714,200);
		
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(255, 250, 240));
		panel.setBounds(0, 0, 714, 200);
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setMinimumSize(new Dimension(32767, 32767));
		scrollPane.setMaximumSize(new Dimension(23, 23));
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBackground(new Color(255, 250, 240));
		scrollPane.setBounds(0, 70, 714, 130);
		panel.add(scrollPane);
		
		JTextPane textPaneReview = new JTextPane();
		textPaneReview.setText(r.getText());
		textPaneReview.setEditable(false);
		scrollPane.setViewportView(textPaneReview);
		
		JTextPane textPaneTitle = new JTextPane();
		textPaneTitle.setText(r.getTitle());
		textPaneTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		textPaneTitle.setBackground(new Color(255, 250, 240));
		textPaneTitle.setBounds(0, 39, 388, 20);
		panel.add(textPaneTitle);
		
		JLabel lblUsername = new JLabel();
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBackground(new Color(255, 250, 240));
		lblUsername.setBounds(0, 14, 109, 26);
		panel.add(lblUsername);
		
		JLabel lblRating = new JLabel();
		lblRating.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblRating.setBounds(574, 14, 140, 40);
		lblRating.setText(rating.toString());
		panel.add(lblRating);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		separator.setBackground(Color.BLACK);
		separator.setBounds(0, 11, 714, 1);
		panel.add(separator);

	}
}
