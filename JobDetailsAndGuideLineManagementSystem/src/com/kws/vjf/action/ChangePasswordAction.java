package com.kws.vjf.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kws.vjf.bean.UserMasterBean;
import com.kws.vjf.dao.UserMasterDAO;

public class ChangePasswordAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		  UserMasterBean userMasterBean=new UserMasterBean();
		  userMasterBean.setUsername(request.getParameter("uname"));
		  userMasterBean.setPassword(request.getParameter("upass"));
		  userMasterBean.setNewpassword(request.getParameter("newpass"));
		  UserMasterDAO userMasterDAO=new UserMasterDAO();
		  boolean flag=userMasterDAO.changePassword(userMasterBean);
		  if(flag)
			  response.sendRedirect("ChangePassword.jsp?status=Change Password Success");
		  else
			  response.sendRedirect("ChangePassword.jsp?status=Change Password Failure");
	}

}
