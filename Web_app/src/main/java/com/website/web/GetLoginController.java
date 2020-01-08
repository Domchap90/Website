package com.website.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.website.web.dao.ClientDao;
import com.website.web.model.Client;

/**
 * Servlet implementation class GetLoginController
 */
public class GetLoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email_address = request.getParameter("email_address");
		String password = request.getParameter("password");
		ClientDao dao = new ClientDao();
		Client c1 = dao.getClient(email_address, password);

		request.setAttribute("client", c1);
//		RequestDispatcher rd = request.getRequestDispatcher("ShowClient.jsp");
		if (c1.getFullName() == null) {
			response.sendRedirect("loginError.jsp");
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("ShowClient.jsp");
			rd.forward(request, response);
		// alternatively you could use session object instead of request object:
		// HttpSession session = request.getSession();
		// session.setAttribute("client",c1);
		}

		// response.sendRedirect("ShowClient.jsp"); would reveal the showClient url to
		// client
	}
	// protected doPost()

}
