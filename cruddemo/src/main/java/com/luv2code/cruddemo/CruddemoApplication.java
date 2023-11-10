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
		
		return runner->{
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO){
		//creating multiple student objects
		System.out.println("Creating three new students.....");
		Student tempStudent1 = new Student("Meet", "Shah", "meetshah.sr@gmail.com");
		Student tempStudent2 = new Student("Prexu", "Shah", "prexushah.sr@gmail.com");
		Student tempStudent3 = new Student("Kunj", "Shah", "kunjshah.sr@gmail.com");

		//save the student object
		System.out.println("Saving the students....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		//display id of the saved student
		System.out.println("New student created with ID: "+tempStudent1.getId());
		System.out.println("New student created with ID: "+tempStudent2.getId());
		System.out.println("New student created with ID: "+tempStudent3.getId());
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
