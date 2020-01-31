package panel;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import classi.Post;
import controller.Controller;

import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ResultPanel extends JPanel {

	Controller control;
	public ResultPanel(Post p, Controller ctrl) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				revalidate();
			}
		});
		control = ctrl;
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				control.LinkPost(p);
				control.toOpenAndCloseFrame(control.getPostFrame(),control.getResults());
				System.out.println(p.getURLMedia());
			}
		});
		setBackground(new Color(255, 250, 240));
		setLayout(null);
		setBounds(0,0,757,173);
		

		try {
			URL url = new URL(p.getURLMedia());
			BufferedImage image = ImageIO.read(url);
			
			JLabel lblFoto = new JLabel(new ImageIcon(image));
			lblFoto.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			lblFoto.setBounds(10, 12, 150, 150);
			add(lblFoto);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel lblStelle = new JLabel(p.getRating_avg());
		lblStelle.setBounds(436, 0, 180, 33);
		add(lblStelle);
		
		if(Float.parseFloat(p.getRating_avg()) >= 1.5 && Float.parseFloat(p.getRating_avg()) < 2)
			lblStelle.setIcon(new ImageIcon(ResultPanel.class.getResource("/images/1emezza.png")));
		else if (Float.parseFloat(p.getRating_avg()) >= 1 && Float.parseFloat(p.getRating_avg()) < 1.5)
			lblStelle.setIcon(new ImageIcon(ResultPanel.class.getResource("/images/1stella.png")));
		else if (Float.parseFloat(p.getRating_avg()) >= 2.5 && Float.parseFloat(p.getRating_avg()) < 3)
			lblStelle.setIcon(new ImageIcon(ResultPanel.class.getResource("/images/2emezza.png")));
		else if (Float.parseFloat(p.getRating_avg()) >= 2 && Float.parseFloat(p.getRating_avg()) < 2.5)
			lblStelle.setIcon(new ImageIcon(ResultPanel.class.getResource("/images/2stelle.png")));
		else if (Float.parseFloat(p.getRating_avg()) >= 3.5 && Float.parseFloat(p.getRating_avg()) < 4)
			lblStelle.setIcon(new ImageIcon(ResultPanel.class.getResource("/images/3emezza.png")));
		else if (Float.parseFloat(p.getRating_avg()) >= 3 && Float.parseFloat(p.getRating_avg()) < 3.5)
			lblStelle.setIcon(new ImageIcon(ResultPanel.class.getResource("/images/3stelle.png")));
		else if (Float.parseFloat(p.getRating_avg()) >= 4.5 && Float.parseFloat(p.getRating_avg()) < 5)
			lblStelle.setIcon(new ImageIcon(ResultPanel.class.getResource("/images/4emezza.png")));
		else if (Float.parseFloat(p.getRating_avg()) >= 4 && Float.parseFloat(p.getRating_avg()) < 4.5)
			lblStelle.setIcon(new ImageIcon(ResultPanel.class.getResource("/images/4stelle.png")));
		else if (Float.parseFloat(p.getRating_avg()) > 4.5)
			lblStelle.setIcon(new ImageIcon(ResultPanel.class.getResource("/images/5stelle.png")));
		
			
			
		
		
		JLabel lblNrecensioni = new JLabel(p.getNreviews());
		lblNrecensioni.setBounds(633, 12, 95, 21);
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