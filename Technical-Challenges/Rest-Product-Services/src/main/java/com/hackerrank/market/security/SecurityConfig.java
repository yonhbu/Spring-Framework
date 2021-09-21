package com.hackerrank.market.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hackerrank.market.security.filter.JwtFilterRequest;
import com.hackerrank.market.service.MarketUserDetailService;


@EnableWebSecurity // Esta es la clase encargada de nuestra seguridad
public class SecurityConfig extends WebSecurityConfigurerAdapter { //Entiende de esta clase de Spring Security
	
	@Autowired
	private MarketUserDetailService marketUserDetailService;
	
	
	@Autowired
	private JwtFilterRequest jwtFilterRequest;
	
	

	@Override // Generamos este @Override propio de security
	protected void configure(AuthenticationManagerBuilder auth) throws Exception { //Este metodo lo modificamos diciendo que la autenticacion la vamos a generar nosotros, y no  spring boot 
		auth.userDetailsService(marketUserDetailService);                         ///Ya que al arrancar este genera una contrase;a aleatoria
	}

	
	@Override // Con este metodo decimos que queremos autenticar todas las peticiones desde el recurso /authenticate, que lo muestre sin autenticarse por que con este lo haran
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/**/authenticate").permitAll() //Desabilitamos las peticiones cruzadas y que autorice las peticiones de este recurso /**/authenticate con antMatchers hacemos esto
		.anyRequest().authenticated() // Y que el resto de peticiones o recursos si requiere autenticarse esto lo hacemos con .anyRequest().authenticated()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); 
		//Ahora en esta parte debemos decir que va hacer el filtro el encargado de recibir las peticiones y procesarlas
		//Con and.sessionManagement etc.etc sera STATELESS es decir sin sesion, ya que todos nuestros recursos usaran token
		
		
		//Le inyectamos el filtro que se usara de ahora en adelante
		http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class); // Con UsernamePasswordAuthenticationFilter decimos de que tipo de filtro es, el cual sera de usuario y contrase;a
		
	}

	//Para finalizar como desde la clase AuthController estamos utilizando el Gestor de Autenticacion de Spring osea la interfaz AuthenticationManager debemos incluirlo aca y que arranque de una
	@Override
	@Bean //Para que lo use y sepa que lo estamos eligiendo a el para la autenticacion
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean(); // Que sea spring quien continue manejando la autenticacion
	}
	
	
	
	
	

}
