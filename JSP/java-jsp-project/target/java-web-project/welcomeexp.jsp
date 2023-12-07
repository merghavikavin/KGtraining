<html>

<body>
    <%= "Welcome " +request.getParameter("uname") %>

        Current Time: <%= java.util.Calendar.getInstance().getTime() %>
</body>

</html>