/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-11-08 10:26:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import login.Emp;
import login.EmpDao;

public final class view_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("\r\n");
  
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

      out.write("  \r\n");
      out.write("<a href=\"view.jsp?page=1\">1</a>  \r\n");
      out.write("<a href=\"view.jsp?page=2\">2</a>  \r\n");
      out.write("<a href=\"view.jsp?page=3\">3</a>\r\n");
      out.write("<a href=\"view.jsp?page=4\">4</a>  \r\n");
      out.write("<a href=\"view.jsp?page=5\">5</a>\r\n");
      out.write("<a href=\"view.jsp?page=6\">6</a>    ");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
