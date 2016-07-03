package model;

public class UserKeys {

	private int keyId;
	private String key_N;
	private String key_E;
	private String key_D;

	private Users user;
	private String username;

	public UserKeys() {
	}

	public UserKeys(int keyId, String key_N, String key_E, String key_D, Users user, String username) {
		this.keyId = keyId;
		this.key_N = key_N;
		this.key_E = key_E;
		this.key_D = key_D;
		this.user = user;
		this.username = username;
	}

	public int getKeyId() {
		return keyId;
	}

	public void setKeyId(int keyId) {
		this.keyId = keyId;
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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
