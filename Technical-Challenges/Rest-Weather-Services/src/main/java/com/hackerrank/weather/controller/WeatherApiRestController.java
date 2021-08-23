package com.hackerrank.weather.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.weather.dto.WeatherRequestDTO;
import com.hackerrank.weather.dto.WeatherResponseDTO;
import com.hackerrank.weather.exception.WeatherDoesNotExistException;
import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.service.WeatherService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class WeatherApiRestController {
	
	@Autowired
	WeatherService weatherService;
	
	static SimpleDateFormat DATE_PATTERN = new SimpleDateFormat("dd/M/yyyy");
	
	@PostMapping("/weather")
	public ResponseEntity<WeatherResponseDTO> createWeather (@RequestBody WeatherRequestDTO weatherDTO) throws ParseException {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true);

		Weather weatherRequest = modelMapper.map(weatherDTO, Weather.class);
		Weather weather = weatherService.create_Weather(weatherRequest);
		
		// convert entity to DTO
		WeatherResponseDTO weatherResponse = modelMapper.map(weather, WeatherResponseDTO.class);
		return new ResponseEntity<>(weatherResponse, HttpStatus.CREATED);

	}
	
	
	@GetMapping("/weather/{expected}")
	public ResponseEntity<WeatherResponseDTO> getWeatherxID (@PathVariable("expected") int expected) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true);

		Weather weather = weatherService.getConsulWeatherById(expected)
				 .orElseThrow(() -> new WeatherDoesNotExistException(expected));

		WeatherResponseDTO weatherResponseDTO = modelMapper.map(weather, WeatherResponseDTO.class);
		return new ResponseEntity<>(weatherResponseDTO, HttpStatus.OK);
		
	}
	
	@GetMapping("/weather")
	public ResponseEntity<List<Weather>> consultWeathersOptionalInfo (@RequestParam Optional<Object> info) {
		if(info.isPresent()) {
			return new ResponseEntity<>(weatherService.getConsultByInfo(info.get()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(weatherService.getConsult(), HttpStatus.OK);
		}
	}
}