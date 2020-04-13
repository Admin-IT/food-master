package edu.nf.food.user.web;

import edu.nf.food.user.entity.Administrator;
import edu.nf.food.user.entity.Role;
import edu.nf.food.user.service.RoleService;
import edu.nf.food.util.BaseController;
import edu.nf.food.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ethan
 * @Classname RoleController
 * @Description TODO
 * @Date 2020/4/8 21:55
 */

@RestController
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    /**
     * 获取角色列表
     *
     * @return
     */
    @GetMapping("/list_role")
    public ResponseVO listRole() {
        List<Role> list = roleService.listRole();
        return success(list);
    }

    /**
     * 删除角色
     *
     * @param role
     * @return
     */
    @PostMapping("/del_role")
    public ResponseVO delRole(Role role) {
        roleService.delRoleById(role);
        return success("删除成功");
    }

    /**
     * 修改角色
     *
     * @param role
     * @return
     */
    @PostMapping("/up_role")
    public ResponseVO upRole(Administrator administrator, Role role) {
        roleService.upRoleById(administrator, role);
        return success("修改成功");
    }

    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    @PostMapping("/add_role")
    public ResponseVO addRole(Role role) {
        roleService.addRole(role);
        return success("添加成功");
    }

    /**
     * 分配角色
     *
     * @param role
     * @return
     */
    @PostMapping("/authority_role")
    public ResponseVO authorityRole(Administrator administrator, Role role) {
        System.out.println(role.getRoleAuthority());
        roleService.authorityRole(administrator, role);
        return success("分配成功");
    }

}
