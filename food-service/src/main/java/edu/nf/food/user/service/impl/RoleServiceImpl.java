package edu.nf.food.user.service.impl;

import edu.nf.food.user.dao.RoleDao;
import edu.nf.food.user.entity.Administrator;
import edu.nf.food.user.entity.Role;
import edu.nf.food.user.service.RoleService;
import edu.nf.food.user.service.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ethan
 * @Classname RoleServiceImpl
 * @Description TODO
 * @Date 2020/4/8 16:14
 * 角色
 */

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    /**
     * 获取角色列表
     *
     * @return
     */
    @Override
    public List<Role> listRole() {
        try {
            List<Role> list = roleDao.listRole();
            return list;
        } catch (Exception e) {
            throw new UserException("获取角色列表异常：" + e);
        }
    }

    /**
     * 删除角色
     *
     * @param role
     */
    @Override
    public void delRoleById(Role role) {
        try {
            roleDao.delRoleById(role);
        } catch (Exception e) {
            throw new UserException("删除角色异常：" + e);
        }
    }

    /**
     * 修改角色
     *
     * @param role
     */
    @Override
    public void upRoleById(Administrator administrator, Role role) {
        try {
            roleDao.upRoleById(administrator, role);
        } catch (Exception e) {
            throw new UserException("修改角色异常：" + e);
        }
    }

    /**
     * 添加角色
     *
     * @param role
     */
    @Override
    public void addRole(Role role) {
        try {
            roleDao.addRole(role);
        } catch (Exception e) {
            throw new UserException("添加角色异常：" + e);
        }
    }

    /**
     * 分配权限
     *
     * @param administrator
     * @param role
     */
    @Override
    public void authorityRole(Administrator administrator, Role role) {
        try {
            roleDao.authorityRole(administrator, role);
        } catch (Exception e) {
            throw new UserException("分配权限异常：" + e);
        }
    }
}
