/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.util.HashMap;
import javax.ejb.Local;

/**
 *
 * @author 46378
 */
@Local
public interface BookBeanLocal {
 
    void AddNewBook(String ISBN,String Title, String Auther,String Press,double Price);

    void SetBookNumber(String ISBN, int Number);

    void DeleteBook(String ISBN);

    book[] GetAllBooks();

    
}
