package edu.nf.food.user.service.impl;

import edu.nf.food.user.service.UserService;
import edu.nf.food.exception.UserException;
import edu.nf.food.user.dao.UserDao;
import edu.nf.food.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

/**
 * @Author ethan
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2020/3/25 14:48
 * 用户
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 获取用户列表
     * @return
     */
    @Override
    public List<User> listUser() {
        try {
            List<User> list = userDao.listUser();
            return list;
        }catch (Exception e){
            throw new UserException("获取用户列表异常：" + e);
        }
    }

    /**
     * 删除用户（暂用）
     * @param user
     */
    @Override
    public void delUserById(User user) {
        try {
            userDao.delUserById(user);
        }catch (Exception e){
            throw new UserException("删除用户异常：" + e);
        }
    }


    /**
     * 更新用户
     *
     * @param userId
     */
    @Override
    public void upUserById(Integer userId) {
        try {
            userDao.upUserById(userId);
        } catch (Exception e) {
            throw new UserException("更新用户异常：" + e);
        }
    }

    /**
     * 添加用户
     * @param user
     */
    @Override
    public void addUser(User user) {
        try {
            userDao.addUser(user);
        } catch (Exception e) {
            throw new UserException("添加用户异常：" + e);
        }
    }


    @Override
    public User loginUser(User user) {
        User us = userDao.loginUser(user);

        if (us == null) {
            throw new UserException("该账户未存在");
        }
        if (!us.getUserPass().equals(user.getUserPass())) {
            throw new UserException("账户或密码错误");
        }
        return us;
    }

    /**
     * 查询登录用户个人信息
     *
     * @param userId
     * @return
     */
    @Override
    public User allUserMess(Integer userId) {

        User user = userDao.allUserMess(userId);
        return user;
    }

    /**
     * 修改用户基础信息
     *
     * @param user
     */
    @Override
    public void upUser(User user) {
        try {
            userDao.upUser(user);
        } catch (Exception e) {
            throw new UserException("修改用户异常，请联系专业人士进行处理！" + e.getMessage());
        }
    }

    /**
     * 修改用户密码
     *
     * @param user
     */
    @Override
    public void upPass(User user) {
        try {
            userDao.upPass(user);
        } catch (Exception e) {
            throw new UserException("密码修改异常！");
        }
    }

    @Override
    public void upImage(User user) {
        try {
            userDao.upImage(user);
        } catch (Exception e) {
            throw new UserException("修改异常 ：" + e);
        }
    }

    @Override
    public void addPhone(User user) {
        try {
            userDao.addPhone(user);
        } catch (Exception e) {
            throw new UserException("添加失败: " + e);
        }
    }

    @Override
    public User phoneLogin(String phone) {
        User user = userDao.phoneLogin(phone);
        return user;
    }
}
