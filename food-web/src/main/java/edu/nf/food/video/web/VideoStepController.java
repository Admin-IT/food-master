package edu.nf.food.video.web;

import edu.nf.food.util.BaseController;
import edu.nf.food.video.entity.VideoStep;
import edu.nf.food.video.service.VideoStepService;
import edu.nf.food.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class VideoStepController extends BaseController {

    @Autowired
    private VideoStepService service;

    @GetMapping("/get_steps")
    public ResponseVO<List<VideoStep>> listSteps(Integer videoId) {
        return success(service.getStep(videoId));
    }

    @PostMapping("/update_steps")
    public ResponseVO update(VideoStep videoStep) {
        service.updateStep(videoStep);
        return success("video_find.html");
    }

    @PostMapping("/add_steps")
    public void add(VideoStep videoStep, HttpServletResponse response) throws IOException {
        service.addStep(videoStep);
        ;
        response.sendRedirect("video_find.html");
    }
}
