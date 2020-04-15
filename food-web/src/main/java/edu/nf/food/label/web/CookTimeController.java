package edu.nf.food.label.web;

import com.github.pagehelper.PageInfo;
import edu.nf.food.label.entity.CookTime;
import edu.nf.food.label.service.CookTimeService;
import edu.nf.food.util.BaseController;
import edu.nf.food.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 * 烹饪时间
 */
@RestController
public class CookTimeController extends BaseController {
    @Autowired
    private CookTimeService service;

    @GetMapping("/list_cooktime")
    public ResponseVO<PageInfo<CookTime>> listCookTime(Integer pageNum, Integer paSize) {
        List<CookTime> list = service.listCookTime(pageNum, paSize);
        PageInfo<CookTime> page = new PageInfo<>(list);
        return success(page);
    }

    @GetMapping("/acquire_cooktime")
    public ResponseVO<CookTime> acquireCooltime(Integer id) {
        CookTime cookTime = service.acquireCoolTime(id);
        return success(cookTime);
    }

    @PostMapping("/update_cooktime")
    public ResponseVO updateCooltime(CookTime cookTime) {
        service.updateCoolTime(cookTime);
        return success("修改成功");
    }

    @PostMapping("/add_cooktime")
    public ResponseVO addCookTime(CookTime cooktime) {
        service.addCookTime(cooktime);
        return success("添加成功");
    }

    @GetMapping("/del_cooktime")
    public ResponseVO delCookTime(CookTime cooktime) {
        service.delCookTime(cooktime);
        return success("删除失败");
    }
}