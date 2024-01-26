package com.example.demo.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
@TableName("user")
public interface UserMapper extends BaseMapper<User> {
/*    @Select("select * from user")
    public List<User> findAll();

    @Insert("insert into user values (#{id},#{name},#{age},#{birthday})")
    public int insert(User user);

    @Delete("DELETE FROM user WHERE sid = (#{id})")
    public int delete(int id);*/


}
