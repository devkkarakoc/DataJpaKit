package com.keremk.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.keremk.entites.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	
	//SQL TABLO isimleri kullanılır -- nativeQuery = true
	@Query(value = "select*from student.student ",nativeQuery = true)
	List<Student> findAllStudents();
	//HİBERNATE QUERY LANGUAGE -- HQL-- CLASS isimleri kullanılır -- nativeQuery = false)
	@Query(value="from Student s where s.id=:id",nativeQuery = false)
	Optional<Student> findStudentById(Integer id);

}
