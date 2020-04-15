package edu.nf.food.label.dao;

import edu.nf.food.label.entity.ReparationTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 */
@Mapper
public interface ReparationTimeDao {
    List<ReparationTime> listReparationTime(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    ReparationTime acquireReparationTime(Integer id);

    void updateReparationTime(ReparationTime reparationTime);

    void addReparationTime(ReparationTime reparationTime);

    void delReparationTime(ReparationTime ReparationTime);
}