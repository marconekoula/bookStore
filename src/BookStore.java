
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author marco
 */
public class BookStore {

    Scanner input = new Scanner(System.in);
    public static ArrayList<Product> products = new ArrayList<Product>();
    public static ArrayList<Member> members = new ArrayList<Member>();
    public static ArrayList<Premium> pMembers = new ArrayList<Premium>();

    public BookStore() {
    }

    /**
     * 1.This function, addProducts, allows the user to add a product to the
     * library They can add a book, DVD, or CD
     */
    public void addProducts() {
        Scanner input = new Scanner(System.in);
        String name;
        int productId;
        int ammountAdd;
        int isbn;
        int productType;

        Book book;
        CD cd;
        DVD dvd;

        System.out.println("What kind of product would you like to donate?");
        System.out.println("1.Book \n2.CD \n3.DVD");
        productType = input.nextInt();
        System.out.println("How many would you like to add?");
        ammountAdd = input.nextInt();

        switch (productType) {
            case 1:
                System.out.println("What is the book's ISBN number?");
                isbn = input.nextInt();
                input.nextLine();
                System.out.println("What is the title?");
                name = input.nextLine();
                productId = (int) (Math.random() * 150 + 110);
                book = new Book(isbn, name, productId, ammountAdd);
                products.add(book);
                break;
            case 2:
                input.nextLine();
                System.out.println("What is the song name?");
                name = input.nextLine();
                productId = (int) (Math.random() * 250 + 210);
                cd = new CD(name, productId, ammountAdd);
                products.add(cd);
                break;
            case 3:
                input.nextLine();
                System.out.println("What is the name of the DVD?");
                name = input.nextLine();
                productId = (int) (Math.random() * 350 + 310);
                dvd = new DVD(name, productId, ammountAdd);
                products.add(dvd);
                break;
        }
    }

    /**
     * 2.This function, addMember, allows the user to create a new account if
     * they don't have one Also, gives them the option to be a premium member or
     * not
     */
    public void addMember() {
        Scanner input = new Scanner(System.in);
        String firstNmae;
        String lastName;
        String paymentType;
        int memberType;
        int amount;
        int accountNumber;
        boolean loop = true;
        Premium premium;
        Member member;

        System.out.println("What is your first name new member?");
        firstNmae = input.nextLine();
        System.out.println("What is your last name new member");
        lastName = input.nextLine();
       
        do {
            try {
                System.out.println("\nWould you like to be a premium member? \n1.Yes \n2.No");
                memberType = input.nextInt();
                do {
                    accountNumber = (int) (Math.random() * 1000 + 101);
                    if (memberType == 1) {
                        System.out.println("The monthly fee is $10, How would you like to pay?");
                        paymentType = input.nextLine();
                        input.nextLine();
                        System.out.println("How much money would you like to add to your account?");
                        amount = input.nextInt();
                        System.out.println("$" + amount + " has been added to your account. $10 has been debited from your account and will be taken out every month");
                        System.out.println("Your current balance now is " + (amount - 10));
                        premium = new Premium(paymentType, accountNumber, firstNmae, lastName, (amount - 10));
                        members.add(premium);
                        pMembers.add(premium);
                        System.out.println("Your account number is: " + accountNumber + "\nplease save it.");
                        System.out.println();
                        loop=false;
                    } else if (memberType == 2) {
                        member = new Member(accountNumber, firstNmae, lastName);
                        members.add(member);
                        System.out.println("Your account number is: " + accountNumber + "\nplease save it.");
                        System.out.println();
                        loop=false;
                    } else {
                        System.out.println("That was an invalid option, please try again");
                        System.out.println("Would you like to be a premium member? \n1.Yes \n2.No");
                        memberType = input.nextInt();
                        System.out.println();
                        loop=false;
                    }
                } while (memberType != 1 && memberType != 2);
            } catch (InputMismatchException z) {
                System.out.println("That was an invalid option, please try again");
                input.nextLine();
                System.out.println();
                loop = true;
            }
        } while (loop);
    }

    /**
     * These are some default books,CDs, and DVDs I have added for the user to
     * choose from
     */
    public void productsAvailable() {
        Book book;
        CD cd;
        DVD dvd;
        book = new Book(1001, "How to get away with murder", 101, 1);
        products.add(book);
        book = new Book(1002, "Harry Potter", 102, 1);
        products.add(book);
        book = new Book(1003, "Marco's life story", 103, 1);
        products.add(book);
        book = new Book(1004, "Mirror Mirror on the wall", 104, 1);
        products.add(book);

        cd = new CD("Electric", 201, 1);
        products.add(cd);
        cd = new CD("Fire", 202, 1);
        products.add(cd);
        cd = new CD("Earth", 203, 1);
        products.add(cd);
        cd = new CD("Air", 204, 1);
        products.add(cd);

        dvd = new DVD("Hong Kong", 301, 1);
        products.add(dvd);
        dvd = new DVD("A flower's life", 302, 1);
        products.add(dvd);
        dvd = new DVD("Camels", 303, 1);
        products.add(dvd);
        dvd = new DVD("America's finest", 304, 1);
        products.add(dvd);
    }

    /**
     * 3.This function allows the user to buy a product, either a book, CD, or
     * DVD
     *
     * @param id
     * @return returns 0 if the product Id was not valid and returns 1 if
     * product Id is valid
     */
    public void buyProduct() {
        System.out.println("These are the products we have currently available: ");
        displayProducts();
        System.out.println();
            try {
                System.out.println("What is your account number?");
                int accountNumber = input.nextInt();
                int checkNumber = checkAccount(accountNumber);

                if (checkNumber == 1) {
                    System.out.println("Welcome back!");
                    System.out.println("What is the of product ID of the item you would like to buy?");
                    int productID = input.nextInt();
                    Product product = null;
                    int count = 0;

                    for (Product a : products) {
                        if (a.getProductId() == productID) {
                            product = a;
                            count = 1;
                        }
                    }
                    if (count == 1) {
                        products.remove(product);
                        System.out.println("Product was found and has been checked out for you.");
                    } else {
                        System.out.println("Product was not found, invalid product Id");
                    }
                } else {
                    System.out.println("That account number was not found. \nIf you have forgoten your account number please select option 3 in the main menu");
                }
            } catch (InputMismatchException a) {
                System.out.println("That was an invalid option, please try again");
                input.nextLine();
                System.out.println();
            }
    }

    
    /**
     * Displays products available to buy
     */
    public void displayProducts() {
        for (int i = 0; i < products.size(); i++) {
            products.get(i).print();
        }
    }

    
    /**
     * Searches if account number is valid
     *
     * @param num
     * @return returns either 1 meaning the account number is valid or 0 meaning
     * the account number is not valid
     */
    public int checkAccount(int num) {
        Member member = null;
        int check = 0;
        for (Member s : members) {
            if (s.getId() == num) {
                member = s;
                check = 1;
            }
        }
        return check;
    }

    
    /**
     * Displays both premium and normal members Used this to check if members
     * have been add or not
     */
    public void displayMembers() {
        for (int i = 0; i < members.size(); i++) {
            members.get(i).displayMemebr();
        }
    }

    
    /**
     * 4.This function is used to retrieve the users account number if they have
     * forgotten it
     *
     * @param lname
     * @return returns the users account number
     */
    public void forgotAccount() {
        System.out.println("I see you have forgot your account number. What is your last name on file?");
        String lastName = input.nextLine();
        Member member = null;
        int check = 0;
        for (Member a : members) {
            if (a.getLastName().equals(lastName)) {
                member = a;
                check++;
            }
        }
        if (check > 0) {
            Member z = member;
            System.out.println("Your account number is: " + z.getId());
        } else {
            System.out.println("Sorry that last name was not found on file");
        }
    }

    
    /**
     * 5.This function allows the user to add money to there account
     * @param num 
     */
    public void addFuns(int num) {
        int check = checkAccount(num);
        Premium premium = null;
        double money;
        if(check==1){
            System.out.println("The account was succcefully found, How much would you like to add?");
             money = input.nextDouble();
            for(Premium a: pMembers){
                if(a.getId()==num){
                    premium = a;
                }
            }
            premium.setBalance(premium.getBalcane()+money); 
            System.out.println("That money has been successfully added, thank you!");
        }     
    }

}
