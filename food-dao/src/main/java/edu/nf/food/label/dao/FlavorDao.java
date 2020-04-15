package edu.nf.food.label.dao;

import edu.nf.food.label.entity.Flavor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 * 口味
 */
@Mapper
public interface FlavorDao {
    List<Flavor> listFlaver(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    Flavor acquireFlaver(Integer id);

    void updateFlaver(Flavor flavor);

    void addFlaver(Flavor flavor);

    void delFlaver(Flavor flaver);
}