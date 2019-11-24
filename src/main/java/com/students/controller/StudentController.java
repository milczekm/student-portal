package com.students.controller;

import com.students.model.Student;
import com.students.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    private StudentServiceImpl studentService;

    @Autowired
    public void setStudentService(StudentServiceImpl ss){
        this.studentService = ss;
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("listStudents", this.studentService.findAll());
        return "student";
    }

    @RequestMapping(value= "/student/add", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Student s){

        if(s.getId() == 0){

            this.studentService.save(s);
        }else{

            this.studentService.update(s);
        }

        return "redirect:/students";

    }

    @RequestMapping("/remove/{s}")
    public String delete(Student s){

        this.studentService.delete(s);
        return "redirect:/students";
    }

}