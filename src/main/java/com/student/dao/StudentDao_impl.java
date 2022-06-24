package com.student.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.student.entity.Student;
import com.student.model.Branch;
import com.student.model.Student_Branch;

@Repository
public class StudentDao_impl implements StudentDao {

	

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	org.hibernate.SessionFactory sf;

	@Override
	public Student saveStudent(Student student) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(student);
			tx.commit();

		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			session.close();
		}
		return student;
	}

	@Override
	public Student getStudentById(Integer studentId) {
		Session session = sf.openSession();
		Student stud = null;
		try {

			stud = session.get(Student.class, studentId);

		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			session.close();
		}

		return stud;
	}

	@Override
	public boolean deleteStudent(Integer studentId) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		boolean flag = true;
		try {
			Student student = session.load(Student.class, studentId);
			session.delete(student);
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
			flag = false;
			return flag;
		} finally {
			session.close();
		}
		return flag;
	}

	@Override
	public Student updateStudent(Student student) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Student stud = session.load(Student.class, student.getStudentId());
			session.update(stud);
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return student;
	}

	@Override
	public Student_Branch getStudentBybranchbyId(Integer studentId) {

		Student student = getStudentById(studentId);
		Student_Branch student_Branch = new Student_Branch();
		 //this is what calling one service from another service
		Branch branch = restTemplate.getForObject("http://localhost:8081/branch/getBranchById/" + student.getBranchId(),
				Branch.class);
		student_Branch.setStudent(student);
		student_Branch.setBranch(branch);

		System.out.println(student_Branch);
		return student_Branch;
	}

}
