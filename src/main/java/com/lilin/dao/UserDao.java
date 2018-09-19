package com.lilin.dao;

import com.lilin.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    @Select("SELECT * FROM user")
    List<User> selectAllUser();

    @Select("SELECT * FROM user WHERE id=#{id}")
    User selectUserById(int id);

    @Insert("INSERT INTO User ( userName, password ) " +
            "VALUES ( #{userName}, #{password} )")
    void insertUser(@Param("userName")String userName, @Param("password")String password);

    @Delete("DELETE FROM User WHERE id = #{id}")
    void deleteUserById(int id);

    @Update("UPDATE User SET userName = #{userName}, password = #{password}" +
            "WHERE id = #{id}")
    void updateUser(@Param("id")int id, @Param("userName")String userName, @Param("password")String password);

    @Select("SELECT * FROM user WHERE userName=#{userName} AND password=#{password}")
    User checkUser(@Param("userName")String userName, @Param("password")String password);
}
