package co.com.practical.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="character")
public class Character {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "idCharacter")
	private Long id;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "age")
	private int age;
	
	@Column (name = "weight")
	private int weight;
	
	@Column (name = "historys")
	private String history;
	
	@Column (name = "movies")
	private Movies movie;

}
