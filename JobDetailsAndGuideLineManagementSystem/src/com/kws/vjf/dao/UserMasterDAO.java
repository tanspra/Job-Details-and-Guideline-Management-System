package com.kws.vjf.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.kws.vjf.bean.UserMasterBean;
import com.kws.vjf.core.dao.AbstractDataAccessObject;
import com.kws.vjf.core.util.DateWrapper;

public class UserMasterDAO extends AbstractDataAccessObject{
	Connection con=null;
	PreparedStatement ps=null;
	Statement st=null;
	public boolean registerUser(UserMasterBean userMasterBean){
		boolean flag=false;
		try{
			con=getConnection();
			int id=getSequenceID("usermaster", "userid");
			ps=con.prepareStatement("insert into usermaster values(?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,id);
			ps.setString(2,userMasterBean.getUsername());
			ps.setString(3,userMasterBean.getPassword());
			ps.setString(4,userMasterBean.getLogintype());
			ps.setString(5,userMasterBean.getFirstname());
			ps.setString(6,userMasterBean.getLastname());
			ps.setString(7,DateWrapper.parseDate(userMasterBean.getDob()));
			File f=new File(userMasterBean.getPhoto());
			FileInputStream fis=new FileInputStream(f);
			ps.setBinaryStream(8,fis,(int)f.length());
			ps.setString(9,userMasterBean.getLocation());
			ps.setString(10,userMasterBean.getCity());
			ps.setString(11,userMasterBean.getState());
			ps.setString(12,userMasterBean.getCountry());
			ps.setString(13,userMasterBean.getPincode());
			ps.setString(14,userMasterBean.getPhoneno());
			ps.setString(15,userMasterBean.getEmail());
			ps.setString(16,userMasterBean.getSex());
			ps.setString(17,"pending");
			ps.setString(18,userMasterBean.getSquestion());
			ps.setString(19,userMasterBean.getSanswer());
			int count=ps.executeUpdate();
			if(count>0)
				 flag=true;
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return flag;
	}
	public UserMasterBean viewProfile(int id,String storepath){
		UserMasterBean userMasterBean=null;
		try{
			con=getConnection();
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select userid,username,password,firstname,lastname,dor,dob,photo,location,city,state,country,pincode,phoneno,email,sex,squestion,sanswer from usermaster where userid="+id);
			while(rs.next()){
				userMasterBean=new UserMasterBean();
				int userid=rs.getInt(1);
				userMasterBean.setUserid(userid);
				userMasterBean.setUsername(rs.getString(2));
				userMasterBean.setPassword(rs.getString(3));
				userMasterBean.setFirstname(rs.getString(4));
				userMasterBean.setLastname(rs.getString(5));
				userMasterBean.setDor(DateWrapper.parseDate(rs.getDate(6)));
				userMasterBean.setDob(DateWrapper.parseDate(rs.getDate(7)));
				Blob b=rs.getBlob(8);
				byte b1[]=b.getBytes(1,(int)b.length());
				OutputStream fout=new FileOutputStream(storepath+"/"+userid+"p.gif");
				fout.write(b1);
				userMasterBean.setPhoto(userid+"p.gif");
				userMasterBean.setLocation(rs.getString(9));
				userMasterBean.setCity(rs.getString(10));
				userMasterBean.setState(rs.getString(11));
				userMasterBean.setCountry(rs.getString(12));
				userMasterBean.setPincode(rs.getString(13));
				userMasterBean.setPhoneno(rs.getString(14));
				userMasterBean.setEmail(rs.getString(15));
				userMasterBean.setSex(rs.getString(16));
				userMasterBean.setSquestion(rs.getString(17));
				userMasterBean.setSanswer(rs.getString(18));
				
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return userMasterBean;
	}
	public String getLoginType(UserMasterBean userMasterBean){
		String logintype="";
		try{
			con=getConnection();
			ps=con.prepareStatement("select logintype from usermaster where username=? and password=?");
			ps.setString(1,userMasterBean.getUsername());
			ps.setString(2,userMasterBean.getPassword());
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				logintype=rs.getString(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return logintype;
	}
	public int getUserId(UserMasterBean userMasterBean){
		int userid=0;
		try{
			con=getConnection();
			ps=con.prepareStatement("select userid from usermaster where username=? and password=?");
			ps.setString(1,userMasterBean.getUsername());
			ps.setString(2,userMasterBean.getPassword());
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				userid=rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return userid;
	}
   public boolean changePassword(UserMasterBean userMasterBean){
	   boolean flag=false;
	   try{
		   con=getConnection();
		   ps=con.prepareStatement("update usermaster set password=? where username=? and password=?");
		   ps.setString(1,userMasterBean.getNewpassword());
		   ps.setString(2,userMasterBean.getUsername());
		   ps.setString(3,userMasterBean.getPassword());
		   int count=ps.executeUpdate();
		   if(count>0)
			   flag=true;
	   }catch (Exception e) {
		   e.printStackTrace();
		// TODO: handle exception
	}
	   return flag;
   }
   public String retrievePassword(UserMasterBean userMasterBean){
	   String password="";
	   try {
		   con=getConnection();
		   ps=con.prepareStatement("select password from usermaster where username=? and squestion=? and sanswer=?");
		   ps.setString(1,userMasterBean.getUsername());
		   ps.setString(2,userMasterBean.getSquestion());
		   ps.setString(3,userMasterBean.getSanswer());
		   ResultSet rs=ps.executeQuery();
		   while(rs.next()){
			   password=rs.getString(1);
		   }
	   }catch (Exception e) {
		   e.printStackTrace();
		// TODO: handle exception
	}
	   return password;
   }
   public ArrayList<UserMasterBean> getUsers(){
	   ArrayList<UserMasterBean> usersList=new ArrayList<UserMasterBean>();
	   try{
		   con=getConnection();
		   st=con.createStatement();
		   UserMasterBean userMasterBean=null;
		   ResultSet rs=st.executeQuery("select userid,username from usermaster");
		   while(rs.next()){
			   userMasterBean=new UserMasterBean();
			   userMasterBean.setUserid(rs.getInt(1));
			   userMasterBean.setUsername(rs.getString(2));
			   usersList.add(userMasterBean);
		   }
	   }catch (Exception e) {
		   e.printStackTrace();
		// TODO: handle exception
	}
	   return usersList;
   }
   public ArrayList<UserMasterBean> getEmployers(){
	   ArrayList<UserMasterBean> usersList=new ArrayList<UserMasterBean>();
	   try{
		   con=getConnection();
		   st=con.createStatement();
		   UserMasterBean userMasterBean=null;
		   ResultSet rs=st.executeQuery("select userid,username from usermaster where logintype='employer'");
		   while(rs.next()){
			   userMasterBean=new UserMasterBean();
			   userMasterBean.setUserid(rs.getInt(1));
			   userMasterBean.setUsername(rs.getString(2));
			   usersList.add(userMasterBean);
		   }
	   }catch (Exception e) {
		   e.printStackTrace();
		// TODO: handle exception
	}
	   return usersList;
   }
   public ArrayList<UserMasterBean> viewJobSeakers(String storepath){
		  ArrayList<UserMasterBean> jobSeakersList=new ArrayList<UserMasterBean>();
		try{
			con=getConnection();
			st=con.createStatement();
			UserMasterBean userMasterBean=null;
			ResultSet rs=st.executeQuery("select userid,username,password,firstname,lastname,dor,dob,photo,location,city,state,country,pincode,phoneno,email,sex,squestion,sanswer from usermaster where logintype='jobseaker'");
			while(rs.next()){
				userMasterBean=new UserMasterBean();
				int userid=rs.getInt(1);
				userMasterBean.setUserid(userid);
				userMasterBean.setUsername(rs.getString(2));
				userMasterBean.setPassword(rs.getString(3));
				userMasterBean.setFirstname(rs.getString(4));
				userMasterBean.setLastname(rs.getString(5));
				userMasterBean.setDor(DateWrapper.parseDate(rs.getDate(6)));
				userMasterBean.setDob(DateWrapper.parseDate(rs.getDate(7)));
				Blob b=rs.getBlob(8);
				byte b1[]=b.getBytes(1,(int)b.length());
				OutputStream fout=new FileOutputStream(storepath+"/"+userid+"p.gif");
				fout.write(b1);
				userMasterBean.setPhoto(userid+"p.gif");
				userMasterBean.setLocation(rs.getString(9));
				userMasterBean.setCity(rs.getString(10));
				userMasterBean.setState(rs.getString(11));
				userMasterBean.setCountry(rs.getString(12));
				userMasterBean.setPincode(rs.getString(13));
				userMasterBean.setPhoneno(rs.getString(14));
				userMasterBean.setEmail(rs.getString(15));
				userMasterBean.setSex(rs.getString(16));
				userMasterBean.setSquestion(rs.getString(17));
				userMasterBean.setSanswer(rs.getString(18));
				jobSeakersList.add(userMasterBean);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return jobSeakersList;
	}
   public ArrayList<UserMasterBean> viewEmployers(String storepath){
		  ArrayList<UserMasterBean> employersList=new ArrayList<UserMasterBean>();
		try{
			con=getConnection();
			st=con.createStatement();
			UserMasterBean userMasterBean=null;
			ResultSet rs=st.executeQuery("select userid,username,password,firstname,lastname,dor,dob,photo,location,city,state,country,pincode,phoneno,email,sex,squestion,sanswer from usermaster where logintype='employer'");
			while(rs.next()){
				userMasterBean=new UserMasterBean();
				int userid=rs.getInt(1);
				userMasterBean.setUserid(userid);
				userMasterBean.setUsername(rs.getString(2));
				userMasterBean.setPassword(rs.getString(3));
				userMasterBean.setFirstname(rs.getString(4));
				userMasterBean.setLastname(rs.getString(5));
				userMasterBean.setDor(DateWrapper.parseDate(rs.getDate(6)));
				userMasterBean.setDob(DateWrapper.parseDate(rs.getDate(7)));
				Blob b=rs.getBlob(8);
				byte b1[]=b.getBytes(1,(int)b.length());
				OutputStream fout=new FileOutputStream(storepath+"/"+userid+"p.gif");
				fout.write(b1);
				userMasterBean.setPhoto(userid+"p.gif");
				userMasterBean.setLocation(rs.getString(9));
				userMasterBean.setCity(rs.getString(10));
				userMasterBean.setState(rs.getString(11));
				userMasterBean.setCountry(rs.getString(12));
				userMasterBean.setPincode(rs.getString(13));
				userMasterBean.setPhoneno(rs.getString(14));
				userMasterBean.setEmail(rs.getString(15));
				userMasterBean.setSex(rs.getString(16));
				userMasterBean.setSquestion(rs.getString(17));
				userMasterBean.setSanswer(rs.getString(18));
				employersList.add(userMasterBean);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return employersList;
	}
}
