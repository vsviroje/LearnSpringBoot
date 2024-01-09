package com.example.sb.demo.rest;

import com.example.sb.demo.entity.student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class studentRestController {

    private List<student> studentList;

    @PostConstruct // to load the data only once...like static scope
    public void loadData() {
        studentList = new ArrayList<>();

        studentList.add(new student("vardhaman", "viroje"));
        studentList.add(new student("raju", "patil"));
        studentList.add(new student("anjum", "shaikh"));
    }

    @GetMapping("/students")
    public List<student> getStatus() {
        return studentList;
    }

    @GetMapping("/students/{id}")//PathVariable name and func parameter names should be same
    public student getStudent(@PathVariable int id) {

        if (id < 0 || id > studentList.size()) {
            throw new StudentNotFoundException("Invalid ID:" + id);
        }
        return studentList.get(id); // studentList is util.List
    }


}
