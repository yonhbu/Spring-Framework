package com.hackerrank.biblioteca;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class PrestamoTests {


    public static final int USUARIO_AFILIADO = 1;
    public static final int USUARIO_EMPLEADO = 2;
    public static final int USUARIO_INVITADO = 3;
    public static final int USUARIO_DESCONOCIDO = 5;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;
   
    @Before
    public void initLibro () throws Exception {
    

     MvcResult resultadoCrearPrimerLibro = mvc.perform(
                MockMvcRequestBuilders.post("/prestamo/crearLibro")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new CrearLibroTest(1L, "978J007101", "Java: A Beginner's Guide","Mcgraw-Hill", 20))))
                .andExpect(status().isOk())
                .andReturn();
   	 
     MvcResult resultadoCrearSegundoLibro = mvc.perform(
             MockMvcRequestBuilders.post("/prestamo/crearLibro")
                     .contentType(MediaType.APPLICATION_JSON)
                     .content(objectMapper.writeValueAsString(new CrearLibroTest(2L, "978J007102", "ANGULAR: A Beginner's Guide","Mcgraw-Hill", 20))))
             .andExpect(status().isOk())
             .andReturn();
     
    
     
    }
    
    
    @Test
    public void prestamoLibroUsuarioAfiliadoDeberiaAlmacenarCorrectamenteYCalcularFechaDeDevolucion() throws Exception {
    
    	 MvcResult resultadoCrearUsuarioAfiliado = mvc.perform(
                 MockMvcRequestBuilders.post("/prestamo/crearUsuario")
                         .contentType(MediaType.APPLICATION_JSON)
                         .content(objectMapper.writeValueAsString(new CrearUsuarioTest(1L,"Jose Armando","Reguillo Vargas", "2021ABCD01","cra 12 #30-99","313000000","Medellin", 1))))
                 .andExpect(status().isOk())
                 .andReturn();

        MvcResult resultadoLibroPrestado = mvc.perform(
                MockMvcRequestBuilders.post("/prestamo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new SolicitudPrestarLibroTest(1L, "978J007101", "2021ABCD01", USUARIO_AFILIADO))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.fechaMaximaDevolucion").exists())
                .andReturn();


        ResultadoPrestarTest resultadoPrestamo = objectMapper.readValue(resultadoLibroPrestado.getResponse().getContentAsString(), ResultadoPrestarTest.class);

        LocalDate fechaPrestamo = LocalDate.now();
        fechaPrestamo = addDaysSkippingWeekends(fechaPrestamo, 10);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        mvc.perform(MockMvcRequestBuilders
                .get("/prestamo/" + resultadoPrestamo.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.fechaMaximaDevolucion", is(fechaPrestamo.format(formato))))
                .andExpect(jsonPath("$.isbn", is("978J007101")))
                .andExpect(jsonPath("$.identificacionUsuario", is("2021ABCD01")))
                .andExpect(jsonPath("$.tipoUsuario", is(USUARIO_AFILIADO)));

    }

    
    
    @Test
    public void prestamoLibroUsuarioEmpleadoDeberiaAlmacenarCorrectamenteYCalcularFechaDeDevolucion() throws Exception {
    	
   	 MvcResult resultadoCrearUsuarioEmpleado = mvc.perform(
             MockMvcRequestBuilders.post("/prestamo/crearUsuario")
                     .contentType(MediaType.APPLICATION_JSON)
                     .content(objectMapper.writeValueAsString(new CrearUsuarioTest(1L,"Juan Antonio","Valencia Gomez", "2021ABCD02","cra 12 #30-99","313000000","Medellin", 2))))
             .andExpect(status().isOk())
             .andReturn();

        MvcResult resultadoLibroPrestado = mvc.perform(MockMvcRequestBuilders
                .post("/prestamo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new SolicitudPrestarLibroTest(1L, "978J007101", "2021ABCD02", USUARIO_EMPLEADO))))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.fechaMaximaDevolucion").exists())
                .andReturn();

        ResultadoPrestarTest resultadoPrestamo = objectMapper.readValue(resultadoLibroPrestado.getResponse().getContentAsString(), ResultadoPrestarTest.class);

        LocalDate fechaPrestamo = LocalDate.now();
        fechaPrestamo = addDaysSkippingWeekends(fechaPrestamo, 8);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        mvc.perform(MockMvcRequestBuilders
                .get("/prestamo/" + resultadoPrestamo.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.fechaMaximaDevolucion", is(fechaPrestamo.format(formato))))
                .andExpect(jsonPath("$.isbn", is("978J007101")))
                .andExpect(jsonPath("$.identificacionUsuario", is("2021ABCD02")))
                .andExpect(jsonPath("$.tipoUsuario", is(USUARIO_EMPLEADO)));


    }
    
    
    @Test
    public void prestamoLibroUsuarioInvitadoDeberiaAlmacenarCorrectamenteYCalcularFechaDeDevolucion() throws Exception {
    	
    	MvcResult resultadoCrearUsuarioInvitado = mvc.perform(
                MockMvcRequestBuilders.post("/prestamo/crearUsuario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new CrearUsuarioTest(1L,"Yesica","Durango", "2021ABCD03","cra 12 #30-99","313000000","Medellin", 3))))
                .andExpect(status().isOk())
                .andReturn();


        MvcResult resultadoLibroPrestado = mvc.perform(MockMvcRequestBuilders
                .post("/prestamo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new SolicitudPrestarLibroTest(1L, "978J007101", "2021ABCD03", USUARIO_INVITADO))))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.fechaMaximaDevolucion").exists())
                .andReturn();

        ResultadoPrestarTest resultadoPrestamo = objectMapper.readValue(resultadoLibroPrestado.getResponse().getContentAsString(), ResultadoPrestarTest.class);

        LocalDate fechaPrestamo = LocalDate.now();
        fechaPrestamo = addDaysSkippingWeekends(fechaPrestamo, 7);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        mvc.perform(MockMvcRequestBuilders
                .get("/prestamo/" + resultadoPrestamo.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.fechaMaximaDevolucion", is(fechaPrestamo.format(formato))))
                .andExpect(jsonPath("$.isbn", is("978J007101")))
                .andExpect(jsonPath("$.identificacionUsuario", is("2021ABCD03")))
                .andExpect(jsonPath("$.tipoUsuario", is(USUARIO_INVITADO)));


    }
    
    
    @Test
    public void usuarioInvitadoTratandoDePrestarUnSegundoLibroDeberiaRetornarExcepcion() throws Exception {
    	
    	MvcResult resultadoCrearUsuarioInvitado = mvc.perform(
                MockMvcRequestBuilders.post("/prestamo/crearUsuario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new CrearUsuarioTest(1L,"Yesica","Durango", "1111111111","cra 12 #30-99","313000000","Medellin", 3))))
                .andExpect(status().isOk())
                .andReturn();

        mvc.perform(MockMvcRequestBuilders
                .post("/prestamo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new SolicitudPrestarLibroTest(1L,"978J007101", "1111111111", USUARIO_INVITADO))))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.fechaMaximaDevolucion").exists());

        mvc.perform(MockMvcRequestBuilders
                .post("/prestamo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new SolicitudPrestarLibroTest(2L, "978J007102", "1111111111", USUARIO_INVITADO))))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.mensaje", is("El usuario con identificación 1111111111 ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo")));

    }


    
    @Test
    public void usuarioNoInvitadoTratandoDePrestarUnSegundoLibroDeberiaPrestarloCorrectamente() throws Exception {
    	
   	 MvcResult resultadoCrearUsuarioAfiliado = mvc.perform(
             MockMvcRequestBuilders.post("/prestamo/crearUsuario")
                     .contentType(MediaType.APPLICATION_JSON)
                     .content(objectMapper.writeValueAsString(new CrearUsuarioTest(1L,"Jose Armando","Reguillo Vargas", "1111111111","cra 12 #30-99","313000000","Medellin", 1))))
             .andExpect(status().isOk())
             .andReturn();

        mvc.perform(MockMvcRequestBuilders
                .post("/prestamo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new SolicitudPrestarLibroTest(1L,"978J007101", "1111111111", USUARIO_AFILIADO))))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.fechaMaximaDevolucion").exists());

        mvc.perform(MockMvcRequestBuilders
                .post("/prestamo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new SolicitudPrestarLibroTest(2L,"978J007102", "1111111111", USUARIO_AFILIADO))))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.fechaMaximaDevolucion").exists());

    }
    
    @Test
    public void prestamoConTipoDeUsuarioNoPermitidoDeberiaRetornarExcepcion() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                .post("/prestamo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new SolicitudPrestarLibroTest(8L,"978J007102", "1111111111", USUARIO_DESCONOCIDO))))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.mensaje", is("Tipo de usuario no permitido en la biblioteca")));
    }

    

    public static LocalDate addDaysSkippingWeekends(LocalDate date, int days) {
        LocalDate result = date;
        int addedDays = 0;
        while (addedDays < days) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }
        return result;
    }
    
}
