package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Crn;
import model.Grade;
import model.Huuser;
import model.Instructor;
import model.Student;
import util.DBUtil;

public class LoginDao {

	public static Huuser getUser(String username) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		TypedQuery<Huuser> query= em.createQuery("SELECT b FROM Huuser b "
				+ "where b.username = :name", Huuser.class);
		query.setParameter("name", username);
		Huuser user = null;
		try {
			user = query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return user;
	}
	
	public static Student getStudent(Huuser user) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		TypedQuery<Student> query= em.createQuery("SELECT b FROM Student b "
				+ "where b.huuser.username = :name", Student.class);
		query.setParameter("name", user.getUsername());
		Student student = null;
		try {
			System.out.println("ran query");
			student = query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return student;
	}

	public static boolean isValidUser(Huuser user, String pwd) {
		return user.getPwd().equals(pwd);
	}

	public static Instructor getInstructor(Huuser user) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Crn> getClasses() {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		TypedQuery<Crn> query= em.createQuery("SELECT b FROM Crn b", Crn.class);
		List<Crn> crns = null;
		try {
			crns = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return crns;
	}

	public static List<Crn> getClassesRegistered(Student student) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		/*TypedQuery<Grade>  query= em.createQuery("SELECT b FROM Grade b "
				+ "where b.student.studentid = :studentid", Grade.class);
		query.setParameter("studentid", student.getStudentid());
		List<Crn> crns = null;
		try {
			List<Grade> grade= query.getResultList();
			if (grade != null && grade.size() !=0) {
				crns = new ArrayList<>();
			}
			for(Grade g: grade) {
				crns.add(g.getCrn());
			}
			
		} */
		
		Query query = em.createQuery("SELECT b.crn FROM Grade b where b.student.studentid = :studentid",
				Grade.class);
		query.setParameter("studentid", student.getStudentid());
		List<Crn> crns = null;
		try {
			crns = query.getResultList();

		} catch (NoResultException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return crns;
	}

	public static Map<String, List<Crn>> getClasseSchedule(List<Crn> classesRegistered) {
		Map<String, List<Crn>> classeSchedule = new HashMap<String, List<Crn>>();
		List<Crn> mon = new ArrayList<Crn>();
		List<Crn> tue = new ArrayList<Crn>();
		List<Crn> wed = new ArrayList<Crn>();
		List<Crn> thu = new ArrayList<Crn>();
		List<Crn> fri = new ArrayList<Crn>();
		List<Crn> sat = new ArrayList<Crn>();
		
		for (Crn crn: classesRegistered) {
			if (crn.getDays().contains("1")) {
				mon.add(crn);
			}
			if (crn.getDays().contains("2")) {
				tue.add(crn);
			}
			if (crn.getDays().contains("3")) {
				wed.add(crn);
			}
			if (crn.getDays().contains("4")) {
				thu.add(crn);
			}
			if (crn.getDays().contains("5")) {
				fri.add(crn);
			}
			if (crn.getDays().contains("6")) {
				sat.add(crn);
			}			
		}
		if (mon.size()!=0)
			classeSchedule.put("Monday", mon);
		if (tue.size()!=0)
			classeSchedule.put("Tuesday", tue);
		if (wed.size()!=0)
			classeSchedule.put("Wednesday", wed);
		if (thu.size()!=0)
			classeSchedule.put("Thursday", thu);
		if (fri.size()!=0)
			classeSchedule.put("Friday", fri);
		if (sat.size()!=0)
			classeSchedule.put("Saturday", sat);
		return classeSchedule;
	}

	public static String enrollStudent(List<Crn> checked) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		TypedQuery<Crn> query= em.createQuery("SELECT b FROM Crn b", Crn.class);
		try {
		for (Crn crn: checked) {
			
			
		}} catch (NoResultException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
