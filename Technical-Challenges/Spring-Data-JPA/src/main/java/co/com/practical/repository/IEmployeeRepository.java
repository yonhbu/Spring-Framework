package co.com.practical.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.practical.model.Employee;


public interface IEmployeeRepository extends CrudRepository <Employee, Long> {
	
	Employee findEmployeesById(Long id);
	
	@Query("SELECT e FROM Employee e WHERE e.position.role = :role")
	List<Employee> findEmployeesByPosition(@Param("role") final String role);
	
	@Query("SELECT e FROM Employee e ORDER BY e.salary DESC ")
	List<Employee> findEmployeesByRoleOrderSalary ();
	
}