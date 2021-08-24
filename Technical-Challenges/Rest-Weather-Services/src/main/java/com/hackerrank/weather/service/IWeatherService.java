package com.hackerrank.weather.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.hackerrank.weather.model.Weather;


public interface IWeatherService {
	
	public List<Weather> getConsultOrOptionalInfo  (List<String> cityList, Date date);
	
	public Weather create_Weather (Weather weather);
	
	public Optional<Weather> getConsulWeatherById(Integer id);

	
}
