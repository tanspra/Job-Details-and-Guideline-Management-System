<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Job seeker placement portal</title>
	
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
                     <jsp:include page="GeneralOptions.jsp" /> 
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
                      <form name="signinform" action="./LoginAction">
                       <table align="center" bgcolor="9966FF" width="371" height="210">
                        <tr><td colspan="2" align="center"><b><font color="white">SignIn Here</font></b></td></tr>
                         <tr>
                            <td><font color="white">UserName</font></td>
                            <td><input type="text" name="uname"></td>
                          </tr>
                          <tr>
                            <td><font color="white">Password</font></td>
                            <td><input type="password" name="upass"></td>
                          </tr>
                          <tr>
                            <td align="center"><input type="submit" value="SignIn"></td>
                            <td align="center"><input type="reset" value="cancel"></td>
                          </tr>
                       </table> 
                       </form>
                           <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
         var frmvalidator  = new Validator("signinform");
  
            frmvalidator.addValidation("uname","req","Please enter Username");
            frmvalidator.addValidation("upass","req","Please enter password");
  
     </script>
                           
                       <a href="UserMaster.jsp"><font color="white"><b>Job Seeker's Register Here</b></font></a>
                  </td></tr>
                </table>
            </td>
          </tr>
      </table>
  </body>
</html>
