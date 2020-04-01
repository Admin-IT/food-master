package edu.nf.food.food;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author admin
 * @date 2020/3/11
 */
@SpringBootApplication
@MapperScan(basePackages = {"edu.nf.food.label.dao","edu.nf.food.food.dao"})
public class FoodApplication {
    public static void main(String[] args) {
        SpringApplication.run(FoodApplication.class, args);
    }
}