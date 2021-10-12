package co.com.event.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="Event")
public class EventDataJPA implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "idEvent")
    private Integer id;
	
	@NotBlank
	@Column (name = "Type")
    private String type;
	
	
	@Column (name = "IsPublic")
    private Boolean isPublic;
    
	@NotNull
	@Column (name = "RepoID")
    private Integer repoId;
	
	@NotNull
	@Column (name = "ActorID")
    private Integer actorId;
	

    public EventDataJPA () {

    }

    public EventDataJPA (Integer id, String type, Boolean isPublic, Integer repoId, Integer actorId) {
        this.id = id;
        this.type = type;
        this.isPublic = isPublic;
        this.repoId = repoId;
        this.actorId = actorId;
    }

    public EventDataJPA (String type, Boolean isPublic, Integer repoId, Integer actorId) {
        this.type = type;
        this.isPublic = isPublic;
        this.repoId = repoId;
        this.actorId = actorId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public Integer getRepoId() {
        return repoId;
    }

    public void setRepoId(Integer repoId) {
        this.repoId = repoId;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }
    

    
    
}
