package edu.nf.food.user.service.impl;

import edu.nf.food.user.dao.AdministratorDao;
import edu.nf.food.user.entity.Administrator;
import edu.nf.food.user.service.AdministratorService;
import edu.nf.food.user.service.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ethan
 * @Classname AdministratorServiceImpl
 * @Description TODO
 * @Date 2020/4/8 16:09
 * 管理员
 */

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorDao administratorDao;

    /**
     * 获取管理员列表
     *
     * @return
     */
    @Override
    public List<Administrator> listAdministrator() {
        try {
            List<Administrator> list = administratorDao.listAdministrator();
            return list;
        } catch (Exception e) {
            throw new UserException("获取管理员列表异常：" + e);
        }
    }

    /**
     * 修改管理员信息
     *
     * @param administrator
     */
    @Override
    public void upAdministratorById(Administrator administrator) {
        try {
            administratorDao.upAdministratorById(administrator);
        } catch (Exception e) {
            throw new UserException("修改管理员信息异常：" + e);
        }
    }

    /**
     * 添加管理员
     *
     * @param administrator
     */
    @Override
    public void addAdministrator(Administrator administrator) {
        try {
            administratorDao.addAdministrator(administrator);
        } catch (Exception e) {
            throw new UserException("添加管理员异常：" + e);
        }
    }

    /**
     * 管理员登录
     *
     * @param administrator
     * @return
     */
    @Override
    public Administrator loginAdministrator(Administrator administrator) {
        try {
            return administratorDao.loginAdministrator(administrator);
        } catch (Exception e) {
            throw new UserException("管理员登录异常：" + e);
        }
    }

    /**
     * 查看管理员信息
     *
     * @param administrator
     * @return
     */
    @Override
    public Administrator selectAdministratorById(Administrator administrator) {
        try {
            return administratorDao.selectAdministratorById(administrator);
        } catch (Exception e) {
            throw new UserException("管理员登录异常：" + e);
        }
    }
}
