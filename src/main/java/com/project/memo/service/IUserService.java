package com.project.memo.service;

import com.project.memo.entity.User;

public interface IUserService {

    void signUp(User user);

    User login(String username, String password);

    User reset(String username, String phone, String email, String password);


    User getById(Integer id);

    void changeInfo(Integer id, String username, User user);
}
