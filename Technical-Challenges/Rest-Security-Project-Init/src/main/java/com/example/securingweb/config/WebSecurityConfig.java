package com.example.securingweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
        .antMatchers("/user/**").hasRole("USER")//USER role can access /users/**
        .antMatchers("/admin/**").hasRole("ADMIN")//ADMIN role can access /admin/**
        .antMatchers("/shared/**").hasRole("ADMIN")//ADMIN role can access /shareds/**
        .antMatchers("/shared/**").hasRole("USER")//USER role can access /shared/**
        .antMatchers("/**", "/logout").permitAll()// anyone can access /public/**
        .anyRequest().authenticated()//any other request just need authentication
        .and()
        .formLogin();//enable form login
	}
	
   @Autowired
   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	   auth.inMemoryAuthentication()
       .withUser("user").password("{noop}1234").roles("USER")
       .and()
       .withUser("admin").password("{noop}1234").roles("ADMIN");
    }
	   
}  
