package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ProfileFrame extends JFrame {

	private JPanel contentPane;
	private JTextPane textPaneBio;
	private Controller control;

	/**
	 * Create the frame.
	 */
	public ProfileFrame(Controller ctrl) {
		setTitle("BonVoyage!");
		setResizable(false);

		Color bg = Color.decode("#4d92c2");
		Color bginner = Color.decode("#046490");
		control = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();

		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Gianluca Savonarola");
		lblUsername.setFont(new Font("Nirmala UI", Font.BOLD, 28));
		lblUsername.setBounds(250, 75, 384, 35);
		contentPane.add(lblUsername);
		
		JLabel lblDi = new JLabel("di");
		lblDi.setFont(new Font("Nirmala UI", Font.PLAIN, 17));
		lblDi.setBounds(250, 120, 48, 17);
		contentPane.add(lblDi);
		
		JLabel lblPosition = new JLabel("Napoli");
		lblPosition.setFont(new Font("Nirmala UI", Font.BOLD, 20));
		lblPosition.setBounds(272, 109, 271, 35);
		contentPane.add(lblPosition);
		
		JLabel lblemail = new JLabel("gianlucasavonarola@helle.com");
	    lblemail.setFont(new Font("Nirmala UI", Font.PLAIN, 22));
	    lblemail.setBounds(250, 147, 384, 35);
	    contentPane.add(lblemail);
	    
	    JLabel lblBiografia = new JLabel("Biografia");
	    lblBiografia.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
	    lblBiografia.setBounds(272, 254, 89, 35);
	    contentPane.add(lblBiografia);
	    
	    textPaneBio = new JTextPane();
	    textPaneBio.setBorder(new LineBorder(new Color(0, 0, 0)));
	    textPaneBio.setBackground(Color.WHITE);
	    textPaneBio.setEditable(false);
	    textPaneBio.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
	    textPaneBio.setBounds(272, 299, 441, 150);
	    contentPane.add(textPaneBio);
	    
	    JButton btnModifyBio = new JButton("");
	    btnModifyBio.setIcon(new ImageIcon(ProfileFrame.class.getResource("/images/File-Edit-icon.png")));
	    btnModifyBio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	    btnModifyBio.setBounds(680, 254, 33, 35);
	    contentPane.add(btnModifyBio);
	    
	    JButton btnEsci = new JButton("");
	    btnEsci.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btnEsci.setIcon(new ImageIcon(ProfileFrame.class.getResource("/images/logout_btn.png")));
	    btnEsci.setOpaque(false);
	    btnEsci.setContentAreaFilled(false);
	    btnEsci.setBorderPainted(false);
	    btnEsci.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		btnEsci.setIcon(new ImageIcon(ProfileFrame.class.getResource("/images/logout_btn_light.png")));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		btnEsci.setIcon(new ImageIcon(ProfileFrame.class.getResource("/images/logout_btn.png")));
	    	}
	    });
	    btnEsci.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		int input = JOptionPane.showInternalConfirmDialog(contentPane, "sei sicuro di voler fare il logout?", "BonVoyage!", JOptionPane.INFORMATION_MESSAGE);
	    		
	    		if(input == 0) {
	    		control.toOpenAndCloseFrame(control.getSearch(), control.getProfile());
	    		control.getUser().setLogged(false);
	    		}
	    	}
	    });
	    btnEsci.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnEsci.setBounds(801, 510, 149, 40);
	    contentPane.add(btnEsci);
	    
	    JButton btnEliminaAccount = new JButton("");
	    btnEliminaAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btnEliminaAccount.setIcon(new ImageIcon(ProfileFrame.class.getResource("/images/btn_elimina_account.png")));
	    btnEliminaAccount.setOpaque(false);
	    btnEliminaAccount.setContentAreaFilled(false);
	    btnEliminaAccount.setBorderPainted(false);
	    btnEliminaAccount.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		btnEliminaAccount.setIcon(new ImageIcon(ProfileFrame.class.getResource("/images/elimina_account_light.png")));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		btnEliminaAccount.setIcon(new ImageIcon(ProfileFrame.class.getResource("/images/btn_elimina_account.png")));
	    	}
	    });
	    btnEliminaAccount.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		int input = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler elimnare l'Account?", "Attenzione!", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
	    		
	    		if (input == 0) {
	    			control.toDeleteUser(control.getUser().getIduser());
	    			control.toOpenAndCloseFrame(control.getSearch(), control.getProfile());
	    			JOptionPane.showConfirmDialog(null, "L'Account e' stato eliminato con successo!", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
	    			
	    		}
	    	}
	    });
	    btnEliminaAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnEliminaAccount.setBounds(30, 510, 186, 45);
	    contentPane.add(btnEliminaAccount);
	        
	    JLabel lblRecensioniScritte = new JLabel("Recensioni scritte:");
	    lblRecensioniScritte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    lblRecensioniScritte.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		control.toOpenAndCloseFrame(control.getUserReview(), control.getProfile());
	    	}
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		lblRecensioniScritte.setText("<HTML><U>Recensioni scritte:</U></HTML>");
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		lblRecensioniScritte.setText("Recensioni scritte:");
	    	}
	    });
	    lblRecensioniScritte.setFont(new Font("Nirmala UI", Font.PLAIN, 16));
	    lblRecensioniScritte.setBounds(250, 192, 128, 28);
	    contentPane.add(lblRecensioniScritte);
	    
	    JLabel lblNreviews = new JLabel("1");
	    lblNreviews.setFont(new Font("Nirmala UI", Font.BOLD, 16));
	    lblNreviews.setBounds(380, 193, 48, 28);
	    contentPane.add(lblNreviews);
	    
	    JButton btnSaveChanges = new JButton("");
	    btnSaveChanges.setIcon(new ImageIcon(ProfileFrame.class.getResource("/images/btn_salva_modifiche.png")));
	    btnSaveChanges.setOpaque(false);
	    btnSaveChanges.setContentAreaFilled(false);
	    btnSaveChanges.setBorderPainted(false);
	    btnSaveChanges.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		 btnSaveChanges.setIcon(new ImageIcon(ProfileFrame.class.getResource("/images/btn_salva_modifiche_light.png")));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		 btnSaveChanges.setIcon(new ImageIcon(ProfileFrame.class.getResource("/images/btn_salva_modifiche.png")));
	    	}
	    });
	    btnSaveChanges.setVisible(false);
	    btnSaveChanges.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnSaveChanges.setBounds(537, 254, 176, 45);
	    contentPane.add(btnSaveChanges);
	    
	    JPanel panel = new JPanel();
	    panel.setBounds(0, 0, 1000, 51);
	    panel.setBackground(bg);
	    contentPane.add(panel);
	    panel.setLayout(null);
	    
	    JLabel lblLogo = new JLabel("");
	    lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    lblLogo.setBounds(895, 0, 59, 48);
	    panel.add(lblLogo);
	    lblLogo.setIcon(new ImageIcon(ProfileFrame.class.getResource("/images/logo_mini_png.png")));
	    
	    JPanel inner = new JPanel();
	    inner.setBounds(0, 0, 1000, 16);
	    inner.setBackground(bginner);
	    panel.add(inner);
	    
	    JButton btnIndietro = new JButton("");
	    btnIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btnIndietro.setIcon(new ImageIcon(ProfileFrame.class.getResource("/images/btn_indietro.png")));
	    btnIndietro.setOpaque(false);
	    btnIndietro.setContentAreaFilled(false);
	    btnIndietro.setBorderPainted(false);
	    btnIndietro.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		btnIndietro.setIcon(new ImageIcon(ProfileFrame.class.getResource("/images/btn_indietro_light.png")));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		btnIndietro.setIcon(new ImageIcon(ProfileFrame.class.getResource("/images/btn_indietro.png")));
	    	}
	    });
	    btnIndietro.setBounds(20, 17, 100, 32);
	    panel.add(btnIndietro);
	    btnIndietro.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(control.getPreviousOpenedFrame() == 1)
	    			control.toOpenAndCloseFrame(control.getSearch(), control.getProfile());
	    		if(control.getPreviousOpenedFrame() == 2)
	    			control.toOpenAndCloseFrame(control.getResults(), control.getProfile());
	    		if(control.getPreviousOpenedFrame() == 3)
	    			control.toOpenAndCloseFrame(control.getPostFrame(), control.getProfile());
	    		
	    	}
	    });
	    btnIndietro.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    
	    JLabel label = new JLabel("");
	    label.setIcon(new ImageIcon(ProfileFrame.class.getResource("/images/utente_placeholder.png")));
	    label.setBounds(30, 55, 200, 200);
	    contentPane.add(label);
	    lblLogo.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		control.toOpenAndCloseFrame(control.getSearch(), control.getProfile());
	    	}
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		lblLogo.setIcon(new ImageIcon(ProfileFrame.class.getResource("/images/logo_mini_png_light.png")));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		lblLogo.setIcon(new ImageIcon(ProfileFrame.class.getResource("/images/logo_mini_png.png")));
	    	}
	    });
	    
	    JLabel lblDate = new JLabel("");
	    lblDate.setFont(new Font("Nirmala UI", Font.BOLD, 16));
	    lblDate.setBounds(557, 193, 167, 28);
	    contentPane.add(lblDate);
	   
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				control.updateUserDatas();
				lblUsername.setText(control.getUser().getUsername());
				lblPosition.setText(control.getUser().getCity()+", "+control.getUser().getRegion());
				lblemail.setText(control.getUser().getEmail());
				lblNreviews.setText(control.getUser().getNreviews());
				lblDate.setText(control.getUser().getDate());
				textPaneBio.setText(control.getUser().getBio());
				
			}
		});
		
	    btnModifyBio.setOpaque(false);
	    btnModifyBio.setContentAreaFilled(false);
	    btnModifyBio.setBorderPainted(false);
	    
	    JLabel lblRegistratoDal = new JLabel("Registrato dal:");
	    lblRegistratoDal.setFont(new Font("Nirmala UI", Font.PLAIN, 16));
	    lblRegistratoDal.setBounds(453, 192, 128, 28);
	    contentPane.add(lblRegistratoDal);
	    
	    btnModifyBio.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		btnModifyBio.setVisible(false);
	    		btnSaveChanges.setVisible(true);
	    		textPaneBio.setEditable(true);
	    	}
	    });
	    
	    btnSaveChanges.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		btnModifyBio.setVisible(true);
	    		btnSaveChanges.setVisible(false);
	    		control.ModifyBio(textPaneBio.getText(), control.getUser().getUsername());
	    		textPaneBio.setEditable(false);
	    	}
	    });
	}
}