package ntu.trannhuttrung_63135935;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Panel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public class MyBMI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyBMI frame = new MyBMI();
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
	public MyBMI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BMI Calculator");
		lblNewLabel.setBounds(70, 10, 248, 24);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 255)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(33, 151, 326, 85);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Cân nặng");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(114, 10, 99, 24);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(65, 38, 96, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(184, 37, 77, 21);
		panel.add(comboBox);
		comboBox.addItem("Kg");
		comboBox.addItem("Pound");
		comboBox.setSelectedItem("Kg");
		comboBox.setAlignmentX(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 255)));
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(33, 44, 326, 85);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Chiều cao");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(114, 10, 99, 24);
		panel_1.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(65, 38, 96, 19);
		panel_1.add(textField_1);
		
		JComboBox<String> comboBox_1 = new JComboBox<>();
		comboBox_1.setBounds(184, 37, 78, 21);
		panel_1.add(comboBox_1);
		comboBox_1.addItem("cm");
		comboBox_1.addItem("m");
		comboBox_1.setSelectedItem("m");
		
		Panel panel_2 = new Panel();
		panel_2.setForeground(new Color(0, 0, 255));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(33, 252, 126, 85);
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 255)));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Nam");
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton.setBounds(13, 32, 103, 21);
		panel_2.add(rdbtnNewRadioButton);
		
		Panel panel_3 = new Panel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(225, 252, 134, 85);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Nữ");
		rdbtnNewRadioButton_1.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton_1.setBounds(6, 28, 122, 29);
		panel_3.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("Calculator BMI");
		btnNewButton.setBackground(new Color(128, 0, 255));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setBounds(33, 357, 326, 33);
		contentPane.add(btnNewButton);
	}
}
