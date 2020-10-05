package com.api.shoes.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@ToString

public class Users {

	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int id;
	private String name;
	private String contact;
	private String address;

	
//	@Column(name = "superHeroContact",length = 10,unique = true)
//	private long contact;
//	
//	@Temporal(TemporalType.DATE)
//	private Date dob;
//	
//	@OneToOne
//	private Comic comic:
}
