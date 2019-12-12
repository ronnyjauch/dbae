package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Benutzer;
import manager.FehlerManager;

/**
 * Servlet implementation class ProfilServlet
 */
@WebServlet("/ProfilServlet")
public class ProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FehlerManager fm = new FehlerManager();
		HttpSession session = request.getSession();
		Benutzer user = (Benutzer) session.getAttribute("user");
		if(user == null) {
			user = new Benutzer();
		}

		user.parse(request.getParameterMap());
		
		String pass1 = request.getParameter("password1");
		String pass2 = request.getParameter("password2");
		
		if (!fm.pruefeAlter(user.getAge())) {
			fm.addError("Das Alter muss zwischen inklusive 0 und 123 liegen!");
		}
		if (!fm.pruefeEmail(user.getEmail())) {
			fm.addError("Die E-Mail-Adresse muss aus 5-20 Groß- oder Kleinbichstaben (ebenfalls erlaubt sind + - . _) gefolgt von @, beliebig vielen Groß- oder Kleinbuchstaben oder Zahlen, einem Punkt und 2-3 Kleinbuchstaben bestehen!");
		}
		if (!fm.pruefeTelNr(user.getNumber())) {
			fm.addError( "Die Telefonnummer muss entweder mit + und zwei Zahlen oder mit 0 beginnen, gefolgt von 4 Ziffern für die Vorwahl und maximal 10 Ziffern nach einem optionalen Bindestrich bzw Schrägstrich!");
		}
		if (!fm.pruefePasswort(pass1, pass2)) {
			fm.addError("Die Passwörter stimmen nicht überein!");
		}
		if (!user.getAgb()) {
			fm.addError("Sie müssen die AGBs akzeptieren!");
		}
		if (!user.getPrivacypolicies()) {
			fm.addError("Sie müssen die Datenschutzbestimmungen akzeptieren!");
		}
		
		if(fm.hasError()) {
			request.setAttribute("message", fm.getErrorHTML());
			request.setAttribute("password1", pass1);
			request.setAttribute("password2", pass2);
			request.setAttribute("errorUserData", user);
			request.getRequestDispatcher("profil.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "Erfolgreich!");
			session.setAttribute("user", user);
			session.setAttribute("errorUserData", null);
			user.setPassword(pass1);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}


}
