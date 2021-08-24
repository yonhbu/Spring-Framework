package com.hackerrank.weather.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hackerrank.weather.model.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {
	
	Optional<Weather> findById(Integer id);
	
	//@Query("SELECT w FROM Weather w WHERE w.city IN :city")
	List<Weather> findWeatherByCityInIgnoreCase (List<String> city);
	
	@Query("SELECT w FROM Weather w WHERE w.date = date")
	List<Weather> findWeatherByDate (Date date);
	
	//I can do it also this
	//List<Weather> findWeatherByCityIn(List<String> city);
	
	
}
