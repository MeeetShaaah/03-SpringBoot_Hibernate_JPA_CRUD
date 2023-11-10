package com.luv2code.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
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

}
