package data;

import java.util.Map;

public class Benutzer {

	private String name = "";
	private String password = "";
	private String age = "";
	private String email = "";
	private String number = "";
	private Boolean agb = false;
	private Boolean privacypolicies = false;

	public Benutzer() {
		name = "foo";
		password = "bar";
	}

	public Benutzer(String name) {
		this.name = name;
		password = "root";
	}

	public Benutzer(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public void parse(Map<String, String[]> parameters) {
		if (parameters.containsKey("name")) {
			this.name = parameters.get("name")[0];
		}

		if (parameters.containsKey("age")) {
			this.age = parameters.get("age")[0];
		}

		if (parameters.containsKey("email")) {
			this.email = parameters.get("email")[0];
		}

		if (parameters.containsKey("number")) {
			this.number = parameters.get("number")[0];
		}

		this.agb = parameters.containsKey("agb");
		this.privacypolicies = parameters.containsKey("privacypolicies");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Boolean getAgb() {
		return agb;
	}

	public void setAgb(Boolean agb) {
		this.agb = agb;
	}

	public Boolean getPrivacypolicies() {
		return privacypolicies;
	}

	public void setPrivacypolicies(Boolean privacypolicies) {
		this.privacypolicies = privacypolicies;
	}
}
