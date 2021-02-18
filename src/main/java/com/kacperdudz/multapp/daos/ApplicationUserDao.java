package com.kacperdudz.multapp.daos;

import com.kacperdudz.multapp.models.ApplicationUser;

import java.util.Optional;

public interface ApplicationUserDao {

    Optional<ApplicationUser> selectApplicationUserByUsername(String username);

}
