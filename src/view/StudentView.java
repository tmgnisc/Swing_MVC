package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.BorderLayout;
import java.awt.EventQueue;
import model.*;
import controller.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class StudentView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fnametxt;
	private JTextField lnametxt;
	private JTextField citytxt;
	private JTextField numbertxt;
	private JTextField agetxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentView frame = new StudentView();
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
	public StudentView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 637);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STUDENT RECORD");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(271, 37, 206, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FIRST NAME:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(35, 118, 235, 62);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("LAST NAME:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(35, 205, 235, 62);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("CITY:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(35, 288, 235, 62);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("PHONE NUMBER:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(35, 366, 235, 62);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("AGE:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(35, 439, 235, 62);
		contentPane.add(lblNewLabel_1_4);
		
		fnametxt = new JTextField();
		fnametxt.setBounds(254, 124, 328, 56);
		contentPane.add(fnametxt);
		fnametxt.setColumns(10);
		
		lnametxt = new JTextField();
		lnametxt.setColumns(10);
		lnametxt.setBounds(254, 205, 328, 56);
		contentPane.add(lnametxt);
		
		citytxt = new JTextField();
		citytxt.setColumns(10);
		citytxt.setBounds(254, 294, 328, 56);
		contentPane.add(citytxt);
		
		numbertxt = new JTextField();
		numbertxt.setColumns(10);
		numbertxt.setBounds(254, 372, 328, 56);
		contentPane.add(numbertxt);
		
		agetxt = new JTextField();
		agetxt.setColumns(10);
		agetxt.setBounds(254, 439, 328, 56);
		contentPane.add(agetxt);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Student std =new Student();
				
				std.setFname(fnametxt.getText());
				std.setLname(lnametxt.getText());
				std.setAge(Integer.valueOf(agetxt.getText()));
				std.setCity(citytxt.getText());
				std.setNumber(numbertxt.getText());
				
				StudentController sc = new StudentImple();
				if(sc.addStudent(std))
				{
					JOptionPane.showMessageDialog(null, "Data is added");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Data is not added");
				}
				
				
							
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnNewButton.setBounds(274, 527, 280, 62);
		contentPane.add(btnNewButton);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TableView().setVisible(true);
				dispose();
			}
		});
		btnView.setBounds(611, 551, 117, 25);
		contentPane.add(btnView);
	}
}