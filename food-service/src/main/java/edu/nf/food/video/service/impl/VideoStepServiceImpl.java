package edu.nf.food.video.service.impl;

import edu.nf.food.video.dao.VideoStepDao;
import edu.nf.food.video.entity.VideoStep;
import edu.nf.food.video.service.VideoStepService;
import edu.nf.food.video.service.exception.VideoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoStepServiceImpl implements VideoStepService {

    @Autowired
    private VideoStepDao dao;

    @Override
    public List<VideoStep> getStep(Integer videoId) {
        try {
            return dao.listStep(videoId);
        } catch (Exception e) {
            throw new VideoException("查看异常" + e);
        }
    }

    @Override
    public void updateStep(VideoStep videoStep) {
        try {
            dao.updateStep(videoStep);
        } catch (Exception e) {
            throw new VideoException("修改异常" + e);
        }
    }
}
