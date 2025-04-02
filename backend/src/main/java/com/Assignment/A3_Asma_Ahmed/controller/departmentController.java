package com.Assignment.A3_Asma_Ahmed.controller;

import java.util.List;

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
	
	@PostMapping("/addDepartment/")
	public String saveEmployee(@RequestBody Department data) {
		dao.save(data);
		return "Department Saved";
	}
	
	@GetMapping("/getDepartments/")
	public List<Department> getEmployee(){
		return (List<Department>) dao.findAll();
	}
	
    @Transactional
    @PostMapping("/updateDepartment")
    public String updateDepartment(@RequestBody Department data) {
        Department existingDepartment = dao.findById(data.getDept_id())
                .orElseThrow(() -> new RuntimeException("Department not found"));
        
        // Update fields
        existingDepartment.setEmail(data.getEmail());
        existingDepartment.setDept_name(data.getDept_name());
        existingDepartment.setPhone(data.getPhone());

        dao.save(existingDepartment);
        return "Department updated successfully";
    }

}
