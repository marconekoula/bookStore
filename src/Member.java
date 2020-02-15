
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marco
 */
public class Member {
    private int id;
    private String firstName;
    private String lastName;
    

    public Member(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id){
        
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    

   public void displayMemebr(){
       System.out.println("Name: " + firstName + " " + lastName + "\nStatus: Regular Memeber" );
       System.out.println();
   }
    
    
    
    
}
