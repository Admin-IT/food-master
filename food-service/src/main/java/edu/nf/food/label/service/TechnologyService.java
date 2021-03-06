package edu.nf.food.label.service;


import edu.nf.food.label.entity.Technology;

import java.util.List;

/**
 * @author admin
 * @date 2020/3/11
 * <p>
 * 口艺
 */

public interface TechnologyService {
    /**
     * 获取全部
     *
     * @return
     */
    List<Technology> listTechnology(Integer pageNum, Integer pageSize);

    Technology acquireTechnology(Integer id);

    void updateTechnology(Technology technology);

    /**
     * 添加
     *
     * @param technology
     */
    void insertTechnology(Technology technology);

    /**
     * 删除
     *
     * @param technology
     */
    void deleteTechnology(Technology technology);

}