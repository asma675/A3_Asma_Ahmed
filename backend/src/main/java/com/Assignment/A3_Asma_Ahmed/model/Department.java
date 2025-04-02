package com.Assignment.A3_Asma_Ahmed.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    private Long dept_id;
    @JsonProperty("email")
    private String email;
    @JsonProperty("dept_name")
    private String dept_name;
    @JsonProperty("phone")
    private String phone;
    @ManyToMany(mappedBy = "departments",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Employee> employees;

}
