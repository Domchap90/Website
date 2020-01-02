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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email_address = request.getParameter("email_address");
		ClientDao dao = new ClientDao();
		Client c1 = dao.getClient(email_address);

		request.setAttribute("client", c1);
		RequestDispatcher rd = request.getRequestDispatcher("ShowClient.jsp");
		rd.forward(request, response);
	}

}
