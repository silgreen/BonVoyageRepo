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
		setLayout(null);
		setBounds(0,0,757,173);
		
		JLabel lblFoto = new JLabel("Foto");
		lblFoto.setBounds(10, 30, 151, 141);
		add(lblFoto);
		
		JLabel lblNomeStrut = new JLabel(p.getName());
		lblNomeStrut.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNomeStrut.setBounds(171, 11, 119, 22);
		add(lblNomeStrut);
		
		JLabel lblStelle = new JLabel(p.getStars());
		lblStelle.setBounds(300, 11, 151, 21);
		add(lblStelle);
		
		JLabel lblNrecensioni = new JLabel(p.getNreviews());
		lblNrecensioni.setBounds(461, 12, 95, 21);
		add(lblNrecensioni);
		
		JLabel lblPosizione = new JLabel(p.getCity() + "," + p.getRegion());
		lblPosizione.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPosizione.setBounds(181, 30, 151, 13);
		add(lblPosizione);
		
		JLabel lblTipoCate = new JLabel(p.getCategory() + "," + p.getSub_category());
		lblTipoCate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoCate.setBounds(181, 152, 122, 19);
		add(lblTipoCate);
		
		JTextPane textPaneInfo = new JTextPane();
		textPaneInfo.setText(p.getInfo());
		textPaneInfo.setEditable(false);
		textPaneInfo.setBackground(new Color(255, 250, 240));
		textPaneInfo.setBounds(180, 59, 520, 83);
		add(textPaneInfo);

	}
}