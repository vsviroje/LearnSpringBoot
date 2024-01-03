package com.sblearn.cruddemo;

import com.sblearn.cruddemo.dao.studentDAO;
import com.sblearn.cruddemo.entity.student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(studentDAO theStudentDAO) {
        return runner -> {
            System.out.println("commandLineRunner started");
//            deleteAllStudent(theStudentDAO);
//            deleteStudent(theStudentDAO);
//            updateStudent(theStudentDAO);
//            queryForStudentByLastName(theStudentDAO);
//            createAndReadStudent(theStudentDAO);
            createMultipleStudent(theStudentDAO);
//            createStudent(theStudentDAO);
            System.out.println("commandLineRunner ended");
        };
    }

    private void deleteAllStudent(studentDAO theStudentDAO) {
        System.out.println("deleting all count:" + theStudentDAO.deleteAll());
    }

    private void deleteStudent(studentDAO theStudentDAO) {
        Integer id = 4;
        System.out.println("deleting id:" + id);
        theStudentDAO.delete(id);
    }

    private void updateStudent(studentDAO theStudentDAO) {
        Integer id = 4;
        student theStudent = theStudentDAO.findByID(id);
        System.out.println("before update:" + theStudent);
        theStudent.setLastName("shaikh");
        theStudentDAO.update(theStudent);
        System.out.println("after update:" + theStudentDAO.findByID(id));
    }

    private void queryForStudentByLastName(studentDAO theStudentDAO) {
        List<student> theStudents = theStudentDAO.findByLastName("viroje");
        System.out.println("List of object:");
        for (student student : theStudents) {
            System.out.println(student);
        }
    }

    private void queryForStudent(studentDAO theStudentDAO) {
        List<student> theStudents = theStudentDAO.findAll();
        System.out.println("List of object:");
        for (student student : theStudents) {
            System.out.println(student);
        }
    }

    private void createAndReadStudent(studentDAO theStudentDAO) {
        //create the object
        student tempStudent = new student("asv", "viroje", "email");

        //save the object
        theStudentDAO.save(tempStudent);

        //get obj by id
        System.out.println("getID of saved obj:" + theStudentDAO.findByID(tempStudent.getId()));

    }

    private void createMultipleStudent(studentDAO theStudentDAO) {
        //create the object
        student tempStudent1 = new student("john", "patil", "email");
        student tempStudent2 = new student("mutuswami", "singh", "email");
        student tempStudent3 = new student("chang", "khan", "email");

        //save the object
        System.out.println("createMultipleStudent saving object");
        theStudentDAO.save(tempStudent1);
        theStudentDAO.save(tempStudent2);
        theStudentDAO.save(tempStudent3);

    }

    private void createStudent(studentDAO theStudentDAO) {
        System.out.println("createStudent started");

        //create the object
        student tempStudent = new student("vardhaman", "viroje", "email");

        //save the object
        System.out.println("createStudent saving object");
        theStudentDAO.save(tempStudent);

        //display id
        System.out.println("getID:" + tempStudent.getId());

        System.out.println("createStudent ended");
    }
}
