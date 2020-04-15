package edu.nf.food.video.dao;

import edu.nf.food.video.entity.VideoStep;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VideoStepDao {
    List<VideoStep> listStep(Integer videoId);

    void addStep(VideoStep videoStep);

    void updateStep(VideoStep videoStep);
}
