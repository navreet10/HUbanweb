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
import model.Student;
import util.Email;

/**
 * Servlet implementation class SendQuery
 */
@WebServlet("/SendQuery")
public class SendQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendQuery() {
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
			Student student = (Student) session.getAttribute("student");
			String profName= request.getParameter("insEmail");
			String content = request.getParameter("content");
			if ( user == null) {
				request.setAttribute("message", "Log in!!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				String email = LoginDao.getEmailProf(profName);
				if (email == null)  {
					request.setAttribute("message", "Incorrect Username!!");
				} else {
					Email.sendEmail(email, student.getHuuser().getEmail(), "Query from student " + student.getHuuser().getUsername(),
							content, true);					
				}
				List<Crn> classes = LoginDao.getClasses();
				List<Crn> classesRegistered = LoginDao.getClassesRegistered(student);
				Map<String, List<Crn>> classeSchedule = LoginDao.getClasseSchedule(classesRegistered);
				request.setAttribute("classes", classes);
				request.setAttribute("classesRegistered", classesRegistered);
				request.setAttribute("classeSchedule", classeSchedule);
				request.getRequestDispatcher("studentHome.jsp").forward(request, response);
				
			}
			
			
		} catch (NullPointerException e) {
			request.setAttribute("message", "Something went wrong!!");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "Something went wrong!!");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		} 
	}

}
