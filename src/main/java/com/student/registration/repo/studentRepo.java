package com.student.registration.repo;

import com.student.registration.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface studentRepo extends CrudRepository<Student,Integer> {
}
