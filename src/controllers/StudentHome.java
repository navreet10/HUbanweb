package controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.LoginDao;
import model.Crn;
import model.Huuser;
import model.Instructor;
import model.Student;

/**
 * Servlet implementation class StudentHome
 */
@WebServlet("/StudentHome")
public class StudentHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			Huuser user = (Huuser) session.getAttribute("user");
			if ( user != null) {
				Student student = (Student) session.getAttribute("student");
				if (student != null) {
					List<Crn> classes = LoginDao.getClasses();
					List<Crn> classesRegistered = LoginDao.getClassesRegistered(student);
					Map<String, List<Crn>> classeSchedule = LoginDao.getClasseSchedule(classesRegistered);
					request.setAttribute("classes", classes);
					request.setAttribute("classesRegistered", classesRegistered);
					request.setAttribute("classeSchedule", classeSchedule);
					
				}
					session.setAttribute("user", user);			
								
					session.setAttribute("userName", user.getUsername());
					request.getRequestDispatcher("studentHome.jsp").forward(request, response);
			} else {
				String username= request.getParameter("name");
				System.out.println(username);
				String pwd= request.getParameter("password");
				System.out.println(pwd);
				user = LoginDao.getUser(username);	
				String type = request.getParameter("type");
				System.out.println(type);
				Student student = null;
				Instructor instructor = null;
				if (type.equals("Faculty")) {
					instructor = LoginDao.getInstructor(user);
					session.setAttribute("instructor", instructor);					
				} else {
					student = LoginDao.getStudent(user);
					session.setAttribute("student", student);
				}
				
				if (user == null || !LoginDao.isValidUser(user,pwd)) {
						request.setAttribute("message", "Credentials are wrong!!");
						request.getRequestDispatcher("login.jsp").forward(request, response);
				} else if (student == null && instructor == null) {
					request.setAttribute("message", "No such student exists!!");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				} else {
					if (student != null) {
						List<Crn> classes = LoginDao.getClasses();
						List<Crn> classesRegistered = LoginDao.getClassesRegistered(student);
						Map<String, List<Crn>> classeSchedule = LoginDao.getClasseSchedule(classesRegistered);
						request.setAttribute("classes", classes);
						request.setAttribute("classesRegistered", classesRegistered);
						request.setAttribute("classeSchedule", classeSchedule);
						
					}
						session.setAttribute("user", user);			
									
						session.setAttribute("userName", user.getUsername());
						request.getRequestDispatcher("studentHome.jsp").forward(request, response);
				}
				
				
			}
			
			
		} catch (NullPointerException e) {
			request.setAttribute("message", "Credentials are wrong!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} 
	}

}
