package com.form.login.form_login.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.form.login.form_login.Entity.MyUser;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser,Long> {

    Optional<MyUser> findByUsername(String username);
}
