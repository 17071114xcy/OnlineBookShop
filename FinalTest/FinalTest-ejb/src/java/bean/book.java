/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

/**
 *
 * @author 46378
 */
public class book {
    private String ISBN = null;
    private String Title = null;
    private String Auther = null;
    private String Press = null;
    private double Price = 0;
    private int Number = 0;
    
    
    public book(String ISBN,String Title,String Auther,String Press,double Price){
        this.ISBN = ISBN;
        this.Title = Title;
        this.Auther = Auther;
        this.Press = Press;
        this.Price = Price;
        this.Number = 1;
    }
    
    public void setNumber(int Number){
        this.Number = Number;
        return;
    }
    
    public String getISBN(){
        return this.ISBN; 
    }
    public String getTitle(){
        return this.Title; 
    }
    public String getAuther(){
        return this.Auther; 
    }
    public String getPress(){
        return this.Press; 
    }
    public double getPrice(){
        return this.Price; 
    }
    public int getNumber(){
        return this.Number; 
    }
    
}
