package com.mycompany.bankingapplication;
/**
 *
 * @author manan
 */
import java.util.ArrayList;
import java.util.HashMap;


public class Bank {
    HashMap<String, String> userPasswords;
    ArrayList<Person> people;
    ArrayList<String> usernames;
    
    public Bank(){
        userPasswords = new HashMap<>();
        people = new ArrayList<>();
        usernames = new ArrayList<>();
    }
    
    public boolean newUser(String user, String pass){
        if(userPasswords.containsKey(user)){
            return false;
        }
        userPasswords.put(user, pass);
        usernames.add(user);
        people.add(new Person(user));
        return true;
    }

    public int login(String user, String pass){
        if(userPasswords.containsKey(user)){
            String storedPass = userPasswords.get(user);
            if (storedPass.equals(pass)){
                return usernames.indexOf(user);
            }
        }
        return -1;
    }
    
    public Person getPerson(int id){
        return people.get(id);
    }
    
    public void deposit(int id, double amount, int account){
        people.get(id).deposit(amount,account);
    }
    public boolean withdraw(int id, double amount, int account){
        if(people.get(id).withdraw(amount,account)){
            return true;
        }
        return false;
    }
}
