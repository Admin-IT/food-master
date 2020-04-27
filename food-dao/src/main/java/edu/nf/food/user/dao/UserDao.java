package edu.nf.food.user.dao;

import edu.nf.food.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

/**
 * @Author ethan
 * @Classname UserDao
 * @Description TODO
 * @Date 2020/3/25 14:41
 */

@Mapper
public interface UserDao {

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
