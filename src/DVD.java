/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marco
 */
public class DVD extends Product{
    private String name;

    public DVD(String name, int productId, int productCount) {
        super(productId, productCount);
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    @Override
     public void print(){
        System.out.println("DVD Name: " + name + " Product Id: " + productId);
    }
    
    
    
}
