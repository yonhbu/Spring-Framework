package co.com.practical.service;

import java.util.List;

import co.com.practical.model.Employee;

public interface IEmployeeService {
	
	public List<Employee> getConsult ();
	
    public List<Employee> getConsultByRole (String role);
    
	public List<Employee> getConsultBySalaryRoleGroup ();
	
	public Employee getConsultId (Long id);
	
	public Employee save_Employee (Employee employee);
	
	public void delete_Employee (Employee employee);

}
