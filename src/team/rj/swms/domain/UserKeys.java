package team.rj.swms.domain;

import org.springframework.stereotype.Component;

@Component
public class UserKeys {
	private String key_N;
	private String key_E;
	private String key_D;
	private String user_username;

	public UserKeys() {
	}

	public UserKeys(String key_N, String key_E, String key_D, String user_username) {
		this.key_N = key_N;
		this.key_E = key_E;
		this.key_D = key_D;
		this.user_username = user_username;
	}

	public String getKey_N() {
		return key_N;
	}

	public void setKey_N(String key_N) {
		this.key_N = key_N;
	}

	public String getKey_E() {
		return key_E;
	}

	public void setKey_E(String key_E) {
		this.key_E = key_E;
	}

	public String getKey_D() {
		return key_D;
	}

	public void setKey_D(String key_D) {
		this.key_D = key_D;
	}

	public String getUser_username() {
		return user_username;
	}

	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}

}
