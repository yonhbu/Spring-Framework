package co.com.practical.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "idPerson")
	private Long id;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "lastname")
	private String lastname; 
	
	@Column (name = "address")
	private String address; 
	
	@Column (name = "cellphone")
	private String cellphone; 
	
	@Column (name = "cityName")
	private String cityName; 
	
	@ManyToOne
	@JoinColumn (name = "idEmployee")
	private Employee employee;

	
	
	
}