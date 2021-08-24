package com.hackerrank.weather.service;


import java.util.List;
import java.util.Optional;

import com.hackerrank.weather.model.Weather;


public interface IWeatherService {
	
	public List<Weather> findWeatherByCityInIgnoreCase  (List<String> cityList);
	
	public Weather create_Weather (Weather weather);
	
	public Optional<Weather> getConsulWeatherById(Integer id);

	
}
