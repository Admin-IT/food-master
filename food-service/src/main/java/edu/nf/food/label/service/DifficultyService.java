package edu.nf.food.label.service;


import edu.nf.food.label.entity.Difficulty;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 * 难度
 */
public interface DifficultyService {
    List<Difficulty> listDifficulty(Integer pageNum, Integer pageSize);

    Difficulty acquireDifficulty(Integer id);

    void updateDiffculty(Difficulty difficulty);

    void addDiffculty(Difficulty difficulty);

    void delDiffculty(Difficulty difficulty);
}