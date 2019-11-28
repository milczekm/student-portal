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
    public String findAllStudents(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("listStudents", studentService.findAllStudents());

        return "listStudents";
    }

    @RequestMapping(value= "/student/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student s){
        studentService.saveStudent(s);

        return "redirect:/students";
    }

    @RequestMapping("/student/delete")
    public String deleteStudent(Student s){
        studentService.deleteStudent(s);

        return "redirect:/students";
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String findStudentbById(Long id){
        studentService.findStudentById(id);

        return "student";
    }

}