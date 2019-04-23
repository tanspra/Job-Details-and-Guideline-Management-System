package com.kws.vjf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.kws.vjf.bean.CategoryMasterBean;
import com.kws.vjf.core.dao.AbstractDataAccessObject;

public class CategoryDAO extends AbstractDataAccessObject{
   Connection con=null;
   PreparedStatement ps=null;
   Statement st=null;
   public boolean registerCategory(CategoryMasterBean categoryMasterBean){
	   boolean flag=false;
	   try{
		   con=getConnection();
		   int cid=getSequenceID("categorymaster", "categoryid");
		   ps=con.prepareStatement("insert into categorymaster values(?,?,?)");
		   ps.setInt(1,cid);
		   ps.setString(2,categoryMasterBean.getCategoryname());
		   ps.setString(3,categoryMasterBean.getCategorydesc());
		   
		   
		   int count=ps.executeUpdate();
		   if(count>0)
			    flag=true;
	   }catch (Exception e) {
		   e.printStackTrace();
		// TODO: handle exception
	}
	   return flag;
   }
   public ArrayList<CategoryMasterBean> viewCategories(){
	   ArrayList<CategoryMasterBean> categoryList=new ArrayList<CategoryMasterBean>();
	   try{
		   con=getConnection();
		   st=con.createStatement();
		   CategoryMasterBean categoryMasterBean=null;
		   ResultSet rs=st.executeQuery("select * from categorymaster");
		   while(rs.next()){
			   categoryMasterBean=new CategoryMasterBean();
			   categoryMasterBean.setCategoryid(rs.getInt(1));
			   categoryMasterBean.setCategoryname(rs.getString(2));
			   categoryMasterBean.setCategorydesc(rs.getString(3));
			   categoryList.add(categoryMasterBean);
		   }
	   }catch (Exception e) {
		   e.printStackTrace();
		   
		  
		// TODO: handle exception
	}
	   return categoryList;
   }
   
}
