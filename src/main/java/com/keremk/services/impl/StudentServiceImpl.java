package com.keremk.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keremk.dto.DtoCourse;
import com.keremk.dto.DtoStudent;
import com.keremk.dto.DtoStudentIU;
import com.keremk.entites.Course;
import com.keremk.entites.Student;
import com.keremk.repository.StudentRepository;
import com.keremk.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
		DtoStudent responseDtoStudent = new DtoStudent();
		Student student = new Student();

		BeanUtils.copyProperties(dtoStudentIU, student);
		Student dbStudent = studentRepository.save(student);
		BeanUtils.copyProperties(dbStudent, responseDtoStudent);

		return responseDtoStudent;
	}

	@Override
	public List<DtoStudent> getAllStudents() {

		List<DtoStudent> dtoStudentList = new ArrayList<>();
		List<Student> studentList = studentRepository.findAllStudents();
		for (Student student : studentList) {
			DtoStudent dtoStudent = new DtoStudent();
			BeanUtils.copyProperties(student, dtoStudent);
			dtoStudentList.add(dtoStudent);
		}

		return dtoStudentList;

	}

	@Override
	public DtoStudent getStudentById(Integer id) {
		DtoStudent dtoStudent = new DtoStudent();

		Optional<Student> optionalStudent = studentRepository.findById(id);
		if (optionalStudent.isPresent()) {
			Student dbStudent = optionalStudent.get();
			BeanUtils.copyProperties(dbStudent, dtoStudent);
			if (dbStudent.getCourses() != null && !dbStudent.getCourses().isEmpty()) {
				for (Course course : dbStudent.getCourses()) {
					 
					DtoCourse dtoCourse = new DtoCourse();
					BeanUtils.copyProperties(course,dtoCourse);
					dtoStudent.getCourses().add(dtoCourse);
					
					
				}
			}
					return dtoStudent;
		} else {
			return null;
		}

	}

	@Override
	public void deleteStudent(Integer id) {
		Optional<Student> studentOptional = studentRepository.findById(id);
		if (studentOptional.isPresent()) {
			studentRepository.delete(studentOptional.get());
		}

	}

	@Override
	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {

		DtoStudent dtoStudent = new DtoStudent();
		Optional<Student> dbStudentOptional = studentRepository.findById(id);

		if (dbStudentOptional.isPresent()) {

			Student dbStudent = dbStudentOptional.get();
			dbStudent.setFirstName(dtoStudentIU.getFirstName());
			dbStudent.setLastName(dtoStudentIU.getLastName());
			dbStudent.setBirthOfDate(dtoStudentIU.getBirthOfDate());

			Student updatedStudent = studentRepository.save(dbStudent);
			BeanUtils.copyProperties(updatedStudent, dtoStudent);
			return dtoStudent;

		}

		return null;
	}

}
