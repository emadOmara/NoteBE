package com.emad.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.emad.integration.CustomDateDeserializer;
import com.emad.integration.NoteSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
//@JsonSerialize(using = NoteSerializer.class)
public class Note implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String description;

	@ManyToMany()
	@JoinTable(name = "Note_Tag", joinColumns = @JoinColumn(name = "NOTE_ID", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id"))
	private List<Tag> tags = new ArrayList<Tag>();

	@JsonDeserialize(using = CustomDateDeserializer.class)
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	private Date createdDate;

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

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}