package forms;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;

public class ResultPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ResultPanel() {
		setLayout(null);
		setBounds(0,0,757,173);
		
		JLabel label = new JLabel("Foto");
		label.setBounds(10, 30, 151, 141);
		add(label);
		
		JLabel label_1 = new JLabel("NomeStruttura");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(171, 11, 119, 22);
		add(label_1);
		
		JLabel label_2 = new JLabel("Stars");
		label_2.setBounds(300, 11, 151, 21);
		add(label_2);
		
		JLabel label_3 = new JLabel("NumeroRecensioni");
		label_3.setBounds(461, 12, 95, 21);
		add(label_3);
		
		JLabel label_4 = new JLabel("Posizione");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(181, 30, 151, 13);
		add(label_4);
		
		JLabel label_5 = new JLabel("tipologia,categoria");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(181, 152, 122, 19);
		add(label_5);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBackground(new Color(255, 250, 240));
		textPane.setBounds(180, 59, 520, 83);
		add(textPane);

	}
}
