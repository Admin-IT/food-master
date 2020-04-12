package edu.nf.food.video.service.impl;

import edu.nf.food.video.dao.VideoDao;
import edu.nf.food.video.entity.Video;
import edu.nf.food.video.service.VideoService;
import edu.nf.food.video.service.exception.VideoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoDao dao;

    @Override
    public void addVideo(Video video) {
        try {
            dao.addVideo(video);
        } catch (Exception e) {
            throw new VideoException("添加异常" + e);
        }
    }

    @Override
    public void deleteVideo(Integer videoId) {
        try {
            dao.deleteVideoById(videoId);
        } catch (Exception e) {
            throw new VideoException("删除异常" + e);
        }
    }

    @Override
    public List<Video> listVideo(Integer pageNum, Integer pageSize) {
        try {
            return dao.listVideo(pageNum, pageSize);
        } catch (Exception e) {
            throw new VideoException("查找异常" + e);
        }

    }

    @Override
    public List<Video> search(String name) {
        try {
            return dao.searchByName(name);
        } catch (Exception e) {
            throw new VideoException("查找异常" + e);
        }
    }

    @Override
    public List<Video> listVideoByName(Integer pageNum, Integer pageSize) {
        try {
            return dao.listVideoByName(pageNum, pageSize);
        } catch (Exception e) {
            throw new VideoException("查找异常" + e);
        }
    }
}
