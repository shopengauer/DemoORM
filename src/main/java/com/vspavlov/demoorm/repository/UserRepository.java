package com.vspavlov.demoorm.repository;

import com.vspavlov.demoorm.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Vasiliy on 08.05.2015.
 */
public interface UserRepository extends JpaRepository<User,Integer> {

//    @Query("select u from User u where u.email=?1 and u.password=?2")
//    User login(String email, String password);
//
//    User findByEmailAndPassword(String email, String password);
//    @Query("select u from User u where u.username=?1")
     User findByUsername(String username);

}
