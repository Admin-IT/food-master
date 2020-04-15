package edu.nf.food.label.service;

import edu.nf.food.label.entity.Number;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 */
public interface NumberService {
    List<Number> listNumber(Integer pageNum, Integer pageSize);

    Number acquireNumber(Integer id);

    void updateNumber(Number number);

    void addNumber(Number number);

    void delNumber(Number number);
}