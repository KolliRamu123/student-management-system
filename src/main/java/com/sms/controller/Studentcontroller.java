package com.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.entity.Student;
import com.sms.entity.exception.StudentNotFoundException;
import com.sms.entity.exception.StudentRollNoAlreadyExistsException;
import com.sms.service.StudentService;
@CrossOrigin
@RestController
public class Studentcontroller {
	@Autowired
	private StudentService studentservice;
	
	@PostMapping("/addstudent")
	public ResponseEntity<Student>addStudent(@RequestBody Student student) throws StudentRollNoAlreadyExistsException{
		Student add=studentservice.addStudent(student);
		return new ResponseEntity<Student>(add, HttpStatus.OK);
	}
	@GetMapping("/getstudents")
	public ResponseEntity<List<Student>>getstudent(){
		List<Student> getlist=studentservice.getAllStudents();
		return new ResponseEntity<List<Student>>(getlist,HttpStatus.OK);
	}
	@GetMapping("/getstudent")
	public ResponseEntity<Student> getstudentbyid(@RequestParam long id) throws StudentNotFoundException{
		Student getbyid=studentservice.getStudent(id);
		return new ResponseEntity<Student>(getbyid, HttpStatus.OK);
	}
	@PutMapping("/updatestudent")
	public ResponseEntity<Student>updatestudent(@RequestParam long id,@RequestBody Student student) throws StudentNotFoundException{
		Student update=studentservice.updateStudent(id, student);
		return new ResponseEntity<Student>(update, HttpStatus.OK);

	}
	@DeleteMapping("/deletestudent")
	public ResponseEntity<String>deletestudent(@RequestParam long id) throws StudentNotFoundException{
		String delete=studentservice.removeStudent(id);
		return new ResponseEntity<String>(delete, HttpStatus.OK);

	}
}
