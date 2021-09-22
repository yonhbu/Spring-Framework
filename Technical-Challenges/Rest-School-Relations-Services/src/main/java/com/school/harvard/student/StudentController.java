package com.school.harvard.student;


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
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
    @PostMapping
    public ResponseEntity<Student> createStudent (@RequestBody Student student) {		
        return new ResponseEntity<Student>(studentRepository.save(student), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Student>> getStudent () {	
    	    	
        return new ResponseEntity<List<Student>>(studentRepository.findAll(), HttpStatus.OK);
    }
	


}
