package edu.nf.food.util.config;

import edu.nf.food.util.interceptor.RoleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private RoleInterceptor roleInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器,并设置访问规则，哪些请求经过这个拦截器,也可以排除个别请求，让其放行
        registry.addInterceptor(roleInterceptor)
                .addPathPatterns("/permission-assignment.html");
    }

}
