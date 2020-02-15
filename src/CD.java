/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marco
 */
public class CD extends Product {
    private String songName;

    public CD(String songName, int productId, int productCount) {
        super(productId, productCount);
        this.songName = songName;
    }

    public String getSongName() {
        return songName;
    }

    @Override
     public void print(){
        System.out.println("Song Name: " + songName + " Product Id: " + productId);
    }
    
    
    
    
}
