// Asma Ahmed
// 991699083

package com.Assignment.A3_Asma_Ahmed.dao;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Assignment.A3_Asma_Ahmed.model.Employee;
import com.Assignment.A3_Asma_Ahmed.model.EmployeeDeptDTO;

import jakarta.transaction.Transactional;

public interface employeeDao extends JpaRepository<com.Assignment.A3_Asma_Ahmed.model.Employee, Long>{
	
	
	@Query(value = "SELECT e.emp_id, e.email, e.first_name, e.last_name, e.gender, e.hire_date, d.dept_name " +
            "FROM employee e " +
            "LEFT JOIN emp_dept ed ON e.emp_id = ed.emp_id " +
            "LEFT JOIN department d ON ed.dept_id = d.dept_id", 
    nativeQuery = true)
List<EmployeeDeptDTO> findAllEmployeesWithDepartments();
	

}
