package com.example.hbcalendar.service;

import com.example.hbcalendar.dtos.RegistrationUserDto;
import com.example.hbcalendar.entities.Role;
import com.example.hbcalendar.entities.User;
import com.example.hbcalendar.entities.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

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

    public User createNewUser(RegistrationUserDto registrationUserDto){
        User user = new User();
        user.setName(registrationUserDto.getName());
        user.setPassword(passwordEncoder.encode(registrationUserDto.getPassword()));
        user.setRole(roleService.getUserRole());
        return userRepository.save(user);
    }
}
