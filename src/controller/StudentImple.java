package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Student;

public class StudentImple implements StudentController{
	
	Connection conn = null;
	public StudentImple()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studenttable","root","");			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
	
	@Override
	public boolean addStudent(Student std) {
		
		
		String sql="insert into studentdb (fname,lname,city,number,age) values(?,?,?,?,?)";
		try {
			PreparedStatement pstm= conn.prepareStatement(sql);
			pstm.setString(1,std.getFname());
			pstm.setString(2,std.getLname());
			pstm.setString(3, std.getCity());
			pstm.setString(4, std.getNumber());
			pstm.setInt(5, std.getAge());
			pstm.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}





	public List<Student> getAllData()
	{
		String sql="select * from studentdb";
		List<Student> stdList= new ArrayList<>();
		try {
			Statement stm= conn.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
			{
				Student std= new Student();
				
				std.setId(rs.getInt("id"));
				std.setFname(rs.getString("fname"));
				std.setLname(rs.getString("lname"));
				std.setCity(rs.getString("city"));
				std.setNumber(rs.getString("number"));
				std.setAge(rs.getInt("age"));
				
				stdList.add(std);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return stdList;	
	}





	@Override
	public List<Student> searchStudentByID(int id) {
		
		String sql= "select * from studentdb where id="+id;
		
		List<Student> stdList= new ArrayList<>();
		try {
			Statement stm= conn.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
			{
				Student std= new Student();
				
				std.setId(rs.getInt("id"));
				std.setFname(rs.getString("fname"));
				std.setLname(rs.getString("lname"));
				std.setCity(rs.getString("city"));
				std.setNumber(rs.getString("number"));
				std.setAge(rs.getInt("age"));
				
				stdList.add(std);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return stdList;	
			
		
	}
	
	@Override
    public void deleteStudent(int id) {
        String sql = "DELETE FROM studentdb WHERE id = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	
	public boolean editStudent(Student std)
	{
		
String sql= "update studentdb set fname=?,lname=?,age=?,city=?,number=? where id=?";
try {
	PreparedStatement pstm= conn.prepareStatement(sql);
	pstm.setString(1, std.getFname());
	pstm.setString(2, std.getLname());
	pstm.setInt(3, std.getAge());
	pstm.setString(4, std.getCity());
	pstm.setString(5, std.getNumber());
	pstm.setInt(6, std.getId());
	pstm.execute();	
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}		
		
		
		
		
		return true;
		
	}


}
