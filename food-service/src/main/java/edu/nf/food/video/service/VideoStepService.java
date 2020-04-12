package edu.nf.food.video.service;

import edu.nf.food.video.dao.VideoStepDao;
import edu.nf.food.video.entity.VideoStep;

import java.util.List;

public interface VideoStepService {
    List<VideoStep> getStep(Integer videoId);

    void updateStep(VideoStep videoStep);
}
