package com.cityconnect.service;

import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.cityconnect.util.RouteUtility;

@Service
public class RouterService {

	
	public boolean checkRouteAvailablity(String origin, String destination){
		Map<String,String> connectionMap = RouteUtility.getConnectivityMap();
		int count  = 0;
		String key = origin;
		boolean result = false;
	
			while (count <= connectionMap.keySet().size()) {
			if (null != key && null != destination) {
				if (connectionMap.get(key).equals(destination)) {
					result = true;
					break;
				} else if (connectionMap.get(destination).equals(key)) {
					result = true;
					break;
				} else {
					key = connectionMap.get(key);
					count++;
				}
			}
			} 
		
		return result;
	}
	
}