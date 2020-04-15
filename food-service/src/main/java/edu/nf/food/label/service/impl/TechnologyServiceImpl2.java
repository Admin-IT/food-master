package edu.nf.food.label.service.impl;

import edu.nf.food.label.dao.TechnologyDao;
import edu.nf.food.label.entity.Technology;
import edu.nf.food.label.service.TechnologyService;
import edu.nf.food.label.service.exception.LabelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TracyMcGrady
 * @date 2020-04-11
 */
@Service
public class TechnologyServiceImpl2 implements TechnologyService {

    @Autowired
    private TechnologyDao technologyDao;

    @Override
    public List<Technology> listTechnology(Integer pageNum, Integer pageSize) {

        try {
            return technologyDao.listTechnology(pageNum, pageSize);
        } catch (Exception e) {
            throw new LabelException("数据库错误");
        }
    }

    @Override
    public Technology acquireTechnology(Integer id) {
        try {
            return technologyDao.acquireTechnology(id);
        } catch (Exception e) {
            throw new LabelException("数据库错误");
        }
    }

    @Override
    public void updateTechnology(Technology technology) {
        try {
            technologyDao.updateTechnology(technology);
        } catch (Exception e) {
            throw new LabelException("数据库错误");
        }
    }

    @Override
    public void insertTechnology(Technology technology) {
        try {
            technologyDao.insertTechnology(technology);
        } catch (Exception e) {
            throw new LabelException("添加错误");
        }
    }

    @Override
    public void deleteTechnology(Technology technology) {
        try {
            technologyDao.deleteTechnology(technology);
        } catch (Exception e) {
            throw new LabelException("删除失败");
        }
    }

}
