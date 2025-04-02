package com.Assignment.A3_Asma_Ahmed.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Assignment.A3_Asma_Ahmed.dao.departmentDao;
import com.Assignment.A3_Asma_Ahmed.dao.employeeDao;
import com.Assignment.A3_Asma_Ahmed.model.Department;
import com.Assignment.A3_Asma_Ahmed.model.Employee;

@RestController
@RequestMapping("/department/")
public class departmentController {
	@Autowired
	private departmentDao dao;
	
	@Transactional
	@PostMapping("/addDepartment/")
	public String saveEmployee(@RequestBody Department data) {
	    if (data.getDept_id() == null || data.getDept_id() == 0) {
	        data.setDept_id(generateRandomEmpId());
	    }
		dao.save(data);
		return "Department Saved";
	}
	
	private long generateRandomEmpId() {
	    return 10000000000L + new Random().nextInt(900000000); 
	}
	
	@GetMapping("/getDepartments/")
	public List<com.Assignment.A3_Asma_Ahmed.model.Department> getEmployee(){
		return (List<com.Assignment.A3_Asma_Ahmed.model.Department>) dao.findAll();
	}
	
    @Transactional
    @PostMapping("/updateDepartment")
    public String updateDepartment(@RequestBody Department data) {
        Department existingDepartment = dao.findById(data.getDept_id())
                .orElseThrow(() -> new RuntimeException("Department not found"));
        
        
        existingDepartment.setEmail(data.getEmail());
        existingDepartment.setDept_name(data.getDept_name());
        existingDepartment.setPhone(data.getPhone());

        dao.save(existingDepartment);
        return "Department updated successfully";
    }

}
