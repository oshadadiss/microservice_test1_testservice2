package com.microservice.usermicroservice.Repository;

import com.microservice.usermicroservice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserID(Long userId);

    User findByUsernameAndPassword(String username, String password);
}
