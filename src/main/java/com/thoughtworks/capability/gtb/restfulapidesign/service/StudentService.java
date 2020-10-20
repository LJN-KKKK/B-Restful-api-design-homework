package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentNotExistException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    private final Map<Integer, Student> studentList = new HashMap<Integer, Student>(){{
        put(1, new Student(1, "111", "male", ""));
        put(2, new Student(2, "222", "female", ""));
        put(3, new Student(3, "333", "female", ""));
        put(4, new Student(4, "444", "male", ""));
        put(5, new Student(5, "555", "female", ""));
        put(6, new Student(6, "666", "male", ""));
        put(7, new Student(7, "777", "male", ""));
        put(8, new Student(8, "888", "male", ""));
    }};

    public Student addStudent(Student student) {
        studentList.put(student.getId(), student);
        return student;
    }

    public Student getStudentById(int id) {
        if(studentList.containsKey(id)){
            return studentList.get(id);
        }
        else{
            throw new StudentNotExistException("student does not exist");
        }
    }

    public void deleteStudent(int id){
        if(studentList.containsKey(id)){
            studentList.remove(id);
        }
        else{
            throw new StudentNotExistException("student does not exist");
        }
    }

    public List<Student> getAll(String gender) {
        List<Student> students = new ArrayList<>(studentList.values());
        if(gender == null) return students;
        else{
            List<Student> studentsByGender = new ArrayList<>();
            for (Student student : students) {
                if (student.getGender().equals(gender))
                    studentsByGender.add(student);
            }
            return studentsByGender;
        }
    }

    public Student updateStudent(int id, Student student){
        if(!studentList.containsKey(id)){
            throw new StudentNotExistException("student does not exist");
        }
        Student studentOld = studentList.get(id);
        studentOld.setName(student.getName());
        studentOld.setGender(student.getGender());
        studentOld.setNote(student.getNote());
        return studentList.get(id);
    }

    public Map<Integer, Student> getStudentList() {
        return studentList;
    }
}
