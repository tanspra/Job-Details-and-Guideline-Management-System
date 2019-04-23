
<%@page import="com.kws.vjf.dao.CategoryDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kws.vjf.bean.CategoryMasterBean"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Virtual Job Fair</title>
	
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
                      <form name="companyform" action="./CompanyAction">
                       <table align="center" bgcolor="9966FF">
                        <tr><td colspan="2" align="center"><b><font color="white">Company Register Form</font></b></td></tr>
                         <input type="hidden" name="empid" value="<%=uid %>">
                         <tr>
                            <td><font color="white">CompanyName</font></td>
                            <td><input type="text" name="cname" ></td>
                          </tr>
                          <tr>
                            <td><font color="white">LoactionMap</font></td>
                            <td><input type="file" name="clmap"></td>
                          </tr>
                          <tr>
                            <td><font color="white">Industry</font></td>
                            <td><input type="text" name="industry" ></td>
                          </tr>
                          <tr>
                            <td><font color="white">CompanyType</font></td>
                            <td><input type="text" name="ctype"></td>
                          </tr>
                         <tr>
                            <td><font color="white">CompanySize</font></td>
                            <td><input type="text" name="csize"></td>
                          </tr>
                           <tr>
                            <td><font color="white">CompanyDesc</font></td>
                            <td><input type="text" name="cdesc"></td>
                          </tr>
                           <tr>
                            <td><font color="white">CompanyLocation</font></td>
                            <td><input type="text" name="clocation"></td>
                          </tr>
                           <tr>
                            <td><font color="white">CompanyCity</font></td>
                            <td><input type="text" name="ccity"></td>
                          </tr>
                           <tr>
                            <td><font color="white">CompanyState</font></td>
                            <td><input type="text" name="cstate"></td>
                          </tr>
                           <tr>
                            <td><font color="white">CompanyCountry</font></td>
                            <td><input type="text" name="cCountry"></td>
                          </tr>
                           <tr>
                            <td><font color="white">CompanyZip</font></td>
                            <td><input type="text" name="czip"></td>
                          </tr>
                           <tr>
                            <td><font color="white">CompanyCategory</font></td>
                            <td><select name="ccategory">
                            <option value="">select</option>
                            <%
                              CategoryDAO categoryDAO=new CategoryDAO();
                              ArrayList<CategoryMasterBean> categoryList=categoryDAO.viewCategories();
                              for(CategoryMasterBean categoryMasterBean:categoryList){
                             %>
                             <option value="<%=categoryMasterBean.getCategoryid() %>" ><%=categoryMasterBean.getCategoryname() %></option>
                             <%} %>
                             </select>
                            </td>
                          </tr>
                          <tr>
                            <td><input type="submit" value="RegisterCompany"></td>
                            <td><input type="reset" value="cancel"></td>
                          </tr>
                       </table> 
                       </form>
                          <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("companyform");
  
 
  frmvalidator.addValidation("cname","req","Please enter company Name");
  
  frmvalidator.addValidation("clmap","req","Please load company location map");
 
  frmvalidator.addValidation("industry","req","Please enter industry");
  
  frmvalidator.addValidation("ctype","req","Please enter company type");
  
    frmvalidator.addValidation("csize","req","Please enter company size");
    frmvalidator.addValidation("csize","numeric");
  
  	frmvalidator.addValidation("cdesc","req","Please enter company description");
   	frmvalidator.addValidation("clocation","req","Please enter company location");
  
    frmvalidator.addValidation("ccity","req","Please enter company city");
    
   	frmvalidator.addValidation("cstate","req","Please enter company state");
   	frmvalidator.addValidation("cCountry","req","Please enter company country");
   
   frmvalidator.addValidation("czip","req","pls enter company zip code");
   frmvalidator.addValidation("czip","numeric");
   
     frmvalidator.addValidation("ccategory","dontselect=0");
    
 </script>
                          
                  </td></tr>
                </table>
            </td>
          </tr>
      </table>
  </body>
</html>
