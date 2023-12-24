package com.devsuperior.dslearnbds.entities.learnship;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.devsuperior.dslearnbds.entities.sale.EnrollmentAssociation;

@Entity
@Table (name = "tb_offer") // Versão do curso. Exemplo: 1.0 ou 2.0
public class Offer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String edition;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE") // Padrão UTC de data para compatibilidade entre banco de dados diferentes
	private Instant startMoment;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant endMoment;
	
	// composição
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	
	@OneToMany (mappedBy = "offer") // o atributo offer na classe Resource faz a ligação entre essas duas classes
	private List<Resource> resource = new ArrayList<>();
	
	// classe/tabela associativa
	@OneToMany (mappedBy = "offer")
	private Set<EnrollmentAssociation> enrollment = new HashSet<>();
	
	
	public Offer() {}

	public Offer(Long id, String edition, Instant startMoment, Instant endMoment, Course course) {
		this.id = id;
		this.edition = edition;
		this.startMoment = startMoment;
		this.endMoment = endMoment;
		this.course = course;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public Instant getStartMoment() {
		return startMoment;
	}

	public void setStartMoment(Instant startMoment) {
		this.startMoment = startMoment;
	}

	public Instant getEndMoment() {
		return endMoment;
	}

	public void setEndMoment(Instant endMoment) {
		this.endMoment = endMoment;
	}
	
	

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Resource> getResource() {
		return resource;
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
		Offer other = (Offer) obj;
		return Objects.equals(id, other.id);
	}
}
