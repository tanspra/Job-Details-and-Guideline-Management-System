package com.kws.vjf.bean;

public class EmailBean {
   private int emailid;
   private int senderid;
   private int receiverid;
   private String sendername;
   private String receivername;
   private String senddate;
   private String subject;
   private String maildesc;
public int getEmailid() {
	return emailid;
}
public void setEmailid(int emailid) {
	this.emailid = emailid;
}
public int getSenderid() {
	return senderid;
}
public void setSenderid(int senderid) {
	this.senderid = senderid;
}
public int getReceiverid() {
	return receiverid;
}
public void setReceiverid(int receiverid) {
	this.receiverid = receiverid;
}
public String getSendername() {
	return sendername;
}
public void setSendername(String sendername) {
	this.sendername = sendername;
}
public String getReceivername() {
	return receivername;
}
public void setReceivername(String receivername) {
	this.receivername = receivername;
}
public String getSenddate() {
	return senddate;
}
public void setSenddate(String senddate) {
	this.senddate = senddate;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getMaildesc() {
	return maildesc;
}
public void setMaildesc(String maildesc) {
	this.maildesc = maildesc;
}
   
}
