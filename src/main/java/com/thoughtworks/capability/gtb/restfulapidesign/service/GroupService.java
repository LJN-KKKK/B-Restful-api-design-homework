package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GroupService {

    private final StudentService studentService;
    private Map<Integer, Group> GroupList;

    public GroupService(StudentService studentService) {
        this.studentService = studentService;
        reSet();
    }
    public List<Group> getAll() {
        List<Group> groups = new ArrayList<>();
        GroupList.forEach((id, group) -> groups.add(group));
        return groups;
    }

    public Group updateGroupName(Integer id, String name) {
        Group group = GroupList.get(id);
        group.setName(name);
        return GroupList.get(id);
    }

    public List<Group> createGroups() {
        this.reSet();
        List<Student> studentList = new ArrayList<>(studentService.getStudentList().values());
        int size = studentList.size();
        for (int i = 0; i < size; i ++){
            int index = (int) (Math.random() * studentList.size());
            GroupList.get(i % 6 + 1).getStudentList().add(studentList.get(index));
            studentList.remove(index);
        }
        return new ArrayList<>(GroupList.values());
    }

    public void reSet() {
        GroupList = new HashMap<>();
        for (int i = 1; i <= 6 ;i++){
            Group group = new Group(i ,"Team " + i,new ArrayList<>(), "");
            GroupList.put(i, group);
        }
    }
}
