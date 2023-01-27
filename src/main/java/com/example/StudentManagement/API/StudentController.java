package com.example.StudentManagement.API;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

     Map<Integer , Student> db = new HashMap<>();


     // Adding the information or Making Post API
    @PostMapping("/add_student")
    public String addStudent(@RequestBody Student student) {
        int admnNo = student.getAdmnNo();
        db.put(admnNo , student);
        return "Student Added Successful";
    }

    // Get the information
    @GetMapping("/get_student")
    public Student getStudent(@RequestParam("q") int admnNo){
        return db.get(admnNo);

    }
    @DeleteMapping("/delete_student")
    public String deleteStudent(@PathVariable("id") int id){
        if(!db.containsKey(id))
            return "Invalid Id";

        db.remove(id);
        return "Student remove Successfully";
    }
    @PutMapping("/upadate_student")
    public String updateStudnet(@RequestParam("id") int id, @RequestParam("age") int age){
        if(!db.containsKey(id)){
            return "Invalid Id";
        }
        int upage;
        db.get(id).setAge(20);
        return "Age Update successfull";
    }
}
