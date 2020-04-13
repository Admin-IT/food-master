package edu.nf.food.user.dao;

import edu.nf.food.user.entity.Administrator;
import edu.nf.food.user.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author ethan
 * @Classname RoleDao
 * @Description TODO
 * @Date 2020/4/8 15:27
 */

@Mapper
public interface RoleDao {

    List<Role> listRole();

    void delRoleById(Role role);

    void upRoleById(@Param("administrator") Administrator administrator, @Param("role") Role role);

    void addRole(Role role);

    void authorityRole(@Param("administrator") Administrator administrator, @Param("role") Role role);

}
