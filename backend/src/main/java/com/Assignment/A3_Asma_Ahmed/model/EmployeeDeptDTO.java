package com.Assignment.A3_Asma_Ahmed.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDeptDTO {

    private int emp_id;
    private String email;
    private String first_name;
    private String last_name;
    private String gender;
    private String hire_date;
    private String dept_name;
}
