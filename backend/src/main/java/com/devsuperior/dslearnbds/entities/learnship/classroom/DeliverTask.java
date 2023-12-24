package com.devsuperior.dslearnbds.entities.learnship.classroom;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.devsuperior.dslearnbds.entities.learnship.Offer;
import com.devsuperior.dslearnbds.entities.learnship.classroom.enums.DeliverStatus;
import com.devsuperior.dslearnbds.entities.login.User;
import com.devsuperior.dslearnbds.entities.sale.association.Enrollment;

@Entity
@Table (name = "tb_deliver_task")
public class DeliverTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private String url;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant moment;
	private DeliverStatus status;
	private String feedback;
	private Integer correctCount;
	
	
	@ManyToOne
	@JoinColumn (name = "lesson_id")
	private Lesson lesson;
	
	@ManyToOne
	@JoinColumns({ // Primary key composta precisa de JoinColumnS (S no plural) e joinColumn de cada parte da primary key composta
		@JoinColumn(name = "user_id"),
		@JoinColumn(name = "offer_id")
	})
	private Enrollment enrollment;

	
	public DeliverTask() {}
	
	public DeliverTask(Long id, String url, Instant moment, DeliverStatus status, String feedback, Integer correctCount,
			Lesson lesson, Enrollment enrollment) {
		this.id = id;
		this.url = url;
		this.moment = moment;
		this.status = status;
		this.feedback = feedback;
		this.correctCount = correctCount;
		
		this.lesson = lesson;
		this.enrollment = enrollment;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public DeliverStatus getStatus() {
		return status;
	}

	public void setStatus(DeliverStatus status) {
		this.status = status;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Integer getCorrectCount() {
		return correctCount;
	}

	public void setCorrectCount(Integer correctCount) {
		this.correctCount = correctCount;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public Enrollment getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
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
		DeliverTask other = (DeliverTask) obj;
		return Objects.equals(id, other.id);
	}
}
