package panel;

import javax.swing.JPanel;

import classi.Review;
import controller.Controller;
import except.NoUserReviewException;

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

public class UserReviewPanel extends JPanel {
	Controller control;

	public UserReviewPanel(Controller ctrl, Review r) {
		setBackground(new Color(255, 250, 240));
		control = ctrl;
		
		setBounds(new Rectangle(0, 0, 714, 250));
		setLayout(null);
		
		JButton btnSalva = new JButton("Salva");
		btnSalva.setVisible(false);

		btnSalva.setBounds(619, 207, 85, 21);
		add(btnSalva);
		
		JButton btnElimina = new JButton("Elimina");
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
		btnElimina.setBounds(524, 207, 85, 21);
		add(btnElimina);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 65, 694, 132);
		add(scrollPane);
		
		JTextPane textPaneReview = new JTextPane();
		textPaneReview.setBackground(new Color(255, 250, 240));
		textPaneReview.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPaneReview.setEditable(false);
		textPaneReview.setText(r.getText());
		scrollPane.setViewportView(textPaneReview);
		
		JButton btnModifica = new JButton("Modifica");
		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPaneReview.setEditable(true);
				btnModifica.setVisible(false);
				btnElimina.setVisible(false);
				btnSalva.setVisible(true);
			}
		});
		btnModifica.setBounds(619, 207, 85, 21);
		add(btnModifica);
		
		JTextPane textPaneTitle = new JTextPane();
		textPaneTitle.setBackground(new Color(255, 250, 240));
		textPaneTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneTitle.setBounds(10, 10, 214, 45);
		textPaneTitle.setText(r.getTitle());
		add(textPaneTitle);
		
		JLabel lblStars = new JLabel("New label");
		lblStars.setBackground(new Color(255, 250, 240));
		lblStars.setBounds(227, 10, 180, 33);
		control.toShowStars(lblStars, Float.parseFloat(Integer.valueOf(r.getRating()).toString()));
		add(lblStars);
		
		JTextPane textPaneNomeStruttura = new JTextPane();
		textPaneNomeStruttura.setBackground(new Color(255, 250, 240));
		textPaneNomeStruttura.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneNomeStruttura.setBounds(417, 10, 287, 45);
		textPaneNomeStruttura.setText(control.toFetchSinglePost(r.getIdpost()).getName());
		add(textPaneNomeStruttura);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 238, 694, 2);
		add(separator);
		
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
