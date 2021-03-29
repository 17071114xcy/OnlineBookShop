/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Book;
import java.util.ArrayList;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author 46378
 */
@Stateless
public class BookFacade extends AbstractFacade<Book> implements BookFacadeLocal {
    @PersistenceContext(unitName = "FinalTest-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BookFacade() {
        super(Book.class);
    }

    public List<Book> likefind(Object input){
        return getEntityManager().createNamedQuery("Book.likefind").setParameter("a",input).getResultList();
    }

    @Override
    public Book FindByIsbn(Object Isbn) {
        return (Book) getEntityManager().createNamedQuery("Book.findByIsbn").setParameter("isbn",Isbn).getSingleResult();
    }

    
}
