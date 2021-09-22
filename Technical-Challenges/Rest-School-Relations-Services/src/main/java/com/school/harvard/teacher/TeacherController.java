package com.school.harvard.teacher;


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
@RequestMapping("/teachers")
public class TeacherController {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	
    @PostMapping
    public ResponseEntity<Teacher> createTeacher (@RequestBody Teacher teacher) {		
        return new ResponseEntity<Teacher>(teacherRepository.save(teacher), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Teacher>> geTeacher () {	
    	    	
        return new ResponseEntity<List<Teacher>>(teacherRepository.findAll(), HttpStatus.OK);
    }
	


}
