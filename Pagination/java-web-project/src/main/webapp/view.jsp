<%@page import="java.util.*" %>
<%@page import="login.Emp" %> 
<%@page import="login.EmpDao" %> 

<%  
String spageid=request.getParameter("page");  
int pageid=Integer.parseInt(spageid);  
int total=2;  
if(pageid==1){}  
else{  
    pageid=pageid-1;  
    pageid=pageid*total+1;  
}  
List<Emp> list=EmpDao.getRecords(pageid,total);  
  
out.print("<h1>Page No: "+spageid+"</h1>");  
out.print("<table border='1' cellpadding='4' width='60%'>");  
out.print("<tr><th>Id</th><th>Name</th><th>Salary</th>");  
for(Emp e:list){  
    out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getSalary()+"</td></tr>");  
}  
out.print("</table>");  
%>  
<a href="view.jsp?page=1">1</a>  
<a href="view.jsp?page=2">2</a>  
<a href="view.jsp?page=3">3</a>
<a href="view.jsp?page=4">4</a>  
<a href="view.jsp?page=5">5</a>
<a href="view.jsp?page=6">6</a>    