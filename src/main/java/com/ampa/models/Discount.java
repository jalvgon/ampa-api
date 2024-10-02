package com.ampa.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "discounts")
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class Discount implements Serializable {

	private static final long serialVersionUID = -1364384323116803544L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"idDiscount\"")
	private Long idDiscount;

	@Column(name = "titular")
	private String titular;

	@Column(name = "text")
	private String text;

	@Column(name = "image")
	private String image;
	
	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	
	@ManyToOne
    @JoinColumn(name = "idAmpa", nullable = false, updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Ampa ampa;

}