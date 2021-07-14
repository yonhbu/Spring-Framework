package co.com.practical.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.practical.model.Employee;
import co.com.practical.model.Person;
import co.com.practical.service.EmployeeService;



@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;



	@GetMapping("/consult")
	public ResponseEntity<List<Employee>> consultEmployee () {
		return new ResponseEntity<List<Employee>>(employeeService.getConsult(), HttpStatus.OK);
	}


	@GetMapping("/consultId/{id}")
	public ResponseEntity<Employee> consultxID (@PathVariable("id") Long id) {
		return new ResponseEntity<Employee>(employeeService.getConsultId(id),HttpStatus.OK);		

	}


	@PostMapping("/insert")
	public ResponseEntity<Employee> insertEmployee (@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.insert_Employee(employee), HttpStatus.OK); 
	}


	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee (@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.insert_Employee(employee), HttpStatus.OK); 
	}


	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee (@PathVariable ("id") Long id) {
		Employee employee = employeeService.getConsultId(id);
		employeeService.delete_Employee(employee);
		return new ResponseEntity<String>("Employee delete", HttpStatus.OK);

	}


}
