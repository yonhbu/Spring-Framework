package com.hackerrank.biblioteca;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearUsuarioTest {

	private Long id;
	private String nombre;
	private String apellido; 
	private String identificacionUsuario;
	private String direccion; 
	private String telefono; 
	private String ciudad; 
	private int tipoDeUsuario;
	
   
    
}
