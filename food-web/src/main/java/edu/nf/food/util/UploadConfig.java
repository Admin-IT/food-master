package edu.nf.food.util;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * 上传文件设置相关参数
 */
@Configuration
public class UploadConfig {

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //设置单个文件大小
        factory.setMaxFileSize(DataSize.ofMegabytes(100));
        //设置上传总数据大小
        factory.setMaxRequestSize(DataSize.ofKilobytes(1024000));
        return factory.createMultipartConfig();
    }
}
