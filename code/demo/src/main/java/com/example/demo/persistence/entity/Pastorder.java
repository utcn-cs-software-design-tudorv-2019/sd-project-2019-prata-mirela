package com.example.demo.persistence.entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pastorder")
public class Pastorder {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer idpastorder;
	 
	 @Column
	 private String details;
		
	 
	 @OneToMany(mappedBy = "pastorder", fetch = FetchType.EAGER)
	 private List<Ticket> tickets;
	 
	 @OneToOne
	 @JoinColumn
	 @MapsId
	 private User user;
}
