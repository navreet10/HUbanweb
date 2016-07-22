package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
		TypedQuery<Huuser> query = em.createQuery("SELECT b FROM Huuser b " + "where b.username = :name", Huuser.class);
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
		TypedQuery<Student> query = em.createQuery("SELECT b FROM Student b " + "where b.huuser.username = :name",
				Student.class);
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
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		TypedQuery<Instructor> query = em.createQuery("SELECT b FROM Instructor b " + "where b.huuser.username = :name",
				Instructor.class);
		query.setParameter("name", user.getUsername());
		Instructor instructor = null;
		try {
			System.out.println("ran query");
			instructor = query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return instructor;
	}

	public static List<Crn> getClasses() {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		TypedQuery<Crn> query = em.createQuery("SELECT b FROM Crn b", Crn.class);
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
		Query query = em.createQuery("SELECT b.crn FROM Grade b where b.student.studentid = :studentid", Grade.class);
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

		for (Crn crn : classesRegistered) {
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
		if (mon.size() != 0)
			classeSchedule.put("Monday", mon);
		if (tue.size() != 0)
			classeSchedule.put("Tuesday", tue);
		if (wed.size() != 0)
			classeSchedule.put("Wednesday", wed);
		if (thu.size() != 0)
			classeSchedule.put("Thursday", thu);
		if (fri.size() != 0)
			classeSchedule.put("Friday", fri);
		if (sat.size() != 0)
			classeSchedule.put("Saturday", sat);
		return classeSchedule;
	}

	public static String enrollStudent(List<Crn> checked, Student student) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		String message = "";
		try {
			TypedQuery<Grade> query = em
					.createQuery("SELECT b FROM Grade b where " + "b.student.studentid = :studentid", Grade.class);
			query.setParameter("studentid", student.getStudentid());
			List<Grade> coursesRegistered = query.getResultList();
			List<Crn> errors = new ArrayList<Crn>();
			for (Crn crn : checked) {
				TypedQuery<Grade> query1 = em.createQuery(
						"SELECT b FROM Grade b where b.crn.crnid = :crnid " + "and b.student.studentid = :studentid",
						Grade.class);
				query1.setParameter("crnid", crn.getCrnid());
				query1.setParameter("studentid", student.getStudentid());
				Grade grade = null;
				try {
					grade = query1.getSingleResult();
				} catch (NoResultException e) {
					
				}				
				if (grade != null) {
					message += "Course " + crn.getCourse().getName() + " already registered.\n";
					errors.add(crn);
				} else {
					for (Grade course : coursesRegistered) {
						String[] days = course.getCrn().getDays().split("");
						String[] daysAl = crn.getDays().split("");
						for (String d : days) {
							for (String d1 : daysAl) {
								if (d.equals(d1)) {
									if (Integer.parseInt(crn.getTimeofclass()) < Integer
											.parseInt(course.getCrn().getTimeofclass())
											|| Integer.parseInt(crn.getTimeofclass()) > (Integer
													.parseInt(course.getCrn().getTimeofclass() + 1))) {
										message += "Course " + crn.getCourse().getName()
												+ " conflicts with your schedule.\n";
										errors.add(crn);
									}
								}
							}
						}
					}
				}
			}
			checked.removeAll(errors);
			for (Crn crn : checked) {
				Grade grade = new Grade();
				grade.setCrn(crn);
				grade.setGrade("NA");
				grade.setStudent(student);
				EntityTransaction trans = em.getTransaction();
				trans.begin();
				em.persist(grade);
				trans.commit();
			}

		} catch (NoResultException e) {
			return "error";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		} finally {
			em.close();
		}
		if (message.equals(""))
			return null;
		else
			return message;
	}

	public static void dropClass(List<Crn> checked, Student student) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		try {
			for (Crn crn : checked) {
				TypedQuery<Grade> query = em
						.createQuery("SELECT b FROM Grade b where b.crn.crnid = :crnid and b.student.studentid = :studentid",
								Grade.class);

				query.setParameter("crnid", crn.getCrnid());
				query.setParameter("studentid", student.getStudentid());
				Grade  grade = query.getSingleResult();
				if (grade != null) {
					 EntityTransaction trans = em.getTransaction();
					 trans.begin();
			         em.remove(em.merge(grade));
			         trans.commit();
				}
			}
		} catch (NoResultException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public static String getEmailProf(String profName) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		TypedQuery<String> query = em.createQuery("SELECT b.email FROM Huuser b where b.username = :profName", String.class);
		query.setParameter("profName", profName);
		String email = null;
		try {
			email = query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return email;
	}

	public static List<Crn> getClassesInstructor(Instructor instructor) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		TypedQuery<Crn> query = em.createQuery("SELECT b FROM Crn b where b.instructor.instructorid "
				+ "= :instructorid", Crn.class);
		query.setParameter("instructorid", instructor.getInstructorid());
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

	public static Map<Crn, List<Student>> getStudentDetails(List<Crn> classes) {
		Map<Crn, List<Student>> studentDetails = new HashMap<Crn, List<Student>>();
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		try {
			for (Crn crn : classes) {
				TypedQuery<Student> query = em.createQuery("SELECT b.student FROM Grade b where b.crn.crnid "
						+ "= :crnid", Student.class);
				query.setParameter("crnid", crn.getCrnid());
				List<Student> students = query.getResultList();
				studentDetails.put(crn, students);
			}
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
		return studentDetails;
		
	}

	public static String persistUser(Huuser user) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            return"Try using a different username";
        } finally {
            em.close();
        }
		return "Successfully Registered!!";
	}

}
