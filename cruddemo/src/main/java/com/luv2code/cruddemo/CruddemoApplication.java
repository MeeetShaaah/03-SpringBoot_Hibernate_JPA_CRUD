package com.luv2code.cruddemo;

import java.util.List;

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
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO); 
			queryForStudents(studentDAO);
		};
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get the List of students
		List<Student> theStudents = studentDAO.finfAll();

		//display list of studnets
		for (Student tempStudent : theStudents ){
			System.out.println(tempStudent);
		}
	}

	// Create Student Method
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

	// Create Multiple Student Method
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

	//Create Read Method for Student Database
	private void readStudent(StudentDAO studentDAO){
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

		//Display Id of the saved student
		int theId1= tempStudent1.getId();
		int theId2= tempStudent2.getId();
		int theId3= tempStudent3.getId();
		System.out.println("Saved student with generated ID: " + theId1);
		System.out.println("Saved student with generated ID: " + theId2);
		System.out.println("Saved student with generated ID: " + theId3);

		//retrive the student baased on id: primary key
		System.out.println("Retriving the student by id " + theId1);
		Student retrievedStudent1 = studentDAO.findById(theId1);

		System.out.println("Retriving the student by id " + theId2);
		Student retrievedStudent2 = studentDAO.findById(theId2);

		System.out.println("Retriving the student by id " + theId3);
		Student retrievedStudent3 = studentDAO.findById(theId3);

		//Display Student
		System.out.println("Student 1:" + retrievedStudent1);
		System.out.println("Student 2:" + retrievedStudent2);
		System.out.println("Student 3:" + retrievedStudent3);
	}
}
	