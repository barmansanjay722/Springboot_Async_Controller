package com.asynccontroller.mapper;

import com.asynccontroller.data.entities.Student;
import com.asynccontroller.models.requests.StudentRequest;
import com.asynccontroller.models.response.StudentResponse;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class StudentMapper {
    public static StudentResponse mapStudentToStudentResponse(Student student) {
        return StudentResponse.builder()
                .id(student.getId())
                .name(student.getName())
                .address(student.getAddress())
                .age(student.getAge())
                .email(student.getEmail())
                .status(true)
                .build();
    }

    public static Student mapStudentRequstToStudent(StudentRequest studentRequest) {
        return Student.builder()
                .name(studentRequest.getName())
                .address(studentRequest.getAddress())
                .age(studentRequest.getAge())
                .email(studentRequest.getEmail())
                .build();
    }
}
