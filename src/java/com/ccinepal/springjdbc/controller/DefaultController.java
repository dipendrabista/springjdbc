/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccinepal.springjdbc.controller;

import com.ccinepal.springjdbc.daoimpl.StudentDAOImpl;
import com.ccinepal.springjdbc.entity.Student;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author punoj123
 */
@Controller
@RequestMapping(value = {"/"})
public class DefaultController {

    @Autowired
    private StudentDAOImpl studentdao;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {

        ModelAndView mav = new ModelAndView("index");
        try {

            mav.addObject("students", studentdao.getAll());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return mav;
    }

    @RequestMapping(value = {"/student/add"}, method = RequestMethod.GET)

    public ModelAndView add() {
        ModelAndView mav = new ModelAndView("add");
        return mav;

    }

    @RequestMapping(value = {"/student/add"}, method = RequestMethod.POST)

    public ModelAndView addv(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        studentdao.insert(new Student(0, request.getParameter("name")));

        return new ModelAndView("success");

    }

    @RequestMapping(value = {"/student/edit"}, method = {RequestMethod.GET})
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("edit");
        try {
            Student s = studentdao.getById(Integer.parseInt(request.getParameter("id")));
            mav.addObject("student", s);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return mav;
    }
    

    @RequestMapping(value = {"/student/edit"}, method = {RequestMethod.POST})
    public ModelAndView edits(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView mav = new ModelAndView("success");
        Student s = new Student();
        String name = request.getParameter("name");
        s.setId(Integer.parseInt(request.getParameter("id")));
        s.setName(name);
        try {

            studentdao.update(s);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return mav;
    }

    
    @RequestMapping(value = "/student/delete", method = {RequestMethod.GET})
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) {

        try {

            studentdao.delete(Integer.parseInt(request.getParameter("id")));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        ModelAndView mav = new ModelAndView("success");
        return mav;
    }

    
    
    
}
