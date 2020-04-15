package edu.nf.food.label.service;


import edu.nf.food.label.entity.Flavor;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 * 口味
 */
public interface FlavorService {
    List<Flavor> listFlavor(Integer pageNum, Integer pageSize);

    Flavor acquireFlavor(Integer id);

    void updateFlavor(Flavor flavor);

    void addFlavor(Flavor flavor);

    void delFlavor(Flavor flavor);
}