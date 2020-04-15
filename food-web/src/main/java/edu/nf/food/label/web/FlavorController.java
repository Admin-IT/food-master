package edu.nf.food.label.web;

import com.github.pagehelper.PageInfo;
import edu.nf.food.label.entity.Flavor;
import edu.nf.food.label.service.FlavorService;
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
 * 口味
 */
@RestController
public class FlavorController extends BaseController {
    @Autowired
    private FlavorService service;

    /**
     * 标签：口味 查询全部
     *
     * @return
     */
    @GetMapping("/list_flavor")
    public ResponseVO<PageInfo<Flavor>> listFlavor(Integer pageNum, Integer pageSize) {
        List<Flavor> flavors = service.listFlavor(pageNum, pageSize);
        PageInfo<Flavor> page = new PageInfo<>(flavors);
        return success(page);
    }


    @GetMapping("/acquire_flavor")
    public ResponseVO acquireFlavor(Integer id) {
        Flavor flavor = service.acquireFlavor(id);
        return success(flavor);
    }

    @PostMapping("/update_flavor")
    public ResponseVO updateFlavor(Flavor flavor) {
        service.updateFlavor(flavor);
        return success("修改成功");
    }
    /**
     * 标签：口味 添加
     *
     * @param flavor
     * @return
     */
    @PostMapping("/add_flavor")
    public ResponseVO addFlavor(Flavor flavor) {
        service.addFlavor(flavor);
        return success("添加成功");
    }

    /**
     * 标签：口味 删除
     *
     * @param flavor
     * @return
     */
    @GetMapping("/del_flavor")
    public ResponseVO delFlavor(Flavor flavor) {
        service.delFlavor(flavor);
        return success("删除成功");
    }

}