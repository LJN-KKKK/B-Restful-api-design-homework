package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GroupService {
    Map<Integer, Group> studentGroup = new HashMap<>();

    public List<Group> getAll() {
        List<Group> groups = new ArrayList<>();
        studentGroup.forEach((id, group) -> groups.add(group));
        return groups;
    }

    public Group updateGroupName(Integer id, String name) {
        Group group = studentGroup.get(id);
        group.setName(name);
        return studentGroup.get(id);
    }
}
