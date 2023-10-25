package com.cursoOnline.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_Course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Insira um nome do curso")
	private String curseName;
	
	//private Module module;
	
	//private Group group;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCurseName() {
		return curseName;
	}

	public void setCurseName(String curseName) {
		this.curseName = curseName;
	}

	/*public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	*/
}
