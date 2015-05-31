package com.vspavlov.demoorm.repository;


import com.vspavlov.demoorm.domain.users.MdbUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Vasiliy on 12.05.2015.
 */
public interface MdbUserRepository  extends JpaRepository<MdbUser,Long> {

   Optional<MdbUser> findMdbUserByUsername(String username);
   Optional<MdbUser> findMdbUserByEmail(String email);


}
