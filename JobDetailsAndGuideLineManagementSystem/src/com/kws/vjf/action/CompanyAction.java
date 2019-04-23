package com.kws.vjf.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kws.vjf.bean.CompanyMasterBean;
import com.kws.vjf.dao.CompanyDAO;

public class CompanyAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          CompanyMasterBean companyMasterBean=new CompanyMasterBean();
          companyMasterBean.setCompanyname(request.getParameter("cname"));
          companyMasterBean.setCompanylocationmap(request.getParameter("clmap"));
          companyMasterBean.setCompanyindustry(request.getParameter("industry"));
          companyMasterBean.setCmpanytype(request.getParameter("ctype"));
          companyMasterBean.setCompanysize(request.getParameter("csize"));
          companyMasterBean.setCompanydesc(request.getParameter("cdesc"));
          companyMasterBean.setCompanylocation(request.getParameter("clocation"));
          companyMasterBean.setCompanycity(request.getParameter("ccity"));
          companyMasterBean.setCompanystate(request.getParameter("cstate"));
          companyMasterBean.setCompanycountry(request.getParameter("cCountry"));
          companyMasterBean.setCompanyzip(request.getParameter("czip"));
          companyMasterBean.setCompanycategoryid(Integer.parseInt(request.getParameter("ccategory")));
          companyMasterBean.setEmployeeid(Integer.parseInt(request.getParameter("empid")));
          CompanyDAO companyDAO=new CompanyDAO();
          boolean flag=companyDAO.registerCompany(companyMasterBean);
          if(flag)
        	  response.sendRedirect("CompanyMaster.jsp?status=Company Registration Success");
          else
        	 response.sendRedirect("CompanyMaster.jsp?status=Company Registration Failure");
		
	}

}
