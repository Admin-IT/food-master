package edu.nf.food.label.web;

import com.github.pagehelper.PageInfo;
import edu.nf.food.label.entity.Number;
import edu.nf.food.label.service.NumberService;
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
 * 人数
 */
@RestController
public class NumberController extends BaseController {
    @Autowired
    private NumberService service;

    /**
     * 标签：人数查询
     *
     * @return
     */
    @GetMapping("/list_number")
    public ResponseVO<PageInfo<Number>> listNumber(Integer pageNum, Integer pageSize) {
        List<Number> list = service.listNumber(pageNum, pageSize);
        PageInfo<Number> page = new PageInfo<>(list);
        return success(page);
    }

    @GetMapping("/acquire_number")
    public ResponseVO acquireNumber(Integer id) {
        Number number = service.acquireNumber(id);
        return success(number);
    }

    @PostMapping("/update_number")
    public ResponseVO updateNumber(Number number) {
        service.updateNumber(number);
        return success("修改成功");
    }

    /**
     * 标签：人数 添加
     *
     * @param number
     * @return
     */
    @PostMapping("/add_number")
    public ResponseVO addNumber(Number number) {
        service.addNumber(number);
        return success("添加成功");
    }

    /**
     * 标签： 人数 删除
     *
     * @param number
     * @return
     */
    @GetMapping("/del_number")
    public ResponseVO delNumber(Number number) {
        service.delNumber(number);
        return success("删除成功");
    }
}