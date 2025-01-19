package com.Employee_Performance.Services.imple;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee_Performance.Entities.Appraisal;
import com.Employee_Performance.Repositories.Appraisal_Repo;
import com.Employee_Performance.Services.Appraisal_Servcie;

@Service
public class Appraisal_Service_impl implements Appraisal_Servcie {

	@Autowired
	private Appraisal_Repo repo;
	
	@Override
	public HashMap<String,String> getAllAppraisal(){
		HashMap<String,String> map = new HashMap<>();
		List<Appraisal> list =  repo.findAll();
		for(Appraisal a:list) {
			map.put(a.getAppraisal(),a.getRating());
		}
		return map;
	} 
}
