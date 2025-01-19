package com.Employee_Performance.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Employee_Performance.Entities.Employee_Details;

public interface Emp_Repositories extends JpaRepository<Employee_Details, String>{

}
