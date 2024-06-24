package com.example.demo.v1.configs;

import com.example.demo.v1.dtos.RoleDTO;
import com.example.demo.v1.enumerations.EUserRole;
import com.example.demo.v1.services.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ServiceRunner implements CommandLineRunner {
    @Autowired
    private RoleServiceImpl roleService;

    @Override
    public void run(String... args) throws Exception {
        createRoleIfNotExist(EUserRole.ADMIN);
        createRoleIfNotExist(EUserRole.USER);
        System.out.println("RoleServiceCommandRunner.run");
    }

    public void createRoleIfNotExist(EUserRole roleName) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleName(roleName);
        roleService.save(roleDTO);
        System.out.println("RoleServiceCommandRunner.createRoleIfNotExist");
    }
}
