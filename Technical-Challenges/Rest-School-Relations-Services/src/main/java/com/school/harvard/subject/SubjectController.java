package com.school.harvard.subject;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/subjects")
public class SubjectController {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	
    @PostMapping
    public ResponseEntity<Subject> createSubject (@RequestBody Subject subject) {		
        return new ResponseEntity<Subject>(subjectRepository.save(subject), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Subject>> getSubject () {	
    	    	
        return new ResponseEntity<List<Subject>>(subjectRepository.findAll(), HttpStatus.OK);
    }
	


}
