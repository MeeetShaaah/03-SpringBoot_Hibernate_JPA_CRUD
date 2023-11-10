package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;

@SpringBootApplication 
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		
		return runner->{createStudent(studentDAO);};
	}

	private void createStudent(StudentDAO studentDAO){
		//create the student object
		System.out.println("Creating new student Object....");
		Student tempStudent = new Student("Meet", "Shah", "meetshah.sr@gmail.com");
		
		//save the student object
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent);
		
		//display id of the saved student
		System.out.println("New student created with ID: "+tempStudent.getId());
	}
}
