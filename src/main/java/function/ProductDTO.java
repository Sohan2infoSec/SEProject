/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

/**
 *
 * @author user
 */
public class ProductDTO {
    
    int proid;
    String proname;
    double proprice;
    String prodate;
    String prosup;
    String proimg;       
    String group;
    String discription;
    int quantity;
    public ProductDTO() {
    }

    public ProductDTO(int proid, String proname, double proprice, String prodate, String prosup, String proimg, String group , String discription) {
        this.proid = proid;
        this.proname = proname;
        this.proprice = proprice;
        this.prodate = prodate;
        this.prosup = prosup;
        this.proimg = proimg;
        this.group = group;
        this.discription = discription;
    }

    public ProductDTO(int proid, String proname, double proprice, String prodate, String prosup, String proimg, String group, String discription, int quantity)
    {
        this.proid = proid;
        this.proname = proname;
        this.proprice = proprice;
        this.prodate = prodate;
        this.prosup = prosup;
        this.proimg = proimg;
        this.group = group;
        this.discription = discription;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public int getProid() {
        return proid;
    }

    public String getProname() {
        return proname;
    }

    public double getProprice() {
        return proprice;
    }

    public String getProdate() {
        return prodate;
    }

    public String getProsup() {
        return prosup;
    }

    public String getProimg() {
        return proimg;
    }

    public String getGroup() {
        return group;
    }

    public String getDiscription() {
        return discription;
    }
    
    
}
