package com.cursoOnline.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_Class")
public class Class {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@NotBlank(message = "Insira um titlo")
	private String title;
	
	@NotBlank(message = "Insira um vídeo")
	private String UrlVideo;
	
	@NotBlank(message = "Insira um modulo")
	private Integer module;
	
	private Integer numSequencia;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrlVideo() {
		return UrlVideo;
	}

	public void setUrlVideo(String urlVideo) {
		UrlVideo = urlVideo;
	}

	public Integer getModule() {
		return module;
	}

	public void setModule(Integer module) {
		this.module = module;
	}

	public Integer getNumSequencia() {
		return numSequencia;
	}

	public void setNumSequencia(Integer numSequencia) {
		this.numSequencia = numSequencia;
	}
	

}
