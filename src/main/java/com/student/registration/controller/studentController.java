package com.student.registration.controller;
import com.student.registration.model.Student;
import com.student.registration.repo.studentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/registration")
public class studentController {
    @Autowired
    private studentRepo studentRepo;

    @PostMapping(path = "/new-student")
    public @ResponseBody Student addNewStudent(@RequestBody Student student) {
        studentRepo.save(student);
        return student;
    }

    @GetMapping(path = "/all-students")
    public @ResponseBody
    Iterable<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @PutMapping(path="update/{id}")
    public @ResponseBody String updateStudent( @PathVariable Integer id , @RequestBody Student newStudent){
        studentRepo.findById(id).map(student -> {
            student.setFirstName(newStudent.getFirstName());
            student.setLastName(newStudent.getLastName());
            student.setPhoneNumber(newStudent.getPhoneNumber());
            student.setEmail(newStudent.getEmail());
            student.setAddress(newStudent.getAddress());
            student.setGender(newStudent.getGender());
            return studentRepo.save(student);
        });
        return "updated successfully";
    }

    @GetMapping(path = "/delete/{id}")
    public @ResponseBody String deleteStudent(@PathVariable Integer id) {
        studentRepo.deleteById(id);
        return "Deleted successfully";
    }

}