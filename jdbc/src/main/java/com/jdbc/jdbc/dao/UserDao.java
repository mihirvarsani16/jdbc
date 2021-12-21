package com.jdbc.jdbc.dao;

import java.util.List;

import com.jdbc.jdbc.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserDao() {

    }

    public int createTable() {
        String query = "CREATE TABLE IF NOT EXISTS User(id int primary key, name varchar(200) , age int , city varchar(100))";
        int update = this.jdbcTemplate.update(query);
        return update;
    }

    public int insertData(User user) {
        String query = "insert into user(id,name,age,city) values(?,?,?,?)";
        int update = this.jdbcTemplate.update(query,
                new Object[] { user.getId(), user.getName(), user.getAge(), user.getCity() });
        return update;
    }

    public int update(User user) {
        String query = "update user set name=?,age=?,city=? where id=?";
        int update = this.jdbcTemplate.update(query, user.getName(), user.getAge(), user.getCity(), user.getId());
        return update;
    }

    public User getUser(int id) {
        String query = "select * from user where id=?";
        UserMapper userMapper = new UserMapper();
        User user = this.jdbcTemplate.queryForObject(query, userMapper, id);
        return user;
    }

    public List<User> getAllUser() {
        String query = "select * from user";
        UserMapper userMapper = new UserMapper();
        List<User> users = this.jdbcTemplate.query(query, userMapper);
        return users;

    }

    public int delete(int id) {
        String query = "delete from user where id=?";
        int update = this.jdbcTemplate.update(query, id);
        return update;
    }
}
