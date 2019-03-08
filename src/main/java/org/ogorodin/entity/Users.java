package org.ogorodin.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {

	public enum ERole {
		ROLE_ADMIN, ROLE_CUSTOMER, ROLE_EMPLOYEE
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	
	@Column(name="usernaame")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="role")
	private ERole role;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_info_id")
	private UserInfo info;
	
	@OneToMany(mappedBy="", cascade=CascadeType.ALL)
	private List<Orders> orders;

	public Users() {
	}

	public Users(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ERole getRole() {
		return role;
	}

	public void setRole(ERole role) {
		this.role = role;
	}

	public UserInfo getInfo() {
		return info;
	}

	public void setInfo(UserInfo info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", role="
				+ role + ", info=" + info + "]";
	}

}
