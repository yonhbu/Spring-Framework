package com.hackerrank.gevents.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class EventResponseDTO {
	
	private Integer id;
    private String  type;
    private Boolean isPublic;
    private Integer repoId;
    private Integer actorId;
	
	
}
