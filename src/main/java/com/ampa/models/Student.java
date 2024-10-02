package com.ampa.models;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter@Setter
public class Student implements Serializable{
	
	private static final long serialVersionUID = -1008848238404634796L;

	@Id
	@Column(name= "idStudent", nullable = false, unique = true, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("idStudent")
	private Long idStudent = 0L;
	
	@Column(name= "name", length = 50,nullable = false, unique = true, updatable = false)
	private String name;
	
	@Column(name= "subname", length = 80,nullable = false, unique = true, updatable = false)
	private String subname;
	
	private Date birthdate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Family family;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Level level;
}
