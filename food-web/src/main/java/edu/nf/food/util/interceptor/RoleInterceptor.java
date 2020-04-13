package edu.nf.food.util.interceptor;

import edu.nf.food.user.entity.Administrator;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ehtan
 * @date 2020-04-08
 * <p>
 * 权限拦截器
 */
@Component
public class RoleInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        System.out.println("administrator authentication ...");
        Administrator administrator = (Administrator) session.getAttribute("administrator");
        if (administrator == null) {
            response.sendRedirect("/food/home.html");
            return false;
        }
        String role = administrator.getRole().getRoleAuthority();
        if (role.equals("超级管理员")) {
            System.out.println(role);
            return true;
        }
        request.getRequestDispatcher("/home.html").forward(request, response);
        return false;
    }
}
