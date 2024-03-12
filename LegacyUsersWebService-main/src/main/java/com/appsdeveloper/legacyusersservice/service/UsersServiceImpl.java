package com.appsdeveloper.legacyusersservice.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.appsdeveloper.legacyusersservice.data.UserEntity;
import com.appsdeveloper.legacyusersservice.data.UsersRepository;
import com.appsdeveloper.legacyusersservice.response.UserRest;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    // For demonstration purposes only - ensure this aligns with your testing setup
    @Value("${test.user.password:defaultPassword}")
    private String testPassword;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    
    @Override
    public UserRest getUserDetails(String userName) {
        UserRest returnValue = new UserRest();

        UserEntity userEntity = usersRepository.findByEmail(userName);
        if (userEntity != null) {
            BeanUtils.copyProperties(userEntity, returnValue);
        }

        return returnValue;
    }

    @Override
    public UserRest getUserDetails(String userName, String password) {
        UserRest returnValue = null;

        UserEntity userEntity = usersRepository.findByEmail(userName);
        if (userEntity != null && userEntity.getPassword().equals(password)) {
            returnValue = new UserRest();
            BeanUtils.copyProperties(userEntity, returnValue);
        }

        return returnValue;
    }
}
