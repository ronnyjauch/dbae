package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Benutzer;

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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String age = (String) request.getParameter("age");
		String email = (String) request.getParameter("email");
		String number = (String) request.getParameter("number");
		String pass1 = (String) request.getParameter("password1");
		String pass2 = (String) request.getParameter("password2");
		String agb = (String) request.getParameter("agb");
		String privacypolicies = (String) request.getParameter("privacypolicies");
		if (!(age.matches("[0-9]|[0-9][0-9]|1[0-2][0-3]"))) {
			session.setAttribute("message", "Das Alter muss zwischen inklusive 0 und 123 liegen!");
			request.getRequestDispatcher("profil.jsp").forward(request, response);
			return;
		}
		session.setAttribute("age", age);
		if (!(email.matches("[a-zA-Z._+-]{5,20}@[1-9a-zA-Z]*.[a-z]{2,3}"))) {
			session.setAttribute("message", "Die E-Mail-Adresse muss aus 5-20 Groß- oder Kleinbichstaben (ebenfalls erlaubt sind + - . _) gefolgt von @, beliebig vielen Groß- oder Kleinbuchstaben oder Zahlen, einem Punkt und 2-3 Kleinbuchstaben bestehen!");
			request.getRequestDispatcher("profil.jsp").forward(request, response);
			return;
		}
		session.setAttribute("email", email);
		if (!(number.matches("([+][0-9]{2}|0)[0-9]{5}[\\/-]?[0-9]{10}"))) {
			session.setAttribute("message", "Die Telefonnummer muss entweder mit + und zwei Zahlen oder mit 0 beginnen, insgesamt 15 Zahlen lang sein und nach den ersten 5 Zahlen (ohne Vorwahl) ist ein / oder - möglich!");
			request.getRequestDispatcher("profil.jsp").forward(request, response);
			return;
		}
		session.setAttribute("number", number);
		if (!(pass1.equals(pass2))) {
			session.setAttribute("message", "Die Passwörter stimmen nicht überein! " + pass1 + " " + pass2);
			request.getRequestDispatcher("profil.jsp").forward(request, response);
			return;
		}
		session.setAttribute("password1", pass1);
		session.setAttribute("password2", pass1);
		if (agb.equals("false")) {
			session.setAttribute("message", "Sie müssen die AGBs akzeptieren!");
			request.getRequestDispatcher("profil.jsp").forward(request, response);
			return;
		}
		session.setAttribute("agb", agb);
		if (privacypolicies.equals("false")) {
			session.setAttribute("message", "Sie müssen die Datenschutzbestimmungen akzeptieren!");
			request.getRequestDispatcher("profil.jsp").forward(request, response);
			return;
		}
		session.setAttribute("privacypolicies", privacypolicies);
		session.setAttribute("message", "Erfolgreich!");
		Benutzer user = (Benutzer) session.getAttribute("user");
		user.setAge(age);
		user.setEmail(email);
		user.setNumber(number);
		user.setPassword(pass1);
		user.setAgb(agb);
		user.setPrivacypolicies(privacypolicies);
		session.setAttribute("user", user);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		doGet(request, response);
	}

}
