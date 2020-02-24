package vo;

public class User {
	private String id;
	private String password;
	private String username;
	private Double banlance;

	public User() {
		super();
	}

	public User(String id, String password, String username, Double banlance) {
		super();
		this.id = id;
		this.password = password;
		this.username = username;
		this.banlance = banlance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Double getBanlance() {
		return banlance;
	}

	public void setBanlance(Double banlance) {
		this.banlance = banlance;
	}

}
