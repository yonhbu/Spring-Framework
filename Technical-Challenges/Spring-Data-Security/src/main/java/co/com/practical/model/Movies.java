package co.com.practical.model;

import java.util.Date;

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
@Table(name="movies")
public class Movies {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "idMovies")
	private Long id;
	
	@Column (name = "titles")
	private String title;
	
	@Column (name = "creationDate")
	private Date creationDate;
	
	@Column (name = "qualification")
	private int qualification;
	
	@Column (name = "associatedMovies")
	private Character associatedMovie;

}
