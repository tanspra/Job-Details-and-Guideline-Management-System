package com.kws.vjf.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kws.vjf.bean.CategoryMasterBean;
import com.kws.vjf.dao.CategoryDAO;

public class CategoryAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           CategoryMasterBean categoryMasterBean=new CategoryMasterBean();
           categoryMasterBean.setCategoryname(request.getParameter("catname"));
           categoryMasterBean.setCategorydesc(request.getParameter("catdesc"));
           CategoryDAO categoryDAO=new CategoryDAO();
           boolean flag=categoryDAO.registerCategory(categoryMasterBean);
           if(flag)
        	   response.sendRedirect("CategoryMaster.jsp?status=Register Category Success");
           else
        	   response.sendRedirect("CategoryMaster.jsp?status=Register Category Failure");
	}

}
