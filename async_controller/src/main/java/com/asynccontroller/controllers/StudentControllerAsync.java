package com.asynccontroller.controllers;

import com.asynccontroller.models.requests.StudentRequest;
import com.asynccontroller.models.response.StudentResponse;
import com.asynccontroller.services.StudentServiceAsync;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("studentasync")
public class StudentControllerAsync {

    private final StudentServiceAsync studentServiceAsync;

    @GetMapping
    public CompletableFuture<List<StudentResponse>> getdata() {
        return studentServiceAsync.getAllStudent();
    }

    @PostMapping
    public CompletableFuture<StudentResponse> saveStudent(@RequestBody StudentRequest studentRequest) {
        return studentServiceAsync.saveStudent(studentRequest);
    }

    @GetMapping("/{studentId}")
    public CompletableFuture<StudentResponse> getStudent(@PathVariable Integer studentId) {
        return studentServiceAsync.getStudent(studentId);
    }

    @DeleteMapping("/{studentId}")
    public CompletableFuture<Void> deleteStudent(@PathVariable Integer studentId) {
        return studentServiceAsync.deleteStudent(studentId);
    }
}
