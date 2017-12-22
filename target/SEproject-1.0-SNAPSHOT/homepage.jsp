<%@page import="function.ProductDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="function.ProductDTO"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
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

    <!--login-->
      <div id="signup" class="addedform">
            <span onclick="document.getElementById('signup').style.display = 'none'" class="close" title="Close Sign Up">×</span>
            <form class="form-content" id="signupjs" action="hihi.jsp"  >
                <div class="formContainer">
                    <h1>Sign Up</h1>
                    <hr>
                    <label><b>User Name</b></label>
                    <input type="text"  placeholder="Enter User Name" name="name" required>

                    <label><b>Email</b></label>
                    <input type="text" placeholder="Enter Email" name="email" required >

                    <label><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="psw" required>

                    <label><b>Repeat Password</b></label>
                    <input type="password" placeholder="Repeat Password" name="repsw"  required> 
                           <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

                    <div class="clear">
                        <button type="submit" class="signupbtn" onmouseover="checkValid();">Sign Up</button>
                        <button type="button" onclick="document.getElementById('signup').style.display = 'none'" class="cancelbtn">Cancel</button>
                    </div>

                </div>
            </form>
        </div>
     <!--end login-->
    
    <!--<sign up-->
     <div id="login" class="addedform">
            <span onclick="document.getElementById('login').style.display = 'none'" class="close" title="Close Sign Up">×</span>
            <form class="form-content" >
                <div class="formContainer">
                    <h1>Log In</h1>
                    <hr>
                    <label><b>User Name</b></label>
                    <input type="text" placeholder="Enter User Name" name="namelog" required>

                    <label><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="pswlog" required>

                    <div class="clear">
                        <button type="submit" class="signupbtn">Log In</button>
                        <button type="button" onclick="document.getElementById('login').style.display = 'none'" class="cancelbtn">Cancel</button>
                    </div>

                </div>
            </form>
        </div>
    <!--end sign up-->
     
     <!--script form-->
     <script>
            var registration = document.getElementById('signup');
            window.onclick = function (event) {
                if (event.target === registration) {
                    registration.style.display = "none";
                }
            };

            var log = document.getElementById('login');
            window.onclick = function (event) {
                if (event.target === log) {
                    log.style.display = "none";
                }
            };


            function checkValid() {

                var name = document.forms["signupjs"]["name"].value;
                if (name === "") {
                    alert("Please enter your user name");
                    name.focus;
                    return false;
                }

                var email = document.forms["signupjs"]["email"].value;
                var checkem = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
                if ((!checkem.test(email)) || (email === "")) {
                    alert('Please provide a valid email address');
                    email.focus;
                    return false;
                }

                var pass = document.forms["signupjs"]["psw"].value;
                if (pass === "") {
                    alert("Please enter your password");
                    pass.focus;
                    return false;
                }


                var checkpass = document.forms["signupjs"]["repsw"].value;
                if (checkpass !== pass) {
                    alert("Password does not match, please enter again!");
                    checkpass.focus;
                    return false;
                }

                return true;


            }

        </script>
        
        <!--end script form-->
     
    
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="image/bg1.jpg" alt="Image">
        <div class="carousel-caption">
         
        </div>      
      </div>

      <div class="item">
        <img src="image/bg1.jpg" alt="Image">
        <div class="carousel-caption">
          
        </div>      
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>
        
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
       
       List<ProductDTO> products = ProductDAO.get(); // Product is just a Javabean with properties `id`, `name` and `description`.
                String json = new Gson().toJson(products);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);
       
        function loadcontent()
        {
            
        }
       
       
        function openCity(evt, cityName) {
                // Declare all variables
                var i, tabcontent, tablinks;

                // Get all elements with class="tabcontent" and hide them
                tabcontent = document.getElementsByClassName("tabcontent");
                for (i = 0; i < tabcontent.length; i++) {
                    tabcontent[i].style.display = "none";
                }

                // Get all elements with class="tablinks" and remove the class "active"
                tablinks = document.getElementsByClassName("tablinks");
                for (i = 0; i < tablinks.length; i++) {
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
       
      
                        ArrayList<ProductDTO> listOfproduct =  (ArrayList<ProductDTO>) session.getAttribute("ln") ;
        for(int i = 0 ; i < listOfproduct.size() ; i++) {
    %>
 
    
     <a href="/SEproject/ProductController?viewproducts=<%=i %>&action=details" > <div class="col-sm-4">
          <img src="<%=listOfproduct.get(i).getProimg()%>" class="img-responsive" style="size: 100%" alt="Image">
          <p><%=listOfproduct.get(i).getProname()%></p>
         </div></a> <% } %>
     </div>
   
   <hr> 
   <!--end newsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss-->
    
   
   

   
   
  </div>
</div><br>
<img src="image/bg3.jpg"  style="width:100%" alt="Image">
<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

</body>
</html>
