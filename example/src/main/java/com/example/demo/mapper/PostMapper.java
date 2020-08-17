package com.example.demo.mapper;

import com.example.demo.model.POST;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostMapper {

    @Select("SELECT * FROM POST")
    List<POST> getAll();

    @Select("SELECT * from POST WHERE id = #{id}")
    POST getPost(@Param("id") int id);

    @Insert("INSERT INTO POST(title, body, createdAt, updatedAt) VALUES(#{title}, #{b222ody}, now(), now())")
    void insertData(@Param("title") String title, @Param("b222ody") String body);

    @Delete("DELETE FROM POST WHERE id=#{id}")
    void delData(@Param("id") int id);

    @Update("UPDATE POST SET title=#{title}, body=#{body} WHERE id=#{id}")
    void updateData(@Param("title") String title, @Param("body") String body, @Param("id") int id);

}
