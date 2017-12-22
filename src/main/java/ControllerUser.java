

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Database.DatabaseService;
import DTO.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class ControllerUser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        DatabaseService connector = new DatabaseService();

        // Call Servlet Context
        ServletContext sc = getServletContext();

        // Call session
        HttpSession session = request.getSession();

        // Declare requestDispatcher
        RequestDispatcher rd;

        String action = request.getParameter("action");

        switch (action) {
            case "removeUser": {
                String idd = request.getParameter("removeUserID");
                int id = Integer.parseInt(idd);
                connector.removeUser(id);
                ArrayList<User> listUser = connector.getAllUser();
                request.setAttribute("listUser", listUser);
                response.sendRedirect("/RetailShop/userResultPage.jsp");
                // Add news function
                break;
            }
            case "activateUser": {
                String idd = request.getParameter("activateUserID");
                int id = Integer.parseInt(idd);
                connector.activateUser(id);
                ArrayList<User> listUser = connector.getAllUser();
                request.setAttribute("listUser", listUser);
                response.sendRedirect("/RetailShop/userResultPage.jsp");
                // Add news function
                break;
            }
            case "deActivateUser": {
                String idd = request.getParameter("deActivateUserID");
                int id = Integer.parseInt(idd);
                connector.deActivateUser(id);
                ArrayList<User> listUser = connector.getAllUser();
                request.setAttribute("listUser", listUser);
                response.sendRedirect("/RetailShop/userResultPage.jsp");
//                rd = sc.getRequestDispatcher("/userResultPage.jsp");
//                rd.forward(request, response);
                // Add news function
                break;
            }

            case "searchUser": {
                String typing = request.getParameter("searchUserName");
                ArrayList<User> listUser = connector.getUserFromSearch(typing);
                request.setAttribute("listUser", listUser);
//                rd = sc.getRequestDispatcher("/userResultPage.jsp");
//                rd.forward(request, response);
                rd = sc.getRequestDispatcher("/userResultPage.jsp");
                rd.forward(request, response);
                break;
            }
            
            case "showAllUser": {
                ArrayList<User> listUser = connector.getAllUser();
                request.setAttribute("listUser", listUser);
//                response.sendRedirect("/RetailShop/userResultPage.jsp");
                rd = sc.getRequestDispatcher("/userResultPage.jsp");
                rd.forward(request, response);
                break;
            }
            
            default:
                break;

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
