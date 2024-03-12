package com.appsdeveloper.legacyusersservice;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.appsdeveloper.legacyusersservice.data.UserEntity;
import com.appsdeveloper.legacyusersservice.data.UsersRepository;

@Component
public class InitialSetup {

    @Autowired
    UsersRepository usersRepository;

   // @Autowired
    //BCryptPasswordEncoder bCryptPasswordEncoder;

    @EventListener
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {
        UserEntity user = new UserEntity(
                1L,
                "ergerheh",
                "Tom",
                "Sobieski",
                "test2@test.com",
                "tomtom",
                "",
                false);

        usersRepository.save(user);
    }
}
