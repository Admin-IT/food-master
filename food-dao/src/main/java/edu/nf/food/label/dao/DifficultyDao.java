package edu.nf.food.label.dao;

import edu.nf.food.label.entity.Difficulty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 * 难度
 */
@Mapper
public interface DifficultyDao {
    List<Difficulty> listDiffculty(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    Difficulty acquireDiffculty(Integer id);

    void updateDiffculty(Difficulty difficulty);

    void addDiffculty(Difficulty difficulty);

    void delDiffculty(Difficulty difficulty);
}