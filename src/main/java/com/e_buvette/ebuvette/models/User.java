package com.e_buvette.ebuvette.models;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Transactional
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User implements Serializable{
		@Id
	    @Column(name = "user_id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	 
		 @NotNull
	    private String username;
		 @NotNull
	    private String password;
	    private String matchingPassword;
	    private String role;
	    private boolean enabled;
	    
	    public User() {
	    	
	    }
	    
		public User(int id, String username, String password, String role, boolean enabled) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.role = role;
			this.enabled = enabled;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		public String getMatchingPassword() {
			return matchingPassword;
		}

		public void setMatchingPassword(String matchingPassword) {
			this.matchingPassword = matchingPassword;
		}	 
		

}
