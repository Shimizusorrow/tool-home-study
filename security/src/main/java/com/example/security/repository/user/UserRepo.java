package com.example.security.repository.user;

import com.example.security.domain.user.User;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shimizu
 * @description
 * @date 2021-02-03 11:48
 */
@Repository
@AllArgsConstructor
public class UserRepo {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<User> findAll() {
        final String sql = "select u.name as name from user u ";
        Map<String, Object> params = new HashMap<>();
        params.put("1", "1");

        return namedParameterJdbcTemplate.query(sql, params, (rs, rowNum) -> {
            User user = new User();
            user.setName(rs.getString("name"));
            return user;
        });
    }

    public Object find() {
        final String sql = "select * from user";
        return namedParameterJdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class ));
    }
}
