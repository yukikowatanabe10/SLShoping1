package com.slshop.admin.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.slshop.admin.user.UserMapper;
import com.slshop.common.entity.User;

@Service
public class LoginUserDetailsService implements UserDetailsService {

    private final UserMapper userMapper;

    @Autowired
    public LoginUserDetailsService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> loginUserOptional = userMapper.findByEmail(email);
        return loginUserOptional.map(loginUser -> new SLShopUserDetails(loginUser))
                .orElseThrow(() -> new UsernameNotFoundException("ユーザーが見つかりませんでした。"));
    }
}
