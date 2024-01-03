package com.sblearn.cruddemo.dao;

import com.sblearn.cruddemo.entity.student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class studentDAOImpl implements studentDAO {
    //define entity manager for student
    private EntityManager entityManager;

    //inject entity manager using constructor

    @Autowired
    public studentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional //from spring framework
    public void save(student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public student findByID(Integer Id) {
        return entityManager.find(student.class, Id);
    }

    @Override
    public List<student> findAll() {
        //everything mentioned in createQuery string is JPA's class name and class entity name...but never the db or table or column name.
        TypedQuery<student> theQuery = entityManager.createQuery("from student", student.class);
//        TypedQuery<student> theQuery = entityManager.createQuery("from student order by lastName asc", student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<student> findByLastName(String lastName) {
        //everything mentioned in createQuery string is JPA's named parameter starts with colon ie :

        TypedQuery<student> theQuery = entityManager.createQuery("from student where lastName = :theData", student.class);
        theQuery.setParameter("theData", lastName);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        student theStudent = entityManager.find(student.class, id);
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numOfRecDeleted = entityManager.createQuery("delete from student").executeUpdate();
        return numOfRecDeleted;
    }
}
