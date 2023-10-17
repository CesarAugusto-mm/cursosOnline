package com.cursoOnline.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cursoOnline.model.Course;
import com.cursoOnline.repository.CourseRepository;

@RestController
@RequestMapping("/cournse")

public class CourseController {
	
	@Autowired
	private CourseRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Course>> get() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Course> getById(@PathVariable int id) {
		Optional<Course> courseExist = repository.findById(id);
		
		if (courseExist.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.ok(courseExist.get());
	}
	
	@PostMapping
	public ResponseEntity<Course> post(@RequestBody Course course) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(course));
	}

	@PutMapping
	public ResponseEntity<Course> put (@RequestBody Course course) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(course));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> course (@PathVariable int id) {
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
}