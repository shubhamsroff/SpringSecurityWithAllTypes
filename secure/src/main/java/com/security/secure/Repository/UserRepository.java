package com.security.secure.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.security.secure.Entity.MyUser;

@Repository
public interface UserRepository extends JpaRepository<MyUser,Long> {
    
    Optional<MyUser> findByUsername(String username);
}
