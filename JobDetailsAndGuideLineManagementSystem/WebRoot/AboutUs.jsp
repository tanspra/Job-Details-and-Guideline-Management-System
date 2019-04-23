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
                  <tr><td><font face="Times New Roman"><img width="970" height="305" src="images/15.jpg"></font></td></tr>
                </table>
            </td>
          </tr>
          <tr>
           <td><table align="center" width="970" height="20" bgcolor="9966FF">
                  <tr><td align="center">
                     <font face="Times New Roman"><jsp:include page="GeneralOptions.jsp"></jsp:include></font> 
                  <br></td></tr>
                </table>
            </td>
          </tr>
          <tr>
           <td><table align="center" width="970" height="450" bgcolor="9966as" >
                  <tr><td align="center">
                      <font face="Times New Roman"><% 
                        if(request.getParameter("status")!=null){ 
                       %></font>
                       <font color="white" face="Times New Roman"><%=request.getParameter("status") %></font>
                       <font face="Times New Roman"><%} %></font>
                      <form name="signinform" action="./LoginAction">
                       <table align="center" bgcolor="9966FF">
                        <tr><td colspan="2" align="center"><font face="Times New Roman"><b><font color="white">About Virtual job fair</font></b></font></td></tr>
                         <tr>
                            <td><p><font face="Times New Roman">Virtual Job Fair System provides the solution apply for jobs posted online within the Virtual Job Fair.  
                            It provided information and examples to help you build an effective resume and apply for the jobs that fit your experience and skills.  
                            Asynchronous interviews can be more convenient, since everyone can do them on their own time.  
                            It provides to job seekers currently looking for a new position, career fairs can give you some insight into who is hiring.</font></p></td>
                          </tr>
                         <tr>
                            <td><font face="Times New Roman">The existing system not providing facilitate communication between employer and jobseeker.  
                            This system does not provide the resume models and resume tips to jobseeker.  
                            This system does not provide the vacancy job details of company. This system does not provide the news details of jobs.  
                            This system does not provide about faqs.</font></td>
                          </tr>
                          <!-- <tr>
                            <td><input type="submit" value="SignIn"></td>
                            <td><input type="reset" value="cancel"></td>
                          </tr>
                       --></table> 
                       </form>&nbsp; 
                           <!--<a href="UserMaster.jsp"><font color="white"><b>Job Seakers Register Here</b></font></a>
                  --></td></tr>
                </table>
            </td>
          </tr>
      </table>
  </body>
</html>
