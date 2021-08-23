package com.hackerrank.weather.repository;

import com.hackerrank.weather.model.Weather;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {
	
	Optional<Weather> findById(Integer id);
	
	@Query("SELECT w FROM Weather w WHERE w.date = :date")
	List<Weather> findWeatherByInfo(@Param("date") final Object date);
	
}
