package com.form.login.form_login.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.form.login.form_login.Entity.MyUser;
import com.form.login.form_login.Repository.MyUserRepository;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private MyUserRepository myUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            MyUser user=myUserRepository.findByUsername(username).get();
            return  User.builder().username(user.getUsername()).password(user.getPassword())
            .roles(user.getRole().split(",")).build();
    }


}
