/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import DTO.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author junnguyen
 */
public class DatabaseService {

    private Connection conn;
    private PreparedStatement preparedStatement;

    public DatabaseService() {
        preparedStatement = null;
        conn = Connector.getConn();
        //conn = Connector.getConn();
        System.out.println("[+] Conn is okie || " + conn);
    }

    public String getPassword(String name) throws SQLException {

        String sqlQuery = "SELECT * FROM user WHERE nameUser = ?"; //mydb = $Database_Name
        //Ghi dòng Query cần Update hay Delete hay Select ở đây
        //Chỗ ? sẽ input vào sau vì vấn đ�? Security
        String passwd = null; //Anh dùng method này để check password từ DB với input_Pass
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(sqlQuery);//Dùng PreparedStatement để input vào ?
            preparedStatement.setString(1, name);// ? thứ 1 sẽ input từ parameter email.

            ResultSet rs = preparedStatement.executeQuery();
            ///If no data return prepareStmt.executeUpdate(); sao no hieu dc :S
            while (rs.next()) {
                passwd = rs.getString("passUser");//Get giá trị nằm ở Collumn password
                System.out.println("PASS IS " + passwd);//Debug lỗi

            }
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return passwd;
    }

    public String getStatus(String name) throws SQLException {

        String sqlQuery = "SELECT * FROM user WHERE nameUser = ?";
        String status = null; //Anh dùng method này để check password từ DB với input_Pass
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(sqlQuery);//Dùng PreparedStatement để input vào ?
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                status = rs.getString("pendingUser");

            }
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return status;
    }

    public void importValue(String name, String email, String pass, String status) throws SQLException {

        String sqlQuery = "INSERT INTO user "
                + "(nameUser, emailUser, passUser, pendingUser) "
                + "VALUES(?, ?, ?, ?)";//Khoi can ; cung dc. 
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(sqlQuery);//Dùng PreparedStatement để input vào ?
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, pass);
            preparedStatement.setString(4, status);
            preparedStatement.executeUpdate();
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
    }

    public void removeUser(int counter) throws SQLException {
        String sqlQuery = "DELETE FROM user "
                + "WHERE idUser = ?";//Khoi can ; cung dc. 
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(sqlQuery);//Dùng PreparedStatement để input vào ?
            preparedStatement.setInt(1, counter);
            preparedStatement.executeUpdate();
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
    }

    public void activateUser(int counter) throws SQLException {
        String sqlQuery = "UPDATE se_project.user "
                + "SET pendingUser = 1 "
                + "WHERE idUser = ?";//Khoi can ; cung dc. 
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(sqlQuery);//Dùng PreparedStatement để input vào ?
            preparedStatement.setInt(1, counter);
            preparedStatement.executeUpdate();
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
    }

    public void deActivateUser(int counter) throws SQLException {
        String sqlQuery = "UPDATE se_project.user "
                + "SET pendingUser = 0 "
                + "WHERE idUser = ?";//Khoi can ; cung dc. 
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(sqlQuery);//Dùng PreparedStatement để input vào ?
            preparedStatement.setInt(1, counter);
            preparedStatement.executeUpdate();
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
    }

    public ArrayList<User> getUser(int n) throws SQLException {
        ArrayList<User> listOfUser = new ArrayList<User>();
        String query = "SELECT * FROM se_project.user WHERE idUser = ?";
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, n);

            ResultSet rs = preparedStatement.executeQuery();
            ///If no data return prepareStmt.executeUpdate(); sao no hieu dc :S
            while (rs.next()) {
                int id = rs.getInt("idUser");
                String name = rs.getString("nameUser");
                String email = rs.getString("emailUser");
                String pass = rs.getString("passUser");
                int status = rs.getInt("pendingUser");
                User user = new User(id, name, email, pass, status);
                listOfUser.add(user);
            }
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return listOfUser;
    }

    public ArrayList<User> getAllUser() throws SQLException {
        ArrayList<User> listOfUser = new ArrayList<User>();
        String query = "SELECT * FROM se_project.user";
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            ///If no data return prepareStmt.executeUpdate(); sao no hieu dc :S
            while (rs.next()) {
                int id = rs.getInt("idUser");
                String name = rs.getString("nameUser");
                String email = rs.getString("emailUser");
                String pass = rs.getString("passUser");
                int status = rs.getInt("pendingUser");
                User user = new User(id, name,email, pass, status);
                listOfUser.add(user);
            }
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return listOfUser;
    }

    public ArrayList<User> getUserFromSearch(String search) throws SQLException {
        ArrayList<User> listOfUser = new ArrayList<User>();
        String query = "SELECT * FROM se_project.user WHERE locate(?, nameUser)>0";
//        String query = "SELECT * FROM se_project.user WHERE locate('" + search + "', nameUser)>0";
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, search);
            ResultSet rs = preparedStatement.executeQuery();
            ///If no data return prepareStmt.executeUpdate(); sao no hieu dc :S
            while (rs.next()) {
                int id = rs.getInt("idUser");
                String name = rs.getString("nameUser");
                String email = rs.getString("emailUser");
                String pass = rs.getString("passUser");
                int status = rs.getInt("pendingUser");
                User user = new User(id, name, email, pass, status);
                listOfUser.add(user);
            }
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return listOfUser;
    }

}
