package com.hackerrank.weather.dto;


import java.util.Date;
import java.util.List;



import lombok.Data;

@Data
public class WeatherRequestDTO {
	

    private Date date;
    private Float lat;
    private Float lon;
    private String city;
    private String state;
    private List<Double> temperatures;
	
}
