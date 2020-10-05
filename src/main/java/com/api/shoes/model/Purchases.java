package com.api.shoes.model;

import java.util.Date;

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
public class Purchases {

	@Id
	@GeneratedValue
	private int purchase_id;
	
	   @OneToOne
	    @JoinColumn(name = "user_id")
	    private Users user;
	
	   @ManyToOne
	    @JoinColumn(name = "product_id")
	    private Products product;
	   
	//private String customer_name;
	//private String customer_contact;
	//private String address;
	private String category;

	@Temporal(TemporalType.DATE)
	private Date date=new Date();
	
	
}
