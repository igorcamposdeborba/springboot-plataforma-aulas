package com.devsuperior.dslearnbds.entities.sale;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.devsuperior.dslearnbds.entities.learnship.Offer;
import com.devsuperior.dslearnbds.entities.login.User;

@Entity
@Table (name = "tb_enrollment_association")
public class EnrollmentAssociation implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE") // Padrão UTC de data para compatibilidade entre banco de dados diferentes
	private Instant enrollMoment;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant refundMoment;
	private boolean isAvailable;
	private boolean isOnlyUpdate;
	
	// ! Associação de muitos para muitos -> primary key composta (Users e Offers)
	@ManyToOne (optional = true, fetch = FetchType.EAGER) // @ManyToOne: porque muitas matrículas (Enrollment) têm um aluno (User)
	@JoinColumn (name = "user_Id") // nome da coluna
	private User user;			  						  // optional = true: porque um aluno pode não estar matriculado em nenhuma versão (oferta = Offer) de curso (Course)
														  // Eager: porque é obrigado a buscar todas as tabelas quando se faz um get de User ou Offer porque é uma operação comum. Desvantagem: é lenta com grandes tabelas
	
	@ManyToOne (optional = true, fetch = FetchType.EAGER) // Muitas matrículas estão em uma oferta (offer) de curso (course)
	@JoinColumn (name = "offer_Id")
	private Offer offer;
	
	public EnrollmentAssociation() {}
	
	public EnrollmentAssociation(Long id, Instant enrollMoment, Instant refundMoment, boolean isAvailable,
			boolean isOnlyUpdate, User user, Offer offer) {
		this.id = id;
		this.enrollMoment = enrollMoment;
		this.refundMoment = refundMoment;
		this.isAvailable = isAvailable;
		this.isOnlyUpdate = isOnlyUpdate;
		this.user = user;
		this.offer = offer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean IsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public boolean isOnlyUpdate() {
		return isOnlyUpdate;
	}

	public void setOnlyUpdate(boolean isOnlyUpdate) {
		this.isOnlyUpdate = isOnlyUpdate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(offer, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnrollmentAssociation other = (EnrollmentAssociation) obj;
		return Objects.equals(offer, other.offer) && Objects.equals(user, other.user);
	}

}
