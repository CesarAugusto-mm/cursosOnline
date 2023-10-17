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
import com.cursoOnline.model.Group;
import com.cursoOnline.repository.GroupRepository;

@RestController
@RequestMapping("/group")

public class GroupController {
	
	@Autowired
	private GroupRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Group>> get() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Group> getById(@PathVariable int id) {
		Optional<Group> groupExist = repository.findById(id);
		
		if (groupExist.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.ok(groupExist.get());
	}
	
	@PostMapping
	public ResponseEntity<Group> post(@RequestBody Group group) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(group));
	}

	@PutMapping
	public ResponseEntity<Group> put (@RequestBody Group group) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(group));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> group (@PathVariable int id) {
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}

}
