<%@page import="java.util.ArrayList"%>
<%@page import="function.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default rounded borders and increase the bottom margin */ 
    .navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
    
    /* Remove the jumbotron's default bottom margin */ 
     .jumbotron {
      margin-bottom: 0;
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
  </style>
</head>
<body>

      <!--<a align="center" href="/SEproject/manaproduct.jsp">add product</a>-->
    <%
       ArrayList<ProductDTO> ln = (ArrayList<ProductDTO>) session.getAttribute("ln");
    %>

<div class="jumbotron">
  <div class="container text-center">
    <h1><a align="center" href="/SEproject/manaproduct.jsp">add product</a></h1>      
    
  </div>
</div>


<div class="container">    
  <div class="row">
   
      <% 
    if(ln!=null)  for(int i = 0 ; i < ln.size() ; i ++)
      {
      %>
      <div class="col-sm-4">
          <a href="/SEproject/ProductController?viewproducts=<%=i %>&action=details" ><div class="panel panel-primary">
          <div class="panel-heading"><%=ln.get(i).getProname()%> </div>
          <div class="panel-body"><img src="<%=ln.get(i).getProimg()  %>" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">$<%=ln.get(i).getProprice() %>
        </div>
              </div></a>
    </div>
      
      <% } 
else {  
      
      %>
            run serverlet first <% } %>
 </div>
</div>
      
      <br>

    

</body>
</html>
