package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<Group> getGroups(){
        return groupService.getAll();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Group updateGroup(@PathVariable Integer id, @RequestBody String name) {
        return groupService.updateGroupName(id, name);
    }
}
