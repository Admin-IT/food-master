package edu.nf.food.user.web;

import edu.nf.food.user.entity.Administrator;
import edu.nf.food.user.service.AdministratorService;
import edu.nf.food.util.BaseController;
import edu.nf.food.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author ethan
 * @Classname AdministratorController
 * @Description TODO
 * @Date 2020/4/8 21:45
 */

@RestController
public class AdministratorController extends BaseController {

    @Autowired
    private AdministratorService administratorService;

    /**
     * 获取管理员列表
     *
     * @return
     */
    @GetMapping("/list_administrator")
    public ResponseVO listAdministrator() {
        List<Administrator> list = administratorService.listAdministrator();
        return success(list);
    }

    /**
     * 修改管理员信息，根据ID
     *
     * @param administrator
     * @return
     */
    @PostMapping("/up_administrator")
    public ResponseVO upAdministrator(Administrator administrator) {
        administratorService.upAdministratorById(administrator);
        return success("修改成功");
    }

    /**
     * 添加管理员
     *
     * @param administrator
     * @return
     */
    @PostMapping("/add_administrator")
    public ResponseVO addAdministrator(Administrator administrator) {
        administratorService.addAdministrator(administrator);
        return success("添加成功");
    }

    /**
     * 管理员登入 TODO
     *
     * @param administrator
     * @param session
     * @return
     */
    @PostMapping("/login_administrator")
    public ResponseVO loginAdministrator(Administrator administrator, HttpSession session) {
        if (administratorService.loginAdministrator(administrator) != null) {
            session.setAttribute("administrator", administratorService.loginAdministrator(administrator));
            return success("登录成功");
        } else {
            return fail(404, "账号或密码错误");
        }
    }

    /**
     * 查看管理员信息
     *
     * @param administrator
     * @return
     */
    @GetMapping("/select_administrator")
    public ResponseVO selectAdministratorById(Administrator administrator) {
        return success(administratorService.selectAdministratorById(administrator));
    }
}
