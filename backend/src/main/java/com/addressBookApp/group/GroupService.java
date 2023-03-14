package com.addressBookApp.group;

import com.addressBookApp.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository,
                        EmployeeRepository employeeRepository) {
        this.groupRepository = groupRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Group> getGroup() {
        return groupRepository.findAll();
    }

    public void addGroup(Group group) {

        Optional<Group> optionalGroup = groupRepository.
                findGroupByName(group.getName());
        if(optionalGroup.isPresent()) {
            throw new IllegalStateException("group taken");
        }
        groupRepository.save(group);
    }
}
