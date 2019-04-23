package com.kws.vjf.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kws.vjf.bean.SampleResumeBean;

public class ApplyJobAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	
	private static Connection con;
	private static PreparedStatement ps;
	private static ResultSet rs;
	public ApplyJobAction() {
		super();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		boolean flag=false;
		try {
			
			SampleResumeBean sampleResumeBean=new SampleResumeBean();
			String cname=request.getParameter("company");
			System.out.println(sampleResumeBean.getCname());
			String resume=request.getParameter("resume");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","vjf","vjf");
			String sql="insert into ajob values(?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1,cname);
			System.out.println("***********"+cname);
			
			System.out.println(resume);
			File f=new File("resume");
    		FileInputStream fis=new FileInputStream(f);
    		ps.setBinaryStream(2, fis, (int)f.length());
    		int count=ps.executeUpdate();
    		
    		out.println("<font color='yellow'>Posted Sucessfully.....</font>");
    		if(count>0)
    			flag=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
