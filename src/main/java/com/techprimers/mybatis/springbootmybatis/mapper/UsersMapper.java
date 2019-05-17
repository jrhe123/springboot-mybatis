package com.techprimers.mybatis.springbootmybatis.mapper;

import com.techprimers.mybatis.springbootmybatis.model.Users;
import org.apache.ibatis.annotations.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Mapper
public interface UsersMapper {

    @Select("select * from users")
    List<Users> findAll();

    @Select("select * from users where name = #{name}")
    List<Users> findByName(@PathParam("name") final String name);

    @Insert("insert into users(name, salary) values(#{name}, #{salary})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    void insert(Users users);

    @Update("update users set salary = #{salary} where name = #{name}")
    void update(Users users);

    @Delete("delete from users where name = #{name}")
    void delete(Users users);
}
