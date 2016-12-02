package com.lehtarec.web;

import com.lehtarec.domain.User;
import com.lehtarec.domain.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by PENGUIN on 01.12.2016.
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailServiceImpl(UserRepository userRepository) {this.userRepository = userRepository; }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User curuser = userRepository.findByUsername(username);
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, curuser.getPasswordHash(), AuthorityUtils.createAuthorityList(curuser.getRole()));
        return userDetails;
    }
}
