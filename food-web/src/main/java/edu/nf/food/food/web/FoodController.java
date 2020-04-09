package edu.nf.food.food.web;

import com.github.pagehelper.PageInfo;
import edu.nf.food.food.entity.Food;
import edu.nf.food.food.service.FoodService;
import edu.nf.food.util.BaseController;
import edu.nf.food.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ljf
 * @date 2020/4/7
 * 菜谱
 */
@RestController
public class FoodController extends BaseController {

    @Autowired
    private FoodService service;

    @GetMapping("/food_info")
    public ResponseVO<PageInfo<Food>> test(Integer pageNum, Integer pageSize) {
        List<Food> foods = service.listFood(pageNum, pageSize);
        PageInfo<Food> page = new PageInfo<>(foods);
        return success(page);
    }
}