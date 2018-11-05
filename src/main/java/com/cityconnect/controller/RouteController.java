package com.cityconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cityconnect.service.RouterService;

@RestController
public class RouteController {

	@Autowired
	RouterService routerService;
	
	@GetMapping("/connected")
	@ResponseBody
	public String retrieveCoursesForStudent(@RequestParam("origin") String origin, @RequestParam("destination") String destination) {
		boolean result = false;
		String response = "no";
		if(null != origin && !origin.isEmpty() && null != destination && !destination.isEmpty() ){
			result = routerService.checkRouteAvailablity(origin, destination);
			if(result)
				response = "yes";
		}
		
		 return response;
	}

}
