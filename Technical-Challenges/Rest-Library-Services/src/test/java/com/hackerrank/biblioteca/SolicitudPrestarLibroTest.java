package com.hackerrank.biblioteca;

public class SolicitudPrestarLibroTest {

	private Long id;
    private String isbn;
    private String identificacionUsuario;
    private int tipoUsuario;

    public SolicitudPrestarLibroTest(Long id, String isbn, String identificacionUsuario, int tipoUsuario) {
    	this.id = id;
        this.isbn = isbn;
        this.identificacionUsuario = identificacionUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
    
    
}
