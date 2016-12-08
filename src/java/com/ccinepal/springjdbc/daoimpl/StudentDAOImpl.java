/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccinepal.springjdbc.daoimpl;

import com.ccinepal.springjdbc.dao.GenericDAO;
import com.ccinepal.springjdbc.entity.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author punoj123
 */
@Repository(value = "studentDAO")
public class StudentDAOImpl implements GenericDAO<Student> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public StudentDAOImpl() {
    }

    @Override
    public int insert(Student t) throws SQLException {
        String sql = "insert into student(name) values(?)";

        return jdbcTemplate.update(sql, new Object[]{t.getName()});

    }

    @Override
    public int update(Student t) throws SQLException {
        String sql = "update student set name=? where student_id=?";

        return jdbcTemplate.update(sql, new Object[]{t.getName(), t.getId()});

    }

    @Override
    public int delete(int id) throws SQLException {
        String sql = "delete from  student where student_id=?";

        return jdbcTemplate.update(sql, new Object[]{id});

    }

    @Override
    public Student getById(int id) throws SQLException {

        String sql = "select *from student where student_id=? ";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int i) throws SQLException {

                Student s = new Student();
                s.setId(rs.getInt("student_id"));
                s.setName(rs.getString("name"));
                return s;
            }
        }, new Object[]{id});
        
        
    }

    @Override
    public List<Student> getAll() throws SQLException {
        String sql = "Select *from student";
        return jdbcTemplate.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int i) throws SQLException {

                Student s = new Student();
                s.setId(rs.getInt("student_id"));
                s.setName(rs.getString("name"));

                return s;
            }
        });
    }

}
