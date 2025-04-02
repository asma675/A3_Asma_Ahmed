package com.Assignment.A3_Asma_Ahmed.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface EmployeeDeptDTO {
    Long getEmp_id();
    String getEmail();
    String getFirst_name();
    String getLast_name();
    String getGender();
    String getHire_date();
    String getDept_name();
}
