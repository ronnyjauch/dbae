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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String name = (String) request.getParameter("name");
		Benutzer user;
		String password = (String) request.getParameter("password");
		if (name.length() % 5 == 0) {
			if (password == "") {
				user = new Benutzer(name);
			} else {
				user = new Benutzer(name, password);
			}
			session.setAttribute("user", user);
			session.setAttribute("message", "");
			request.getRequestDispatcher("profil.jsp").forward(request, response);
		} else {
			session.setAttribute("message", "Der Benutzername ist nicht restlos durch 5 teilbar");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
		doGet(request, response);
	}

}
