
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
public class Premium extends Member {

    private double feeMonthly = 10;
    private String payemntType;
    private double balance;

    public Premium(String payemntType, int id, String firstName, String lastName, double balance) {
        super(id, firstName, lastName);
        this.payemntType = payemntType;
        this.balance = balance;
    }

    public double getBalcane() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPayemntType(String paymentType) {
        this.payemntType = paymentType;
    }

    public double getFeeMonthly() {
        return feeMonthly;
    }

    public String getPayemnt() {
        return payemntType;
    }

    @Override
    public void displayMemebr() {
        System.out.println("Name: " + this.getFirstName() + " " + this.getLastName() + " \nStatus: Premium Member \nAccount Balance: $" + balance);
        System.out.println();
    }

}
