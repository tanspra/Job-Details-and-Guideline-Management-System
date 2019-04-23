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

import com.kws.vjf.bean.CompanyMasterBean;
import com.kws.vjf.core.dao.AbstractDataAccessObject;
import com.kws.vjf.core.util.DateWrapper;

public class CompanyDAO extends AbstractDataAccessObject{
	Connection con=null;
	PreparedStatement ps=null;
	Statement st=null;
    public boolean registerCompany(CompanyMasterBean companyMasterBean){
    	boolean flag=false;
    	try{
    		con=getConnection();
    		
    		int compid=getSequenceID("companymaster", "companyid");
    		ps=con.prepareStatement("insert into companymaster values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    		ps.setInt(1,compid);
    		ps.setString(2,companyMasterBean.getCompanyname());
    		File f=new File(companyMasterBean.getCompanylocationmap());
    		FileInputStream fis=new FileInputStream(f);
    		ps.setBinaryStream(3,fis, (int)f.length());
    		ps.setString(4,companyMasterBean.getCompanyindustry());
    		ps.setString(5,companyMasterBean.getCmpanytype());
    		ps.setString(6,companyMasterBean.getCompanysize());
    		ps.setString(7,companyMasterBean.getCompanydesc());
    		ps.setString(8,companyMasterBean.getCompanylocation());
    		ps.setString(9,companyMasterBean.getCompanycity());
    		ps.setString(10,companyMasterBean.getCompanystate());
    		ps.setString(11,companyMasterBean.getCompanycountry());
    		ps.setString(12,companyMasterBean.getCompanyzip());
    		ps.setInt(13,companyMasterBean.getCompanycategoryid());
    		ps.setInt(14,companyMasterBean.getEmployeeid());
    		
    		int count=ps.executeUpdate();
    		if(count>0){
    			
    		      flag=true;
    		      
    		    
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    	return flag;
    }
    public ArrayList<CompanyMasterBean> viewCompanies(String storepath,int eid){
    	ArrayList<CompanyMasterBean> companyList=new ArrayList<CompanyMasterBean>();
    	try{
    		con=getConnection();
    		
    		st=con.createStatement();
    		CompanyMasterBean companyMasterBean=null;
    		ResultSet rs=st.executeQuery("select c.companyid,c.companyname,c.companylocationmap,c.companyindustry,c.companytype,c.companysize,c.companydesc,c.companylocation,c.companycity,c.companystate,c.companycounty,c.companyzip,c.companycategoryid,c.employerid,cm.categoryname,u.username from companymaster c,categorymaster cm,usermaster u where c.companycategoryid=cm.categoryid and c.employerid=u.userid and c.employerid="+eid);
    		 while(rs.next()){
    			 int compid=rs.getInt(1);
    			 companyMasterBean=new CompanyMasterBean();
    			 companyMasterBean.setCompanyid(compid);
    			 companyMasterBean.setCompanyname(rs.getString(2));
    			 Blob b=rs.getBlob(3);
    			 byte b1[]=b.getBytes(1,(int)b.length());
    			 OutputStream fout=new FileOutputStream(storepath+"/"+compid+"cli.jpg");
    			 fout.write(b1);
    			 companyMasterBean.setCompanylocationmap(compid+"cli.jpg");
    			 companyMasterBean.setCompanyindustry(rs.getString(4));
    			 companyMasterBean.setCmpanytype(rs.getString(5));
    			 companyMasterBean.setCompanysize(rs.getString(6));
    			 companyMasterBean.setCompanydesc(rs.getString(7));
    			 companyMasterBean.setCompanylocation(rs.getString(8));
    			 companyMasterBean.setCompanycity(rs.getString(9));
    			 companyMasterBean.setCompanystate(rs.getString(10));
    			 companyMasterBean.setCompanycountry(rs.getString(11));
    			 companyMasterBean.setCompanyzip(rs.getString(12));
    			 companyMasterBean.setCompanycategoryid(rs.getInt(13));
    			 companyMasterBean.setEmployeeid(rs.getInt(14));
    			 companyMasterBean.setCompanycategoryname(rs.getString(15));
    			 companyMasterBean.setEmployername(rs.getString(16));
    			 companyList.add(companyMasterBean);
    		 }
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    	return companyList;
    }
    public ArrayList<CompanyMasterBean> viewCompaniesByCategory(String storepath,int cid){
    	ArrayList<CompanyMasterBean> companyList=new ArrayList<CompanyMasterBean>();
    	try{
    		con=getConnection();
    		
    		st=con.createStatement();
    		CompanyMasterBean companyMasterBean=null;
    		ResultSet rs=st.executeQuery("select c.companyid,c.companyname,c.companylocationmap,c.companyindustry,c.companytype,c.companysize,c.companydesc,c.companylocation,c.companycity,c.companystate,c.companycounty,c.companyzip,c.companycategoryid,c.employerid,cm.categoryname,u.username from companymaster c,categorymaster cm,usermaster u where c.companycategoryid=cm.categoryid and c.employerid=u.userid and c.companycategoryid="+cid);
    		 while(rs.next()){
    			 int compid=rs.getInt(1);
    			 companyMasterBean=new CompanyMasterBean();
    			 companyMasterBean.setCompanyid(compid);
    			 companyMasterBean.setCompanyname(rs.getString(2));
    			 Blob b=rs.getBlob(3);
    			 byte b1[]=b.getBytes(1,(int)b.length());
    			 OutputStream fout=new FileOutputStream(storepath+"/"+compid+"cli.jpg");
    			 fout.write(b1);
    			 companyMasterBean.setCompanylocationmap(compid+"cli.jpg");
    			 companyMasterBean.setCompanyindustry(rs.getString(4));
    			 companyMasterBean.setCmpanytype(rs.getString(5));
    			 companyMasterBean.setCompanysize(rs.getString(6));
    			 companyMasterBean.setCompanydesc(rs.getString(7));
    			 companyMasterBean.setCompanylocation(rs.getString(8));
    			 companyMasterBean.setCompanycity(rs.getString(9));
    			 companyMasterBean.setCompanystate(rs.getString(10));
    			 companyMasterBean.setCompanycountry(rs.getString(11));
    			 companyMasterBean.setCompanyzip(rs.getString(12));
    			 companyMasterBean.setCompanycategoryid(rs.getInt(13));
    			 companyMasterBean.setEmployeeid(rs.getInt(14));
    			 companyMasterBean.setCompanycategoryname(rs.getString(15));
    			 companyMasterBean.setEmployername(rs.getString(16));
    			 companyList.add(companyMasterBean);
    		 }
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    	return companyList;
    }
    public ArrayList<CompanyMasterBean> viewAllCompanies(String storepath){
    	ArrayList<CompanyMasterBean> companyList=new ArrayList<CompanyMasterBean>();
    	try{
    		con=getConnection();
    		
    		st=con.createStatement();
    		CompanyMasterBean companyMasterBean=null;
    		ResultSet rs=st.executeQuery("select c.companyid,c.companyname,c.companylocationmap,c.companyindustry,c.companytype,c.companysize,c.companydesc,c.companylocation,c.companycity,c.companystate,c.companycounty,c.companyzip,c.companycategoryid,c.employerid,cm.categoryname,u.username from companymaster c,categorymaster cm,usermaster u where c.companycategoryid=cm.categoryid and c.employerid=u.userid ");
    		 while(rs.next()){
    			 int compid=rs.getInt(1);
    			 companyMasterBean=new CompanyMasterBean();
    			 companyMasterBean.setCompanyid(compid);
    			 companyMasterBean.setCompanyname(rs.getString(2));
    			 Blob b=rs.getBlob(3);
    			 byte b1[]=b.getBytes(1,(int)b.length());
    			 OutputStream fout=new FileOutputStream(storepath+"/"+compid+"cli.jpg");
    			 fout.write(b1);
    			 companyMasterBean.setCompanylocationmap(compid+"cli.jpg");
    			 companyMasterBean.setCompanyindustry(rs.getString(4));
    			 companyMasterBean.setCmpanytype(rs.getString(5));
    			 companyMasterBean.setCompanysize(rs.getString(6));
    			 companyMasterBean.setCompanydesc(rs.getString(7));
    			 companyMasterBean.setCompanylocation(rs.getString(8));
    			 companyMasterBean.setCompanycity(rs.getString(9));
    			 companyMasterBean.setCompanystate(rs.getString(10));
    			 companyMasterBean.setCompanycountry(rs.getString(11));
    			 companyMasterBean.setCompanyzip(rs.getString(12));
    			 companyMasterBean.setCompanycategoryid(rs.getInt(13));
    			 companyMasterBean.setEmployeeid(rs.getInt(14));
    			 companyMasterBean.setCompanycategoryname(rs.getString(15));
    			 companyMasterBean.setEmployername(rs.getString(16));
    			 companyList.add(companyMasterBean);
    		 }
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    	return companyList;
    }
    public boolean registerCompanyJobOpens(CompanyMasterBean companyMasterBean){
    	boolean flag=false;
    	try{
    		con=getConnection();
    		int id=getSequenceID("companyjobopens", "jobid");
    		ps=con.prepareStatement("insert into companyjobopens values(?,?,?,?,sysdate,?)");
    		ps.setInt(1,companyMasterBean.getCompanyid());
    		ps.setString(2,companyMasterBean.getVacancyjobtype());
    		ps.setString(3,companyMasterBean.getJobcategorytype());
    		ps.setInt(4,companyMasterBean.getJobvacancies());
    		ps.setInt(5,id);
    		int count=ps.executeUpdate();
    		if(count>0)
    			 flag=true;
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    	return flag;
    }
    public CompanyMasterBean viewCompaniesByEid(String storepath,int eid){
    	CompanyMasterBean companyMasterBean=null;
    	try{
    		con=getConnection();
    		st=con.createStatement();
    		
    		ResultSet rs=st.executeQuery("select c.companyid,c.companyname,c.companylocationmap,c.companyindustry,c.companytype,c.companysize,c.companydesc,c.companylocation,c.companycity,c.companystate,c.companycountry,c.companyzip,c.companycategoryid,c.employerid,cm.categoryname,u.username from companymaster c,categorymaster cm,usermaster u where c.companycategoryid=cm.categoryid and c.employerid=u.userid and c.employerid="+eid);
    		 while(rs.next()){
    			 int compid=rs.getInt(1);
    			 companyMasterBean=new CompanyMasterBean();
    			 companyMasterBean.setCompanyid(compid);
    			 companyMasterBean.setCompanyname(rs.getString(2));
    			 Blob b=rs.getBlob(3);
    			 byte b1[]=b.getBytes(1,(int)b.length());
    			 OutputStream fout=new FileOutputStream(storepath+"/"+compid+"cli.jpg");
    			 fout.write(b1);
    			 companyMasterBean.setCompanylocationmap(compid+"cli.jpg");
    			 companyMasterBean.setCompanyindustry(rs.getString(4));
    			 companyMasterBean.setCmpanytype(rs.getString(5));
    			 companyMasterBean.setCompanysize(rs.getString(6));
    			 companyMasterBean.setCompanydesc(rs.getString(7));
    			 companyMasterBean.setCompanylocation(rs.getString(8));
    			 companyMasterBean.setCompanycity(rs.getString(9));
    			 companyMasterBean.setCompanystate(rs.getString(10));
    			 companyMasterBean.setCompanycountry(rs.getString(11));
    			 companyMasterBean.setCompanyzip(rs.getString(12));
    			 companyMasterBean.setCompanycategoryid(rs.getInt(13));
    			 companyMasterBean.setEmployeeid(rs.getInt(14));
    			 companyMasterBean.setCompanycategoryname(rs.getString(15));
    			 companyMasterBean.setEmployername(rs.getString(16));
    			 
    		 }
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    	return companyMasterBean;
    }
   
    public ArrayList<CompanyMasterBean> viewJobsByCid(int eid){
    	ArrayList<CompanyMasterBean> companyList=new ArrayList<CompanyMasterBean>();
    	try{
    		con=getConnection();
    		st=con.createStatement();
    		CompanyMasterBean companyMasterBean=null;
    		ResultSet rs=st.executeQuery("select cj.companyid,cj.vacancyjobtype,cj.jobcategorytype,cj.jobvacancies,cj.jobupdated,c.companyname from companyjobopens cj,companymaster c where cj.companyid=c.companyid and c.employerid="+eid);
    		while(rs.next()){
    			companyMasterBean=new CompanyMasterBean();
    			companyMasterBean.setCompanyid(rs.getInt(1));
    			companyMasterBean.setVacancyjobtype(rs.getString(2));
    			companyMasterBean.setJobcategorytype(rs.getString(3));
    			companyMasterBean.setJobvacancies(rs.getInt(4));
    			companyMasterBean.setJobupdated(DateWrapper.parseDate(rs.getDate(5)));
    			companyMasterBean.setCompanyname(rs.getString(6));
    			companyList.add(companyMasterBean);
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    	return companyList;
    }
   
    public ArrayList<CompanyMasterBean> viewAllJobs(){
    	ArrayList<CompanyMasterBean> companyList=new ArrayList<CompanyMasterBean>();
    	try{
    		con=getConnection();
    		st=con.createStatement();
    		CompanyMasterBean companyMasterBean=null;
    		ResultSet rs=st.executeQuery("select cj.companyid,cj.vacancyjobtype,cj.jobcategorytype,cj.jobvacancies,cj.jobupdated,c.companyname,u.username from companyjobopens cj,companymaster c,usermaster u where cj.companyid=c.companyid and c.employerid=u.userid");
    		while(rs.next()){
    			companyMasterBean=new CompanyMasterBean();
    			companyMasterBean.setCompanyid(rs.getInt(1));
    			companyMasterBean.setVacancyjobtype(rs.getString(2));
    			companyMasterBean.setJobcategorytype(rs.getString(3));
    			companyMasterBean.setJobvacancies(rs.getInt(4));
    			companyMasterBean.setJobupdated(DateWrapper.parseDate(rs.getDate(5)));
    			companyMasterBean.setCompanyname(rs.getString(6));
    			String s=rs.getString(7);
    			System.out.println("emp..."+s);
    			companyMasterBean.setEmployername(s);
    			companyList.add(companyMasterBean);
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    	return companyList;
    }
    public ArrayList<CompanyMasterBean> getJobCategoryType(){
    	ArrayList<CompanyMasterBean> jobcategoryList=new ArrayList<CompanyMasterBean>();
    	try{
    		con=getConnection();
    		st=con.createStatement();
    		CompanyMasterBean companyMasterBean=null;
    		ResultSet rs=st.executeQuery("select jobcategorytype from companyjobopens");
    		while(rs.next()){
    			companyMasterBean=new CompanyMasterBean();
    			companyMasterBean.setJobcategorytype(rs.getString(1));
    			jobcategoryList.add(companyMasterBean);
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    	return jobcategoryList;
    }
    public ArrayList<CompanyMasterBean> getJobPostedDate(){
    	ArrayList<CompanyMasterBean> jobcPostedDateList=new ArrayList<CompanyMasterBean>();
    	try{
    		con=getConnection();
    		st=con.createStatement();
    		CompanyMasterBean companyMasterBean=null;
    		ResultSet rs=st.executeQuery("select JOBUPDATED from companyjobopens");
    		while(rs.next()){
    			companyMasterBean=new CompanyMasterBean();
    			companyMasterBean.setJobupdated(DateWrapper.parseDate(rs.getDate(1)));
    			jobcPostedDateList.add(companyMasterBean);
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    	return jobcPostedDateList;
    }
    public ArrayList<CompanyMasterBean> viewAllJobsByCategory(String categoryname){
    	ArrayList<CompanyMasterBean> companyList=new ArrayList<CompanyMasterBean>();
    	try{
    		System.out.println("jc.."+categoryname);
    		con=getConnection();
    		st=con.createStatement();
    		CompanyMasterBean companyMasterBean=null;
    		ResultSet rs=st.executeQuery("select cj.companyid,cj.vacancyjobtype,cj.jobcategorytype,cj.jobvacancies,cj.jobupdated,c.companyname,u.username,cj.jobid from companyjobopens cj,companymaster c,usermaster u where cj.companyid=c.companyid and c.employerid=u.userid and cj.jobcategorytype='"+categoryname+"'");
    		while(rs.next()){
    			companyMasterBean=new CompanyMasterBean();
    			companyMasterBean.setCompanyid(rs.getInt(1));
    			companyMasterBean.setVacancyjobtype(rs.getString(2));
    			companyMasterBean.setJobcategorytype(rs.getString(3));
    			companyMasterBean.setJobvacancies(rs.getInt(4));
    			companyMasterBean.setJobupdated(DateWrapper.parseDate(rs.getDate(5)));
    			companyMasterBean.setCompanyname(rs.getString(6));
    			String s=rs.getString(7);
    			//System.out.println("emp..."+s);
    			companyMasterBean.setEmployername(s);
    			companyMasterBean.setJobid(rs.getInt(8));
    			companyList.add(companyMasterBean);
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    	return companyList;
    }
    public ArrayList<CompanyMasterBean> viewAllJobsByCompany(int compid){
    	ArrayList<CompanyMasterBean> companyList=new ArrayList<CompanyMasterBean>();
    	try{
    		
    		con=getConnection();
    		st=con.createStatement();
    		CompanyMasterBean companyMasterBean=null;
    		ResultSet rs=st.executeQuery("select cj.companyid,cj.vacancyjobtype,cj.jobcategorytype,cj.jobvacancies,cj.jobupdated,c.companyname,u.username,cj.jobid from companyjobopens cj,companymaster c,usermaster u where cj.companyid=c.companyid and c.employerid=u.userid and cj.companyid="+compid);
    		while(rs.next()){
    			companyMasterBean=new CompanyMasterBean();
    			companyMasterBean.setCompanyid(rs.getInt(1));
    			companyMasterBean.setVacancyjobtype(rs.getString(2));
    			companyMasterBean.setJobcategorytype(rs.getString(3));
    			companyMasterBean.setJobvacancies(rs.getInt(4));
    			companyMasterBean.setJobupdated(DateWrapper.parseDate(rs.getDate(5)));
    			companyMasterBean.setCompanyname(rs.getString(6));
    			String s=rs.getString(7);
    			//System.out.println("emp..."+s);
    			companyMasterBean.setEmployername(s);
    			companyMasterBean.setJobid(rs.getInt(8));
    			companyList.add(companyMasterBean);
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    	return companyList;
    }
    public ArrayList<CompanyMasterBean> viewAllJobsByPostedDate(String postedDate){
    	ArrayList<CompanyMasterBean> companyList=new ArrayList<CompanyMasterBean>();
    	try{
    		System.out.println("jc.."+postedDate);
    		con=getConnection();
    		st=con.createStatement();
    		CompanyMasterBean companyMasterBean=null;
    		String pdate=DateWrapper.parseDate(postedDate);
    		
    		System.out.println("pd.."+pdate+"...."+pdate);
    		ResultSet rs=st.executeQuery("select cj.companyid,cj.vacancyjobtype,cj.jobcategorytype,cj.jobvacancies,cj.jobupdated,c.companyname,u.username from companyjobopens cj,companymaster c,usermaster u where cj.companyid=c.companyid and c.employerid=u.userid and cj.jobupdated='"+pdate+"'");
    		while(rs.next()){
    			companyMasterBean=new CompanyMasterBean();
    			companyMasterBean.setCompanyid(rs.getInt(1));
    			companyMasterBean.setVacancyjobtype(rs.getString(2));
    			companyMasterBean.setJobcategorytype(rs.getString(3));
    			companyMasterBean.setJobvacancies(rs.getInt(4));
    			companyMasterBean.setJobupdated(DateWrapper.parseDate(rs.getDate(5)));
    			companyMasterBean.setCompanyname(rs.getString(6));
    			String s=rs.getString(7);
    			//System.out.println("emp..."+s);
    			companyMasterBean.setEmployername(s);
    			companyList.add(companyMasterBean);
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    	return companyList;
    }
    
    public ArrayList<CompanyMasterBean> getCompanies(){
    	ArrayList<CompanyMasterBean> companyList=new ArrayList<CompanyMasterBean>();
    	try{
    		con=getConnection();
    		st=con.createStatement();
    		CompanyMasterBean companyMasterBean=null;
    		ResultSet rs=st.executeQuery("select companyid,companyname from companymaster");
    		while(rs.next()){
    			companyMasterBean=new CompanyMasterBean();
    			companyMasterBean.setCompanyid(rs.getInt(1));
    			companyMasterBean.setCompanyname(rs.getString(2));
    			companyList.add(companyMasterBean);
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    	return companyList;
    }
    public boolean applyJob(CompanyMasterBean companyMasterBean){
    	boolean flag=false;
    	try{
    		con=getConnection();
    		int aid=getSequenceID("jobseekerapplyjobs", "applyid");
    		ps=con.prepareStatement("insert into jobseekerapplyjobs values(?,?,?,sysdate)");
    		ps.setInt(1,aid);
    		ps.setInt(2,companyMasterBean.getJobseekerid());
    		ps.setInt(3,companyMasterBean.getJobid());
    		int count=ps.executeUpdate();
    		if(count>0)
    			 flag=true;
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    	return flag;
    }
    public ArrayList<CompanyMasterBean> viewApplyJobs(int jsid){
    	ArrayList<CompanyMasterBean> applyList=new ArrayList<CompanyMasterBean>();
    	try{
    		con=getConnection();
    		st=con.createStatement();
    		ResultSet rs=st.executeQuery("select jsaj.applyid,jsaj.jobseekerid,jsaj.jobid,jsaj.applydate,cjo.vacancyjobtype,cjo.jobcategorytype,c.companyname,u.username,cjo.jobupdated from jobseekerapplyjobs jsaj,companyjobopens cjo,companymaster c,usermaster u where jsaj.jobid=cjo.jobid and jsaj.jobseekerid=u.userid and cjo.companyid=c.companyid and jsaj.jobseekerid="+jsid);
    		CompanyMasterBean companyMasterBean=null;
    		while(rs.next()){
    		  companyMasterBean=new CompanyMasterBean();
    		  companyMasterBean.setApplyid(rs.getInt(1));
    		  companyMasterBean.setJobseekerid(rs.getInt(2));
    		  companyMasterBean.setJobid(rs.getInt(3));
    		  companyMasterBean.setApplydate(DateWrapper.parseDate(rs.getDate(4)));
    		  companyMasterBean.setVacancyjobtype(rs.getString(5));
    		  companyMasterBean.setJobcategorytype(rs.getString(6));
    		  companyMasterBean.setCompanyname(rs.getString(7));
    		  companyMasterBean.setJobseekername(rs.getString(8));
    		  companyMasterBean.setJobupdated(DateWrapper.parseDate(rs.getDate(9)));
    		  applyList.add(companyMasterBean);
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    	return applyList;
    }
    public ArrayList<CompanyMasterBean> viewAppliedJobsByJobSeekers(int eid){
    	ArrayList<CompanyMasterBean> jobseekersAppliedList=new ArrayList<CompanyMasterBean>();
    	try{
    		con=getConnection();
    		st=con.createStatement();
    		CompanyMasterBean companyMasterBean=null;
    		ResultSet rs=st.executeQuery("select jsaj.applyid,jsaj.jobseekerid,jsaj.jobid,jsaj.applydate,cjo.vacancyjobtype,cjo.jobcategorytype,c.companyname,u.username,cjo.jobupdated from jobseekerapplyjobs jsaj,companyjobopens cjo,companymaster c,usermaster u where jsaj.jobid=cjo.jobid and c.employerid=u.userid and cjo.companyid=c.companyid and c.employerid="+eid);
    		while(rs.next()){
    			companyMasterBean=new CompanyMasterBean();
    			companyMasterBean.setApplyid(rs.getInt(1));
    			companyMasterBean.setJobseekerid(rs.getInt(2));
    			companyMasterBean.setJobid(rs.getInt(3));
    			companyMasterBean.setApplydate(DateWrapper.parseDate(rs.getDate(4)));
    			companyMasterBean.setVacancyjobtype(rs.getString(5));
    			companyMasterBean.setJobcategorytype(rs.getString(6));
    			companyMasterBean.setCompanyname(rs.getString(7));
    			companyMasterBean.setJobseekername(rs.getString(8));
    			companyMasterBean.setJobupdated(DateWrapper.parseDate(rs.getDate(9)));
    			jobseekersAppliedList.add(companyMasterBean);
    			
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    	return jobseekersAppliedList;
    }
}
