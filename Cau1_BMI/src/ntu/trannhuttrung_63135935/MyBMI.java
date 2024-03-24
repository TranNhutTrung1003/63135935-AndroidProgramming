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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import java.text.*;

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
	
	public String checkHeart(float BMI) {
		if(BMI < 18.5f) {
			return "gầy";
		} else if (BMI >= 18.5f && BMI <= 24.9) {
			return "bình thường";
		} else if (BMI > 24.9 && BMI <= 29.9) {
			return "tiền béo phì";
		} else if (BMI > 29.9 && BMI <= 34.9){
			return "béo phì độ I";
		} else if(BMI > 34.9 && BMI <= 39.9) {
			return "béo phì độ II";
		} else {
			return "Béo phì độ III";
		}
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
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField.setBounds(23, 33, 154, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox.setBounds(184, 37, 78, 30);
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
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(20, 38, 154, 30);
		panel_1.add(textField_1);
		
		JComboBox<String> comboBox_1 = new JComboBox<>();
		comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_1.setBounds(184, 37, 78, 30);
		panel_1.add(comboBox_1);
		comboBox_1.addItem("cm");
		comboBox_1.addItem("m");
		comboBox_1.setSelectedItem("m");
		
		Panel panel_2 = new Panel();
		panel_2.setForeground(new Color(0, 0, 255));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(33, 252, 134, 85);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Nam");
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton.setBounds(17, 46, 103, 21);
		rdbtnNewRadioButton.setSelected(true);
		panel_2.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\workspace\\63135935-AndroidProgramming\\Cau1_BMI\\nam.png"));
		lblNewLabel_2.setBounds(53, 0, 36, 43);
		panel_2.add(lblNewLabel_2);
		
		Panel panel_3 = new Panel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(225, 252, 134, 85);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Nữ");
		rdbtnNewRadioButton_1.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton_1.setBounds(6, 38, 122, 29);
		panel_3.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("E:\\workspace\\63135935-AndroidProgramming\\Cau1_BMI\\nữ.png"));
		lblNewLabel_3.setBounds(55, -11, 45, 58);
		panel_3.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Calculator BMI");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(128, 0, 255));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setBounds(33, 357, 157, 33);
		contentPane.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 218, 185));
		panel_4.setBounds(33, 400, 326, 69);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Kết quả BMI");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(113, 10, 92, 20);
		panel_4.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("0");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5.setBounds(134, 30, 53, 29);
		panel_4.add(lblNewLabel_5);
		
		Panel panel_5 = new Panel();
		panel_5.setBackground(new Color(0, 255, 255));
		panel_5.setBounds(33, 475, 326, 80);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Tình trạng sức khỏe");
		lblNewLabel_6.setForeground(new Color(64, 0, 64));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6.setBounds(77, 10, 173, 20);
		panel_5.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7.setBounds(10, 40, 306, 30);
		panel_5.add(lblNewLabel_7);
		
		JButton btnNewButton_1 = new JButton("Đặt Lại");
		btnNewButton_1.setBackground(new Color(128, 0, 255));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_1.setBounds(200, 357, 159, 33);
		contentPane.add(btnNewButton_1);
		
		comboBox_1.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedValue = (String) comboBox_1.getSelectedItem();
                    if(!textField_1.getText().toString().isEmpty()) {
                    	float chieucao = Float.parseFloat(textField_1.getText().toString());
                        if(selectedValue.equals("m")) {
                        	textField_1.setText(String.valueOf(Math.round(chieucao * 0.01f * 10f) / 10f));
                        }else {
                        	textField_1.setText(String.valueOf(Math.round(chieucao * 100f * 10f) / 10f));
                        }
                    }	
                }
			}
        });
		
		comboBox.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedValue = (String) comboBox.getSelectedItem();
                    if(!textField.getText().toString().isEmpty()) {
                    	float cannang = Float.parseFloat(textField.getText().toString());
                        if(selectedValue.equals("Pound")) {
                        	textField.setText(String.valueOf(Math.round(cannang * 2.205 * 10f) / 10f));
                        }else {
                        	textField.setText(String.valueOf(Math.round(cannang * 0.454 * 10f) / 10f));
                        }
                    }
                }
			}
        });
		
		btnNewButton_1.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textField_1.setText("");
				textField.setText("");
				lblNewLabel_5.setText("0");
				lblNewLabel_7.setText("");
			}
        });
		
		rdbtnNewRadioButton.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rdbtnNewRadioButton_1.setSelected(false);
			}
			
		});
		
		rdbtnNewRadioButton_1.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rdbtnNewRadioButton.setSelected(false);
			}
			
		});
		
		btnNewButton.addActionListener((ActionListener) new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String txtchieucao = textField_1.getText().toString();
				String txtcannang = textField.getText().toString();
				if(!txtchieucao.isEmpty() && !txtcannang.isEmpty()) {
					float chieucao = Float.parseFloat(txtchieucao);
					float cannang = Float.parseFloat(txtcannang);
					float BMI = 0;
					if(rdbtnNewRadioButton.isSelected() || rdbtnNewRadioButton_1.isSelected()) {
						if(comboBox_1.getSelectedItem().toString().equals("cm")) {
							chieucao = chieucao * 0.01f;
							if(comboBox.getSelectedItem().toString().equals("kg")) {
								BMI = (float) (cannang / Math.pow(chieucao, 2));
							} else {
								cannang = cannang * 0.454f;
								BMI = (float) (cannang / Math.pow(chieucao, 2));
							}
						} else {
							if(comboBox.getSelectedItem().toString().equals("kg")) {
								BMI = (float) (cannang / Math.pow(chieucao, 2));
							} else {
								cannang = cannang * 0.454f;
								BMI = (float) (cannang / Math.pow(chieucao, 2));
							}
						}
						
						float roundedNumber = (float) (Math.round(BMI * 10f) / 10f);
						lblNewLabel_5.setText(String.valueOf(roundedNumber));
						
						if(rdbtnNewRadioButton.isSelected()) {
							lblNewLabel_7.setText("Sức khỏe của anh ấy " + checkHeart(BMI));
						} else {
							lblNewLabel_7.setText("Sức khỏe của cô ây " + checkHeart(BMI));
						}
					} 
				}
			}
		});
	}
}
