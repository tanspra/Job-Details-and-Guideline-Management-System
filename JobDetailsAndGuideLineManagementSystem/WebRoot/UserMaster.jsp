<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Job seeker placement portal
    <%
      if((String)session.getAttribute("logintype")!=null){
      if(((String)session.getAttribute("logintype")).equals("admin")){
     %> 
     <%=(String)session.getAttribute("logintype") %>
     <%}}else{ %>
       Job Seekers Registration
     <%} %>
    </title>
	
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
                        String logintype1="";
                        if((String)session.getAttribute("logintype")!=null){
                        logintype1=(String)session.getAttribute("logintype");
                        if(logintype1.equals("admin")){
                      %>
                     <jsp:include page="AdminOptions.jsp" />
                     
                    <% }}else {%> 
                        <jsp:include page="GeneralOptions.jsp" />
                    <%} %>
                  
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
                      <form name="registerform" action="./RegisterUserAction">
                       <table align="center" bgcolor="9966FF" width="895" height="604">
                        <tr><td colspan="2" align="center"><b><font color="white">Registation Form</font></b></td></tr>
                         <tr align="center">
                            <td><font color="white">UserName</font></td>
                            <td><input type="text" name="uname"></td>
                          </tr>
                          <%
                            if(logintype1.equals("admin")){
                           %>
                           <input type="hidden" name="logintype" value="employer">
                           <%}else{ %>
                          <input type="hidden" name="logintype" value="jobseaker">
                          <%} %>
                          <tr>
                            <td align="center"><font color="white">Password</font></td>
                            <td align="center"><input type="password" name="upass"></td>
                          </tr align="center">
                          <tr align="center">
                            <td ><font color="white">FirstName</font></td>
                            <td><input type="text" name="firstname"></td>
                          </tr>
                          <tr align="center">
                            <td><font color="white">LastName</font></td>
                            <td><input type="text" name="lastname"></td>
                          </tr>
                          <tr align="center">
                            <td><font color="white">DOB</font></td>
                            <td><input type="text" name="dob"></td>
                            <td>DOB Format EX:10-10-1990</td>
                          </tr>
                           <tr align="center">
                            <td><font color="white">Photo</font></td>
                            <td><input type="file" name="photo"></td>
                          </tr>
                           <tr align="center">
                            <td><font color="white">Location</font></td>
                            <td><input type="text" name="location"></td>
                          </tr>
                           <tr align="center">
                            <td><font color="white">City</font></td>
                            <td><input type="text" name="city"></td>
                          </tr>
                           <tr align="center">
                            <td><font color="white">State</font></td>
                            <td><input type="text" name="state"></td>
                          </tr>
                           <tr align="center">
                            <td><font color="white">Country</font></td>
                            <td><input type="text" name="country"></td>
                          </tr>
                           <tr align="center">
                            <td><font color="white">PinCode</font></td>
                            <td><input type="text" name="pincode"></td>
                          </tr>
                           <tr align="center">
                            <td><font color="white">Phoneno</font></td>
                            <td><input type="text" name="phoneno"></td>
                          </tr>
                           <tr align="center">
                            <td><font color="white">Email</font></td>
                            <td><input type="text" name="email"></td>
                          </tr>
                           <tr align="center">
                            <td><font color="white">Sex</font></td>
                            <td><select name="sex">
                            <option value="">select</option>
                            <option value="male">male</option>
                            <option value="female">female</option>
                            </select>
                            </td>
                          </tr>
                           <tr align="center">
                            <td><font color="white">SQuestion</font></td>
                            <td><select name="squestion">
                            <option value="">select</option>
                            <option value="1. What is ur pet name">1. What is ur pet name</option>
                            <option value="2. What is ur favroute color">2. What is ur favroute color</option> 
                            </select>
                            </td>
                          </tr>
                           <tr align="center">
                            <td><font color="white">SAnswer</font></td>
                            <td><input type="text" name="sanswer"></td>
                          </tr>
                          <tr align="center">
                            <td><input type="submit" value="Register"></td>
                            <td><input type="reset" value="cancel"></td>
                          </tr>
                       </table> 
                       </form>
                          <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("registerform");
  
 
      frmvalidator.addValidation("uname","req","Please enter User Name");
      frmvalidator.addValidation("uname","maxlen=20",	"Max length for User Name is 20");
      frmvalidator.addValidation("uname","alpha"," User Name Alphabetic chars only");
  
     frmvalidator.addValidation("upass","req","Please enter upass");
     frmvalidator.addValidation("upass","maxlen=20","Max length is 20");
     frmvalidator.addValidation("upass","alpha"," upass Alphabetic chars only");
  
  frmvalidator.addValidation("firstname","req","Please enter firstname");
  frmvalidator.addValidation("firstname","maxlen=20","Max length is 20");
  frmvalidator.addValidation("firstname","alpha"," firstname Alphabetic chars only");
  
  frmvalidator.addValidation("lastname","req","Please enter lastname");
  frmvalidator.addValidation("lastname","maxlen=20","Max length is 20");
  frmvalidator.addValidation("lastname","alpha"," lastname Alphabetic chars only");
  
  frmvalidator.addValidation("dob","req","Please enter date of birth");
  frmvalidator.addValidation("photo","req","Please enter photo");
  frmvalidator.addValidation("location","req","Please enter location");
  frmvalidator.addValidation("city","req","Please enter city");
  frmvalidator.addValidation("state","req","Please enter state");
  frmvalidator.addValidation("country","req","Please enter country");
  frmvalidator.addValidation("pincode","req","Please enter pincode");
  frmvalidator.addValidation("pincode","numeric");
   frmvalidator.addValidation("pincode","maxlen=6");
   
  frmvalidator.addValidation("phoneno","req","Please enter phoneno");
  frmvalidator.addValidation("phoneno","maxlen=50");
  frmvalidator.addValidation("phoneno","numeric");
 frmvalidator.addValidation("phoneno","Phone");
 
  frmvalidator.addValidation("email","maxlen=50");
  frmvalidator.addValidation("email","req");
  frmvalidator.addValidation("email","email");
  frmvalidator.addValidation("sex","dontselect=0");
 
 
  frmvalidator.addValidation("squestion","dontselect=0");
  frmvalidator.addValidation("sanswer","req","Please enter security answer");
   
  
 </script>
                          
                  </td></tr>
                </table>
            </td>
          </tr>
      </table>
  </body>
</html>
