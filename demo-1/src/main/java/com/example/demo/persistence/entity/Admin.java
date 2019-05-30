package com.example.demo.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "admin")
public class Admin {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer idadmin;
	  
	  @Column
	    private String email;
	    
	    @Column
	    private String password;

		public Integer getIdadmin() {
			return idadmin;
		}

		public void setIdadmin(Integer idadmin) {
			this.idadmin = idadmin;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	    

}
