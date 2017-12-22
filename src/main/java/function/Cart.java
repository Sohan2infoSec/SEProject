package function;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Cpt_Snag
 */
@WebServlet(urlPatterns =
{
    "/cart"
})
public class Cart extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        ProductDAO dao = new ProductDAO();
        
        //System.out.println("[+] PID is " + pid);
        if (request.getParameter("addtocart") != null)
        {
            int pid = Integer.parseInt(request.getParameter("addtocart"));
            SessionService ss = new SessionService(request.getSession());
            //if you have an ArrayList of product --> ss.addProductListToCart(list);
            //if you add only one product --> ss.addProductToCart(list);
            
            ProductDTO tmpProduct = dao.getProductByID(pid);
            ss.addCart(tmpProduct);
            System.out.println("[+] We are here");

            response.sendRedirect("showCart.jsp");
//            RequestDispatcher rd = request.getRequestDispatcher("showCart.jsp");
//            rd.forward(request, response);
        }
        else if (request.getParameter("delete") != null)
        {
            int id_of_delete_item = Integer.parseInt(request.getParameter("delete"));

            SessionService ss = new SessionService(request.getSession());
            ArrayList<ProductDTO> currentCart = ss.getCart();

            removeItemFromCart(id_of_delete_item, currentCart);

            RequestDispatcher rd = request.getRequestDispatcher("showCart.jsp");
            rd.forward(request, response);
        }
        else if (request.getParameter("checkout") != null)
        {
            PrintWriter out = response.getWriter();
            out.print("This is not done yet! Check Cart.java line 75!");
        }
        else if (request.getParameter("add_comment") != null)
        {
            int pid = Integer.parseInt(request.getParameter("addtocart"));
            System.out.println("[+] In the comment section!");
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
            
            String cmt = request.getParameter("comment");
            dao.addComment(pid, cmt);
            
        }
    }

    public void removeItemFromCart(int product_id, ArrayList<ProductDTO> cart)
    {
        ArrayList<ProductDTO> itemBin = new ArrayList<ProductDTO>();
        for (ProductDTO p : cart)
        {
            if (p.getProid() == product_id)
            {
                itemBin.add(p);
            }
        }
        cart.removeAll(itemBin);
    }
}
