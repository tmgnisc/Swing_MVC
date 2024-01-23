package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.StudentController;
import controller.StudentImple;
import model.Student;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TableView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField idTextfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableView frame = new TableView();
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
	public TableView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 92, 543, 406);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "First Name", "Last Name", "City", "Number", "Age"
			}
		));
		
		JTableHeader tableHeader= new JTableHeader();
		tableHeader=table.getTableHeader();
		tableHeader.setFont(new Font("Arial",Font.BOLD,16));
		tableHeader.setForeground(new Color(0,0,0));
		
		
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("SEARCH BY ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(617, 99, 161, 42);
		contentPane.add(lblNewLabel);
		
		idTextfield = new JTextField();
		idTextfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				int id;
				if(idTextfield.getText().isEmpty())
				{
					showTableData();
				}
				else
				{
				id= Integer.valueOf(	idTextfield.getText());
				
				
				showTableDataById(id);
				
				}
			}
		});
		idTextfield.setBounds(591, 144, 215, 49);
		contentPane.add(idTextfield);
		idTextfield.setColumns(10);
		
		JButton btnNewButton = new JButton("REFRESH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTableData();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(597, 27, 181, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EDIT A DATA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int row=table.getSelectedRow();
				
				if(row == -1) {
					JOptionPane.showMessageDialog(null, "Please select a Row");
				}
				
				int id=(int) table.getValueAt(row, 0);
				
				
				EditView ev = new EditView();
				ev.showsDataOnEditView(id); 
				ev.setVisible(true);
				
				dispose();
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(594, 238, 212, 57);
		contentPane.add(btnNewButton_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 int row = table.getSelectedRow();
	                if (row == -1) {
	                    
	                    return;
	                }
	                int id = (int) table.getValueAt(row, 0);
	                

	                int option = JOptionPane.showConfirmDialog(TableView.this, "Are you sure you want to delete this record?", "Confirmation", JOptionPane.YES_NO_OPTION);
	                if (option == JOptionPane.YES_OPTION) {
	                  
	                    deleteStudentById(id);

	                   
	                    showTableData();
	                }
	            }
	        });
		btnDelete.setBounds(661, 328, 117, 25);
		contentPane.add(btnDelete);
				
		showTableData(); 
	}
	
	public void showTableData()
	{
		
		StudentController sc= new StudentImple();
		List<Student>stdList=sc.getAllData();
		
		DefaultTableModel Model=(DefaultTableModel) table.getModel();
		Model.setRowCount(0);
		
		for(Student std:stdList)
		{
		Model.addRow(new Object[] {std.getId(),std.getFname(),std.getLname(),std.getCity(),std.getNumber(),std.getAge()});

		}
		
	}
	
	public void showTableDataById(int id)
	{

		StudentController sc= new StudentImple();
		List<Student>stdList=sc.searchStudentByID(id);
		
		DefaultTableModel Model=(DefaultTableModel) table.getModel();
		Model.setRowCount(0);
		
		for(Student std:stdList)
		{
		Model.addRow(new Object[] {std.getId(),std.getFname(),std.getLname(),std.getCity(),std.getNumber(),std.getAge()});

		}
		
		
		
		
	}
	
	
	 public void deleteStudentById(int id) {
	        StudentController sc = new StudentImple();
	        sc.deleteStudent(id);
	    }
	
}	