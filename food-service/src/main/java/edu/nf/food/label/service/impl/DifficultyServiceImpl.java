package edu.nf.food.label.service.impl;

import edu.nf.food.label.dao.DifficultyDao;
import edu.nf.food.label.entity.Difficulty;
import edu.nf.food.label.service.DifficultyService;
import edu.nf.food.label.service.exception.LabelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 * 难度
 */
@Service
public class DifficultyServiceImpl implements DifficultyService {

    @Autowired
    private DifficultyDao dao;

    @Override
    public List<Difficulty> listDifficulty(Integer pageNum, Integer pageSize) {
        try {
            return dao.listDiffculty(pageNum, pageSize);
        } catch (Exception e) {
            throw new LabelException("数据库错误");
        }
    }

    @Override
    public Difficulty acquireDifficulty(Integer id) {
        try {
            return dao.acquireDiffculty(id);
        } catch (Exception e) {
            throw new LabelException("数据库错误");
        }
    }

    @Override
    public void updateDiffculty(Difficulty difficulty) {
        try {
            dao.updateDiffculty(difficulty);
        } catch (Exception e) {
            throw new LabelException("数据库错误");
        }
    }

    @Override
    public void addDiffculty(Difficulty difficulty) {
        try {
            dao.addDiffculty(difficulty);
        } catch (Exception e) {
            throw new LabelException("添加失败");
        }
    }

    @Override
    public void delDiffculty(Difficulty difficulty) {
        try {
            dao.delDiffculty(difficulty);
        } catch (Exception e) {
            throw new LabelException("删除失败");
        }
    }
}