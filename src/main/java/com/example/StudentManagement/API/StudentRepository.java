package com.example.StudentManagement.API;


import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

    Map<Integer , Student> db = new HashMap<>();

    public String addStudent(@RequestBody Student student) {
        int admnNo = student.getAdmnNo();
        db.put(admnNo , student);
        return "Student Added Successful";
    }

    public Student getStudent(@RequestParam("q") int admnNo){
        return db.get(admnNo);

    }

    public String deleteStudent(@PathVariable("id") int id){
        if(!db.containsKey(id))
            return "Invalid Id";

        db.remove(id);
        return "Student remove Successfully";
    }

    public String updateStudnet(@RequestParam("id") int id, @RequestParam("age") int age){
        if(!db.containsKey(id)){
            return null;
        }
        int upage;
        db.get(id).setAge(20);
        return "Age Update successfull";
    }
}
