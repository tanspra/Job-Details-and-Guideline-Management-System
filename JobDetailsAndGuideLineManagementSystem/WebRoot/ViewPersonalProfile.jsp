
<%@page import="com.kws.vjf.dao.UserMasterDAO"%>
<%@page import="com.kws.vjf.bean.UserMasterBean"%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
                         String storepath=request.getRealPath("./images");
                         UserMasterDAO userMasterDAO=new UserMasterDAO();
                         UserMasterBean userMasterBean=userMasterDAO.viewProfile(uid,storepath);
                         if(userMasterBean!=null){
                        %>
                    <table align="center" border="1">
                    <tr>
                      <td colspan="5" align="center"><font color="white"><b>Personal Profile</b></font></td>
                    </tr>
                    <tr>
                      <td><font color="white">Name</font></td>
                      <td><font color="white">Phoneno</font></td>
                      <td><font color="white">Location</font></td>
                      <td><font color="white">Email</font></td>
                       <td><font color="white">Photo</font></td>
                       </tr>
                       <tr>
                      <td><font color="white"><%=userMasterBean.getFirstname() %> <%=userMasterBean.getLastname() %></font></td>
                      <td><font color="white"><%=userMasterBean.getLocation() %></font></td>
                      <td><font color="white"><%=userMasterBean.getPhoneno() %></font></td>
                      <td><font color="white"><%=userMasterBean.getEmail() %></font></td>  
                      <td><img src="images/<%=userMasterBean.getPhoto() %>" width="50" height="50"></td>
                     </tr>
                    </table>
                    <%}else { %>
                      <font color="white">Profile Not found</font>
                      <%} %>
                  </td></tr>
                </table>
            </td>
          </tr>
      </table>
  </body>
</html>
