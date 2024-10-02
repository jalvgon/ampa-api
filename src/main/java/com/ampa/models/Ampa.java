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
@Table(name = "ampas")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter@Setter
public class Ampa implements Serializable {
	
	private static final long serialVersionUID = -1115934954353866176L;

	@Id
	@Column(name = "idAmpa", nullable = false, unique = true, updatable = false)
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAmpa;
	
	@Column(name = "name", nullable = false, unique = true, updatable = false)
	@NotNull
	private String name;
	
	@Column(name = "description", nullable = false, unique = false, updatable = true)
	@NotNull
	private String description;
	
	@Column(name = "address", nullable = false, unique = false, updatable = true)
	@NotNull
	private String address;
	
	@Column(name = "phone", nullable = false, unique = false, updatable = true)
	@NotNull
	private String phone;
	
	@Column(name = "mail", nullable = false, unique = false, updatable = true)
	@NotNull
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JoinColumn(name = "idSchool", nullable = false, updatable = false)
	@JsonIgnore(value = true)
    private School school;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ampa", fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JsonIgnore(value = true)
	@JsonProperty("families")
	private List<Family> families = new ArrayList<Family>();
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<New> news = new ArrayList<New>();
	

}
