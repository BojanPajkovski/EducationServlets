package servlets;

import Dao.FacultyDAOIMPL;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Faculty;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 10.02.2019.
 */
public class FacultyServlet extends  HttpServlet {

    private FacultyDAOIMPL facultyDAOIMPL = new FacultyDAOIMPL();

    private static String LIST_USER  = "resources/faculty/faculties.jsp";
    private static String INSERT_OR_EDIT = "resources/faculty/Faculty.jsp";
    private static String SUCCESS = "error-pages/success.jsp";

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String action = request.getParameter("action");;

            String forward = "";
            if (action.equalsIgnoreCase("delete")){
                int facultyId = Integer.parseInt(request.getParameter("id"));
                facultyDAOIMPL.delete(facultyId);
                forward = LIST_USER;
                request.setAttribute("listFaculty", facultyDAOIMPL.getAll());
            }else if (action.equalsIgnoreCase("add")){
                forward = INSERT_OR_EDIT;
            }
            else if (action.equalsIgnoreCase("edit")){
                forward = INSERT_OR_EDIT;
                int facultyId = Integer.parseInt(request.getParameter("id"));
                Faculty faculty = facultyDAOIMPL.getById(facultyId);
                request.setAttribute("faculty", faculty);

            } else if (action.equalsIgnoreCase("listFaculty")){
                forward = LIST_USER;
                request.setAttribute("listFaculty", facultyDAOIMPL.getAll());

            } else if (action.equalsIgnoreCase("search")){
                forward = LIST_USER;
                String name = request.getParameter("name");
                String desc = request.getParameter("desc");

                if((request.getParameter("name")== null||request.getParameter("name")== "") ||

                        (request.getParameter("description")== null||request.getParameter("description")== "")) {

                            System.out.println("Morate da gi popolnite site polinja da izvrshite update ili insert");

                                return;

                }

                List<Faculty> faculties = facultyDAOIMPL.getSearchedFaculties(name, desc);
                request.setAttribute("listFaculty", faculties);

            }
            else {
                forward = INSERT_OR_EDIT;
            }

            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }





    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        List<Faculty> faculties = new ArrayList<>();
        String json = "";
        if(br != null){
            json = br.readLine();
        }

        // 2. initiate jackson mapper
        ObjectMapper mapper = new ObjectMapper();

        // 3. Convert received JSON to Faculty
        Faculty faculty = mapper.readValue(json, Faculty.class);

        // 4. Set response type to JSON
        response.setContentType("application/json");

        if(faculty.getId()==null){


            facultyDAOIMPL.insert(faculty);
        }

        else{

            facultyDAOIMPL.update(faculty);
        }
        //TODO insert or edit and implement field validation
        // 5. Add article to List<Article>
        faculties.add(faculty);

        // 6. Send List<Faculty> as JSON to client
        mapper.writeValue(response.getOutputStream(), faculties);

        /*String forward = "";

        FacultyDAOIMPL facultyDAOIMPL = new FacultyDAOIMPL();

        String facultyName = request.getParameter("name");
        String facultyDescription = request.getParameter("description");
        Boolean faculttyTechnical =Boolean.parseBoolean(request.getParameter("tecnical"));

        if((request.getParameter("name")== null||request.getParameter("name")== "") ||

            (request.getParameter("description")== null||request.getParameter("description")== "")) {

            System.out.println("Morate da gi popolnite site polinja da izvrshite update ili insert");

           return;


        }

        Faculty faculty = new Faculty(facultyName,facultyDescription,faculttyTechnical);

        if(request.getParameter("id")!= null && request.getParameter("id") !=""  ){

            Long facultiId =Long.parseLong(request.getParameter("id")) ;
            faculty.setId(Long.parseLong(request.getParameter("id")));
            facultyDAOIMPL.update(faculty);
            forward = SUCCESS;
            request.setAttribute("message", "Successfully updated faculty");
            String url = "/faculty?action=listFaculty";
            request.setAttribute("url", url);
            request.getRequestDispatcher(forward).forward(request,response);
        } else {
            facultyDAOIMPL.insert(faculty);
            forward = SUCCESS;
            request.setAttribute("message", "Successfully inserted faculty");
            String url = "/faculty?action=listFaculty";
            request.setAttribute("url", url);
            request.getRequestDispatcher(forward).forward(request,response);

        }*/

}

}
