package com.ampa.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "families")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter@Setter
public class Family implements Serializable{
	
	private static final long serialVersionUID = -4949508679580990902L;

	@Id
	@Column(name = "idFamily", nullable = false, unique = true, updatable = false)
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFamily;
	
	@Column(name = "name", nullable = false, unique = true, updatable = false)
	@NotNull
	private String name;
	
	@Column(name = "description", nullable = false, unique = true, updatable = false)
	@NotNull
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "family", fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JsonIgnore(value = true)
	@JsonProperty("students")
	private List<Student> students = new ArrayList<Student>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JoinColumn(name = "idAmpa", nullable = false, updatable = false)
	@JsonIgnore(value = true)
	private Ampa ampa;
	
}
