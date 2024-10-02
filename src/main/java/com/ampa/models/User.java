package com.ampa.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {

	private static final long serialVersionUID = -7401832207457106992L;

	@Id
	@Column(name = "userId", nullable = false, unique = true, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("userId")
	private Long userId = 0L;

	@Column(name = "login", length = 15, nullable = false, unique = true, updatable = false)
	private String login;

	@Column(name = "password", length = 200, nullable = false, unique = true, updatable = false)
	private String password;

	private int attempts;

	@Column(name = "mail", length = 50, nullable = false, unique = true, updatable = false)
	private String mail;

	@Column(name = "name", length = 50, nullable = false, unique = true, updatable = false)
	private String name;

	@Column(name = "subnames", length = 80, nullable = false, unique = true, updatable = false)
	private String subnames;

	@Column(name = "phone", length = 12, nullable = false, unique = true, updatable = false)
	private String phone;

	private boolean disabled;

	@Column(name = "change_password", nullable = false, unique = true, updatable = false)
	private boolean changePass;

	private Date antiquity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "idFamily", nullable = false, updatable = false)
	@JsonIgnore(value = true)
	private Family family;

	@ManyToMany(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "idUser"), inverseJoinColumns = @JoinColumn(name = "idRole"), uniqueConstraints = @UniqueConstraint(columnNames = {
			"idUser", "idRole" }))
	private List<Role> roles = new ArrayList<Role>();
	

}
