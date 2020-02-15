
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Five Major Function: Adding a new member, buying a product, donate a product,
 * retrieving lost account number, and adding money to account
 *
 * @author marco
 */
public class Start {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BookStore store = new BookStore();
        store.productsAvailable();

        int option = 0;

        System.out.println("------------------------------Welcome to Marco's Book Store!------------------------------");
        System.out.println("\nPlease select from the following menu options:");

        while (option != 8) {
            try {
                System.out.println("1.New member \n2.Buy a product \n3.Lost Account Number \n4.Donate a Product \n5.Display Available Products \n6.Add money to account \n7.Display Members \n8.Exit");
                option = input.nextInt();
                input.nextLine();

                if (option == 1) {
                    store.addMember();
                } else if (option == 2) {
                    store.buyProduct();
                } else if (option == 3) {
                    store.forgotAccount();
                } else if (option == 4) {
                    System.out.println("Thank You for choosing to donate a product.");
                    store.addProducts();
                    System.out.println("That product has been added, thank you!");
                } else if (option == 5) {
                    store.displayProducts();
                    System.out.println();
                } else if (option == 6) {
                    System.out.println("What is your account number?");
                    int num = input.nextInt();
                    System.out.println();
                    store.addFuns(num);
                } else if (option == 7) {
                    store.displayMembers();
                    System.out.println();
                }else if(option==8){
                    System.out.println();
                } 
                else {
                    System.out.println("Please select a valid option.");
                }
            } catch (InputMismatchException a) {
                System.out.println("That was an invalid option, please try again");
                System.out.println();
                input.nextLine();
            }
        }
        System.out.println("Thanks for visiting!");
    }
}
