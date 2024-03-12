package com.appsdeveloper.legacyusersservice.service;

import com.appsdeveloper.legacyusersservice.response.UserRest;

public interface UsersService {
   UserRest getUserDetails(String userName, String password);
   UserRest getUserDetails(String userName);
}
