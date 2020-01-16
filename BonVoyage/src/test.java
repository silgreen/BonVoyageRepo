import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class test extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 424, 251);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 379, 66);
		panel.add(panel_1);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 103, 379, 66);
		panel.add(panel_2);
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 183, 379, 66);
		panel.add(panel_3);
		
		textField_2 = new JTextField();
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
	    scrollPane.setViewportView(panel); 
	    panel.setPreferredSize(new Dimension (panel.getWidth(),1000));
	}

}
