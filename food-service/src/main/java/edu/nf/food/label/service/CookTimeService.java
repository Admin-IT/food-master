package edu.nf.food.label.service;

import edu.nf.food.label.entity.CookTime;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 */
public interface CookTimeService {
    List<CookTime> listCookTime(Integer pageNum, Integer pageSize);

    CookTime acquireCoolTime(Integer id);

    void updateCoolTime(CookTime cookTime);

    void addCookTime(CookTime cookTime);

    void delCookTime(CookTime cookTime);
}