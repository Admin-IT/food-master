package edu.nf.food.label.dao;

import edu.nf.food.label.entity.Number;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 */
@Mapper
public interface NumberDao {
    List<Number> listNumber(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    Number acquireNumber(Integer id);

    void updateNumber(Number number);

    void addNumber(Number number);

    void delNumber(Number number);
}