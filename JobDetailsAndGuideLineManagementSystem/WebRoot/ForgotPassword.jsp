<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Job seeker placement portal - Home</title>
	
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
                      <form name="/ForgotPasswordAction" action="./ForgotPasswordAction">
                       <table align="center" bgcolor="9966FF" width="512" height="259">
                        <tr><td colspan="2" align="center"><b><font color="white">Retrive Password Form</font></b></td></tr>
                         <tr>
                            <td><font color="white">UserName</font></td>
                            <td><input type="text" name="uname" ></td>
                          </tr>
                          <tr>
                            <td><font color="white">SQuestion</font></td>
                            <td><select name="squestion">
                            <option value="">select</option>
                            <option value="1. What is ur pet name">1. What is ur pet name</option>
                            <option value="2. What is ur favroute color">2. What is ur favroute color</option> 
                            </select></td>
                          </tr>
                           <tr>
                            <td><font color="white">SAnswer</font></td>
                            <td><input type="text" name="sanswer"></td>
                          </tr>
                          <tr>
                            <td><input type="submit" value="RetrievePassword"></td>
                            <td><input type="reset" value="cancel"></td>
                          </tr>
                       </table> 
                       </form>
                          <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("retrievePasswordform");
  
 
     frmvalidator.addValidation("uname","req","Please enter uname");
     frmvalidator.addValidation("squestion","dontselect=0");
 
    frmvalidator.addValidation("sanswer","req","Please enter sanswer");
  
 </script>
                  </td></tr>
                </table>
            </td>
          </tr>
      </table>
  </body>
</html>
