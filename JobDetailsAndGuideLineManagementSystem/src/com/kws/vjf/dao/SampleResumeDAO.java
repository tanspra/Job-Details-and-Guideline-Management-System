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

import com.kws.vjf.bean.SampleResumeBean;
import com.kws.vjf.core.dao.AbstractDataAccessObject;

public class SampleResumeDAO extends AbstractDataAccessObject{
	Connection con=null;
	PreparedStatement ps=null;
	Statement st=null;
    public boolean postSampleResume(SampleResumeBean sampleResumeBean){
    	boolean flag=false;
    	try{
    		con=getConnection();
    		int srid=getSequenceID("sampleresumes", "resumeid");
    		ps=con.prepareStatement("insert into sampleresumes values(?,?,?,?)");
    		ps.setInt(1,srid);
    		ps.setString(2,sampleResumeBean.getResumetitle());
    		ps.setString(3,sampleResumeBean.getResumedesc());
    		File f=new File(sampleResumeBean.getResumedoc());
    		FileInputStream fis=new FileInputStream(f);
    		ps.setBinaryStream(4, fis, (int)f.length());
    		int count=ps.executeUpdate();
    		if(count>0)
    			flag=true;
    		
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    	return flag;
    }
   public ArrayList<SampleResumeBean> viewSampleResumes(String storepath){
	   ArrayList<SampleResumeBean> resumesList=new ArrayList<SampleResumeBean>();
	   try{
		   con=getConnection();
		   st=con.createStatement();
		   SampleResumeBean sampleResumeBean=null;
		   ResultSet rs=st.executeQuery("select * from sampleresumes");
		   while(rs.next()){
			   sampleResumeBean=new SampleResumeBean();
			   int id=rs.getInt(1);
			   sampleResumeBean.setSampleresumeid(id);
			   sampleResumeBean.setResumetitle(rs.getString(2));
			   sampleResumeBean.setResumedesc(rs.getString(3));
			   Blob b=rs.getBlob(4);
			   byte b1[]=b.getBytes(1,(int)b.length());
			   OutputStream fout=new FileOutputStream(storepath+"/"+id+"r.doc");
			   fout.write(b1);
			   sampleResumeBean.setResumedoc(id+"r.doc");
			   resumesList.add(sampleResumeBean);
		   }
	   }catch (Exception e) {
		   e.printStackTrace();
		// TODO: handle exception
	}
	   return resumesList;
   }
}
