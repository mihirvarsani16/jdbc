package com.jdbc.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.jdbc.entity.User;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int arg1) throws SQLException {
        User user = new User();
        user.setId(rs.getInt(1));
        user.setName(rs.getString(2));
        user.setAge(rs.getInt(3));
        user.setCity(rs.getString(4));
        return user;
    }

}
