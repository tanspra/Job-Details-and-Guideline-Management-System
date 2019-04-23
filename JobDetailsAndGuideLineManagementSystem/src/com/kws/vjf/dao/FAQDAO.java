package com.kws.vjf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import com.kws.vjf.bean.FAQBean;
import com.kws.vjf.core.dao.AbstractDataAccessObject;

public class FAQDAO extends AbstractDataAccessObject{
	Connection con=null;
	PreparedStatement ps=null;
	Statement st=null;
	public boolean registerFAQs(FAQBean faqBean){
		boolean flag=false;
		try{
			con=getConnection();
			int fid=getSequenceID("faqs", "faqid");
			ps=con.prepareStatement("insert into faqs values(?,?,?,?)");
			ps.setInt(1,fid);
			ps.setString(2,faqBean.getFaqtype());
			ps.setString(3,faqBean.getFaqquestion());
			ps.setString(4,faqBean.getFaqanswer());
			int count=ps.executeUpdate();
			if(count>0)
				flag=true;
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return flag;
	}
	public ArrayList<FAQBean> viewAllFAQs(){
		ArrayList<FAQBean> faqList=new ArrayList<FAQBean>();
		try{
			con=getConnection();
			st=con.createStatement();
			FAQBean faqBean=null;
			ResultSet rs=st.executeQuery("select * from faqs");
			while(rs.next()){
				faqBean=new FAQBean();
				faqBean.setFaqid(rs.getInt(1));
				faqBean.setFaqtype(rs.getString(2));
				faqBean.setFaqquestion(rs.getString(3));
				faqBean.setFaqanswer(rs.getString(4));
				faqList.add(faqBean);
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return faqList;
	}
	public ArrayList<FAQBean> viewAllFAQsByFaqType(String faqtype){
		ArrayList<FAQBean> faqList=new ArrayList<FAQBean>();
		try{
			con=getConnection();
			st=con.createStatement();
			FAQBean faqBean=null;
			ResultSet rs=st.executeQuery("select * from faqs where faqtype='"+faqtype+"'");
			while(rs.next()){
				faqBean=new FAQBean();
				faqBean.setFaqid(rs.getInt(1));
				faqBean.setFaqtype(rs.getString(2));
				faqBean.setFaqquestion(rs.getString(3));
				faqBean.setFaqanswer(rs.getString(4));
				faqList.add(faqBean);
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return faqList;
	}
}
