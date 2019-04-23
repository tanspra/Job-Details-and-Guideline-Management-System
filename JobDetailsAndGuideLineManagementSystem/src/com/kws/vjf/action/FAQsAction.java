package com.kws.vjf.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kws.vjf.bean.FAQBean;
import com.kws.vjf.dao.FAQDAO;

public class FAQsAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          FAQBean faqBean=new FAQBean();
          faqBean.setFaqtype(request.getParameter("faqtype"));
          faqBean.setFaqquestion(request.getParameter("faqquestion"));
          faqBean.setFaqanswer(request.getParameter("faqanswer"));
          FAQDAO faqdao=new FAQDAO();
          boolean flag=faqdao.registerFAQs(faqBean);
          if(flag)
        	  response.sendRedirect("FAQs.jsp?status=Posting faq success");
          else
        	  response.sendRedirect("FAQs.jsp?status=Posting faq Failure");
		
	}

}
