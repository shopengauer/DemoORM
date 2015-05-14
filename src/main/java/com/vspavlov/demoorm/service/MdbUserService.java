package com.vspavlov.demoorm.service;

import com.vspavlov.demoorm.domain.users.MdbUser;
import com.vspavlov.demoorm.forms.MdbUserCreateForm;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Vasiliy on 12.05.2015.
 */
public interface MdbUserService {

    Optional<MdbUser> getMdbUserById(long id);
    Optional<MdbUser> getMdbUserByUsername(String username);
    Collection<MdbUser> getAllUsers();
    MdbUser create(MdbUserCreateForm form);
}
