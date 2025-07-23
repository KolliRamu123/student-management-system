package com.sms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entity.Student;
import com.sms.entity.exception.StudentNotFoundException;
import com.sms.entity.exception.StudentRollNoAlreadyExistsException;
import com.sms.entity.repository.StudentRepository;
import com.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override

	public Student addStudent(Student student) throws StudentRollNoAlreadyExistsException{
		if (studentRepository.existsByRollNumber(student.getRollNumber().trim())) {
			throw new StudentRollNoAlreadyExistsException("Student Already Exists");
		} else {
			Student save = studentRepository.save(student);
			return save;
		}
	}

	@Override
	public Student updateStudent(long studentId, Student student) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		Student updateStudent = studentRepository.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException("StudentId not Found with " + studentId));
		updateStudent.setStudentName(student.getStudentName());
		updateStudent.setAddress(student.getAddress());
		updateStudent.setAdmissionDate(student.getAdmissionDate());
		updateStudent.setAge(student.getAge());
		updateStudent.setContactNumber(student.getContactNumber());
		updateStudent.setCourse(student.getCourse());
		updateStudent.setEmail(student.getEmail());
		updateStudent.setDepartment(student.getDepartment());
		updateStudent.setYearOfStudy(student.getYearOfStudy());
		updateStudent.setGender(student.getGender());
		updateStudent.setRollNumber(student.getRollNumber());
		return studentRepository.save(updateStudent);
	}

	@Override
	public Student getStudent(long studentId) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		Student getStudent = studentRepository.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException("StudentId not Found with " + studentId));

		return getStudent;
	}

	@Override
	public String removeStudent(long studentId) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		Student removeStudent = studentRepository.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException("StudentId not Found with " + studentId));
		studentRepository.delete(removeStudent);
		return "Student deleted Successfully..!!";
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		List<Student> getAllStudents = studentRepository.findAll();
		return getAllStudents;
	}

}
