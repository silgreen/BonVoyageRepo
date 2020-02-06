package panel;

import javax.swing.JPanel;

import classi.Review;
import controller.Controller;
import except.NoUserReviewException;
import forms.SearchFrame;

import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class UserReviewPanel extends JPanel {
	Controller control;

	public UserReviewPanel(Controller ctrl, Review r) {
		Color bg = Color.decode("#046490");
		setBackground(Color.WHITE);
		control = ctrl;
		
		setBounds(new Rectangle(0, 0, 980, 205));
		setLayout(null);
		
		JButton btnSalva = new JButton("");
		btnSalva.setIcon(new ImageIcon(UserReviewPanel.class.getResource("/images/btn_salva.png")));
		btnSalva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSalva.setIcon(new ImageIcon(UserReviewPanel.class.getResource("/images/btn_salva_light.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSalva.setIcon(new ImageIcon(UserReviewPanel.class.getResource("/images/btn_salva.png")));
			}
		});
	    btnSalva.setOpaque(false);
	    btnSalva.setContentAreaFilled(false);
	    btnSalva.setBorderPainted(false);
		btnSalva.setVisible(false);

		btnSalva.setBounds(804, 110, 156, 35);
		add(btnSalva);
		
		JButton btnElimina = new JButton("");
		btnElimina.setIcon(new ImageIcon(UserReviewPanel.class.getResource("/images/btn_elimina.png")));
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnElimina.setIcon(new ImageIcon(UserReviewPanel.class.getResource("/images/btn_elimina_light.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnElimina.setIcon(new ImageIcon(UserReviewPanel.class.getResource("/images/btn_elimina.png")));
			}
		});
	    btnElimina.setOpaque(false);
	    btnElimina.setContentAreaFilled(false);
	    btnElimina.setBorderPainted(false);
		btnElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showInternalConfirmDialog(null, "sei sicuro di voler eliminare recensione?", "BonVoyage!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
				if(input == 0) {
					control.toDeleteReview(r.getIdpost(),r.getIduser());
					control.getUser().getWritedReviews().clear();
					try {
						control.toShowUserReview(r.getIduser());
					} catch (NoUserReviewException e1) {
						e1.printStackTrace();
					}
				}
				setVisible(false);
				setVisible(true);
				revalidate();
				repaint();
			}
		});
		btnElimina.setBounds(804, 146, 156, 35);
		add(btnElimina);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(30, 63, 694, 132);
		add(scrollPane);
		
		JTextPane textPaneReview = new JTextPane();
		textPaneReview.setBackground(Color.WHITE);
		textPaneReview.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		textPaneReview.setEditable(false);
		textPaneReview.setText(r.getText());
		scrollPane.setViewportView(textPaneReview);
		
		JButton btnModifica = new JButton("");
		btnModifica.setIcon(new ImageIcon(UserReviewPanel.class.getResource("/images/btn_modifica.png")));
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnModifica.setIcon(new ImageIcon(UserReviewPanel.class.getResource("/images/btn_modifica_light.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnModifica.setIcon(new ImageIcon(UserReviewPanel.class.getResource("/images/btn_modifica.png")));
			}
		});
	    btnModifica.setOpaque(false);
	    btnModifica.setContentAreaFilled(false);
	    btnModifica.setBorderPainted(false);
		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPaneReview.setEditable(true);
				btnModifica.setVisible(false);
				btnElimina.setVisible(false);
				btnSalva.setVisible(true);
			}
		});
		btnModifica.setBounds(804, 74, 156, 35);
		add(btnModifica);
		
		JTextPane textPaneTitle = new JTextPane();
		textPaneTitle.setBackground(bg);
		textPaneTitle.setFont(new Font("Nirmala UI", Font.BOLD, 20));
		textPaneTitle.setBounds(20, 5, 276, 30);
		textPaneTitle.setText(r.getTitle());
		add(textPaneTitle);
		
		JLabel lblStars = new JLabel("");
		lblStars.setBackground(bg);
		lblStars.setBounds(780, 5, 180, 33);
		control.toShowStars(lblStars, Float.parseFloat(Integer.valueOf(r.getRating()).toString()));
		add(lblStars);
		
		JTextPane textPaneNomeStruttura = new JTextPane();
		textPaneNomeStruttura.setBackground(bg);
		textPaneNomeStruttura.setFont(new Font("Nirmala UI", Font.BOLD, 20));
		textPaneNomeStruttura.setBounds(317, 5, 382, 30);
		textPaneNomeStruttura.setText(control.toFetchSinglePost(r.getIdpost()).getName());
		add(textPaneNomeStruttura);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 980, 45);
		panel.setBackground(bg);
		add(panel);
		
		btnSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPaneReview.setEditable(false);
				control.UpdateUserReview(textPaneReview.getText(), control.getUser().getIduser(), r.getIdpost());
				JOptionPane.showInternalMessageDialog(null, "Recensione modificata con successo", "BonVoyage!", JOptionPane.INFORMATION_MESSAGE);
				btnModifica.setVisible(true);
				btnSalva.setVisible(false);
				btnElimina.setVisible(true);
			}
		});
	}
}
