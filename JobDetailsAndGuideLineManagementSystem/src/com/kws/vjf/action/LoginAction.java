package com.kws.vjf.action;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kws.vjf.bean.UserMasterBean;
import com.kws.vjf.dao.UserMasterDAO;

public class LoginAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            UserMasterBean userMasterBean=new UserMasterBean();
            String user=request.getParameter("uname");
            userMasterBean.setUsername(user);
            userMasterBean.setPassword(request.getParameter("upass"));
            UserMasterDAO userMasterDAO=new UserMasterDAO();
            String logintype=userMasterDAO.getLoginType(userMasterBean);
            int userid=userMasterDAO.getUserId(userMasterBean);
            HttpSession session=request.getSession();
            if(logintype.equals("admin")){
            	response.sendRedirect("AdminHome.jsp?status=welcome "+logintype);
            	session.setAttribute("user",user);
            	session.setAttribute("logintype",logintype);
            	session.setAttribute("userid",userid);	
            }else if(logintype.equals("employer")){
            	response.sendRedirect("EmployerHome.jsp?status=welcome "+logintype);
            	session.setAttribute("user",user);
            	session.setAttribute("logintype",logintype);
            	session.setAttribute("userid",userid);	
            }else if(logintype.equals("jobseaker")){
            	response.sendRedirect("JobSeakerHome.jsp?status=welcome "+logintype);
            	session.setAttribute("user",user);
            	session.setAttribute("logintype",logintype);
            	session.setAttribute("userid",userid);	
            }else
            	response.sendRedirect("index.jsp?status=Invalid Username and password, Try again");
            
		
	}

}
