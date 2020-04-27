package edu.nf.food.user.service;

import edu.nf.food.user.entity.User;

import java.util.List;

/**
 * @Author ethan
 * @Classname UserService
 * @Description TODO
 * @Date 2020/3/25 14:48
 */

public interface UserService {

    List<User> listUser();

    void delUserById(User user);

    void upUserById(Integer userId);

    void addUser(User user);

    User loginUser(User user);

    User allUserMess(Integer userId);

    void upUser(User user);

    void upPass(User user);

    void upImage(User user);

    void addPhone(User user);

    User phoneLogin(String phone);
}
