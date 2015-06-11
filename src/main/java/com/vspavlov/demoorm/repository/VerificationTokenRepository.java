package com.vspavlov.demoorm.repository;

import com.vspavlov.demoorm.domain.users.MdbUser;
import com.vspavlov.demoorm.domain.users.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vasiliy on 05.06.2015.
 */
public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long> {

    public VerificationToken findByToken(String token);

    public VerificationToken findByMdbUser(MdbUser user);
}
