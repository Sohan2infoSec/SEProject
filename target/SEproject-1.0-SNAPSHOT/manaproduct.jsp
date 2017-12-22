<%@page import="function.ProductDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="function.ProductDTO"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>add new page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>

        <div class="container">
            <h2 align="center">Add product </h2>
            <form class="form-horizontal" action="ProductController" method="post">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="name">Name: </label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="gro">Group: </label>
                    <div class="col-sm-10">
                      <select name="gro" class="form-control" id="gro" placeholder="Enter Name" name="gro" required>
                        <option value="cosmetics">Cosmetics</option>
                        <option value="brushes">Brushes</option> 
                        <option value="eyelashes">Eyelashes</option>
                        <option value="hair">Hair</option>
                         <option value="jewelry">Jewelry</option>
                         <option value="acessories">Acessories</option>
                          
                        </select>
                    </div>
                </div>
                 <div class="form-group">
                    <label class="control-label col-sm-2" for="price">price: </label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="price" placeholder="Enter price" name="price" required>
                    </div>
                </div>
                 <div class="form-group">
                    <label class="control-label col-sm-2" for="sup">Supplier: </label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="sup" placeholder="Enter Supplier" name="sup" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="dis">Discription: </label>
                    <div class="col-sm-10">          
                        <textarea  class="form-control" id="dis" placeholder="Enter product's description" name="dis" required></textarea>

                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="image">Image: </label>
                    <div class="col-sm-10">          
                        <input type="text" class="form-control" id="image" placeholder="Enter image's name" name="image" required>
                    </div>
                </div>

                <div class="form-group">        
                    <div class="col-sm-offset-2 col-sm-10">

                        <button type="submit" class="btn btn-default" name="action" value="addproduct">Add</button>
                    </div>
                </div>
            </form>
            
            
            <hr>
            
            
            <!--a script to check-->
            
             <divclass="col-sm-4">
    <%
                ProductDAO dao = new ProductDAO();
                            
                        ArrayList<ProductDTO> listOfproduct =  (ArrayList<ProductDTO>) dao.getAllproduct() ;
        for(int i = 0 ; i < listOfproduct.size() ; i++) {
    %>
 
    <div class="col-sm-4">
     <a href="/SEproject/ProductController?viewproducts=<%=i %>&action=details" > 
          <img src="<%=listOfproduct.get(i).getProimg()%>" class="img-responsive" style="size: 100%" alt="Image">
          <p><%=listOfproduct.get(i).getProname()%>  <%=i %></p>
     </a> <form action="ProductController" method="POST">
         <input type="hidden" name="remove" value="<%=listOfproduct.get(i).getProid()%>">
        <button type="submit" name="action" value="remove" >remove</button> 
        </form>
          </div>
                 <% } %>
     </div>
            
            
     <hr><br>

    </body>
</html>
