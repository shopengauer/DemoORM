package com.vspavlov.demoorm.service;

import com.vspavlov.demoorm.domain.users.MdbUser;
import com.vspavlov.demoorm.domain.users.VerificationToken;
import com.vspavlov.demoorm.dto.MdbUserCreateForm;
import com.vspavlov.demoorm.repository.MdbUserRepository;
import com.vspavlov.demoorm.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by Vasiliy on 12.05.2015.
 */
@Service
//@Transactional
public class MdbUserServiceImpl implements MdbUserService{


    @Autowired
    private MdbUserRepository mdbUserRepository;
    @Autowired
    private VerificationTokenRepository tokenRepository;


    @Override
    public Optional<MdbUser> getMdbUserById(long id) {
        return Optional.ofNullable(mdbUserRepository.findOne(id));
    }

    @Override
    public Optional<MdbUser> getMdbUserByUsername(String username) {
        return mdbUserRepository.findMdbUserByUsername(username);
    }

    @Override
    public Collection<MdbUser> getAllUsers() {
        return mdbUserRepository.findAll();
    }

    @Override
    public Optional<MdbUser> getUserByEmail(String email) {
        return mdbUserRepository.findMdbUserByEmail(email);
    }

    @Override
    public MdbUser create(MdbUserCreateForm form) {

        MdbUser mdbUser = new MdbUser();
        mdbUser.setUsername(form.getUsername());
        mdbUser.setEmail(form.getEmail());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        mdbUser.setPasswordHash(passwordEncoder.encode(form.getPassword()));
        mdbUser.setMdbRole(form.getRole());
        mdbUserRepository.save(mdbUser);
        return mdbUser;
    }

    @Override
    public void createVerificationTokenForUser(MdbUser user, String token) {
        final VerificationToken myToken = new VerificationToken(token, user);
        tokenRepository.save(myToken);
    }
}
