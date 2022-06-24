package com.student.service;

import com.student.entity.Student;
import com.student.model.Student_Branch;

public interface StudentService {

	public Student saveStudent(Student student);

	public Student getStudentById(Integer studentId);

	public boolean deleteStudent(Integer studentId);

	public Student updateStudent(Student student);

	public Student_Branch getStudentBybranchbyId(Integer studentId);
}
