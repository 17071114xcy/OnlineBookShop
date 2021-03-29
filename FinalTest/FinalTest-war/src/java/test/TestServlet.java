/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import bean.BookBeanLocal;
import bean.book;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.String;
import static java.lang.String.valueOf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.BookFacadeLocal;
/**
 *
 * @author 46378
 */
public class TestServlet extends HttpServlet {
    BookBeanLocal bookBean;
    @EJB
    private BookFacadeLocal bookFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //request.setCharacterEncoding("UTF-8");
            /* TODO output your page here. You may use following sample code. */
            String source = request.getParameter("Source");
            String submit = request.getParameter("Submit");
            String SUBMIT = new String(submit.getBytes("iso8859-1"), "UTF-8");
            int i = 0;
            
            if(source.equals("Welcome")){
                String order_book = request.getParameter("order_book");
                String Order_Book = new String(order_book.getBytes("iso8859-1"), "UTF-8");
                java.util.List<entity.Book> Found_books = this.bookFacade.likefind(Order_Book);
                if(Found_books.size()==0){
                    request.getRequestDispatcher("Wrong.jsp").forward(request, response);
                }
                request.setAttribute("result", Found_books);
                request.getRequestDispatcher("Directory.jsp").forward(request, response);
            }
            
            if(SUBMIT.equals("返回首页")){
                request.getRequestDispatcher("Welcome.jsp").forward(request, response);
            }
            
            if(source.equals("Directory")&&SUBMIT.equals("加入购物车")){
                if(request.getSession().getAttribute(request.getRemoteAddr())==null){
                    bookBean = lookupBookBeanLocal();
                    request.getSession().setAttribute(request.getRemoteAddr(),this.bookBean);
                }
                else{
                    bookBean = (BookBeanLocal)request.getSession().getAttribute(request.getRemoteAddr());
                }
                String[] list = request.getParameterValues("choose");
                if(list == null){
                    request.setAttribute("books", "aaa");
                    request.getRequestDispatcher("Wrong2.jsp").forward(request, response);
                }
                for (i=0;i<list.length;i++) {
                    entity.Book the_book_info = this.bookFacade.FindByIsbn(list[i]);
                    bookBean.AddNewBook(the_book_info.getIsbn(),the_book_info.getTitle(),the_book_info.getAuther(),the_book_info.getPress(),
                            the_book_info.getPrice());
                }
                request.setAttribute("books", bookBean.GetAllBooks());
                request.getRequestDispatcher("Cart.jsp").forward(request, response);       
            }

            if(source.equals("Cart")&&SUBMIT.equals("刷新")){   
                if(request.getSession().getAttribute(request.getRemoteAddr())==null){
                        bookBean = lookupBookBeanLocal();
                        request.getSession().setAttribute(request.getRemoteAddr(),this.bookBean);
                }
                else{
                        bookBean = (BookBeanLocal)request.getSession().getAttribute(request.getRemoteAddr());
                }
                book[] books = bookBean.GetAllBooks();
                for(i = 0 ; i < 100 ; i++){
                    if(books[i] != null)
                        books[i].setNumber(Integer.parseInt(request.getParameter(String.valueOf(i))));
                }
                request.setAttribute("books", bookBean.GetAllBooks());
                request.getRequestDispatcher("Cart.jsp").forward(request, response);
            }        
            
            if(source.equals("Cart")&&SUBMIT.equals("结算")){
                if(request.getSession().getAttribute(request.getRemoteAddr())==null){
                        bookBean = lookupBookBeanLocal();
                        request.getSession().setAttribute(request.getRemoteAddr(),this.bookBean);
                }
                else{
                        bookBean = (BookBeanLocal)request.getSession().getAttribute(request.getRemoteAddr());
                }
                book[] books = bookBean.GetAllBooks();
                for(i = 0 ; i < 100 ; i++){
                    if(books[i] != null)
                        books[i].setNumber(Integer.parseInt(request.getParameter(String.valueOf(i))));
                }
                request.setAttribute("books", bookBean.GetAllBooks());
                request.getRequestDispatcher("Order.jsp").forward(request, response);
            
            }
            
            
            
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private BookBeanLocal lookupBookBeanLocal() {
        try {
            Context c = new InitialContext();
            return (BookBeanLocal) c.lookup("java:global/FinalTest/FinalTest-ejb/BookBean!bean.BookBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    
}