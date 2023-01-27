package com.example.StudentManagement.API;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

@Autowired
StudentService studentService;

     // Adding the information or Making Post API
    @PostMapping("/add_student")
    public ResponseEntity addStudent(@RequestBody Student student) {
       String respons = studentService.addStudent(student);
       return new ResponseEntity<>(respons , HttpStatus.CREATED);
    }

    // Get the information
    @GetMapping("/get_student")
    public ResponseEntity getStudent(@RequestParam("q") int admnNo){
       Student student = studentService.getStudent(admnNo);
       return new ResponseEntity(student,HttpStatus.FOUND);


    }
    @DeleteMapping("/delete_student/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") int id){
        String response = studentService.deleteStudet(id);
        if(response.equals("Invalid Id")){
            return new ResponseEntity<>(response , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response , HttpStatus.FOUND);

    }
    @PutMapping("/upadate_student")
    public ResponseEntity updateStudnet(@RequestParam("id") int id, @RequestParam("age") int age){

        String response = studentService.updateStudent(id,age);
        if(response == null){
            return new ResponseEntity<>("Invalid request" , HttpStatus.BAD_REQUEST );
        }

        return new ResponseEntity<>("Updated" , HttpStatus.ACCEPTED);
    }
}
