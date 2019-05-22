package com.example.demo.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer iduser;
	  
	  @Column
	    private String email;
	    
	    @Column
	    private String password;
	    
	    @Column
	    private String name;
	    
	    @Column
	    private String address;
	    
	    public User()
	    {
	    	
	    }
		public User(int id, String email, String password, String name, String address) {
			// TODO Auto-generated constructor stub
			this.iduser=id;
			this.email=email;
			this.password=password;
			this.address=address;
		}

		public Integer getIduser() {
			return iduser;
		}

		public void setIduser(Integer iduser) {
			this.iduser = iduser;
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

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
	    
	    
		public String toString() {
			return "user[" + iduser + "] " + email+ " " +password +" "+name + " "+address; 
		}
	    
	

}
