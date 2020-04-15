package edu.nf.food.label.web;

import com.github.pagehelper.PageInfo;
import edu.nf.food.label.entity.Technology;
import edu.nf.food.label.service.TechnologyService;
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
 */
@RestController
public class TechnologyController extends BaseController {

    @Autowired
    private TechnologyService service;

    /**
     * 标签：获取工艺全部信息
     *
     * @return
     */
    @GetMapping("/list_technology")
    public ResponseVO<PageInfo<Technology>> listTechnology(Integer pageNum, Integer pageSize) {
        List<Technology> technologies = service.listTechnology(pageNum, pageSize);
        PageInfo<Technology> pageInfo = new PageInfo<>(technologies);
        return success(pageInfo);
    }

    @GetMapping("/acquire_technology")
    public ResponseVO acquireTechnology(Integer id) {
        Technology technology = service.acquireTechnology(id);
        return success(technology);
    }

    @PostMapping("/update_technology")
    public ResponseVO updateTechnology(Technology technology) {
        service.updateTechnology(technology);
        return success("修改成功");
    }
    /**
     * 标签：添加工艺
     *
     * @param technology
     * @return
     */
    @PostMapping("/add_technology")
    public ResponseVO insertTechnology(Technology technology) {
        service.insertTechnology(technology);
        return success("添加成功");
    }


    /**
     * 标签：删除工艺
     *
     * @param technology
     * @return
     */
    @GetMapping("/delete_technology")
    public ResponseVO deleteTechnology(Technology technology) {
        service.deleteTechnology(technology);
        return success("删除成功");
    }

}