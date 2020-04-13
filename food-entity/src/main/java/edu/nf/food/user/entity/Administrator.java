package edu.nf.food.user.entity;

import lombok.Data;


/**
 * @Author ethan
 * @Classname Administrator
 * @Description TODO
 * @Date 2020/4/8 14:20
 */

@Data
public class Administrator {

    private Integer administratorId;
    private String administratorAccount;
    private String administratorPassword;
    private String administratorName;
    private String administratorSex;
    private String administratorEmail;
    private String administratorTel;
    private String administratorImage;
    private Role role;

}
