package com.vspavlov.demoorm.service;

import com.vspavlov.demoorm.domain.users.MdbUser;
import com.vspavlov.demoorm.forms.MdbUserCreateForm;
import com.vspavlov.demoorm.repository.MdbUserRepository;
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
@Transactional
public class MdbUserServiceImpl implements MdbUserService{


    @Autowired
    private MdbUserRepository mdbUserRepository;

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
    public MdbUser create(MdbUserCreateForm form) {

        MdbUser mdbUser = new MdbUser();
        mdbUser.setUsername(form.getUsername());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        mdbUser.setPasswordHash(passwordEncoder.encode(form.getPassword()));
        mdbUser.setMdbRole(form.getRole());
        mdbUserRepository.save(mdbUser);
        return mdbUser;
    }
}
