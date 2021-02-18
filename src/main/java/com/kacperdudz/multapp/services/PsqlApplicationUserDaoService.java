package com.kacperdudz.multapp.services;

import com.kacperdudz.multapp.daos.ApplicationUserDao;
import com.kacperdudz.multapp.daos.PsqlDao;
import com.kacperdudz.multapp.models.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository("psql")
public class PsqlApplicationUserDaoService implements ApplicationUserDao {

    @Autowired
    private PsqlDao psqlDao;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PsqlApplicationUserDaoService(PsqlDao psqlRepo, PasswordEncoder passwordEncoder) {
        this.psqlDao = psqlRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {

        passwordEncoder.encode("yo");

        System.out.println("in DaoService");

        try {
            Optional<ApplicationUser> found = psqlDao.findByUsername(username);
            Collection<? extends GrantedAuthority> authorities = found.get().getAuthorities();

            for (GrantedAuthority g : authorities){
                System.out.println(g.getAuthority());
            }

            return found;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

//        System.out.println("After searching");
//        System.out.println("we have " + found);
//
//        System.out.println(found.get().getUsername());
    }


}
