<%-- 
    Document   : showCart
    Created on : Dec 18, 2017, 9:05:39 PM
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
        <h1>Cart:</h1>
        <form action="Cart" method="post">

            <%
                SessionService ss = new SessionService(request.getSession());
                ArrayList<ProductDTO> pList = ss.getCart();

                if (pList != null)
                {
                    System.out.println("[+] in the LIST");

            %>

            <table border="1" width="80%">
                <tr>
                    <th>Image</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Delete</th>
                </tr>
                <%                    for (ProductDTO p : pList)
                    {
                %>
                <tr>
                    <td><img src="<%= p.getProimg()%>" alt="Smiley face" height="42" width="42"></td>
                    <td><%= p.getProname()%></td>
                    <td><%= p.getQuantity()%></td>
                    <td><%= p.getProprice()%></td>
                    <td><button type="submit" name="delete" value="<%= p.getProid()%>" formmethod="post">Delete</button></td>
                </tr>
                <%
                    }
                %>

                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><a href="ProductController">Continue shoping!</a></td>
                    <td><a href="checkout.jsp">Check out!</a></td>               
                </tr>
            </table>
            <%
                }
            %>
        </form>   
        <div class="container text-center">    

            <hr>    
            <!--sssss-->
            <nav class="navbar navbar-collapse">
                <div class="container-fluid">

                    <ul class="nav navbar-nav" class="tab">
                        <li class="tablinks"><a href="/SEproject/ProductController">Home</a></li>
                        <li class="tablinks"><a href="/SEproject/ProductController?catagory=cosmetics&action=cata">Cosmetics</a></li>
                        <li class="tablinks"><a href="/SEproject/ProductController?catagory=brushes&action=cata">Brushes</a></li> 
                        <li class="tablinks"><a href="/SEproject/ProductController?catagory=eyelashes&action=cata">Eyelashes</a></li>
                        <li class="tablinks"><a href="/SEproject/ProductController?catagory=hair&action=cata">Hair</a></li>
                        <li class="tablinks"><a href="/SEproject/ProductController?catagory=jewelry&action=cata">Jewelry</a></li>
                        <li class="tablinks"><a href="/SEproject/ProductController?catagory=acessories&action=cata">Acessories</a></li>


                    </ul>


                    <form class="navbar-form navbar-left" action="ProductController" method="POST"> 
                        <input class="form-control" id="myInput" type="text" placeholder="Search.." name="search">
                        <button type="submit" class="btn btn-default" name="action" value="search">Search</button>

                    </form> </div>
            </nav>
            <hr>


            <!--newwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww-->
            <script>

                List < ProductDTO > products = ProductDAO.get(); // Product is just a Javabean with properties `id`, `name` and `description`.
                        String json = new Gson().toJson(products);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);

                function loadcontent()
                {

                }


                function openCity(evt, cityName)
                {
                    // Declare all variables
                    var i, tabcontent, tablinks;

                    // Get all elements with class="tabcontent" and hide them
                    tabcontent = document.getElementsByClassName("tabcontent");
                    for (i = 0; i < tabcontent.length; i++)
                    {
                        tabcontent[i].style.display = "none";
                    }

                    // Get all elements with class="tablinks" and remove the class "active"
                    tablinks = document.getElementsByClassName("tablinks");
                    for (i = 0; i < tablinks.length; i++)
                    {
                        tablinks[i].className = tablinks[i].className.replace(" active", "");
                    }

                    // Show the current tab, and add an "active" class to the button that opened the tab
                    document.getElementById(cityName).style.display = "block";
                    evt.currentTarget.className += " active";
                }
            </script>


            <div id="content" class="tabcontent">

            </div>





            <div class="row">
                <%
                    ArrayList<ProductDTO> listOfproduct = (ArrayList<ProductDTO>) session.getAttribute("ln");
                    for (int i = 0; i < listOfproduct.size(); i++)
                    {
                %>


                <a href="/SEproject/ProductController?viewproducts=<%=i%>&action=details" > <div class="col-sm-4">
                        <img src="<%=listOfproduct.get(i).getProimg()%>" class="img-responsive" style="size: 100%" alt="Image">
                        <p><%=listOfproduct.get(i).getProname()%></p>
                    </div></a> <% }%>
            </div>

            <hr> 
            <!--end newsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss-->
        </div>

        <footer class="container-fluid text-center">
            <p>Footer Text</p>
        </footer>
    </body>
</html>
