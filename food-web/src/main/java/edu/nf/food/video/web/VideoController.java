package edu.nf.food.video.web;


import com.github.pagehelper.PageInfo;
import edu.nf.food.MyFileUtils;
import edu.nf.food.util.BaseController;
import edu.nf.food.video.entity.Video;
import edu.nf.food.video.service.VideoService;
import edu.nf.food.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class VideoController extends BaseController {
    @Autowired
    private VideoService service;

    /**
     * 视频数据显示
     *
     * @param pageNum  第几页
     * @param pageSize 每页条数
     * @return
     */
    @GetMapping("/get_videos")
    public ResponseVO<PageInfo<Video>> listVideo(Integer pageNum, Integer pageSize) {
        List<Video> videoList = service.listVideo(pageNum, pageSize);
        PageInfo<Video> pageInfo = new PageInfo<>(videoList);
        return success(pageInfo);
    }

    /**
     * 上传视频
     *
     * @param file
     * @param video
     * @param request
     * @param response
     * @throws IOException
     */
    @PostMapping("/add_video")
    public void add(MultipartFile file, Video video, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //System.out.println(file);
        //System.out.println(video.getUserId());
        //String uploadPath = request.getServletContext().getRealPath(File.separator + "upload");
        String uploadPath = System.getProperty("user.dir") + "\\food-web\\src\\main\\resources\\static\\upload";
        //System.out.println(uploadPath);
        //构建上传目录
        MyFileUtils.createUploadDir(uploadPath);
        //System.out.println(uploadPath);
        String fName = file.getOriginalFilename();
        //构建上传的文件
        File uploadFile = MyFileUtils.createUploadFile(uploadPath, fName);
        //执行上传
        file.transferTo(uploadFile);
        //System.out.println(fName);
        //video.getName();
        //获取文件名无后缀
        //video.setName(fName.substring(0,fName.lastIndexOf(".")));
        video.setName(fName);
        //System.out.println(video.getVName());
        service.addVideo(video);
        response.sendRedirect("home.html");
    }

    @GetMapping("/get_videos_name")
    public ResponseVO<PageInfo<Video>> listByName(Integer pageNum, Integer pageSize) {
        List<Video> videoList = service.listVideoByName(pageNum, pageSize);
        PageInfo<Video> pageInfo = new PageInfo<>(videoList);
        return success(pageInfo);
    }

    /**
     * 模糊查询
     *
     * @param name 查询字样
     * @return
     */
    @GetMapping("/find_videos")
    public ResponseVO<List<Video>> search(String name) {
        List<Video> videoList = service.search(name);
        return success(videoList);
    }

    /**
     * 删除数据
     *
     * @param videoId 视频ID
     * @return
     */
    @PostMapping("/delete_video")
    public ResponseVO delete(Integer videoId) {
        service.deleteVideo(videoId);
        String a = "assdsd";
        return success("video_find.html");
    }
}
