package com.hackerrank.weather.service;


import java.util.List;
import java.util.Optional;

import com.hackerrank.weather.model.Weather;


public interface IWeatherService {
	
	public List<Weather> getConsult ();
	
	public Weather create_Weather (Weather weather);
	
	public Optional<Weather> getConsulWeatherById(Integer id);
	
	public List<Weather> getConsultByInfo (Object info);
	
}
