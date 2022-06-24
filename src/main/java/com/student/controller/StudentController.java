package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.entity.Student;
import com.student.model.Student_Branch;
import com.student.service.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	StudentService service;

	@PostMapping(value = "/save")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {

		Student std = service.saveStudent(student);
		if (std != null) {
			return new ResponseEntity<>(std, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(std, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(value = "/getStudentById/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer studentId) {
		Student std = service.getStudentById(studentId);

		System.out.println(std);
		if (std != null) {
			return new ResponseEntity<>(std, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(std, HttpStatus.NO_CONTENT);
		}

	}

	@DeleteMapping(value = "/deleteStudentById/{studentId}")
	public ResponseEntity<Boolean> deleteStudent(@PathVariable Integer studentId) {
		Boolean flag = service.deleteStudent(studentId);

		if (flag) {
			return new ResponseEntity<>(flag, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(flag, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/updateStudent")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {

		Student std = service.updateStudent(student);
		if (std != null) {
			return new ResponseEntity<Student>(std, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(std, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getStudentBybranchbyId/{studentId}")
	public ResponseEntity<Student_Branch> getStudentBybranchbyId(@PathVariable Integer studentId) {
		Student_Branch student_branch = service.getStudentBybranchbyId(studentId);
		if (student_branch != null) {
			return new ResponseEntity<Student_Branch>(student_branch, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(student_branch, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
