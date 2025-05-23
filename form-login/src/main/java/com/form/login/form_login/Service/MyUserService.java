package com.form.login.form_login.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.form.login.form_login.Entity.MyUser;
import com.form.login.form_login.Repository.MyUserRepository;

@Service
public class MyUserService {

    @Autowired
    private MyUserRepository myUserRepository;

    public MyUser saveUser(MyUser user){
        return myUserRepository.save(user);
    }

    public MyUser findById(Long id){
        return myUserRepository.findById(id).get();
    }

    public List<MyUser> findAll(){
        return myUserRepository.findAll();
    }

}
