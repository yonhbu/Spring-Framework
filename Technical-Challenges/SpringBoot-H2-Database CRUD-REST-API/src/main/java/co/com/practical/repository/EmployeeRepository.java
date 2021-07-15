package co.com.practical.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.practical.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {
	
	Employee findAllById(Long id);

}
