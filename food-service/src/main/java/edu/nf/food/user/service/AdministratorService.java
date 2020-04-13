package edu.nf.food.user.service;

import edu.nf.food.user.entity.Administrator;

import java.util.List;

/**
 * @Author ethan
 * @Classname AdministratorService
 * @Description TODO
 * @Date 2020/4/8 16:08
 */

public interface AdministratorService {

    List<Administrator> listAdministrator();

    void upAdministratorById(Administrator administrator);

    void addAdministrator(Administrator administrator);

    Administrator loginAdministrator(Administrator administrator);

    Administrator selectAdministratorById(Administrator administrator);

}
