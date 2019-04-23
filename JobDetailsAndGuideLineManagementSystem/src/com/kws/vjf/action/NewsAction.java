package com.kws.vjf.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kws.vjf.bean.NewsMasterBean;
import com.kws.vjf.dao.NewsDAO;

public class NewsAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           NewsMasterBean newsMasterBean=new NewsMasterBean();
           newsMasterBean.setNewsheader(request.getParameter("newsheader"));
           newsMasterBean.setNewsdesc(request.getParameter("newsdesc"));
           NewsDAO newsDAO=new NewsDAO();
           boolean flag=newsDAO.postNews(newsMasterBean);
           if(flag)
        	   response.sendRedirect("News.jsp?status=Posting News Success");
           else
        	   response.sendRedirect("News.jsp?status=Posting News Failure");
		
	}

}
