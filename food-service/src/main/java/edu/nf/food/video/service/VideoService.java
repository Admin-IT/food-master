package edu.nf.food.video.service;


import edu.nf.food.video.entity.Video;

import java.util.List;

public interface VideoService {
    void addVideo(Video video);

    void deleteVideo(Integer videoId);

    List<Video> listVideo(Integer pageNum, Integer pageSize);

    List<Video> search(String name);

    List<Video> listVideoByName(Integer pageNum, Integer pageSize);
}
