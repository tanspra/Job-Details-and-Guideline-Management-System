package com.kws.vjf.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kws.vjf.bean.UserMasterBean;
import com.kws.vjf.dao.UserMasterDAO;

public class RegisterUserAction extends HttpServlet {

	
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
         userMasterBean.setLogintype(request.getParameter("logintype"));
         userMasterBean.setFirstname(request.getParameter("firstname"));
         userMasterBean.setLastname(request.getParameter("lastname"));
         userMasterBean.setDob(request.getParameter("dob"));
         userMasterBean.setPhoto(request.getParameter("photo"));
         userMasterBean.setLocation(request.getParameter("location"));
         userMasterBean.setCity(request.getParameter("city"));
         userMasterBean.setState(request.getParameter("state"));
         userMasterBean.setCountry(request.getParameter("country"));
         userMasterBean.setPincode(request.getParameter("pincode"));
         userMasterBean.setPhoneno(request.getParameter("phoneno"));
         userMasterBean.setEmail(request.getParameter("email"));
         userMasterBean.setSex(request.getParameter("sex"));
         userMasterBean.setSquestion(request.getParameter("squestion"));
         userMasterBean.setSanswer(request.getParameter("sanswer"));
         
         UserMasterDAO userMasterDAO=new UserMasterDAO();
         boolean flag=userMasterDAO.registerUser(userMasterBean);
         if(flag)
        	 response.sendRedirect("UserMaster.jsp?status="+user+" Registration Success ");
         else
        	 response.sendRedirect("UserMaster.jsp?status="+user+" Registration Failure ");
         
		  
	}

}
