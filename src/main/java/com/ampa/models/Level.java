package com.ampa.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
@Table(name = "levels")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter@Setter
public class Level implements Serializable{
	
	private static final long serialVersionUID = -8145846712242468722L;

	@Id
	@Column(name = "idLevel", nullable = false, unique = true, updatable = false)
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long idLevel;
	
	@Column(name = "description", nullable = false, unique = true, updatable = false)
	@NotNull
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "level")
	List<Student> students = new ArrayList<Student>();

}
