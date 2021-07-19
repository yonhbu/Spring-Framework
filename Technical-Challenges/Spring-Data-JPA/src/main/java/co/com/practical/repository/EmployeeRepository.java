package co.com.practical.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import co.com.practical.model.Employee;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface EmployeeRepository extends CrudRepository <Employee, Long> {
	
	Employee findEmployeesById(Long id);
	
	@Query("SELECT e FROM Employee e WHERE e.position.role = :role")
	List<Employee> findEmployeesByPosition(@Param("role") final String role);
}
