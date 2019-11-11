package servlets;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	    
		String text = request.getParameter("text");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String zugriff = request.getParameter("zugriff");
		
		HttpSession session = request.getSession();
		session.setAttribute("text", text);
		session.setAttribute("password", password);
		session.setAttribute("email", email);
		session.setAttribute("zugriff", zugriff);
		
		Random rand = new Random();
		
		for (int i = 0; i < 3; i++) {
			int prozent = (int) (rand.nextDouble() * 100);
			session.setAttribute("proz" + i, prozent);
			session.setAttribute("fehlerquote"+i, getFehlerQuote(prozent));
		}
		
		request.setAttribute("serverzeit", new Date());
		request.getRequestDispatcher("table.jsp").forward(request, response);
	}

	// erstellt eine Fehlerquotenklassifizierungseinteilung
	private String getFehlerQuote(int prozent) {
		if (prozent <= 33) {
			return "gering";
		} else if (prozent > 33 && prozent <= 66) {
			return "durchschnittlich";
		} else {
			return "hoch";
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
				
	}

}
