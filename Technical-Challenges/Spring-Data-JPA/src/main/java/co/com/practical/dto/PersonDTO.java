package co.com.practical.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

	private Long id;
	private String name;
	private String lastname; 
	private String address; 
	private String cellphone; 
	private String cityName; 
	


	
	
	
}