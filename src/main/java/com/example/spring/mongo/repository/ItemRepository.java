package com.example.spring.mongo.repository;

import com.example.spring.mongo.student.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Student, Integer>{
}
