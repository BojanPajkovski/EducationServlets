package servlets;

import Dao.UniversityDAOIMPL;
import model.University;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 11.02.2019.
 */
public class UniversityServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("id")!= null && request.getParameter("id")!=""){

            UniversityDAOIMPL universityDAOIMPL = new UniversityDAOIMPL();
            University university;
            university = universityDAOIMPL.getById(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("id", university.getId());
            request.setAttribute("name", university.getName());
            request.setAttribute("description", university.getDescription());
            request.setAttribute("location", university.getLocation());
            request.getRequestDispatcher("/resources/university/University.jsp").forward(request,response);
        }

        else{
            request.getRequestDispatcher("/resources/university/University.jsp").forward(request,response);
        System.out.println("Nema id");

        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String desc = request.getParameter("description");
        String location = request.getParameter("location");

        University university = new University(name,desc,location);

        UniversityDAOIMPL universityDAOIMPL = new UniversityDAOIMPL();

        if(request.getParameter("id")!= null && request.getParameter("id")!=""){

            int id =  Integer.parseInt(request.getParameter("id"));
            university.setId(id);

            universityDAOIMPL.update(university);

        } else{
            universityDAOIMPL.insert(university);
        }
        request.getRequestDispatcher("/resources/university/University.jsp").forward(request,response);
    }

}
