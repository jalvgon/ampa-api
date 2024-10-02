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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "schools")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter@Setter
public class School implements Serializable{
	
	private static final long serialVersionUID = -3227372475033807643L;

	@Id
	@Column(name = "idSchool", nullable = false, unique = true, updatable = false)
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSchool;
	
	@Column(name = "name", nullable = false, unique = true, updatable = false)
	@NotNull
	private String name;
	
	@Column(name = "description", nullable = false, unique = false, updatable = true)
	@NotNull
	private String description;
	
	@Column(name = "address", nullable = false, unique = false, updatable = true)
	@NotNull
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "school", fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JsonIgnore(value = true)
	@JsonProperty("ampas")
	private List<Ampa> ampas = new ArrayList<Ampa>();
	
}
