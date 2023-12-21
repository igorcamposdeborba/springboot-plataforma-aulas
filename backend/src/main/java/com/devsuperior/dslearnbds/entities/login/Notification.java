package com.devsuperior.dslearnbds.entities.login;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "tb_notification")
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String text;
	private Instant moment;
	private boolean read;
	private String route;
	
	// composição
	@ManyToOne
	@JoinColumn(name = "user_Id")
	private User user;
	
	public Notification() {}

	public Notification(Long id, String text, Instant moment, boolean read, String route, User user) {
		super();
		this.id = id;
		this.text = text;
		this.moment = moment;
		this.read = read;
		this.route = route;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public User getUser() {
		return user;
	}
	
}