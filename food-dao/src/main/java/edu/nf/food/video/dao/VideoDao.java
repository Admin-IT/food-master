package edu.nf.food.video.dao;

import edu.nf.food.video.entity.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VideoDao {
    void addVideo(Video video);

    void deleteVideoById(Integer videoId);

    List<Video> searchByName(String name);

    List<Video> listVideo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    List<Video> listVideoByName(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
}
