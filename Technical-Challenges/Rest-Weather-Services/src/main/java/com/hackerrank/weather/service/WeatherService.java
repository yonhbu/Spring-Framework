package com.hackerrank.weather.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class WeatherService implements IWeatherService{

	@Autowired
	WeatherRepository weatherRepository;


	@Override
	public Weather create_Weather(Weather weather) {
		log.info("*******INIT CREATED WEATHER ******");
		return weatherRepository.save(weather);
	}


	@Override
	public Optional<Weather> getConsulWeatherById(Integer id) {
		return weatherRepository.findById(id); 
	}


	@Override
	public List<Weather> getConsultOrOptionalInfo (List<String> city, List<Date> date) {
		if(city != null){
			
			return (List<Weather>) weatherRepository.findWeatherByCityInIgnoreCase(city);
			
		}else if (date != null) {
			
			return (List<Weather>) weatherRepository.findWeatherByDateIn(date);			
		}
		
		return (List<Weather>) weatherRepository.findAll();
	}


}
