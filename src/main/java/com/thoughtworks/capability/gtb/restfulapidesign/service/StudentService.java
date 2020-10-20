package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentNotExistException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final List<Student> studentList = new ArrayList<Student>(){{
        add(new Student(1, "111", "male", ""));
        add(new Student(2, "222", "female", ""));
        add(new Student(3, "333", "female", ""));
        add(new Student(4, "444", "male", ""));
        add(new Student(5, "555", "female", ""));
        add(new Student(6, "666", "male", ""));
    }};
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

    public List<Student> getAll(String gender) {
        if(gender == null) return studentList;
        else{
            List<Student> studentsByGender = new ArrayList<>();
            for (Student student : studentList) {
                if (student.getGender().equals(gender))
                    studentsByGender.add(student);
            }
            return studentsByGender;
        }
    }

}
