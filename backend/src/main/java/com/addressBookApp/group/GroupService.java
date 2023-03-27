package com.addressBookApp.group;

import com.addressBookApp.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;
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

    public void deleteGroup(Integer groupId) {
        boolean exists = groupRepository.existsById(groupId);
        if(!exists) {
            throw new IllegalStateException("group with id " + groupId + " dose not exists");
        }
        groupRepository.deleteById(groupId);
    }

    @Transactional
    public void updateGroup(Integer groupId,
                            Group group) {
        Group groupRep = groupRepository.findById(groupId).
                orElseThrow(() -> new IllegalStateException(
                        "group with id " + groupId + " dose not exists"));

        if(group.getName() != null &&
        group.getName().length() > 0 &&
        !Objects.equals(groupRep.getName(), group.getName())) {
            groupRep.setName(group.getName());
        }
    }
}
