package com.assessment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.assessment.connect.databaseConnect;
import com.assessment.entity.Student;
import com.assessment.entity.Subject;
import com.assessment.entity.Teacher;



import com.assessment.entity.Class;



public class ListDao {
	public List<Student> queryStudentlist() throws SQLException {
		Connection con1=null;
		List<Student> students = new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
   try {
	   con1=databaseConnect.createConnection();
		String query = "Select * from students";
		 ps = con1.prepareStatement(query);
	     rs = ps.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String fname = rs.getString("fname");
			String lname = rs.getString("lname");
			int age=rs.getInt("age");
			int aclass=rs.getInt("class");
			Student tempStudent=new Student(id,fname,lname,age,aclass);
			students.add(tempStudent);
		}
		//return studentlist;
	} catch (Exception e) {
		// TODO: handle exception
	} finally {
		// close JDBC objects
		close(con1, ps, rs);
	}
		return students;
}
	public List<Subject> querySubjectlist() throws SQLException {
		Connection con1=null;
		
		List<Subject> subjects= new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
   try {
	   con1=databaseConnect.createConnection();
	   String query = "Select * from subjects";
		 ps = con1.prepareStatement(query);
	     rs = ps.executeQuery();
	
		while (rs.next()) {
			
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String shortcut = rs.getString("shortcut");

			// create new student object
			Subject temp = new Subject(id, name,shortcut);

			// add it to the list of students
			subjects.add(temp);
		}
		//return subjectlist;
	} catch (Exception e) {
		// TODO: handle exception
	} finally {
		// close JDBC objects
		close(con1, ps, rs);
	}
		return subjects;
}
	
	public List<Teacher> queryTeacherlist() throws SQLException {
		
		Connection con1=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<Teacher> teachers = new ArrayList<>();
   try {
	   con1=databaseConnect.createConnection();
	   String query = "Select * from teachers";
	  	 ps = con1.prepareStatement(query);
	     rs = ps.executeQuery();
	
		while (rs.next()) {
			
			int id = rs.getInt("id");
			String firstName = rs.getString("fname");
			String lastName = rs.getString("lname");
			int age = rs.getInt("age");
			Teacher temp = new Teacher(id, firstName, lastName, age);
			teachers.add(temp);
			
		}
		//return teacherlist;
	} catch (Exception e) {
		// TODO: handle exception
	} finally {
		// close JDBC objects
		close(con1, ps, rs);
	}
		return teachers;
}
	public List<Class> queryClasslist() throws SQLException {
		Connection con1=null;
		
		List<Class> classes = new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
try {
	con1=databaseConnect.createConnection();
	String query = "Select * from classes";
		ps = con1.prepareStatement(query);

		rs = ps.executeQuery();
		
		while (rs.next()) {

			// retrieve data from result set row
			int id = rs.getInt("id");
			int section = rs.getInt("section");
			int subject = rs.getInt("subject");
			int teacher = rs.getInt("teacher");
			String time = rs.getString("time");

			Teacher tempTeacher = loadTeacher(teacher);
			Subject tempSubject = loadSubject(subject);

			String teacher_name = tempTeacher.getFname() + " " + tempTeacher.getLname();
			
			Class temp = new Class(id, section, teacher_name, tempSubject.getName(), time);
	
			classes.add(temp);
		}
		return classes;
	} catch (Exception e) {
		// TODO: handle exception
		
	} finally {
		// close JDBC objects
		close(con1, ps, rs);
	}
	return classes;
}public static Teacher loadTeacher(int teacherId)throws SQLException {
	Connection con1=null;
	Teacher theTeacher = null;
	PreparedStatement ps=null;
	ResultSet rs=null;

	try {
		con1=databaseConnect.createConnection();
		String query = "SELECT * FROM teachers WHERE id = " + teacherId;
		ps = con1.prepareStatement(query);

		rs = ps.executeQuery();
		
				// process result
		while (rs.next()) {

			// retrieve data from result set row
			int id = rs.getInt("id");
			String fname = rs.getString("fname");
			String lname = rs.getString("lname");
			int age = rs.getInt("age");
			theTeacher = new Teacher(id, fname, lname, age);

		}
		return theTeacher;
	} catch (Exception e) {
		// TODO: handle exception
	} finally {
		// close JDBC objects
		close(con1, ps, rs);
	}
	return theTeacher;

}

public static Subject loadSubject(int subjectId) {
	Connection con1=null;
	Subject theSubject = null;

	PreparedStatement ps=null;
	ResultSet rs=null;

	try {
		con1=databaseConnect.createConnection();
		String sql = "SELECT * FROM subjects WHERE id = " + subjectId;
		ps = con1.prepareStatement(sql);

		rs = ps.executeQuery();

		
		while (rs.next()) {

			// retrieve data from result set row
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String shortcut = rs.getString("shortcut");

			theSubject = new Subject(id, name,shortcut);

		}
		return theSubject;
	} catch (Exception e) {
		// TODO: handle exception
	} finally {
		// close JDBC objects
		close(con1, ps, rs);
	}
	return theSubject;

}

@SuppressWarnings("unused")
public Class loadClass(int classId) {
	Connection con1=null;
	Class theClass = null;

	PreparedStatement ps=null;
	ResultSet rs=null;

	try {
		con1=databaseConnect.createConnection();
		String sql = "SELECT * FROM clasess WHERE id = " + classId;
		ps = con1.prepareStatement(sql);

		rs = ps.executeQuery();

		// process result
		while (rs.next()) {

			// retrieve data from result set row
			int id = rs.getInt("id");
			int section = rs.getInt("section");
			int subject = rs.getInt("subject");
			int teacher = rs.getInt("teacher");
			String time = rs.getString("time");

			Teacher tempTeacher = loadTeacher(teacher);
			Subject tempSubject = loadSubject(subject);

			String teacher_name = tempTeacher.getFname() + " " + tempTeacher.getLname();
			
		}
		return theClass;
	} catch (Exception e) {
		// TODO: handle exception
	} finally {
		// close JDBC objects
		close(con1, ps, rs);
	}
	return theClass;

}

public List<Student> loadClassStudents(int classId) {
	
	List<Student> students = new ArrayList<>();
	Connection con1=null;
	PreparedStatement ps=null;
	ResultSet rs=null;


	try {
		con1=databaseConnect.createConnection();
		String sql = "SELECT * FROM students WHERE class =" + classId;
		ps = con1.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
	
			int id = rs.getInt("id");
			String fname = rs.getString("fname");
			String lname = rs.getString("lname");
			int age = rs.getInt("age");
			int aclass = rs.getInt("class");
			Student tempStudent = new Student(id, fname, lname, age, aclass);
			students.add(tempStudent);
			}
	
	} catch (Exception e) {
		// TODO: handle exception
	} finally {
	
		close(con1, ps, rs);
	}
	return students;

}

private static void close(Connection con1, PreparedStatement ps, ResultSet rs) {

	try {
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		if (con1 != null) {
			con1.close();
		}

	} catch (Exception e) {
		e.printStackTrace();
	}

}

	
}
