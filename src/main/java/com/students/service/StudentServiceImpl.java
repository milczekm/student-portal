package com.students.service;

import com.students.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired(required=true)
    @Qualifier(value= "studentServiceImpl")
    public void setStudentService(StudentServiceImpl ss){
        this.studentService = ss;
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String listStudents(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("listStudents", this.studentService.listStudents());
        return "student";
    }

    @RequestMapping(value= "/student/add", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Student s){

        if(s.getId() == 0){

            this.studentService.addStudent(s);
        }else{

            this.studentService.updateStudent(s);
        }

        return "redirect:/students";

    }

    @RequestMapping("/remove/{id}")
    public String removeStudent(@PathVariable("id") int id){

        this.studentService.removeStudent(id);
        return "redirect:/students";
    }

    @RequestMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") int id, Model model){
        model.addAttribute("student", this.studentService.getStudentById(id));
        model.addAttribute("listStudents", this.studentService.listStudents());
        return "student";
    }
}