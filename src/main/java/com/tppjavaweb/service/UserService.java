package com.tppjavaweb.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tppjavaweb.model.Role;
import com.tppjavaweb.model.Usuario;
import com.tppjavaweb.repository.RoleRepository;
import com.tppjavaweb.repository.Usuarios;

@Service
public class UserService {

    private Usuarios userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(Usuarios userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Usuario findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Usuario saveUser(Usuario user) {
        user.setSenha(bCryptPasswordEncoder.encode(user.getSenha()));
        user.setActive(true);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

}