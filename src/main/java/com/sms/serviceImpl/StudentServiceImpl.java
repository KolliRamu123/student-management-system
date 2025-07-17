package com.sms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entity.Student;
import com.sms.entity.exception.StudentNotFoundException;
import com.sms.entity.repository.StudentRepository;
import com.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
    
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		Student save=studentRepository.save(student);
		return save;
	}

	@Override
	public Student updateStudent(long studentId, Student student) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		Student updateStudent=studentRepository.findById(studentId)
				.orElseThrow(()->new StudentNotFoundException("StudentId not Found with "+studentId));
		updateStudent.setStudentName(updateStudent.getStudentName());
		updateStudent.setAddress(updateStudent.getAddress());
		updateStudent.setAdmissionDate(updateStudent.getAdmissionDate());
		updateStudent.setAge(updateStudent.getAge());
		updateStudent.setContactNumber(updateStudent.getContactNumber());
		updateStudent.setCourse(updateStudent.getCourse());
		updateStudent.setEmail(updateStudent.getEmail());
		updateStudent.setDepartment(updateStudent.getDepartment());
		updateStudent.setYearOfStudy(updateStudent.getYearOfStudy());
		updateStudent.setGender(updateStudent.getGender());
		updateStudent.setRollNumber(updateStudent.getRollNumber());
		studentRepository.save(updateStudent);
		return updateStudent;
	}

	@Override
	public Student getStudent(long studentId) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		Student getStudent=studentRepository.findById(studentId)
				.orElseThrow(()->new StudentNotFoundException("StudentId not Found with "+studentId));
	    
		return getStudent;
	}

	@Override
	public String removeStudent(long studentId) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		Student removeStudent=studentRepository.findById(studentId)
				.orElseThrow(()->new StudentNotFoundException("StudentId not Found with "+studentId));
	    studentRepository.delete(removeStudent);
		return "Student deleted Successfully..!!";
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		List<Student> getAllStudents=studentRepository.findAll();
		return getAllStudents;
	}

}
