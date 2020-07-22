package mypro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JSplitPane;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Button;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Canvas;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextComponent EmailField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 531);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 327, 338);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Register Yourself...");
		lblNewLabel_4.setBounds(0, 0, 327, 338);
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_4.setBackground(new Color(240, 240, 240));
		lblNewLabel_4.setIcon(new ImageIcon(Registration.class.getResource("/images/reg3.jpg")));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Register Yourself...");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setIcon(new ImageIcon(Registration.class.getResource("/images/reg4.gif")));
		lblNewLabel_5.setBounds(28, 369, 267, 70);
		panel.add(lblNewLabel_5);
		
		
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(337, 161, 56, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(337, 186, 312, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(337, 252, 312, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(337, 384, 312, 30);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(337, 318, 312, 30);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(337, 293, 56, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Confirm Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(337, 359, 108, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email Id");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(337, 227, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		Button button = new Button("Register");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newpro","root", "");
					String query = "insert into register(Username,Email,Password,Confirm_Password)values(?,?,?,?)";

					PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, passwordField.getText());
					pst.setString(4, passwordField_1.getText());
					
					pst.executeUpdate();
					
						JOptionPane.showMessageDialog(null,"Registerd Sucessfully");
						GFG field  = new GFG();     //edited to add applet after registration.
					    field.setVisible(true);
					    setVisible(false);
					Con.close();
				}catch(Exception e1) {System.out.println(e1);}
			}
		});
		button.setBackground(Color.CYAN);
		button.setFont(new Font("Dialog", Font.PLAIN, 13));
		button.setBounds(337, 438, 312, 30);
		contentPane.add(button);
		
		JLabel lblNewLabel_6 = new JLabel("Register Yourself Here...!!");
		lblNewLabel_6.setForeground(new Color(240, 255, 240));
		lblNewLabel_6.setBackground(Color.CYAN);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(20, 375, 287, 73);
		contentPane.add(lblNewLabel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(0, 338, 327, 154);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(Registration.class.getResource("/images/iconr.png")));
		lblNewLabel_7.setBounds(403, 11, 175, 205);
		contentPane.add(lblNewLabel_7);
	}
}
