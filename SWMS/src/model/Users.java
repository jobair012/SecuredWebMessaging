package model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Users {

	@NotEmpty(message="Username must contain atleast 1 character")
	private String username;
	
	@Size(max = 15, min = 4, message = "Password must between 4 and 15 character")
	private String password;
	
	private String role;
	private boolean enabled;
	
	@NotEmpty(message="Name can not be empty")
	private String name;
	
	@Email(message = "This doesn't seems to be a valid email address")
	@NotEmpty(message = "Email can not be empty")
	private String email;
	
	@NotEmpty(message = "Must select 1 option")
	private String gender;

	public Users() {
	}

	public Users(String username, String password, String role, boolean enabled, String name, String email,
			String gender) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
		this.name = name;
		this.email = email;
		this.gender = gender;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
