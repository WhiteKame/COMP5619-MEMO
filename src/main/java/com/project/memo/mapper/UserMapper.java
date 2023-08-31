package com.project.memo.mapper;

import com.project.memo.entity.User;

public interface UserMapper {
    User findByUsername(String username);

    Integer insert(User user);

    Integer reset(User user);

    User findById(Integer id);

    Integer updateInfoById(User user);

}
