package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FehlerManager {

	private List<String> error = new ArrayList<String>();

	public boolean pruefePasswort(String pass1, String pass2) {
		return pass1 != null && pass2 != null && pass1.equals(pass2);
	}

	public boolean pruefeTelNr(String number) {
		return number.matches("([+][0-9]{2}|0)[0-9]{4}[\\/-]?[0-9]{1,10}");
	}

	public boolean pruefeEmail(String email) {
		return email.matches("[a-zA-Z._+-]{5,20}@[1-9a-zA-Z]*.[a-z]{2,3}");
	}

	public boolean pruefeAlter(String age) {
		return age.matches("[0-9]|[0-9][0-9]|1[0-2][0-3]");
	}
	
	public String getErrorHTML() {
		return this.error.stream().collect(Collectors.joining("<br>"));
	}
	
	public void addError(String error) {
		this.error.add(error);
	}
	
	public boolean hasError() {
		return this.error.size() > 0;
	}
	
}
