package com.asynccontroller.services;

import com.asynccontroller.models.requests.StudentRequest;
import com.asynccontroller.models.response.StudentResponse;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface StudentServiceAsync {

    CompletableFuture<List<StudentResponse>> getAllStudent();

    CompletableFuture<StudentResponse> getStudent(Integer studentId);

    CompletableFuture<Void> deleteStudent(Integer studentId);

    CompletableFuture<StudentResponse> saveStudent(StudentRequest studentRequest);
}
