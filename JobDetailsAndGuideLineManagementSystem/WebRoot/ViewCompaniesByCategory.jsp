
<%@page import="com.kws.vjf.dao.CompanyDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kws.vjf.bean.CompanyMasterBean"%>
<%@page import="com.kws.vjf.dao.CategoryDAO"%>
<%@page import="com.kws.vjf.bean.CategoryMasterBean"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Job seeker placement portal</title>
	
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
                       <font color="white"><b>View Companies By Category</b></font>
                       <form name="viewcompaniesbycategory" action="ViewCompaniesByCategory.jsp">
                       <table align="center" >
                       <tr>
                          <td><font color="white">Category</font></td>
                          <td>
                          <select name="cid">
                          <option value="select">select</option>
                          <%
                             CategoryDAO categoryDAO=new CategoryDAO();
                             ArrayList<CategoryMasterBean> categoryList=categoryDAO.viewCategories();
                             for(CategoryMasterBean categoryMasterBean:categoryList){
                           %>
                           <option value="<%=categoryMasterBean.getCategoryid() %>"><%=categoryMasterBean.getCategoryname() %> </option>
                           <%} %>
                          </select>
                          </td>
                          <td>
                          <input type="submit" value="Search">
                       </tr>
                       </table>
                       </form>
                       <%
                        if(request.getParameter("cid")!=null){
                         int cid=Integer.parseInt(request.getParameter("cid"));
                         String storepath=request.getRealPath("/images");
                         CompanyDAO companyDAO=new CompanyDAO();
                         ArrayList<CompanyMasterBean> companyList=companyDAO.viewCompaniesByCategory(storepath,cid);
                         if(companyList.size()!=0){
                        %>
                    <table align="center" border="1">
                    <tr>
                      <td colspan="9" align="center"><font color="white"><b>View All Companies</b></font></td>
                    </tr>
                    <tr>
                      <td><font color="white">ComapnyName</font></td>
                      <td><font color="white">Industry</font></td>
                      <td><font color="white">Type</font></td>
                      <td><font color="white">Size</font></td>
                      <td><font color="white">Desc</font></td>
                      <td><font color="white">Location</font></td>
                      <td><font color="white">Category</font></td>
                      <td><font color="white">LoactionMap</font></td>
                       
                       </tr>
                       <%
                         for(CompanyMasterBean companyMasterBean:companyList){
                        %>
                       <tr>
                      <td><font color="white"><%=companyMasterBean.getCompanyname() %> </font></td>
                      <td><font color="white"><%=companyMasterBean.getCompanyindustry() %></font></td>
                      <td><font color="white"><%=companyMasterBean.getCmpanytype() %></font></td>
                      <td><font color="white"><%=companyMasterBean.getCompanysize() %></font></td>  
                      <td><font color="white"><%=companyMasterBean.getCompanydesc() %></font></td>
                      <td><font color="white"><%=companyMasterBean.getCompanylocation() %></font></td>
                      <td><font color="white"><%=companyMasterBean.getCompanycategoryname() %></font></td>
                      <td><img src="images/<%=companyMasterBean.getCompanylocationmap() %>" width="50" height="50" ></td>
                       
                      
                     </tr>
                     <%} %>
                    </table>
                    <%}else { %>
                      <font color="white">Company Records Not found</font>
                      <%} }%>
                  </td></tr>
                </table>
            </td>
          </tr>
      </table>
  </body>
</html>
