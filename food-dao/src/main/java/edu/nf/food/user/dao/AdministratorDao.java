package edu.nf.food.user.dao;

import edu.nf.food.user.entity.Administrator;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author ethan
 * @Classname AdministratorDao
 * @Description TODO
 * @Date 2020/4/8 15:23
 */

@Mapper
public interface AdministratorDao {

    List<Administrator> listAdministrator();

    void upAdministratorById(Administrator administrator);

    void addAdministrator(Administrator administrator);

    Administrator loginAdministrator(Administrator administrator);

    Administrator selectAdministratorById(Administrator administrator);

}
