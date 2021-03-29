/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Book;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import javax.ejb.Local;

/**
 *
 * @author 46378
 */
@Local
public interface BookFacadeLocal {

    void create(Book book);

    void edit(Book book);

    void remove(Book book);

    Book find(Object id);

    List<Book> findAll();

    List<Book> findRange(int[] range);

    int count();
    
    public List<Book> likefind(Object input);

    Book FindByIsbn(Object Isbn);
    
    
}
