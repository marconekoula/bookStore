
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marco
 */
public class Product {
    public int productId;
    public int productCount;
    //public static ArrayList<Products> products = new ArrayList<Products>();


    public Product(int productId, int productCount) {
        this.productId = productId;
        this.productCount = productCount;
    }

    public int getProductId() {
        return productId;
    }

    public int getProductCount() {
        return productCount;
    }
    
    public void print(){
        
    }
    
}
