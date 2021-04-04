package com.weather.thinkific.services;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


import springfox.documentation.spring.web.json.Json;
import com.alicp.jetcache.anno.Cached;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;






@Service
public class WeatherService {
    private final String URI = "http://api.openweathermap.org/data/2.5/weather";
    private final String API_ID = "43259e5f1f513b63210b590ffd929c69";



    @Cached(expire = 10, timeUnit = TimeUnit.MINUTES)
    public ResponseEntity<?> weatherForecast(String city)  {
    	Map<String,String> output = new HashMap<String,String>();
        try {
        	StringBuilder result = new StringBuilder();
        	URL url = new URL(this.url(city));
        	HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        	if(conn.getResponseCode() == 200) {
        		BufferedReader  rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            	String line;
            	while((line = rd.readLine()) != null) {
            		result.append(line);
            		
            	}
            	rd.close();
            
            	Map<String,Object> respMap = jsonToMap(result.toString());
            	Map<String,Object> mainMap = jsonToMap(respMap.get("main").toString());
            	Map<String,Object> windMap = jsonToMap(respMap.get("wind").toString());
            		
            output.put("Temperature(in Celsius):", mainMap.get("temp").toString());
            output.put("feels_like(in Celsius):", mainMap.get("temp").toString());
            output.put("Minimum Temperature(in Celsius):", mainMap.get("temp_min").toString());
            output.put("Maximum Temperature(in Celsius):", mainMap.get("temp_max").toString());
            output.put("Wind speed(in m/s):", windMap.get("speed").toString());
            return new ResponseEntity<>(output, HttpStatus.OK);
        	} else {
        		output.put("Sorry, city not found", "Error code:"+conn.getResponseCode());
        		return new ResponseEntity<>(output,HttpStatus.BAD_REQUEST);
        	}
     
        	
        } catch (Exception e) {
        	System.out.println(e);
        
		} 

        return new ResponseEntity<>(output, HttpStatus.OK);
    }

   private static Map<String, Object> jsonToMap(String str) {
	   Map<String, Object> map = new Gson().fromJson(
			   	str,new TypeToken<HashMap<String, Object>>() {}.getType()
			   	);
	   return map;
   }

    private String url(String city) {
        return String.format(URI.concat("?q=%s").concat("&appid=%s").concat("&units=metric"), city, API_ID);
    }
}