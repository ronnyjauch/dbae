package data;

public class Benutzer {
	
	String name;
	String password;
	String age;
	String email;
	String number;
	String agb;
	String privacypolicies;
	
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

	public String getAgb() {
		return agb;
	}

	public void setAgb(String agb) {
		this.agb = agb;
	}

	public String getPrivacypolicies() {
		return privacypolicies;
	}

	public void setPrivacypolicies(String privacypolicies) {
		this.privacypolicies = privacypolicies;
	}
}
