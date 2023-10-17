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
import com.cursoOnline.model.Class;
import com.cursoOnline.repository.ClassRepository;

@RestController
@RequestMapping("/class")
public class ClassController {
	
	@Autowired
	private ClassRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Class>> get() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Class> getById(@PathVariable int id) {
		Optional<Class> classExist = repository.findById(id);
		
		if (classExist.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.ok(classExist.get());
	}
	
	@PostMapping
	public ResponseEntity<Class> post(@RequestBody Class class1) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(class1));
	}

	@PutMapping
	public ResponseEntity<Class> put (@RequestBody Class class1) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(class1));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> class1 (@PathVariable int id) {
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
}
