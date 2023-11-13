package com.luv2code.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // Define field for entity manager
    private EntityManager entitManager;

    // Define entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entitManager) {
        this.entitManager = entitManager;
    }

    //Define Save method
    @Override
    @Transactional
    public void save(Student theStudent) {
      entitManager.persist(theStudent);  
    }

    @Override
    public Student findById(Integer id) {
        return entitManager.find(Student.class, id);
    }

    @Override
    public List<Student> finfAll() {
        //Create Query
        TypedQuery<Student> theQuery = entitManager.createQuery("FROM Student order by firstName asc", Student.class);

        //Return Query Results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //Find student by Id
        Student thesStudent = entitManager.find(Student.class, id);

        //Delete the Student 
        entitManager.remove(thesStudent);
    }

    @Override
    @Transactional
    public int deleteall() {
        int numRowsDeleted = entitManager.createQuery("DELETE From Student").executeUpdate();

        return numRowsDeleted;
    }
    
    
}
