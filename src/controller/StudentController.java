package controller;
import java.util.List;

import model.*;

public interface StudentController {
 

public boolean addStudent(Student std);
	
	public List<Student> getAllData(); 

	public List<Student> searchStudentByID(int id);
	
	public boolean editStudent(Student std);
	
	
	public void deleteStudent(int id);
}

