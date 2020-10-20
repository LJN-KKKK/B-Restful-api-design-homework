package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final List<Student> studentList = new ArrayList<>();
    public Student addStudent(Student student) {
        studentList.add(student);
        return student;
    }
}
