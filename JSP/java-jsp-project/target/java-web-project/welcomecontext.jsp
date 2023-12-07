<html>

<body>
    <% out.print("Welcome " + request.getParameter(" uname")); 
    String driver=application.getInitParameter("dname");
    out.print(" Driver name is: " + driver);  
%>

</body>
</html>