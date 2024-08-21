package com.asynccontroller.services;

import com.asynccontroller.models.requests.StudentRequest;
import com.asynccontroller.models.response.StudentResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    ResponseEntity<List<StudentResponse>> getAllStudent();

    ResponseEntity<StudentResponse> getStudent(Integer studentId);

    ResponseEntity<Void>  deleteStudent(Integer studentId);

    ResponseEntity<StudentResponse> saveStudent(StudentRequest studentRequest);
}
