package com.hackerrank.weather.dto;



import java.util.Date;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponseDTO {
	
    private Integer id;
    private Date date;  
    private Float lat;
    private Float lon;
    private String city;
    private String state;
    private List<Double> temperatures;
    

	
}
