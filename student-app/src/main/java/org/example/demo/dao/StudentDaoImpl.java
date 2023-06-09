package org.example.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.example.demo.facory.MyFactory;
import org.example.demo.model.Student;
import org.hibernate.Session;

public class StudentDaoImpl implements StudentDao {

	private Session session;

	{
		session = MyFactory.getSessionFactory().openSession();
	}

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		session.getTransaction().begin();
		session.save(student);
		session.getTransaction().commit();
		return student;
	}

	@Override
	public void deleteStudentById(int studentId) {
		session.getTransaction().begin();
		Student s = session.get(Student.class, studentId);

		if (s == null) {
			System.out.println("no such id found: " + studentId);
		} else {
			session.delete(s);
			System.out.println("Deleted...");
		}
		session.getTransaction().commit();

	}

	@Override
	public void deleteAllStudents() {
		session.getTransaction().begin();

		Query query = session.createQuery("FROM Student", Student.class);
		List<Student> list = query.getResultList();
		for (Student s : list) {
			session.delete(s);
		}
		session.getTransaction().commit();

	}

	@Override
	public Student updateStudent(int studentId, Student student) {
		session.getTransaction().begin();
		Student s = session.get(Student.class, studentId);
		if (s == null) {
			System.out.println("No Result Found");
		} else {
			s.setFirstName(student.getFirstName());
			s.setLastName(student.getLastName());
			s.setEmail(student.getEmail());
			session.merge(s);
			session.getTransaction().commit();
		}
		return student;
	}

	@Override
	public Student findStudentById(int studentId1) {
		session.getTransaction().begin();
		Student s = session.get(Student.class, studentId1);
		session.getTransaction().commit();
		System.out.println(s);
		return s;
	}

	@Override
	public void viewAllStudentDetails() {
		session.getTransaction().begin();

		Query query = session.createQuery("FROM Student", Student.class);
		List<Student> list = query.getResultList();
		for (Student s : list) {
			System.out.println(s);
		}
		session.getTransaction().commit();
	}

}
