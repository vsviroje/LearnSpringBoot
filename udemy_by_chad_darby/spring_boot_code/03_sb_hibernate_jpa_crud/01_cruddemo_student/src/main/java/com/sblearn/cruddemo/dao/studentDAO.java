package com.sblearn.cruddemo.dao;

import com.sblearn.cruddemo.entity.student;

import java.util.List;

public interface studentDAO {
    void save(student theStudent);

    student findByID(Integer Id);

    List<student> findAll();

    List<student> findByLastName(String lastName);

    void update(student theStudent);

    void delete(Integer id);

    int deleteAll();

}
