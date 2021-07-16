package co.com.practical.repository;


import org.springframework.data.repository.CrudRepository;

import co.com.practical.model.Employee;



public interface EmployeeRepository extends CrudRepository <Employee, Long> {
	
	Employee findAllById(Long id);

}
