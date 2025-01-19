package com.Employee_Performance.Services.imple;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee_Performance.Entities.Employee_Details;
import com.Employee_Performance.Repositories.Emp_Repositories;
import com.Employee_Performance.Services.Emp_Service;

@Service
public class Emp_Service_impl implements Emp_Service{

	@Autowired
	private Emp_Repositories emp_repo;
	@Override
	public Employee_Details saveEmp(Employee_Details emp) {
		return   emp_repo.save(emp);
	}

	@Override
	public Employee_Details deleteEmp(String id) {
		@SuppressWarnings("deprecation")
		Employee_Details emp = emp_repo.getById(id);
		 Optional<Employee_Details> resp =  emp_repo.findById(id);
		    if(resp.isPresent())emp = resp.get();
		emp_repo.deleteById(id);
		return  emp;
	}

	@Override
	public Employee_Details updateEmp(Employee_Details emp) {
		return emp_repo.save(emp) ;
	}

	
	@Override
	public Employee_Details getEmp(String id) {
		
		@SuppressWarnings("deprecation")
		Employee_Details emp = emp_repo.getById(id);
		System.out.println(emp);
	    Optional<Employee_Details> resp =  emp_repo.findById(id);
	    if(resp.isPresent())emp = resp.get();
		return emp;
		
	}
	
	

}
