package com.asynccontroller.models.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentResponse {

    private Integer id;
    private String name;
    private String address;
    private Integer age;
    private String email;
    private Boolean status;
}
