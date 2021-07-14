package co.com.practical.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.practical.model.Employee;
import co.com.practical.model.Person;
import co.com.practical.repository.EmployeeRepository;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	

	public List<Employee> getConsult () {
		return (List<Employee>) employeeRepository.findAll();
	}
	

	public Employee getConsultId (Long id) {		
		return employeeRepository.findAllById(id); 		
	}	
	

	public Employee insert_Employee (Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public void delete_Employee (Employee employee) {
		employeeRepository.delete(employee);
	}
	
	
}
