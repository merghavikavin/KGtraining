package com.jdbctemp.web;

import java.util.List;
 
import org.springframework.jdbc.core.JdbcTemplate;
 
public class RegistrationDAO {
 
    private JdbcTemplate jdbcTemplate;
 
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
 
    public List<Registration> listAllRegistrations() {
        String query = "SELECT * FROM registration";
        return jdbcTemplate.query(query,new RegistrationMapper());
    }
}
