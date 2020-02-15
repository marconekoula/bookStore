/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marco
 */
public class Book extends Product {
    private int ISBN;
   private String title;

    public Book(int ISBN, String title, int productId, int productCount) {
        super(productId, productCount);
        this.ISBN = ISBN;
        this.title = title;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }
    
    @Override
    public void print(){
        System.out.println("Book Title: " + title + " ISBN: " + ISBN + " Product Id: " + productId);
    }

    
    
    
}
