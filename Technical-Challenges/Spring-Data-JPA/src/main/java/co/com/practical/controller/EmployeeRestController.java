package co.com.practical.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.practical.model.Employee;
import co.com.practical.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;




@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeRestController {

	@Autowired
	private EmployeeServiceImpl employeeService;


	@GetMapping("/consult")
	public ResponseEntity<List<Employee>> consultEmployeesOptionalRole (@RequestParam Optional<String> role) {

		if(role.isPresent()) {

			return new ResponseEntity<>(employeeService.getConsultByRole(role.get()), HttpStatus.OK);

		} else {
			return new ResponseEntity<>(employeeService.getConsult(), HttpStatus.OK);
		}


	}


	@GetMapping("/consultByRole/{role}")
	public ResponseEntity<List<Employee>> consultEmployeesxRole (@PathVariable("role") String role) {
		
		return new ResponseEntity<>(employeeService.getConsultByRole(role), HttpStatus.OK);

	}
	
	
	@GetMapping("/returnEmployeeBySalary")
	public ResponseEntity<List<Employee>> returnEmployeeBySalaryOrder () {
		
		return new ResponseEntity<>(employeeService.getConsultBySalaryRoleGroup(), HttpStatus.OK);

	}

	@GetMapping("/consultId/{id}")
	public ResponseEntity<Employee> consulEmployeexID (@PathVariable("id") Long id) {
		log.info("Request received for findById for id=" + id);
		return new ResponseEntity<>(employeeService.getConsultId(id),HttpStatus.OK);		

	}


	@PostMapping("/insert")
	public ResponseEntity<Employee> insertEmployee (@RequestBody Employee employee) {
		log.info("Request received for employee insert", employee.toString());
		return new ResponseEntity<>(employeeService.save_Employee(employee), HttpStatus.CREATED); 
	}


	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee (@RequestBody Employee employee) {
		log.info("Request received for employee update", employee.toString());
		return new ResponseEntity<>(employeeService.save_Employee(employee), HttpStatus.OK); 
	}


	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee (@PathVariable ("id") Long id) {
		Employee employee = employeeService.getConsultId(id);
		employeeService.delete_Employee(employee);
		log.info("Request received for employee deletion with id=" + id);
		return new ResponseEntity<>("Employee delete", HttpStatus.OK);

	}


}
