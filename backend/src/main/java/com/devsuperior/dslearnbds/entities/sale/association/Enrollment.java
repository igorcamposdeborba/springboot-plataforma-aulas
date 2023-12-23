package com.devsuperior.dslearnbds.entities.sale.association;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.devsuperior.dslearnbds.entities.learnship.Offer;
import com.devsuperior.dslearnbds.entities.login.User;

@Entity
@Table (name = "tb_enrollment")
public class Enrollment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Na Relação many to many crie uam chave composta.
	@EmbeddedId // vincular id da chave composta
	private EnrollmentPK id = new EnrollmentPK(); // Primary key juntando duas foreign key: chave primária associativa
												  // Obrigatório instanciar chave composta
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE") // Padrão UTC de data para compatibilidade entre banco de dados diferentes
	private Instant enrollMoment;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant refundMoment;
	private boolean isAvailable;
	private boolean isOnlyUpdate;

	public Enrollment() {}

	public Enrollment(Instant enrollMoment, Instant refundMoment, boolean isAvailable, boolean isOnlyUpdate, User user, Offer offer) {
		this.enrollMoment = enrollMoment;
		this.refundMoment = refundMoment;
		this.isAvailable = isAvailable;
		this.isOnlyUpdate = isOnlyUpdate;
		
		this.id.setUser(user); // Cliente informa qual usuário (User) e oferta (Offer) quer se matricular (Enrollment)
		this.id.setOffer(offer);
	}
	public Instant getEnrollMoment() {
		return enrollMoment;
	}

	public void setEnrollMoment(Instant enrollMoment) {
		this.enrollMoment = enrollMoment;
	}

	public Instant getRefundMoment() {
		return refundMoment;
	}

	public void setRefundMoment(Instant refundMoment) {
		this.refundMoment = refundMoment;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public boolean isOnlyUpdate() {
		return isOnlyUpdate;
	}

	public void setOnlyUpdate(boolean isOnlyUpdate) {
		this.isOnlyUpdate = isOnlyUpdate;
	}
	
	// Recuperar estudante (User) e oferta (Offer)
	public User getStudent() {
		return id.getUser();
	}
	public Offer getOffer() {
		return id.getOffer();
	}
	
	public void setStudent(User user) {
		this.id.setUser(user);
	}
	public void setOffer(Offer offer) {
		this.id.setOffer(offer);
	}
	
}
