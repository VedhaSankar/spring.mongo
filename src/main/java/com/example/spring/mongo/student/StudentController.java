package com.example.spring.mongo.student;

import com.example.spring.mongo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController{

    @Autowired
    private ItemRepository itemRepository;

//    http://localhost:8080/addStudent
//{
//    "id": 1,
//        "name" : "jani",
//        "age" : "20",
//        "dob": "2000/6/12",
//        "email": "jani@gmail.com"
//}
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){
        itemRepository.save(student);
        return "Added student with id: " + student.getId();
    }

//  http://localhost:8080/getAllStudents
    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
        return itemRepository.findAll();
    }

//  http://localhost:8080/getStudent/1
    @GetMapping("/getStudent/{id}")
    public Optional<Student> getStudent(@PathVariable int id){
        return itemRepository.findById(id);
    }

//  http://localhost:8080/deleteStudent/2
    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id){
        itemRepository.deleteById(id);
        return "Deleted student with id " + id;
    }

}
