package com.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.StudentDao;
import com.student.entity.Student;
import com.student.model.Student_Branch;

@Service
public class StudentService_impl implements StudentService {

	@Autowired
	StudentDao dao;

	@Override
	public Student saveStudent(Student student) {
		Student std = dao.saveStudent(student);
		return std;
	}

	@Override
	public Student getStudentById(Integer studentId) {
		Student std = dao.getStudentById(studentId);
		return std;
	}

	@Override
	public boolean deleteStudent(Integer studentId) {
		boolean flag = dao.deleteStudent(studentId);

		return flag;
	}

	@Override
	public Student updateStudent(Student student) {

		Student std = dao.updateStudent(student);
		return std;
	}

	@Override
	public Student_Branch getStudentBybranchbyId(Integer studentId) {

		return dao.getStudentBybranchbyId( studentId);
	}

}
