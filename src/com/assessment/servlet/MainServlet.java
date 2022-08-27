package com.assessment.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assessment.dao.ListDao;
import com.assessment.entity.Class;
import com.assessment.entity.Student;
import com.assessment.entity.Subject;
import com.assessment.entity.Teacher;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ListDao lDao;

    @Override
    public void init() {
        lDao = new ListDao();
    } 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();

		try {
        	if(action==null)
        	{
        		action="CLASSES";
        	}
        	else
        	{
				switch (action) {

				case "/STUDENTS":
					studentsList(request, response);
					break;

				case "/TEACHERS":
					teachersList(request, response);
					break;

				case "/SUBJECTS":
					subjectList(request, response);
					break;

				case "/CLASSES":
					classestList(request, response);
					break;

				case "/ST_LIST":
					classStudentsList(request, response);
					break;
				
				default:
					classestList(request, response);

				}
				}
			
	 		  } catch (Exception ex) {
            throw new ServletException(ex);
	 		  }
         }
	private void studentsList(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		List<Student> students = lDao.queryStudentlist();
		request.setAttribute("STUDENTS_LIST", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
		dispatcher.forward(request, response);

	}

	private void teachersList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Teacher> teachers = lDao.queryTeacherlist();
		request.setAttribute("TEACHERS_LIST", teachers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("teachers-list.jsp");
		dispatcher.forward(request, response);
	}

	private void subjectList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Subject> subjects = lDao.querySubjectlist();
		request.setAttribute("SUBJECTS_LIST", subjects);
		RequestDispatcher dispatcher = request.getRequestDispatcher("subject-list.jsp");
		dispatcher.forward(request, response);

	}

	private void classestList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Class> classes = lDao.queryClasslist();
		request.setAttribute("CLASSES_LIST", classes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("class-list.jsp");
		dispatcher.forward(request, response);

	}
	private void classStudentsList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int id = Integer.parseInt(request.getParameter("id"));
		List<Student> students = lDao.loadClassStudents(id);
		String section = request.getParameter("section");
		String subject = request.getParameter("subject");
		request.setAttribute("STUD_LIST", students);
		request.setAttribute("SECTION", section);
		request.setAttribute("SUBJECT", subject);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Class_StudentList.jsp");
		dispatcher.forward(request, response);

	}
	}


