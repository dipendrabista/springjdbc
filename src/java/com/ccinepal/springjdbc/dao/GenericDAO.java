/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccinepal.springjdbc.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author punoj123
 */
public interface GenericDAO<T> {

    int insert(T t) throws SQLException;

    int update(T t) throws SQLException;

    int delete(int id) throws SQLException;

    T getById(int id) throws SQLException;

    List<T> getAll() throws SQLException;

}
