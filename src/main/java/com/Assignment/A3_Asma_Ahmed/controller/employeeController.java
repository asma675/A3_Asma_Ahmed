// Asma Ahmed
// 991699083

package com.Assignment.A3_Asma_Ahmed.controller;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.Assignment.A3_Asma_Ahmed.dao.departmentDao;
import com.Assignment.A3_Asma_Ahmed.dao.employeeDao;
import com.Assignment.A3_Asma_Ahmed.model.Department;
import com.Assignment.A3_Asma_Ahmed.model.Employee;
import com.Assignment.A3_Asma_Ahmed.model.EmployeeDeptDTO;
	
	@RestController
	@RequestMapping("/employee")
	public class employeeController {
		@Autowired
		private employeeDao empDao;
		
		@Autowired
		private departmentDao depDao;
		
		@Transactional
		@PostMapping("/addEmployee")
		public String saveEmployee(@RequestBody Employee data) {
		    if (data.getEmp_id() == null || data.getEmp_id() == 0) {
		        data.setEmp_id(generateRandomEmpId());
		    }
			empDao.save(data);
			return "Employee Saved";
		}
		private long generateRandomEmpId() {
		    return 10000000000L + new Random().nextInt(900000000); 
		}
		
		@GetMapping("/getEmployees")
		@Transactional
		public List<com.Assignment.A3_Asma_Ahmed.model.Employee> getEmployee(){
			return (List<com.Assignment.A3_Asma_Ahmed.model.Employee>) empDao.findAll();
		}
		
		@PostMapping("/{employeeId}/assign/{departmentId}")
		public String assignEmployeeToDepartment(
		        @PathVariable Long employeeId,
		        @PathVariable Long departmentId) {

		    Employee employee = empDao.findById(employeeId)
		            .orElseThrow(() -> new RuntimeException("Employee not found"));
		    Department department = depDao.findById(departmentId)
		            .orElseThrow(() -> new RuntimeException("Department not found"));

		    employee.getDepartments().add(department);

		    department.getEmployees().add(employee);

		    empDao.save(employee);
		    depDao.save(department);

		    return "Employee assigned to Department successfully";
		}
	
	    @GetMapping("/employeesWithDepartments")
	    public List<EmployeeDeptDTO> getAllEmployeesWithDepartments() {
	        return empDao.findAllEmployeesWithDepartments();
	    }
	    
	    @Transactional
	    @PostMapping("/updateEmployee")
	    public String updateEmployee(@RequestBody Employee data) {
	        Employee existingEmployee = empDao.findById(data.getEmp_id())
	                .orElseThrow(() -> new RuntimeException("Employee not found"));
	        
	        existingEmployee.setEmail(data.getEmail());
	        existingEmployee.setFirst_name(data.getFirst_name());
	        existingEmployee.setLast_name(data.getLast_name());
	        existingEmployee.setGender(data.getGender());
	        existingEmployee.setHire_date(data.getHire_date());
	        existingEmployee.setDepartments(data.getDepartments());  

	        empDao.save(existingEmployee);
	        return "Employee updated successfully";
	    }
		
}
