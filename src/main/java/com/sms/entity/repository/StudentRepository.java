package com.sms.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

import com.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{
=======
import org.springframework.stereotype.Repository;

import com.sms.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
>>>>>>> ramu

}
