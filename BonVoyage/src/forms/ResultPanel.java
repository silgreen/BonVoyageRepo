package forms;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import classi.Post;

import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;

public class ResultPanel extends JPanel {

	public ResultPanel(Post p) {
		setBackground(new Color(255, 250, 240));
		setLayout(null);
		setBounds(0,0,757,173);
		
		JLabel lblFoto = new JLabel("Foto");
		lblFoto.setBounds(10, 30, 151, 141);
		add(lblFoto);
		
		JLabel lblStelle = new JLabel(p.getRating_avg());
		lblStelle.setBounds(436, 12, 74, 21);
		add(lblStelle);
		
		JLabel lblNrecensioni = new JLabel(p.getNreviews());
		lblNrecensioni.setBounds(520, 12, 95, 21);
		add(lblNrecensioni);
		
		JLabel lblPosizione = new JLabel(p.getCity() + "," + p.getRegion());
		lblPosizione.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPosizione.setBounds(181, 48, 180, 13);
		add(lblPosizione);
		
		JLabel lblTipoCate = new JLabel(p.getCategory() + "," + p.getSub_category());
		lblTipoCate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoCate.setBounds(181, 152, 206, 19);
		add(lblTipoCate);
		
		JTextPane textPaneInfo = new JTextPane();
		textPaneInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPaneInfo.setText(p.getInfo());
		textPaneInfo.setEditable(false);
		textPaneInfo.setBackground(new Color(255, 250, 240));
		textPaneInfo.setBounds(180, 66, 520, 86);
		add(textPaneInfo);
		
		JTextPane textPaneNomeStruttura = new JTextPane();
		textPaneNomeStruttura.setFont(new Font("Tahoma", Font.BOLD, 16));
		textPaneNomeStruttura.setText(p.getName());
		textPaneNomeStruttura.setEditable(false);
		textPaneNomeStruttura.setBackground(new Color(255,250,240));
		textPaneNomeStruttura.setBounds(181, 0, 245, 40);
		add(textPaneNomeStruttura);

	}
}