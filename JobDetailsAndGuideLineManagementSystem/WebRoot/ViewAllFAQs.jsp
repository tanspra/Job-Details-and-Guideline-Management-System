
<%@page import="com.kws.vjf.dao.FAQDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kws.vjf.bean.FAQBean"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Job seeker placement portal - Home</title>
	
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
                       <%
                         FAQDAO faqdao=new FAQDAO();
                         ArrayList<FAQBean> faqList=faqdao.viewAllFAQs();
                         
                         if(faqList.size()!=0){
                           
                        %>
                    <table align="center" width="402" height="238">
                    <tr>
                      <td colspan="3" align="center" ><font color="white"><b>FAQS</b></font></td>
                    </tr>
                    
                      <%
                         for(FAQBean faqBean:faqList){
                        %>
                        <tr>
                      <td><font color="white">FAQType</font></td>
                      <td><font color="white">:<%=faqBean.getFaqtype() %> </font></td>
                      </tr>
                      <%
                         ArrayList<FAQBean> faqlist=faqdao.viewAllFAQsByFaqType(faqBean.getFaqtype());
                         for(FAQBean faqBean1:faqlist){
                           
                        %>
                      
                      <tr><td colspan="2"><font color="white"><%=faqBean1.getFaqid()%>)<%=faqBean1.getFaqquestion() %></font></td></tr>
                      
                      <tr> <td colspan="2"><font color="white">A)<%=faqBean1.getFaqanswer() %></font></td></tr>
                       <br>
                       
                     <%}} %>
                    </table>
                    <%}else { %>
                      <font color="white">faqs Records Not found</font>
                      <%} %>
                  </td></tr>
                </table>
            </td>
          </tr>
      </table>
  </body>
</html>
