package com.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LogoutClass
 */
@WebServlet("/Logout")
public class LogoutClass extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		session.removeAttribute("username");
		session.removeAttribute("password");
		session.invalidate();
		PrintWriter out=response.getWriter();
		out.println("Logiing out");
		response.sendRedirect("login.jsp");
	}


}
