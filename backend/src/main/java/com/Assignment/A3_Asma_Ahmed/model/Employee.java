package com.Assignment.A3_Asma_Ahmed.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.JoinColumn;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emp_id;
    @JsonProperty("email")
    private String email;
    @JsonProperty("first_name")
    private String first_name;
    @JsonProperty("last_name")
    private String last_name;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("hire_date")
    private String hire_date;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "emp_dept",
        joinColumns = @JoinColumn(name = "emp_id"),
        inverseJoinColumns = @JoinColumn(name = "dept_id")
    )
    @JsonIgnore
    private Set<Department> departments;
}
