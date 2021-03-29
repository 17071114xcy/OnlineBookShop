/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.util.Arrays;
import java.util.HashMap;
import javax.ejb.Stateful;
/**
 *
 * @author 46378
 */
@Stateful
public class BookBean implements BookBeanLocal {
    book[] books = new book[100];
    public BookBean() {
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void AddNewBook(String ISBN,String Title, String Auther,String Press,double Price) {
        book the_book = new book(ISBN,Title,Auther,Press,Price);
        for(int i = 0 ; i<100 ; i++){
            if(this.books[i] == null){
                this.books[i] = the_book;
                break;
            }
            if(this.books[i].getISBN().equals(ISBN)){
                this.books[i].setNumber(this.books[i].getNumber()+1);
            }
        }
    }

    @Override
    public void SetBookNumber(String ISBN, int Number) {
        for(int i = 0 ; i<100 ; i++){
            if(this.books[i].getISBN().equals(ISBN)){
                this.books[i].setNumber(Number);
            }
        }
    }

    @Override
    public void DeleteBook(String ISBN) {
        for(int i = 0 ; i<100 ; i++){
            if(this.books[i].getISBN().equals(ISBN)){
                this.books[i] = null;
            }
        }
    
    }

    @Override
    public book[] GetAllBooks() {
        return this.books;
    }

   
    

}
