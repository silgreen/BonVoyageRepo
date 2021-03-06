package forms;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import controller.Controller;
import except.EmptyFieldException;
import except.LongTitleException;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class ReviewFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTitolo;
	private Controller control;
	private JLabel lblRecensione;
	private JLabel lblTitolo;
	private JButton btnNewPubblicaReview;
	private JRadioButton rdbtnStar1;
	private JRadioButton rdbtnStar2;
	private JRadioButton rdbtnStar3;
	private JRadioButton rdbtnStar4;
	private JRadioButton rdbtnStar5;
	private JLabel lblGiudizio;
	private JLabel lblLogo;
	private JButton btnNewBack;
	private JScrollPane scrollPane;
	private JEditorPane editorPaneReview;
	private int Rating = 1;
	
	public ReviewFrame(Controller ctrl) {
		setResizable(false);

		Color bg = Color.decode("#4d92c2");
		Color bginner = Color.decode("#046490");
		control = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    textFieldTitolo = new JTextField();
	    textFieldTitolo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
	    textFieldTitolo.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    textFieldTitolo.setBounds(318, 134, 350, 27);
	    contentPane.add(textFieldTitolo);
	    textFieldTitolo.setColumns(10);
	    
	    lblRecensione = new JLabel("Recensione");
	    lblRecensione.setFont(new Font("Nirmala UI", Font.PLAIN, 21));
	    lblRecensione.setBounds(440, 207, 106, 27);
	    contentPane.add(lblRecensione);
	    
	    lblTitolo = new JLabel("Titolo");
	    lblTitolo.setFont(new Font("Nirmala UI", Font.PLAIN, 21));
	    lblTitolo.setBounds(318, 105, 53, 19);
	    contentPane.add(lblTitolo);
	    
	    btnNewPubblicaReview = new JButton("");
	    btnNewPubblicaReview.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btnNewPubblicaReview.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		btnNewPubblicaReview.setIcon(new ImageIcon(SearchFrame.class.getResource("/images/button_pubblica-recensione_light.png")));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		btnNewPubblicaReview.setIcon(new ImageIcon(SearchFrame.class.getResource("/images/button_pubblica-recensione.png")));
	    	}
	    });
	    btnNewPubblicaReview.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/button_pubblica-recensione.png")));
	    btnNewPubblicaReview.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnNewPubblicaReview.setBounds(359, 468, 267, 49);
	    btnNewPubblicaReview.setOpaque(false);
	    btnNewPubblicaReview.setContentAreaFilled(false);
	    btnNewPubblicaReview.setBorderPainted(false);
	    contentPane.add(btnNewPubblicaReview);
	    
	    ButtonGroup radioButtonGroup = new ButtonGroup();
	    
	    rdbtnStar1 = new JRadioButton("");
	    rdbtnStar1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


	    rdbtnStar1.setBackground(Color.WHITE);
	    rdbtnStar1.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    rdbtnStar1.setBounds(469, 96, 38, 32);
	    contentPane.add(rdbtnStar1);
	    
	    rdbtnStar2 = new JRadioButton("");
	    rdbtnStar2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


	    rdbtnStar2.setBackground(Color.WHITE);
	    rdbtnStar2.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    rdbtnStar2.setBounds(509, 96, 38, 32);
	    contentPane.add(rdbtnStar2);
	    
	    rdbtnStar3 = new JRadioButton("");
	    rdbtnStar3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


	    rdbtnStar3.setBackground(Color.WHITE);
	    rdbtnStar3.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    rdbtnStar3.setBounds(549, 96, 38, 32);
	    contentPane.add(rdbtnStar3);
	    
	    rdbtnStar4 = new JRadioButton("");
	    rdbtnStar4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


	    rdbtnStar4.setBackground(Color.WHITE);
	    rdbtnStar4.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    rdbtnStar4.setBounds(590, 96, 38, 32);
	    contentPane.add(rdbtnStar4);
	    
	    rdbtnStar5 = new JRadioButton("");
	    rdbtnStar5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


	    rdbtnStar5.setBackground(Color.WHITE);
	    rdbtnStar5.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    rdbtnStar5.setBounds(630, 96, 38, 32);
	    contentPane.add(rdbtnStar5);
	    
	    radioButtonGroup.add(rdbtnStar1);
	    radioButtonGroup.add(rdbtnStar2);
	    radioButtonGroup.add(rdbtnStar3);
	    radioButtonGroup.add(rdbtnStar4);
	    radioButtonGroup.add(rdbtnStar5);
	    
	    lblGiudizio = new JLabel("");
	    lblGiudizio.setHorizontalAlignment(SwingConstants.CENTER);
	    lblGiudizio.setFont(new Font("Montserrat", Font.PLAIN, 12));
	    lblGiudizio.setAutoscrolls(true);
	    lblGiudizio.setBounds(492, 71, 151, 29);
	    contentPane.add(lblGiudizio);
	    
	    lblLogo = new JLabel("");
	    lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    lblLogo.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		lblLogo.setIcon(new ImageIcon(SearchFrame.class.getResource("/images/logo_mini_png_light.png")));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		lblLogo.setIcon(new ImageIcon(SearchFrame.class.getResource("/images/logo_mini_png.png")));
	    	}
	    });
	    lblLogo.setBounds(895, -2, 65, 55);
	    contentPane.add(lblLogo);
	    lblLogo.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/logo_mini_png.png")));
	    lblLogo.setFont(new Font("Montserrat", Font.PLAIN, 27));
	    
	    JPanel topPanel = new JPanel();
	    topPanel.setBounds(0, 0, 1000, 51);
	    topPanel.setBackground(bg);
	    contentPane.add(topPanel);
	    topPanel.setLayout(null);
	    
	    JPanel innerPanel = new JPanel();
	    innerPanel.setBounds(0, 0, 1000, 16);
	    innerPanel.setBackground(bginner);
	    topPanel.add(innerPanel);
	    
	    btnNewBack = new JButton("");
	    btnNewBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btnNewBack.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		btnNewBack.setIcon(new ImageIcon(SearchFrame.class.getResource("/images/btn_indietro_light.png")));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		btnNewBack.setIcon(new ImageIcon(SearchFrame.class.getResource("/images/btn_indietro.png")));
	    	}
	    });
	    btnNewBack.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/btn_indietro.png")));
	    btnNewBack.setBounds(20, 17, 100, 32);
	    topPanel.add(btnNewBack);
	    btnNewBack.setOpaque(false);
	    btnNewBack.setContentAreaFilled(false);
	    btnNewBack.setBorderPainted(false);
	    btnNewBack.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		int input = JOptionPane.showConfirmDialog(contentPane, "sei sicuro di voler tornare indietro? le tue modifiche andranno perdute", "Attenzione!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
	    		if (input == 0)
	    			control.toOpenAndCloseFrame(control.getPostFrame(), control.getReview());
	    	}
	    });
	    btnNewBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    
	    scrollPane = new JScrollPane();
	    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    scrollPane.setBounds(243, 244, 500, 200);
	    contentPane.add(scrollPane);
	    
	    editorPaneReview = new JEditorPane();
	    scrollPane.setViewportView(editorPaneReview);
	    editorPaneReview.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
	    editorPaneReview.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

	    DocumentListener docListener = new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				changed();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				changed();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				changed();
				
			}
			
			private void changed() {
				if(textFieldTitolo.getText().length() <= 48) {
					textFieldTitolo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnNewPubblicaReview.setEnabled(true);
				}
				else {
					textFieldTitolo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.RED));
					btnNewPubblicaReview.setEnabled(false);
				}
			}
		};
		
		textFieldTitolo.getDocument().addDocumentListener(docListener);
	    
	    rdbtnStar1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		lblGiudizio.setText("Pessimo!");
    			rdbtnStar1.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar2.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		rdbtnStar3.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		rdbtnStar4.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		rdbtnStar5.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		Rating = 1;
	    	}
	    });
	    
	    rdbtnStar2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		lblGiudizio.setText("Mediocre");
	    		rdbtnStar1.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar2.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar3.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		rdbtnStar4.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		rdbtnStar5.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		Rating = 2;
	    	}
	    });
	    
	    rdbtnStar3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		lblGiudizio.setText("Buono");
	    		rdbtnStar1.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar2.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar3.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar4.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		rdbtnStar5.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		Rating = 3;
	    	}
	    });
	    
	    rdbtnStar4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		lblGiudizio.setText("Ottimo");
	    		rdbtnStar1.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar2.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar3.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar4.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar5.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		Rating = 4;
	    	}
	    });
	    
	    rdbtnStar5.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		lblGiudizio.setText("Eccellente!");
	    		rdbtnStar1.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar2.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar3.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar4.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar5.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		Rating = 5;
	    	}
	    });
	    
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
			    rdbtnStar1.setSelected(true);
			    lblGiudizio.setText("Pessimo!");
			    rdbtnStar1.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Senza titolo-1.png")));
	    		rdbtnStar2.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		rdbtnStar3.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		rdbtnStar4.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
	    		rdbtnStar5.setIcon(new ImageIcon(ReviewFrame.class.getResource("/images/Empty star (2).png")));
			}
		});
		
	    btnNewPubblicaReview.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
	    			if(textFieldTitolo.getText().length() > 64)
	    				throw new LongTitleException();
	    			else if (editorPaneReview.getText().isEmpty() || textFieldTitolo.getText().isEmpty())
	    				throw new EmptyFieldException();
	    			else {
	    		    	control.createReview(control.getUser().getIduser(), control.getPost().getIdpost(), textFieldTitolo.getText(), editorPaneReview.getText(), Rating);
	    		    	JOptionPane.showInternalMessageDialog(null, "Recensione pubblicata con successo!", "BonVoyage!", JOptionPane.INFORMATION_MESSAGE);
	    		    	control.toOpenAndCloseFrame(control.getPostFrame(), control.getReview());
	    		    	textFieldTitolo.setText(null);
	    		    	editorPaneReview.setText(null);
	    			}
				} catch(LongTitleException e2) {
					JOptionPane.showMessageDialog(contentPane, "Limite massimo di caratteri del titolo raggiunto", "BonVoyage!", JOptionPane.ERROR_MESSAGE);
				} catch (EmptyFieldException e3) {
					JOptionPane.showMessageDialog(contentPane, "I campi titolo e recensione non possono essere vuoti!", "BonVoyage!", JOptionPane.ERROR_MESSAGE);
				}
	    	}
	    });
	}
}
