package com.mukham.crud.controller;

import com.mukham.crud.model.Student;
import com.mukham.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/insertStudentData")
    public void insertStudentData(@RequestBody Student student) {
        studentService.insertStudentData(student);

    }

    @GetMapping("/selectAllStudentData")
    public List<Student> selectAllStudentData() {
        return studentService.selectAllStudentData();

    }

    @GetMapping("/getStudentByName")
    public List<Student> getSelectStudentByName(@RequestParam String name) {
        return studentService.findByName(name);

    }

    @PostMapping("/updateStudentData")
    public String updateStudentData(@RequestBody Student student) {
        String s = studentService.updateStudentName(student);
        return s;

    }

    @DeleteMapping("/deleteData/{id}")
    public String deleteData(@PathVariable Long id) {
        return studentService.deleteData(id);

    }
}
