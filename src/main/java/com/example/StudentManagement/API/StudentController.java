package com.example.StudentManagement.API;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

@Autowired
StudentService studentService;

     // Adding the information or Making Post API
    @PostMapping("/add_student")
    public String addStudent(@RequestBody Student student) {
       return studentService.addStudent(student);
    }

    // Get the information
    @GetMapping("/get_student")
    public Student getStudent(@RequestParam("q") int admnNo){
        return studentService.getStudent(admnNo);

    }
    @DeleteMapping("/delete_student/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        return studentService.deleteStudet(id);
    }
    @PutMapping("/upadate_student")
    public String updateStudnet(@RequestParam("id") int id, @RequestParam("age") int age){
        return studentService.updateStudent(id , age);
    }
}
