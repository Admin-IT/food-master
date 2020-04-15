package edu.nf.food.label.dao;

import edu.nf.food.label.entity.CookTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 */
@Mapper
public interface CookTimeDao {
    List<CookTime> listCookTime(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    CookTime acquireCoolTime(Integer id);

    void updateCookTime(CookTime cookTime);

    void addCookTime(CookTime cookTime);

    void delCookTime(CookTime cookTime);
}