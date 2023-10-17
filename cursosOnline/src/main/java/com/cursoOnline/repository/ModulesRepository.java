package com.cursoOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursoOnline.model.Modules;

@Repository
public interface ModulesRepository extends JpaRepository<Modules, Integer>{

}
