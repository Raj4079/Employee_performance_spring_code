package com.Employee_Performance.Controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employee_Performance.Entities.Employee_Details;
import com.Employee_Performance.Services.imple.Appraisal_Service_impl;
import com.Employee_Performance.Services.imple.Category_service_imple;
import com.Employee_Performance.Services.imple.Emp_Service_impl;

@RestController
@RequestMapping("/emp")
public class UserController {
	
	@Autowired
	private Appraisal_Service_impl app_ser;
	
	@Autowired
	private Category_service_imple cat_ser;
	
	@Autowired
	private Emp_Service_impl emp_ser;
	
	@PostMapping
	public ResponseEntity<Employee_Details> saveEmp(@RequestBody Employee_Details emp)
	{
		Employee_Details resp = emp_ser.saveEmp(emp);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(resp);
	}
	
	@PutMapping
	public ResponseEntity<Employee_Details> updateEmp(@RequestBody Employee_Details emp)
	{
		Employee_Details resp = emp_ser.updateEmp(emp);
		return ResponseEntity.status(HttpStatus.CREATED).body(resp);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee_Details> deleteEmp(@PathVariable("id") String id)
	{
		Employee_Details resp = emp_ser.deleteEmp(id);
		return  ResponseEntity.ok(resp);
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee_Details> getUser(@PathVariable("id") String id)
	{
		Employee_Details emp = emp_ser.getEmp(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(emp);
	}
	
	@GetMapping("/AllActutal")
	public ResponseEntity< HashMap<String,Integer> > getAllActual()
	{
		HashMap<String,Integer> map = cat_ser.getActual();
		
		return ResponseEntity.ok(map);
				
	}

	@GetMapping("/AllStandard")
	public ResponseEntity< HashMap<String,Integer> > getAllStandard()
	{
		HashMap<String,Integer> map = cat_ser.getStandard();
		
		return ResponseEntity.ok(map);
				
	}
	
	@GetMapping("/Appraisal")
	public ResponseEntity< HashMap<String, String> > getAppraisal()
	{
		HashMap<String,String> map = app_ser.getAllAppraisal();		
		return ResponseEntity.ok(map);
				
	}
}
