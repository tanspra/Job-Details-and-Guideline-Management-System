
<%@page import="com.kws.vjf.dao.UserMasterDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kws.vjf.bean.UserMasterBean"%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Virtual Job Fair -<%=(String)session.getAttribute("logintype") %></title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
     <script type="text/javascript" src="scripts/mm_menu.js"> </script>
     <script type="text/javascript" src="scripts/general.js"> </script>
    <script type="text/javascript" src="scripts/gen_validatorv31.js"> </script>
    <script type="text/javascript" src="scripts/form_validation.js"> </script>
     
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
                         Integer userid=(Integer)session.getAttribute("userid");
                         int uid=userid.intValue();
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
                      <form name="emailform" action="./EmailAction">
                       <table align="center" bgcolor="9966FF">
                        <tr><td colspan="2" align="center"><b><font color="white">Email Form</font></b></td></tr>
                         <input type="hidden" name="senderid" value="<%=uid %>" >
                         <tr>
                            <td><font color="white">To</font></td>
                            <td><select name="receiverid">
                            <option value="">select</option>
                            <%
                              UserMasterDAO userMasterDAO=new UserMasterDAO();
                              ArrayList<UserMasterBean> usersList=userMasterDAO.getUsers();
                              for(UserMasterBean userMasterBean:usersList){
                             %>
                             <option value="<%=userMasterBean.getUserid() %>"><%=userMasterBean.getUsername() %></option>
                             <%} %>
                             </select>
                            </td>
                          </tr>
                          <tr>
                            <td><font color="white">Subject</font></td>
                            <td><input type="text" name="subject"></td>
                          </tr>
                          <tr>
                            <td><font color="white">MailDesc</font></td>
                            <td><input type="text" name="maildesc"></td>
                          </tr>
                          <tr>
                            <td><input type="submit" value="SendEmail"></td>
                            <td><input type="reset" value="cancel"></td>
                          </tr>
                       </table> 
                       </form>
                         <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("emailform");
  
  frmvalidator.addValidation("receiverid","dontselect=0");
  
  frmvalidator.addValidation("subject","req","Please enter subject");
 
 </script>
                  </td></tr>
                </table>
            </td>
          </tr>
      </table>
  </body>
</html>
