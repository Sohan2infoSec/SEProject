package function;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import function.ProductDTO;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author junnguyen
 */
public class SessionService
{

    private final HttpSession httpSession;

    public SessionService(HttpSession httpSession)
    {
        this.httpSession = httpSession;
    }

    public ArrayList<ProductDTO> getCart()
    {
        ArrayList<ProductDTO> cartList = (ArrayList<ProductDTO>) httpSession.getAttribute("cart");

        if (cartList == null)
        {
            cartList = new ArrayList<ProductDTO>();
        }
        return cartList;
    }

    public void addCart(ProductDTO p)
    {
        ArrayList<ProductDTO> cartList = (ArrayList<ProductDTO>) httpSession.getAttribute("cart");
        if (cartList == null)
        {
            cartList = new ArrayList<ProductDTO>();
            cartList.add(p);
        }
        else
        {
            for (ProductDTO tmpP : cartList)
            {
                if (tmpP.getProid()== p.getProid())
                {
                    removeItemFromCart(tmpP.getProid(), cartList);
                    Integer newQuantitty = tmpP.getQuantity()+ 1;
                    p.setQuantity(newQuantitty);                 
                    break;
                }
            }
            cartList.add(p);
        }
        httpSession.setAttribute("cart", cartList);
    }
    
    public void removeItemFromCart(Integer pid, ArrayList<ProductDTO> cart)
    {
        ArrayList<ProductDTO> itemBin = new ArrayList<ProductDTO>();
        for (ProductDTO p : cart)
        {
            if (p.getProid()== pid)
            {
                itemBin.add(p);
            }
        }
        cart.removeAll(itemBin);
        httpSession.setAttribute("cart", cart);
    }
    
//    public void addProductListToCart(ArrayList<ProductDTO> list)
//    {
//        ArrayList<ProductDTO> cartList = (ArrayList<ProductDTO>) httpSession.getAttribute("cart");
//
//        if (cartList == null)
//        {
//            cartList = new ArrayList<ProductDTO>();
//            cartList = list;          
//        }
//        else
//        {
//            for (ProductDTO p : list)
//            {
//                cartList.add(p);
//            }
//        }
//        httpSession.setAttribute("cart", cartList);
//    }
}
