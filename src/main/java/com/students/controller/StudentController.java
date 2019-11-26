package com.students.controller;

import com.students.model.Student;
import com.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Welcome to Student Base!");
        model.addAttribute("tagline", "The one and only amazing student-portal!");

        return "welcome";
    }
    @Autowired
    private StudentService studentService;


    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("listStudents", studentService.findAll());
        return "student";
    }

    @RequestMapping(value= "/student/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("student") Student s){

        studentService.save(s);
        return "redirect:/students";

    }

    @RequestMapping("/remove/{s}")
    public String delete(Student s){

        studentService.delete(s);
        return "redirect:/students";
    }

}