package com.asynccontroller.services.Impl;

import com.asynccontroller.data.entities.Student;
import com.asynccontroller.data.repos.StudentRepository;
import com.asynccontroller.mapper.StudentMapper;
import com.asynccontroller.models.requests.StudentRequest;
import com.asynccontroller.models.response.StudentResponse;
import com.asynccontroller.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public ResponseEntity<List<StudentResponse>> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return new ResponseEntity<>(students.stream().map(StudentMapper::mapStudentToStudentResponse).toList(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StudentResponse> getStudent(Integer studentId) {
        Student student = studentRepository.findByid(studentId);
        return new ResponseEntity<>(StudentMapper.mapStudentToStudentResponse(student),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteStudent(Integer studentId) {
        studentRepository.deleteById(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StudentResponse> saveStudent(StudentRequest studentRequest) {
        Student student = StudentMapper.mapStudentRequstToStudent(studentRequest);
        studentRepository.save(student);
        return new ResponseEntity<>(StudentMapper.mapStudentToStudentResponse(student),HttpStatus.CREATED);
    }
}
