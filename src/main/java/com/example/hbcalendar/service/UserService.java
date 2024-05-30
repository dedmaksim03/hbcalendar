package com.example.hbcalendar.service;

import com.example.hbcalendar.entities.Role;
import com.example.hbcalendar.entities.RoleRepository;
import com.example.hbcalendar.entities.User;
import com.example.hbcalendar.entities.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByName(username).orElseThrow(() -> new UsernameNotFoundException(
             String.format("Пользователь '%s' не найден", username)
        ));
        List<Role> roles = new ArrayList<Role>();
        roles.add(user.getRole());
        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList())
        );
    }

    public Optional<User> findByName(String name){
        return userRepository.findByName(name);
    }

    public void createNewUser(User user){
        user.setRole(roleRepository.findByRoleName("ROLE_USER").get());
        userRepository.save(user);
    }
}
