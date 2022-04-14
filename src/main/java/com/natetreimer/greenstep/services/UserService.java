package com.natetreimer.greenstep.services;

import com.natetreimer.greenstep.models.User;
import com.natetreimer.greenstep.security.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);
    User save(UserRegistrationDto registration);
}

