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
import java.awt.FontFormatException;
import java.awt.Image;

import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Cursor;

public class ResultPanel extends JPanel {
	
	Controller control;
	public ResultPanel(Post p, Controller ctrl) {
		Color bg = Color.decode("#046490");
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
			}
		});
		setBackground(new Color(255,255,255));
		setLayout(null);
		setBounds(0,0,1000,173);
		

		try {
			URL url = new URL(p.getURLMedia());
			BufferedImage image = ImageIO.read(url);
			
			JLabel lblFoto = new JLabel(new ImageIcon(image));
			lblFoto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblFoto.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			lblFoto.setBounds(10, 12, 150, 150);
			add(lblFoto);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel lblStelle = new JLabel();
		lblStelle.setBounds(700, 0, 180, 33);
		add(lblStelle);
		control.toShowStars(lblStelle, Float.parseFloat(p.getRating_avg()));

		
		JLabel lblNrecensioni = new JLabel(p.getNreviews());
		lblNrecensioni.setFont(new Font("Nirmala UI", Font.PLAIN, 14));
		lblNrecensioni.setBounds(880, 8, 73, 21);
		add(lblNrecensioni);
		
		JLabel lblPosizione = new JLabel(p.getCity() + "," + p.getRegion());
		lblPosizione.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 16));
		lblPosizione.setBounds(181, 40, 211, 21);
		add(lblPosizione);
		
		JLabel lblTipoCate = new JLabel(p.getCategory() + "," + p.getSub_category());
		lblTipoCate.setFont(new Font("Nirmala UI", Font.PLAIN, 17));
		lblTipoCate.setBounds(181, 152, 497, 21);
		add(lblTipoCate);
		
		JTextPane textPaneInfo = new JTextPane();
		textPaneInfo.setBorder(null);
		textPaneInfo.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		textPaneInfo.setText(p.getInfo());
		textPaneInfo.setEditable(false);
		textPaneInfo.setBackground(Color.WHITE);
		textPaneInfo.setBounds(180, 66, 700, 86);
		add(textPaneInfo);
		
		JTextPane textPaneNomeStruttura = new JTextPane();
		textPaneNomeStruttura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textPaneNomeStruttura.setForeground(new Color(255,255,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				textPaneNomeStruttura.setForeground(new Color(0,0,0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				control.LinkPost(p);
				control.toOpenAndCloseFrame(control.getPostFrame(),control.getResults());
			}
		});
		textPaneNomeStruttura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		textPaneNomeStruttura.setFont(new Font("Nirmala UI", Font.BOLD, 21));
		textPaneNomeStruttura.setText(p.getName());
		textPaneNomeStruttura.setEditable(false);
		textPaneNomeStruttura.setBackground(bg);
		textPaneNomeStruttura.setBounds(181, 0, 318, 40);
		add(textPaneNomeStruttura);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1000, 40);
		panel.setBackground(bg);
		add(panel);
	}
}