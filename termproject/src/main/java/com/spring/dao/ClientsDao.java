package com.spring.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.beans.Clients;

import java.util.List;

@Repository
public class ClientsDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Clients> findAllClients() {
        String sql = "SELECT * FROM clients";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Clients client = new Clients();
            client.setId(rs.getLong("id"));
            client.setName(rs.getString("name"));
            client.setPassword(rs.getString("password"));
            client.setEmail(rs.getString("email"));
            client.setPhoneNumber(rs.getString("phone_number"));
 
            return client;
        });
    }

    // Add other data access methods as needed
}
