package com.kws.vjf.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kws.vjf.bean.CompanyMasterBean;
import com.kws.vjf.dao.CompanyDAO;

public class CompanyJobVacncyAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           CompanyMasterBean companyMasterBean=new CompanyMasterBean();
           companyMasterBean.setCompanyid(Integer.parseInt(request.getParameter("cid")));
           companyMasterBean.setVacancyjobtype(request.getParameter("vacancyjobtype"));
           companyMasterBean.setJobcategorytype(request.getParameter("jobcategory"));
           companyMasterBean.setJobvacancies(Integer.parseInt(request.getParameter("vacancies")));
		   CompanyDAO companyDAO=new CompanyDAO();
		   boolean flag=companyDAO.registerCompanyJobOpens(companyMasterBean);
		   if(flag)
			   response.sendRedirect("ViewCompanies.jsp?status=posing job vacancy success");
		   else
			   response.sendRedirect("ViewCompanies.jsp?status=posing job vacancy failure");
	}

}
