package com.cityconnect.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import com.cityconnect.service.RouterService;

public class RouteUtility {

		public static Map<String,String> connectivityMap;
		
		public static Map<String,String> getConnectivityMap(){
			if(null != connectivityMap){
				return connectivityMap;
			}else {
				connectivityMap = prepareMapfromFile();
				
			}
			
			return connectivityMap;
		}

		private static Map<String, String> prepareMapfromFile() {
			
			String fileName = "city.txt";
			if(null == connectivityMap){
				connectivityMap = new HashMap<String,String>();
			}

			//read file into stream, try-with-resources
			
			try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

				stream.forEach(a-> {
					System.out.println("a-->"+a);
					String [] arrayTokes = a.split(",");
					connectivityMap.put(arrayTokes[0], arrayTokes[1]);
				});
				

			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(connectivityMap);
			return connectivityMap;
		}
		
	/*	public static void main(String[] args) {
			getConnectivityMap();
			RouterService rs = new RouterService();
			System.out.println(rs.checkRouteAvailablity("Boston", "Newark"));
			System.out.println(rs.checkRouteAvailablity("Boston", "Philadelphia"));
		}*/
}
