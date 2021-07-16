package co.com.practical.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class EmployeeTest {

	@Test
	public void testEmployee() {
		Employee employee = new Employee();
		assertNotNull(employee);
	}

}