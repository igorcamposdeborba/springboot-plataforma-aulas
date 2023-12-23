package com.devsuperior.dslearnbds.entities.learnship;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "tb_chapter")
public class Chapter implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private Integer position;
	private String imgUri;
	
	// Composição
	@ManyToOne
	@JoinColumn(name = "resource_Id")
	private Resource resource;
	
	
	// Autoassociação unidirecional: um capítulo (chapter) pode ser pré-requisito para fazer outro capítulo.
	@ManyToOne
	@JoinColumn(name = "prerequisite_Id")
	private Chapter prerequisite;
	
	public Chapter() {}

	public Chapter(Long id, String title, String description, Integer position, String imgUri, Resource resource, Chapter prerequisite) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.position = position;
		this.imgUri = imgUri;
		this.resource = resource;
		this.prerequisite = prerequisite;
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Integer getPosition() {
		return position;
	}



	public void setPosition(Integer position) {
		this.position = position;
	}



	public String getImgUri() {
		return imgUri;
	}



	public void setImgUri(String imgUri) {
		this.imgUri = imgUri;
	}



	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
	public Chapter getPrerequisite() {
		return prerequisite;
	}
	public void setPrerequisite(Chapter prerequisite) {
		this.prerequisite = prerequisite;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chapter other = (Chapter) obj;
		return Objects.equals(id, other.id);
	}

}
