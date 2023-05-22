package com.login;

import java.io.IOException;
import java.sql.SQLException;

import com.login.dao.LoginDao;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class LoginClass extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String uname= req.getParameter("uname");
		String pass =req.getParameter("pass");
		
		
		
		
		try {
			LoginDao dao=new LoginDao();
			
			//if(uname.equals("mehak") && pass.equals("java")) {
			if(dao.checkCredentials(uname, pass)) {
				HttpSession session=req.getSession();
				session.setAttribute("username",uname);
				session.setAttribute("password", pass);
				res.sendRedirect("welcome.jsp");
			}
			else {
				res.sendRedirect("login.jsp"); //if login credentials are wrong
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
