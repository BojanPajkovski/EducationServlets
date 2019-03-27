package servlets;

import Dao.StudentDAOIMPL;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Faculty;
import model.Student;

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
public class StudentServlet extends HttpServlet {


    private StudentDAOIMPL studentDAOIMPL = new StudentDAOIMPL();

    private static String LIST_USER = "resources/student/Students.jsp";
    private static String INSERT_OR_EDIT = "resources/student/Student.jsp";
    private static String SUCCESS = "error-pages/success.jsp";
    private static String NEVER_EMPTY = "error-pages/NeverEmpty.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String action = request.getParameter("action");


        String forward = "";
        if (action.equalsIgnoreCase("delete")) {
            int studentId = Integer.parseInt(request.getParameter("id"));
            studentDAOIMPL.delete(studentId);
            forward = LIST_USER;
            request.setAttribute("listStudent", studentDAOIMPL.getAll());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int studentId = Integer.parseInt(request.getParameter("id"));
            Student student = studentDAOIMPL.getById(studentId);
            request.setAttribute("student", student);

        }
        else if (action.equalsIgnoreCase("add")){
            forward = INSERT_OR_EDIT;
        }
        else if (action.equalsIgnoreCase("listStudent")) {
            forward = LIST_USER;
            request.setAttribute("listStudent", studentDAOIMPL.getAll());
        }

        else if (action.equalsIgnoreCase("listStudentByAge")) {
            forward = LIST_USER;
            request.setAttribute("listStudent", studentDAOIMPL.getStudentsByAge());
        }

        else if (action.equalsIgnoreCase("search")){
            forward = LIST_USER;
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");

            if((request.getParameter("name")== null||request.getParameter("name")== "") ||

                    (request.getParameter("surname")== null||request.getParameter("surname")== "")) {

                System.out.println("Morate da gi popolnite  polinjata name and surname da izvrshite akcija search");

                return;

            }

            List<Student> students = studentDAOIMPL.searchByNameAndSurname(name,surname );
            request.setAttribute("listStudent", students);

        }


        else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        List<Student> students = new ArrayList<>();
        String json = "";
        if(br != null){
            json = br.readLine();
        }

        // 2. initiate jackson mapper
        ObjectMapper mapper = new ObjectMapper();

        // 3. Convert received JSON to Faculty
        Student student = mapper.readValue(json, Student.class);

        // 4. Set response type to JSON
        response.setContentType("application/json");


        //TODO insert or edit and implement field validation
        // 5. Add article to List<Article>
        students.add(student);
        studentDAOIMPL.insert(student);

        // 6. Send List<Faculty> as JSON to client
        mapper.writeValue(response.getOutputStream(), students);










        /*String forward = "";

        StudentDAOIMPL studentDAOIMPL1 = new StudentDAOIMPL();

        if ((request.getParameter("name") == null || request.getParameter("name") == "") ||

                (request.getParameter("surName") == null || request.getParameter("surName") == "")||

                (request.getParameter("age") == null || request.getParameter("age") == "") ) {

            System.out.println("Morate da gi popolnite site polinja da izvrshite update ili insert");

            forward = NEVER_EMPTY;

            request.setAttribute("message", "The fields should not be empty");
            request.getRequestDispatcher(forward).forward(request,response);
        }

        String studentName = request.getParameter("name");
        String studentSurname = request.getParameter("surName");
        int studentAge = Integer.parseInt(request.getParameter("age"));

        Student student = new Student(studentName, studentSurname, studentAge);

        if (request.getParameter("id") != null && request.getParameter("id") != "") {

            Long studentId = Long.parseLong(request.getParameter("id"));
            student.setId(Long.parseLong(request.getParameter("id")));
            studentDAOIMPL1.update(student);
            forward = SUCCESS;
            request.setAttribute("message", "Successfully updated student");
            request.getRequestDispatcher(forward).forward(request, response);
        } else {
            studentDAOIMPL1.insert(student);
            forward = SUCCESS;
            request.setAttribute("message", "Successfully inserted student");
            request.getRequestDispatcher(forward).forward(request, response);
        }
*/

    }
}

