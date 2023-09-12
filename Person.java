package com.mycompany.bankingapplication;


import java.util.ArrayList;

/**
 *
 * @author manan
 */
public class Person {
    
    private String user;
    private double balance1;
    private double balance2;
    ArrayList<Double> transactions1;
    ArrayList<Double> transactions2;
    
    
    public Person(String user){
        this.user = user;
        balance1 = 0;
        balance2 = 0;
        transactions1 = new ArrayList<>();
        transactions2 = new ArrayList<>();
    }
    
    public String getUser(){
        return user;
    }
    
    public double getBalance1(){
        return Math.round(balance1 * 100.0) / 100.0;
    }

    public double getBalance2(){
        return Math.round(balance2 * 100.0) / 100.0;
    }

    
    public void deposit(double amount, int account){
        if(account == 1){
            balance1 += amount;
            transactions1.add(amount);
        }
        else{
            balance2 += amount;
            transactions2.add(amount);
        }
    }
    
    public boolean withdraw(double amount, int account){
        if(account == 1) {
            if(balance1 >= amount){
                balance1 -= amount;
                transactions1.add(amount*-1);
                
                return true;
            }
        } 
        else if(account == 2) {
            if(balance2 >= amount){
                balance2 -= amount;
                transactions2.add(amount*-1);
                
                return true;
            }
        }
        
        return false;
    }
    
    public ArrayList<Double> getTrans(int account){
        if(account == 1)
            return transactions1;
        return transactions2;
    }
}
