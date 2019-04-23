package com.kws.vjf.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kws.vjf.bean.SampleResumeBean;
import com.kws.vjf.dao.SampleResumeDAO;

public class SampleResumeAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SampleResumeBean sampleResumeBean=new SampleResumeBean();
		sampleResumeBean.setResumetitle(request.getParameter("resumeTitle"));
		sampleResumeBean.setResumedesc(request.getParameter("resumedesc"));
		sampleResumeBean.setResumedoc(request.getParameter("resumedoc"));
		SampleResumeDAO sampleResumeDAO=new SampleResumeDAO();
		boolean flag=sampleResumeDAO.postSampleResume(sampleResumeBean);
		if(flag)
			response.sendRedirect("SampleResume.jsp?status=Post Sample Resume Success");
		else
			response.sendRedirect("SampleResume.jsp?status=Post Sample Resume Failure");
	}

}
