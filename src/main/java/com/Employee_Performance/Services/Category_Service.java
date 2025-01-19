package com.Employee_Performance.Services;

import java.util.HashMap;

public interface Category_Service {

	public HashMap<String,Integer> getActual();
	
	public HashMap<String,Integer> getStandard();
}
