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
import com.cursoOnline.model.Modules;
import com.cursoOnline.repository.ModulesRepository;

@RestController
@RequestMapping("/modules")

public class ModulesController {
	
	@Autowired
	private ModulesRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Modules>> get() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Modules> getById(@PathVariable int id) {
		Optional<Modules> modulesExist = repository.findById(id);
		
		if (modulesExist.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.ok(modulesExist.get());
	}
	
	@PostMapping
	public ResponseEntity<Modules> post(@RequestBody Modules modules) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(modules));
	}

	@PutMapping
	public ResponseEntity<Modules> put (@RequestBody Modules modules) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(modules));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> modules (@PathVariable int id) {
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}

}
