package co.com.practical.dto;





import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEmployeeDTO {

	private Long id;
	private String name;
	private List<EmployeeDTO> employees;
	
	
}