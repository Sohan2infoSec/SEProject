package function;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProductController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ProductDAO connector = new ProductDAO();

      

        // Call Servlet Context
        ServletContext sc = getServletContext();

        // Call session
        HttpSession session = request.getSession();

        // Declare requestDispatcher
        RequestDispatcher rd;

        String action = request.getParameter("action");
   //     news product
        if(action == "home" || action == null)
            {   ArrayList<ProductDTO> home = connector.getProduct(9);
           
       
                session.setAttribute("ln", home);
                rd = sc.getRequestDispatcher("/homepage.jsp");
                rd.forward(request, response);
                
            }
        // Show all product
        else if(action == "showdemo") {
             ArrayList<ProductDTO> listall = connector.getAllproduct();
            session.setAttribute("ln",listall);
            rd = sc.getRequestDispatcher("/showdemop.jsp");
            rd.forward(request, response);
            
            
            // Read more function
        }
        else if (action.equals("details")) {
             ArrayList<ProductDTO> listall = (ArrayList<ProductDTO>) session.getAttribute("ln");
            String idd = request.getParameter("viewproducts");
            int id = Integer.parseInt(idd);
            ProductDTO product = listall.get(id);
            session.setAttribute("product", product);
            rd = sc.getRequestDispatcher("/showdetail.jsp");
            rd.forward(request, response);         
            // Add news function
        } 
        
        // show by cata
        else if (action.equals("cata")) {
               String cat = request.getParameter("catagory");
           ArrayList<ProductDTO> catagory = connector.getProductfromGroup(cat);
            
            
          
            
             session.setAttribute("ln", catagory);
            rd = sc.getRequestDispatcher("/homepage.jsp");
            rd.forward(request, response);
            
            // Add news function
        } 
         else if (action.equals("search")) {
               String typing = request.getParameter("search");
           ArrayList<ProductDTO> searchlist = connector.getProductfromSearch(typing);
            
            
          
            
             session.setAttribute("ln", searchlist);
            rd = sc.getRequestDispatcher("/homepage.jsp");
            rd.forward(request, response);
            
            // Add news function
        } 
         else if (action.equals("remove")) {
               String idd = request.getParameter("remove");
               int id = Integer.parseInt(idd);
           connector.removeProduct(id);
           
            ArrayList<ProductDTO> listall = connector.getAllproduct();
            session.setAttribute("ln",listall);
            
          
            

          response.sendRedirect("/SEproject/manaproduct.jsp");
          
            
            // Add news function
        } 
         
        else if (action.equals("addproduct")) {
            // Input title and content with replace superscript
            String name = request.getParameter("name");    // product name
            String pname = convertSup(name);
            String price = request.getParameter("price");  // product price
            String group = request.getParameter("gro");   // group
            double ppp = Double.parseDouble(price);
            String sup = request.getParameter("sup");      // product supplier
            String psup = convertSup(sup);
            String discription = request.getParameter("dis");    // product discription
            String dis = convertSup(discription);
            // Format Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
            Date today = new Date();
            String date = sdf.format(today);       // product date import

            // Input image
            String im = request.getParameter("image");   // link product's image
            
            // Add to database
            connector.addproduct(pname, ppp, date, psup, im, group, dis);
              ArrayList<ProductDTO> listall = connector.getAllproduct();
            session.setAttribute("ln",listall);
            response.sendRedirect("/SEproject/manaproduct.jsp");
        }

    } 

    private String convertSup(String word) {
        StringBuilder sb = new StringBuilder();
        
        char[] charArray = word.toLowerCase().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            // Single character case
            switch (charArray[i]) {
                // Apostrophe
                case '\'':
                    sb.append("\\\'");
                    break;
                // Trademark
                case '™':
                    sb.append("&trade;");
                    break;
                // Register
                case '®':
                    sb.append("&reg;");
                    break;
                // Copyright
                case '©':
                    sb.append("&copy;");
                    break;
                default:
                    sb.append(word.charAt(i));
                    break;
            }
        }
        return sb.toString();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
