package com.techprimers.mybatis.springbootmybatis.resource;

import com.techprimers.mybatis.springbootmybatis.mapper.UsersMapper;
import com.techprimers.mybatis.springbootmybatis.model.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {

    private UsersMapper usersMapper;

    public UsersResource(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @GetMapping("/all")
    public List<Users> getAll(){
        return usersMapper.findAll();
    }

    @GetMapping("/search")
    public List<Users> getByName(){
        return usersMapper.findByName("new insert");
    }

    @GetMapping("/create")
    public List<Users> create(){

        Users users = new Users();
        users.setName("new insert");
        users.setSalary(1200L);
        usersMapper.insert(users);

        return usersMapper.findAll();
    }
}
