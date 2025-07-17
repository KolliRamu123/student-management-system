package com.sms.service;

import java.util.List;

import com.sms.entity.Student;
import com.sms.entity.exception.StudentNotFoundException;

public interface StudentService {

	Student addStudent(Student student);
	
	Student updateStudent(long studentId,Student student) throws StudentNotFoundException;
	
	Student getStudent(long studentId) throws StudentNotFoundException;
	
	String  removeStudent(long studentId) throws StudentNotFoundException ;
	
	List<Student> getAllStudents();
	
	
}
