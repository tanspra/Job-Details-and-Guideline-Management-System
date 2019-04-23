

<%@page import="com.kws.vjf.dao.EmailDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kws.vjf.bean.EmailBean"%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Job seeker placement portal -<%=(String)session.getAttribute("logintype") %></title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
     <script type="text/javascript" src="scripts/mm_menu.js"> </script>
  </head>
  
  <body bgcolor="lightblue">
      <table align="center" width="980" height="600" bgcolor="#1E90FF" >
         <tr>
           <td><table align="center">
                  <tr><td><img src="images/15.jpg" width="970" height="305"></td></tr>
                </table>
            </td>
          </tr>
          <tr>
           <td><table align="center" width="970" height="20" bgcolor="9966FF">
                  <tr><td align="center">
                    <%
                       String logintype=(String)session.getAttribute("logintype");
                         String user=(String)session.getAttribute("user");
                        if(logintype!=null){
                        
                        if(logintype.equals("admin")){
                      %>
                     <jsp:include page="AdminOptions.jsp" />
                      <%}else if(logintype.equals("jobseaker")){
                      %>
                     <jsp:include page="JobSeakerOptions.jsp" />
                      <%}else if(logintype.equals("employer")){
                      %>
                     <jsp:include page="EmployerOptions.jsp" />
                      
                    <% }else{ %>
                     <jsp:include page="GeneralOptions.jsp" />
                     <%
						}}else {
						response.sendRedirect("index.jsp?status=Sorry, session expired, Try Again");
					} %>
                  </td></tr>
                </table>
            </td>
          </tr>
          <tr>
           <td><table align="center" width="970" height="450" bgcolor="9966as" >
                  <tr><td align="center">
                      <%
                        if(request.getParameter("status")!=null){
                       %>
                       <font color="white"><%=request.getParameter("status") %></font>
                       <%} %>
                       <%
                         Integer userid=(Integer)session.getAttribute("userid");
                         int uid=userid.intValue();
                         EmailDAO emailDAO=new EmailDAO();
                         ArrayList<EmailBean> emailList=emailDAO.viewReceivedEmails(uid);
                         if(emailList.size()!=0){
                        %>
                    <table align="center" border="1">
                    <tr>
                      <td colspan="4" align="center"><font color="white"><b><%=(String)session.getAttribute("user") %> Emails</b></font></td>
                    </tr>
                    <tr>
                      <td><font color="white">SenderName</font></td>
                      <td><font color="white">Subject</font></td>
                      <td><font color="white">SendDate</font></td>
                      <td><font color="white">EmailDesc</font></td>
                       
                       </tr>
                       <%
                         for(EmailBean emailBean:emailList){
                        %>
                       <tr>
                      <td><font color="white"><%=emailBean.getSendername() %> </font></td>
                      <td><font color="white"><%=emailBean.getSubject() %></font></td>
                      <td><font color="white"><%=emailBean.getSenddate() %></font></td>
                      <td><font color="white"><%=emailBean.getMaildesc() %></font></td>  
                      
                     </tr>
                     <%} %>
                    </table>
                    <%}else { %>
                      <font color="white">Mails Not found</font>
                      <%} %>
                  </td></tr>
                </table>
            </td>
          </tr>
      </table>
  </body>
</html>
