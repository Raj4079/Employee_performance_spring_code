package com.Employee_Performance.Services;

import com.Employee_Performance.Entities.Employee_Details;

public interface Emp_Service {

	public Employee_Details saveEmp(Employee_Details emp);
	
	public Employee_Details deleteEmp(String id);
	
	public Employee_Details updateEmp(Employee_Details emp);
	
	public Employee_Details getEmp(String id);
}
