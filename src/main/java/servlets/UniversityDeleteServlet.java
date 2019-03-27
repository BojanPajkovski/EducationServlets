package servlets;

import Dao.UniversityDAOIMPL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 15.02.2019.
 */
public class UniversityDeleteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UniversityDAOIMPL universityDAOIMPL = new UniversityDAOIMPL();
        int id = Integer.parseInt(request.getParameter("id"));
        universityDAOIMPL.delete(id);
        System.out.println("From University delete servlet");

    }
}
