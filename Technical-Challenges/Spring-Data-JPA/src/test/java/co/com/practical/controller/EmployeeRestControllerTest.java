package co.com.practical.controller;


import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.practical.model.Employee;
import co.com.practical.model.Person;
import co.com.practical.model.Position;
import co.com.practical.service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeRestController.class)
public class EmployeeRestControllerTest {


	@Autowired
	private MockMvc mockMvc;  

	@MockBean
	private EmployeeService employeeService;

	private Employee employee;

	@Before
	public void init () {

		employee = Employee.builder()
				.id(1L)
				.salary(2000)
				.position(Position.builder()
						.role("dev").build())
				.person(Person.builder()
						.name("Juan Antonio")
						.lastname("Vargas Bustos")
						.address("cra 12 #30-99")
						.cellphone("313000000").build())
				.build();

	}


	@Test
	public void testConsultEmployee() throws Exception {

		doReturn(new ArrayList<>()).when(employeeService).getConsult();
		this.mockMvc.perform(get("/api/consult"))
		.andExpect(status().isOk());
	}


	@Test
	public void testConsultEmployeeByID () throws Exception {

		when(employeeService.getConsultId(1L)).thenReturn(employee);
		mockMvc.perform(get("/api/consultId/{id}", 1L))
		.andExpect(status().isOk());

	}

	@Test
	public void testInsertEmployee () throws Exception {

		mockMvc.perform( MockMvcRequestBuilders
				.post("/api/insert")
				.content(asJsonString(employee))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated());



	}

	@Test
	public void testUpdateEmployee () throws Exception {

		mockMvc.perform( MockMvcRequestBuilders
				.put("/api/update")
				.content(asJsonString(employee))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());



	}



	@Test
	public void deleteEmployee() throws Exception 
	{

		when(employeeService.getConsultId(1L)).thenReturn(employee);
		mockMvc.perform(delete("/api/delete/{id}", 1L))
		.andExpect(status().isOk());


	}


	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}