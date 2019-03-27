package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 10.02.2019.
 */
public class Ajax extends HttpServlet {
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("From Get method");

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("From post method");
        try {
            throw new Exception("Test Exception");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
