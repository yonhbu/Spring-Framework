package co.com.practical.model;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "idEmployee")
	private Long id;	
	
	@Column (name = "salary")
	private double salary;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "idPosition")
	private Position position; 
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "idPerson")
	private Person person;
	
}