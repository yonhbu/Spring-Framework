package co.com.event.model.dto.request;


import lombok.Data;

@Data
public class EventRequestDTO {
	

    private String  type;
    private Boolean isPublic;
    private Integer repoId;
    private Integer actorId;
	
	
}
