package com.kws.vjf.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kws.vjf.bean.EmailBean;
import com.kws.vjf.dao.EmailDAO;

public class EmailAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          EmailBean emailBean=new EmailBean();
          emailBean.setSenderid(Integer.parseInt(request.getParameter("senderid")));
          emailBean.setReceiverid(Integer.parseInt(request.getParameter("receiverid")));
          emailBean.setSubject(request.getParameter("subject"));
          emailBean.setMaildesc(request.getParameter("maildesc"));
          EmailDAO emailDAO=new EmailDAO();
		  boolean flag=emailDAO.sendEmail(emailBean);
		  if(flag)
			  response.sendRedirect("Email.jsp?status=Sending Email Success");
		  else
			  response.sendRedirect("Email.jsp?status=Sending Email Failure");
	}

}
