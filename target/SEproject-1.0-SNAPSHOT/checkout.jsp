<%-- 
    Document   : checkout
    Created on : Dec 18, 2017, 10:27:32 PM
    Author     : Cpt_Snag
--%>

<%@page import="function.SessionService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="function.ProductDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            /* Remove the navbar's default margin-bottom and rounded borders */ 
            .navbar {
                margin-bottom: 0;
                border-radius: 0;
            }

            /* Add a gray background color and some padding to the footer */
            footer {
                background-color: #f2f2f2;
                padding: 25px;
            }

            .carousel-inner img {
                width: 100%; /* Set width to 100% */
                margin: auto;
                min-height:200px;
            }

            /* Hide the carousel text when the screen is less than 600 pixels wide */
            @media (max-width: 600px) {
                .carousel-caption {
                    display: none; 
                }
            }
        </style>
    </head>
    <body>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="#">Card</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li ><a href="#">Account</a></li>
                        <li><a href="#">About</a></li>
                        <li><a href="#">Projects</a></li>
                        <li><a href="#">Contact</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#" onclick="document.getElementById('login').style.display = 'block'" style="width:auto;"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                        <li><a href="#" onclick="document.getElementById('signup').style.display = 'block'" style="width:auto;"></span> Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <h1>Checkout: </h1>
        <%
            SessionService ss = new SessionService(request.getSession());
            ArrayList<ProductDTO> list = ss.getCart();
            double total = 0;
            if (list != null)
            {
        %>
        <form action="Cart" method="post">
            <table border="1" width="80%">
                <tr>
                    <th>Image</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                </tr>
                <%
                    for (ProductDTO p : list)
                    {
                        total += p.getProprice() * p.getQuantity();
                %>
                <tr align="center">
                    <td><img src="<%= p.getProimg()%>" alt="Smiley face" height="42" width="42"></td>
                    <td><%= p.getProname()%></td>
                    <td><%= p.getQuantity()%></td>
                    <td><%= p.getProprice()%></td>
                </tr>
                <%
                    }
                %>
                <tr align="center">
                    <td></td>
                    <td></td>
                    <td><b>Total price</b></td>
                    <td><b><%= total%></b></td>
                </tr>
            </table>
            <hr>
            <b>Bank-Account:</b> <input type="text" name="banking" size="30%"><br>
            <b>Delivery-Addres </b><input type="text" name="address" size="50%"><br>
            <button type="submit" name="checkout" formmethod="POST">Make an order!</button>
        </form>
        <%
            }
        %>
    </body>
</html>
