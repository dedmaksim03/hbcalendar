package com.example.hbcalendar.service;

import com.example.hbcalendar.entities.Role;
import com.example.hbcalendar.entities.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole(){
        return roleRepository.findByRoleName("ROLE_USER").get();
    }
}
