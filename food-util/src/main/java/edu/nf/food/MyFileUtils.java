package edu.nf.food;

import java.io.File;

/**
 * 文件上传工具包
 */
public class MyFileUtils {
    public static void createUploadDir(String uploadPath) {
        //构建上传目录
        File uploadDir = new File(uploadPath);
        //如果不存在此目录则创建
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
    }

    public static File createUploadFile(String uploadPath, String fileName) {
        //构建一个完整的文件上传对象
        File uploadFile = new File(uploadPath + File.separator + fileName);
        return uploadFile;
    }
}
