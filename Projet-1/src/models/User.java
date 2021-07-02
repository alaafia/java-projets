package models;

public class User {

	private Integer id;
	private String username;
	private String name;
	private String role;
	private String password;

	public User(Integer id, String username, String name, String role) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.role = role;
	}
	
	

	public User(String username, String name, String role, String password) {
		super();
		this.username = username;
		this.name = name;
		this.role = role;
		this.password = password;
	}



	public User(Integer id, String username, String name, String role, String password) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.role = role;
		this.password = password;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
