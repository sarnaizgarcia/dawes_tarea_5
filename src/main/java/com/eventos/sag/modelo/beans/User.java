package com.eventos.sag.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USERNAME")
	private String username;

	@Column(name="ENABLED")
	private byte enabled;

	@Column(name="PASSWORD")
	private String password;

	public User() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}