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
import com.cursoOnline.model.Learner;
import com.cursoOnline.repository.LearnerRepository;

@RestController
@RequestMapping("/leaner")

public class LearnerController {
	
	@Autowired
	private LearnerRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Learner>> get() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Learner> getById(@PathVariable int id) {
		Optional<Learner> learnerExist = repository.findById(id);
		
		if (learnerExist.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.ok(learnerExist.get());
	}
	
	@PostMapping
	public ResponseEntity<Learner> post(@RequestBody Learner learner) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(learner));
	}

	@PutMapping
	public ResponseEntity<Learner> put (@RequestBody Learner learner) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(learner));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> learner (@PathVariable int id) {
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}

}
