package servlets;

import Dao.SubjectDAOIMPL;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Faculty;
import model.Subject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 11.02.2019.
 */
public class SubjectServlet extends HttpServlet {

    private SubjectDAOIMPL subjectDAOIMPL = new SubjectDAOIMPL();

    private static String LIST_SUBJECTS  = "resources/subject/AllSubjects.jsp";
    private static String INSERT_OR_EDIT = "resources/subject/Subject.jsp";
    private static String SUCCESS = "error-pages/success.jsp";
    private static String NEVER_EMPTY = "error-pages/NeverEmpty.jsp";


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        String forward = "";
        if(action.equalsIgnoreCase("delete")){
            int subjectId = Integer.parseInt(request.getParameter("id"));
            subjectDAOIMPL.delete(subjectId);
            forward = LIST_SUBJECTS;
            request.setAttribute("listAllSubjects", subjectDAOIMPL.getAll());
        } else if(action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int subjectId = Integer.parseInt(request.getParameter("id"));
            Subject subject = subjectDAOIMPL.getById(subjectId);
            request.setAttribute("subject", subject); // KAKO go predavame subject ??
        } else if (action.equalsIgnoreCase("listSubject")){
            forward = LIST_SUBJECTS;
            request.setAttribute("listAllSubjects", subjectDAOIMPL.getAll());
        } else if (action.equalsIgnoreCase("listSubjectByCredits")){
            forward = LIST_SUBJECTS;
            request.setAttribute("listAllSubjects", subjectDAOIMPL.getSubjectsByCredits());
        } else if (action.equalsIgnoreCase("add")){
            forward = INSERT_OR_EDIT;
        } else if (action.equalsIgnoreCase("search")){
            forward = LIST_SUBJECTS;
            String name = request.getParameter("name");
            int credits = Integer.parseInt(request.getParameter("credits"));

            if((request.getParameter("name")== null||request.getParameter("name")== "") ||

                    (request.getParameter("credits")== null||request.getParameter("credits")== "")) {

                System.out.println("Morate da gi popolnite  polinjata name and credits da izvrshite akcija search");
                 forward = NEVER_EMPTY;
                request.setAttribute("message", "Invalid params");

            }
            List<Subject> subjects = subjectDAOIMPL.searchByNameAndCredits(name,credits );
            request.setAttribute("listAllSubjects", subjects);

        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        List<Subject> subjects = new ArrayList<>();
        String json = "";
        if(br != null){
            json = br.readLine();
        }

        // 2. initiate jackson mapper
        ObjectMapper mapper = new ObjectMapper();

        // 3. Convert received JSON to Faculty
        Subject subject = mapper.readValue(json, Subject.class);

        // 4. Set response type to JSON
        response.setContentType("application/json");

        if(subject.getId()==null){


            subjectDAOIMPL.insert(subject);
        }

        else{

            subjectDAOIMPL.update(subject);
        }
        //TODO insert or edit and implement field validation
        // 5. Add article to List<Article>
        subjects.add(subject);

        // 6. Send List<Faculty> as JSON to client
        mapper.writeValue(response.getOutputStream(), subjects);
    }
}

