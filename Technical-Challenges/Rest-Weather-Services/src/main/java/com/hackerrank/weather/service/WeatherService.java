package com.hackerrank.weather.service;


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
		log.info("*******INIT CREATED Weather ******");
		return weatherRepository.save(weather);
	}


	@Override
	public Optional<Weather> getConsulWeatherById(Integer id) {
		return weatherRepository.findById(id); 
	}


	@Override
	public List<Weather> getConsultByInfo(Object info) {
		return (List<Weather>) weatherRepository.findWeatherByInfo(info);
	}


	@Override
	public List<Weather> getConsult() {
		return (List<Weather>) weatherRepository.findAll();
	}

}
