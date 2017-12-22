<%@page import="Package.User"%>
<%@ page import="java.util.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
    <head>
    </head>
    <body>
        <table width="90%" align="center"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=8 align="center"
                    style="background-color:teal">
                    <b>User Record</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>User ID</b></td>
                <td><b>User Name</b></td>
                <td><b>User Email</b></td>
                <td><b>Password</b></td>
                <td><b>Status</b></td>
                <td colspan=3 align="center"><b>Action</b></td>
            </tr>
            <%
                String color = "#F9EBB3";
                if (request.getAttribute("listUser") != null) {
                    ArrayList<User> listOfUser = (ArrayList<User>) request.getAttribute("listUser");
                    for (int i = 0; i < listOfUser.size(); i++) {
            %>
            <tr style="background-color:<%=color%>;">
                <td><%=listOfUser.get(i).getIdUser()%></td>
                <td><%=listOfUser.get(i).getNameUser()%></td>
                <td><%=listOfUser.get(i).getEmailUser()%></td>
                <td><%=listOfUser.get(i).getPassUser()%></td>
                <td><%if (listOfUser.get(i).getPendingUser() == 1) {
                        out.println("Activated User");
                    } else {
                        out.println("Pending User");
                    }
                    %></td>
                <td>
                    <form action="ControllerUser" method="POST">
                        <input type="hidden" name="activateUserID" value="<%=listOfUser.get(i).getIdUser()%>">
                        <button type="submit" name="action" value="activateUser" >Activate</button> 
                    </form>
                </td>
                <td>
                    <form action="ControllerUser" method="POST">
                        <input type="hidden" name="deActivateUserID" value="<%=listOfUser.get(i).getIdUser()%>">
                        <button type="submit" name="action" value="deActivateUser" >Deactivate</button> 
                    </form>
                </td>
                <td>
                    <form action="ControllerUser" method="POST">
                        <input type="hidden" name="removeUserID" value="<%=listOfUser.get(i).getIdUser()%>">
                        <button type="submit" name="action" value="removeUser" >Remove</button> 
                    </form>

                </td>

            </tr>
            <%
                    }
                }
            %>
            <tr>
                <td colspan=8 align="center"
                    style="background-color:#eeffee"><b>...End of the List...</b></td>
            </tr>
            <%            
            %>
        </table>
    </body>
</html>