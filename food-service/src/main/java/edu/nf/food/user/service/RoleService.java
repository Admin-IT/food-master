package edu.nf.food.user.service;

import edu.nf.food.user.entity.Administrator;
import edu.nf.food.user.entity.Role;

import java.util.List;

/**
 * @Author ethan
 * @Classname RoleService
 * @Description TODO
 * @Date 2020/4/8 16:08
 */

public interface RoleService {

    List<Role> listRole();

    void delRoleById(Role role);

    void upRoleById(Administrator administrator, Role role);

    void addRole(Role role);

    void authorityRole(Administrator administrator, Role role);
}
