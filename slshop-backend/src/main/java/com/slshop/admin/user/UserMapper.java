package com.slshop.admin.user;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.slshop.common.entity.User;

@Mapper
public interface UserMapper {

    public Optional<User> findByEmail(String email);

}
