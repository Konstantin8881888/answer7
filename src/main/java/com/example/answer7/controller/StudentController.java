package com.example.answer7.controller;


import com.example.answer7.entity.Student;
import com.example.answer7.repository.StudentRepository;
import com.example.answer7.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService productService) {
        this.studentService = productService;
    }

    @GetMapping("/")
    public String findAllStudents(Model model) {
        List<Student> allStudents = studentService.findAllStudents();
        model.addAttribute("allStudents", allStudents);
        return "all_students";
    }

    @GetMapping("/students/all")
    public String showAllStudents(Model model) {
        List<Student> students = studentService.findAllStudents();
        model.addAttribute("allStudents", students);
        return "all_students";
    }
    @GetMapping("/all")
    public String getAllStudents(Model model) {
        List<Student> students = studentService.findAllStudents();
        model.addAttribute("allStudents", students);
        model.addAttribute("newStudent", new Student());
        return "all_students";
    }

    @GetMapping("/students/newStudent")
    public String showAddForm(Model model) {
        model.addAttribute("newStudent", new Student());
        return "add_student";
    }
    @PatchMapping ("/{id}")
    public String newProduct(@PathVariable Long id, Model model) {
        Student byId = studentService.findById(id);
        model.addAttribute("newStudent", byId);
        return "add_student";
    }

    @PostMapping("/students")
    public String addStudent(@ModelAttribute("newStudent") Student student) {
        studentService.save(student);
        return "redirect:/students";
    }


    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students/";
    }
}
