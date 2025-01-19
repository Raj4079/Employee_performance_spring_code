package com.Employee_Performance.Services.imple;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee_Performance.Entities.Category;
import com.Employee_Performance.Repositories.Category_Repo;
import com.Employee_Performance.Services.Category_Service;

@Service
public class Category_service_imple implements Category_Service{

	@Autowired
	private Category_Repo repo;
	
	@Override
	public HashMap<String, Integer> getActual() {
		// TODO Auto-generated method stub
		HashMap<String,Integer> map = new HashMap<>();
		List<Category> list =  repo.findAll();
		for(Category c:list) {
			map.put(c.getRating(),c.getActual());
		}
		return map;
	}

	@Override
	public HashMap<String, Integer> getStandard() {
		HashMap<String,Integer> map = new HashMap<>();
		List<Category> list =  repo.findAll();
		for(Category c:list) {
			map.put(c.getRating(),c.getStandard());
		}
		return map;
	}

}
