<%@page import="Package.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Package.DatabaseService"%>
<%@page import="java.sql.*"%>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>User Management</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <style>
            a.logo{
                text-shadow: 2px 0 black, -2px 0 black, 0 2px black, 0 -2px black, 1px 1px black, -1px -1px black, -1px 1px black, 1px -1px black;
            }

            body{
                background-color:#EEEEEE;
            }

            table,th,td
            {
                text-align:center; 
                vertical-align:middle;
            }
        </style>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>


    </head>

    <body>
        <%
            if (session.getAttribute("admin") == null) {
                response.sendRedirect("index.jsp");
            }
        %>

        <div>
            <%
                DatabaseService dao = new DatabaseService();
            %>
            <div class="todolist">
                <h1 align="center">User Management</h1>

                <form class="navbar-form navbar-left" action="ControllerUser" method="POST"> 
                    <input type="text" placeholder="Search for Users" name="searchUserName" id="searchUserName">
                    <button type="submit" class="btn btn-default" name="action" value="searchUser">Search</button>
                </form>
                
                <form class="navbar-form navbar-left" action="ControllerUser" method="POST"> 
                    <button type="submit" class="btn btn-default" name="action" value="showAllUser">Show All User</button>
                </form>

            </div>
                <br>
        <a class="navbar-form navbar-left" href="index.jsp">Back to Home Page</a>

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    </body>


</html>