package co.com.practical.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import co.com.practical.model.Employee;


public interface EmployeeRepository extends JpaRepository <Employee, Long> {
	
	Employee findAllById(Long id);

}
