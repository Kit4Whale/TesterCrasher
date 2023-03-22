package com.addressBookApp.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(path = "api/v1/groups")
    public List<Group> getGroup() {
        return groupService.getGroup();
    }

    @PostMapping(path = "api/v1/groups/create")
    public void addNewGroup(@RequestBody Group group) {
        groupService.addGroup(group);
    }

    @DeleteMapping(path = "api/v1/groups/{groupID}")
    public void deleteGroup(@PathVariable("groupID") Integer groupId) {
        groupService.deleteGroup(groupId);
    }
}
