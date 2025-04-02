package com.Assignment.A3_Asma_Ahmed.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Assignment.A3_Asma_Ahmed.model.Employee;

public interface departmentDao extends JpaRepository<com.Assignment.A3_Asma_Ahmed.model.Department, Long>{

}
