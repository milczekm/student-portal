package com.students.controller;

import com.students.model.Student;
import com.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

@Controller
public class StudentController {

    private boolean isPeselCorrect(String pesel){

        int year     = parseInt(pesel.substring(0,2),10);
        int month = parseInt(pesel.substring(2,4),10)-1;
        int day   = parseInt(pesel.substring(4,6),10);

        if(month >= 80)
        {
            year += 1800;
            month = month - 80;
        }
        else if(month >= 60)
        {
            year += 2200;
            month = month - 60;
        }
        else if (month >= 40)
        {
            year += 2100;
            month = month-40;
        }
        else if (month >= 20)
        {
            year += 2000;
            month = month - 20;
        }
        else
        {
            year += 1900;
        }

        int[] wags = {9,7,3,1,9,7,3,1,9,7};
        int sum = 0;

        for(int i=0;i < wags.length; i++)
        {
            sum+=(parseInt(pesel.substring(i,i+1),10)*wags[i]);
        }

        sum=sum % 10;

        int cyfraKontr = parseInt(pesel.substring(10,11),10);

        return (sum == cyfraKontr);
    }

    private boolean isBirthDateCorrect(Student s){

        int year     = parseInt(s.getPesel().substring(0,2),10);
        int month = parseInt(s.getPesel().substring(2,4),10)-1;
        int day   = parseInt(s.getPesel().substring(4,6),10);

        if(month >= 80)
        {
            year += 1800;
            month = month - 80;
        }
        else if(month >= 60)
        {
            year += 2200;
            month = month - 60;
        }
        else if (month >= 40)
        {
            year += 2100;
            month = month-40;
        }
        else if (month >= 20)
        {
            year += 2000;
            month = month - 20;
        }
        else
        {
            year += 1900;
        }

        return (((s.getBirthDate().get(Calendar.YEAR)%100)==year) && ((s.getBirthDate().get(Calendar.MONTH))==month) &&
                ((s.getBirthDate().get(Calendar.DAY_OF_MONTH))==day));
    }

  /*  @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Welcome to Student Base!");
        model.addAttribute("tagline", "The one and only amazing student-portal!");

        return "welcome";
    } */

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String findAllStudents(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("list", studentService.findAllStudents());

        return "list";
    }

    @RequestMapping("/new")
    public String newStudentForm(Map<String, Object> model) {
        Student student = new Student();
        model.put("student", studentService);
        return "new_student";
    }

    @RequestMapping(value= "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student s){
        if(isPeselCorrect(s.getPesel()) && isBirthDateCorrect(s)) {
            studentService.saveStudent(s);
        } else {
            throw new IllegalArgumentException("Incorrect parameter pesel!");
        }

        return "redirect:/students";
    }


    @RequestMapping("/student/delete")
    public String deleteStudent(Student s){
        studentService.deleteStudent(s);

        return "redirect:/students";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String findStudentbById(Integer id){
        studentService.findStudentById(id);

        return "student";
    }

}