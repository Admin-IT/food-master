package edu.nf.food.label.dao;

import edu.nf.food.label.entity.Technology;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author admin
 * @date 2020/3/11
 * 口艺  增删查改
 */
@Mapper
public interface TechnologyDao {
    List<Technology> listTechnology(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    Technology acquireTechnology(Integer id);

    void updateTechnology(Technology technology);

    void insertTechnology(Technology technology);

    void deleteTechnology(Technology technology);
}