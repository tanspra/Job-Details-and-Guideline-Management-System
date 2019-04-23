package com.kws.vjf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.kws.vjf.bean.EmailBean;
import com.kws.vjf.core.dao.AbstractDataAccessObject;
import com.kws.vjf.core.util.DateWrapper;

public class EmailDAO extends AbstractDataAccessObject {
	Connection con=null;
	PreparedStatement ps=null;
	Statement st=null;
	public boolean sendEmail(EmailBean emailBean){
		boolean flag=false;
		try{
			con=getConnection();
			int eid=getSequenceID("emailmaster", "emailid");
			ps=con.prepareStatement("insert into emailmaster values(?,?,?,sysdate,?,?)");
			ps.setInt(1,eid);
			ps.setInt(2,emailBean.getSenderid());
			ps.setInt(3,emailBean.getReceiverid());
			ps.setString(4,emailBean.getSubject());
			ps.setString(5,emailBean.getMaildesc());
			int count=ps.executeUpdate();
			if(count>0)
				 flag=true;
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return flag;
	}
	public ArrayList<EmailBean> viewReceivedEmails(int rid){
		ArrayList<EmailBean> emailsList=new ArrayList<EmailBean>();
		try{
			con=getConnection();
			st=con.createStatement();
			EmailBean emailBean=null;
			ResultSet rs=st.executeQuery("select e.emailid,e.senderid,e.receiverid,e.senddate,e.subject,e.maildesc,u.username from emailmaster e,usermaster u where e.senderid=u.userid and e.receiverid="+rid);	
			while(rs.next()){
				emailBean=new EmailBean();
				emailBean.setEmailid(rs.getInt(1));
				emailBean.setSenderid(rs.getInt(2));
				emailBean.setReceiverid(rs.getInt(3));
				emailBean.setSenddate(DateWrapper.parseDate(rs.getDate(4)));
				emailBean.setSubject(rs.getString(5));
				emailBean.setMaildesc(rs.getString(6));
				emailBean.setSendername(rs.getString(7));
				emailsList.add(emailBean);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return emailsList;
	}
	public boolean deleteEmails(int eid){
		boolean flag=false;
		try{
			con=getConnection();
			st=con.createStatement();
			int count=st.executeUpdate("delete from emailmaster where emailid="+eid);
			if(count>0)
				 flag=true;
		}catch (Exception e) {
			e.printStackTrace();
			
			
			// TODO: handle exception
		}
		return flag;
	}

}
