package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentNotExistException;
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

    public void deleteStudent(int id){
        for (Student student : studentList) {
            if (student.getId() == id) {
                studentList.remove(student);
                return;
            }
        }
        throw new StudentNotExistException("student does not exist");
    }
}
