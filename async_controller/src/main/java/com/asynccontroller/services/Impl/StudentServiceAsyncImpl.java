package com.asynccontroller.services.Impl;

import com.asynccontroller.data.entities.Student;
import com.asynccontroller.data.repos.StudentRepository;
import com.asynccontroller.mapper.StudentMapper;
import com.asynccontroller.models.requests.StudentRequest;
import com.asynccontroller.models.response.StudentResponse;
import com.asynccontroller.services.StudentServiceAsync;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class StudentServiceAsyncImpl implements StudentServiceAsync {

    private final StudentRepository studentRepository;

    @Override
    @Async
    public CompletableFuture<List<StudentResponse>> getAllStudent() {

  /*      List<Student> students = studentRepository.findAll();
        List<StudentResponse> studentResponses = students.stream()
                .map(StudentMapper::mapStudentToStudentResponse)
                .toList();

        return CompletableFuture.completedFuture(studentResponses);*/

        return CompletableFuture.supplyAsync(() -> {
            List<Student> students = studentRepository.findAll();
            return students.stream()
                    .map(StudentMapper::mapStudentToStudentResponse)
                    .toList();
        });
    }

    @Override
    @Async
    public CompletableFuture<StudentResponse> getStudent(Integer studentId) {
       /* Student student = studentRepository.findByid(studentId);
        StudentResponse studentResponse = StudentMapper.mapStudentToStudentResponse(student);
        return CompletableFuture.completedFuture(studentResponse);*/

        return CompletableFuture.supplyAsync(() -> {
            Student student = studentRepository.findById(studentId)
                    .orElseThrow(() -> new RuntimeException("Student not found"));
            return StudentMapper.mapStudentToStudentResponse(student);
        }).exceptionally(ex -> {
            throw new RuntimeException("Failed to fetch student", ex);
        });
    }

    @Override
    @Async
    public CompletableFuture<Void> deleteStudent(Integer studentId) {
        return CompletableFuture.runAsync(() -> {
            studentRepository.deleteById(studentId);
        });
    }

    @Override
    @Async
    public CompletableFuture<StudentResponse> saveStudent(StudentRequest studentRequest) {
        /*Student student = StudentMapper.mapStudentRequstToStudent(studentRequest);
        studentRepository.save(student);
        return CompletableFuture.completedFuture(StudentMapper.mapStudentToStudentResponse(student));*/

        return CompletableFuture.supplyAsync(() -> {
            Student student = StudentMapper.mapStudentRequstToStudent(studentRequest);
            studentRepository.save(student);
            return StudentMapper.mapStudentToStudentResponse(student);
        });
    }
}
