package Database;

import DTO.ProductDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.*;

public class ProductDAO
{

    private final Database connector;

    public ProductDAO()
    {
        connector = new Database(
                "localhost", "3306", "se_project", "root", "123456");//"Phuvinh651997");
    }

    public ArrayList<ProductDTO> getProduct(int n)
    {
        ArrayList<ProductDTO> listOfproduct = new ArrayList<ProductDTO>();

        String query = "SELECT * FROM product ORDER BY `p_idate` DESC LIMIT " + n;

        connector.openConnection();

        ResultSet rs = connector.ExecuteQuery(query);
        System.out.println("SQL: " + query);
        try
        {

            while (rs.next())
            {
                int id = rs.getInt("p_id");
                String name = rs.getString("p_name");
                double price = rs.getDouble("p_price");

                // Format Date
//                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//                Date today = rs.getDate("news_date");
//                String date = sdf.format(today);
                String date = rs.getString("p_idate");
                String supplier = rs.getString("p_supplier");
                String image = rs.getString("p_image");
                String group = rs.getString("p_group");
                String dis = rs.getString("p_discription");
                ProductDTO product = new ProductDTO(id, name, price, date, supplier, image, group, dis);
                listOfproduct.add(product);
            }

        }
        catch (SQLException ex)
        {
            Logger.getLogger(ProductDTO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listOfproduct;
    }

    public ArrayList<ProductDTO> getAllproduct()
    {
        ArrayList<ProductDTO> listOfproduct = new ArrayList<ProductDTO>();

        String query = "SELECT * FROM product";

        connector.openConnection();

        ResultSet rs = connector.ExecuteQuery(query);

        try
        {

            while (rs.next())
            {
                int id = rs.getInt("p_id");
                String name = rs.getString("p_name");
                double price = rs.getDouble("p_price");

                // Format Date
                //                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                //                Date today = rs.getDate("news_date");
                //                String date = sdf.format(today);
                String date = rs.getString("p_idate");
                String supplier = rs.getString("p_supplier");
                String image = rs.getString("p_image");
                String group = rs.getString("p_group");
                String dis = rs.getString("p_discription");

                ProductDTO product = new ProductDTO(id, name, price, date, supplier, image, group, dis);
                listOfproduct.add(product);
            }

        }
        catch (SQLException ex)
        {
            Logger.getLogger(ProductDTO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listOfproduct;
    }

    public void addproduct(String name, double price, String date, String supplier, String image, String group, String dis)
    {

        String sqlStatement = "INSERT INTO product (p_name,p_price,p_idate,p_supplier,p_image,p_group,p_discription) VALUES ('" + name + "'," + price + ",STR_TO_DATE('" + date + "','%Y-%m-%d'),'" + supplier + "','image/" + image + ".jpg','" + group + "','" + dis + "');";

        System.out.println("SQL: " + sqlStatement);
        connector.openConnection();
        connector.ExecuteUpdate(sqlStatement);
        connector.closeConnection();

    }

    public void removeProduct(int id)
    {

        String sqlStatement = "DELETE FROM `se_project`.`product` where p_id=" + id + ";";

        System.out.println("SQL: " + sqlStatement);
        connector.openConnection();
        connector.ExecuteUpdate(sqlStatement);
        connector.closeConnection();

    }

    public ArrayList<ProductDTO> getProductfromGroup(String groupx)
    {
        ArrayList<ProductDTO> listOfproduct = new ArrayList<ProductDTO>();

        String query = "SELECT * FROM product where p_group='" + groupx + "'";

        connector.openConnection();

        ResultSet rs = connector.ExecuteQuery(query);
        System.out.println("SQL: " + query);
        try
        {

            while (rs.next())
            {
                int id = rs.getInt("p_id");
                String name = rs.getString("p_name");
                double price = rs.getDouble("p_price");

                // Format Date
                //                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                //                Date today = rs.getDate("news_date");
                //                String date = sdf.format(today);
                String date = rs.getString("p_idate");
                String supplier = rs.getString("p_supplier");
                String image = rs.getString("p_image");
                String group = rs.getString("p_group");
                String dis = rs.getString("p_discription");

                ProductDTO product = new ProductDTO(id, name, price, date, supplier, image, group, dis);
                listOfproduct.add(product);
            }

        }
        catch (SQLException ex)
        {
            Logger.getLogger(ProductDTO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listOfproduct;
    }

    public ArrayList<ProductDTO> getProductfromSearch(String search)
    {
        ArrayList<ProductDTO> listOfproduct = new ArrayList<ProductDTO>();

        String query = "SELECT *FROM product WHERE locate('" + search + "',p_name)>0;";

        connector.openConnection();

        ResultSet rs = connector.ExecuteQuery(query);
        System.out.println("SQL: " + query);
        try
        {

            while (rs.next())
            {
                int id = rs.getInt("p_id");
                String name = rs.getString("p_name");
                double price = rs.getDouble("p_price");

                // Format Date
                //                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                //                Date today = rs.getDate("news_date");
                //                String date = sdf.format(today);
                String date = rs.getString("p_idate");
                String supplier = rs.getString("p_supplier");
                String image = rs.getString("p_image");
                String group = rs.getString("p_group");
                String dis = rs.getString("p_discription");

                ProductDTO product = new ProductDTO(id, name, price, date, supplier, image, group, dis);
                listOfproduct.add(product);
            }

        }
        catch (SQLException ex)
        {
            Logger.getLogger(ProductDTO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listOfproduct;
    }

    public ProductDTO getProductByID(int pid)
    {

        String query = "SELECT * FROM product WHERE p_id=" + pid;

        connector.openConnection();

        ResultSet rs = connector.ExecuteQuery(query);
        System.out.println("SQL: " + query);
        try
        {
            while (rs.next())
            {
                int id = rs.getInt("p_id");
                String name = rs.getString("p_name");
                double price = rs.getDouble("p_price");
                String date = rs.getString("p_idate");
                String supplier = rs.getString("p_supplier");
                String image = rs.getString("p_image");
                String group = rs.getString("p_group");
                String dis = rs.getString("p_discription");
                Integer quan = rs.getInt("p_quantity");

                //ProductDTO product = new ProductDTO(id, name, price, date, supplier, image, group, dis);
                ProductDTO product = new ProductDTO(id, name, price, date, supplier, image, group, dis, quan);
                return product;
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ProductDTO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void addComment(Integer pid, String comment)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        
        String query = "INSERT INTO `se_project`.`comment` "
                + "(`p_id`, `c_content`, `c_date`) "
                + "VALUES ('"+ pid +"', '" + comment + "', '" +  dateFormat.format(date) + "');";

        connector.openConnection();

        connector.ExecuteQuery(query);
        System.out.println("SQL: " + query);
        connector.closeConnection();

    }

//    public void addComment(String comment) throws SQLException
//    {
//
//        String sqlQuery = "INSERT INTO `se_project`.`comment` "
//                + "(`c_content`, `c_date`) "
//                + "VALUES (?, ?);";
//
//        try
//        {
//            connector.openConnection();
//            preparedStatement = connector.prepareStatement(sqlQuery);
//
//            preparedStatement.setString(1, p.getpName());
//            preparedStatement.setInt(2, p.getpPrice());
//            preparedStatement.setInt(3, p.getpStockNum());
//            preparedStatement.setString(4, p.getpCategory());
//            preparedStatement.setString(5, p.getpImage());
//            preparedStatement.setString(6, p.getpDescription());
//
//            preparedStatement.executeUpdate();
//        }
//        catch (SQLException ex)
//        {
//            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        finally
//        {
//
//            if (preparedStatement != null)
//            {
//                preparedStatement.close();
//            }
//
//            if (conn != null)
//            {
//                conn.close();
//            }
//
//        }
//    }
}
