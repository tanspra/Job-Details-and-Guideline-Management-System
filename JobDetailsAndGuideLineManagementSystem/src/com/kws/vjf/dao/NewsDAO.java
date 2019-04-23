package com.kws.vjf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.kws.vjf.bean.NewsMasterBean;
import com.kws.vjf.core.dao.AbstractDataAccessObject;
import com.kws.vjf.core.util.DateWrapper;

public class NewsDAO extends AbstractDataAccessObject{
	Connection con=null;
	PreparedStatement ps=null;
	Statement st=null;
	public boolean postNews(NewsMasterBean newsMasterBean){
		boolean flag=false;
		try{
			con=getConnection();
			int nid=getSequenceID("newsmaster", "newsid");
			ps=con.prepareStatement("insert into newsmaster values(?,?,sysdate,?)");
			ps.setInt(1,nid);
			ps.setString(2,newsMasterBean.getNewsheader());
			ps.setString(3,newsMasterBean.getNewsdesc());
			int count=ps.executeUpdate();
			if(count>0)
				 flag=true;
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return flag;
	}
	public ArrayList<NewsMasterBean> viewNews(){
		ArrayList<NewsMasterBean> newsList=new ArrayList<NewsMasterBean>();
		try{
			con=getConnection();
			st=con.createStatement();
			NewsMasterBean newsMasterBean=null;
			ResultSet rs=st.executeQuery("select * from newsmaster");
			while(rs.next()){
				newsMasterBean=new NewsMasterBean();
				newsMasterBean.setNewsid(rs.getInt(1));
				newsMasterBean.setNewsheader(rs.getString(2));
				newsMasterBean.setNewspostdate(DateWrapper.parseDate(rs.getDate(3)));
				newsMasterBean.setNewsdesc(rs.getString(4));
				newsList.add(newsMasterBean);
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return newsList;
	}

}
