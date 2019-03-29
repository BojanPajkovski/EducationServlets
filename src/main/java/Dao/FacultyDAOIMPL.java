package Dao;



import connection.DbConection_Singleton_Pattern;
import model.Faculty;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 29.08.2018.
 */
public class FacultyDAOIMPL {

    public void delete(long id) {

        Connection conn = DbConection_Singleton_Pattern.getConnection();
        Statement stmt;

        try {
            stmt = conn.createStatement();
            String sqlQuery = "DELETE from faculty  where faculty.id = ";
            sqlQuery += id;
            stmt.execute(sqlQuery);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }

    }

    public void insert(Faculty faculty) {

        Connection conn = DbConection_Singleton_Pattern.getConnection();
        PreparedStatement stmt;

        try {
            String sqlQuery = "INSERT INTO faculty (name , location, description, tecnical) VALUES(?,?,?, ?);";

            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, faculty.getName());
            stmt.setString(2, faculty.getLocation());
            stmt.setString(3, faculty.getDescription());
            stmt.setBoolean(4, faculty.isTecnical());
            stmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }

    }

    public void update(Faculty faculty) {

        Connection conn = DbConection_Singleton_Pattern.getConnection();
        PreparedStatement stmt;

        try {

            String sqlQuery = "UPDATE faculty SET  name = ?,location =?, description = ?,universityId = ?, tecnical =? WHERE id = ? ";
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, faculty.getName());
            stmt.setString(2, faculty.getLocation());
            stmt.setString(3, faculty.getDescription());
            stmt.setInt(4, faculty.getUniversityId());
            stmt.setBoolean(5, faculty.isTecnical());
            stmt.setLong(6, faculty.getId());

            stmt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }

    public Faculty getById(long id) {

        Connection conn = DbConection_Singleton_Pattern.getConnection();
        Statement stmt;
        ResultSet rst;
        Faculty faks = null;

        try {
            stmt = conn.createStatement();
            String sqlQuery = "SELECt * from faculty as f where f.id = ";
            sqlQuery += id;
            rst = stmt.executeQuery(sqlQuery);

            while (rst.next()) {
                Long facultyId = rst.getLong("id");
                String facultyDesc = rst.getString("description");
                String facultyName = rst.getString("name");
                 faks = new Faculty(facultyId, facultyName, facultyDesc);
                return faks;

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return faks;
    }

    public List<Faculty> getAll() {

        Connection conn = DbConection_Singleton_Pattern.getConnection();
        Statement stmt ;
        ResultSet rst;

        List<Faculty> faculties = null;
        try {
            stmt = conn.createStatement();
            String sqlQuery = "SELECt * from faculty";

            rst = stmt.executeQuery(sqlQuery);
            faculties = new ArrayList<Faculty>();
            while (rst.next()) {
                Long facultyId = rst.getLong("id");
                String facultyDesc = rst.getString("description");
                String facultyName = rst.getString("name");
                String facultyLocation = rst.getString("location");
                Boolean tecnical = rst.getBoolean("tecnical");
                Faculty faks = new Faculty(facultyId, facultyName, facultyDesc, facultyLocation, tecnical);
                faculties.add(faks);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return faculties;

    }


    public List<Faculty> getSearchedFaculties(String name, String description) {

        Connection conn = DbConection_Singleton_Pattern.getConnection();
        Statement stmt;
        ResultSet rst;

        List<Faculty> faculties = null;
        try {
            stmt = conn.createStatement();
            String sqlQuery = "SELECt * from faculty as f where f.name = ";
            sqlQuery+= "'"+ name+"'";
            sqlQuery += " and f.description = ";
            sqlQuery+= "'"+ description+"'";
            rst = stmt.executeQuery(sqlQuery);

            faculties = new ArrayList<>();
            while (rst.next()) {
                Long facultyId = rst.getLong("id");
                String facultyDesc = rst.getString("description");
                String facultyName = rst.getString("name");
                Faculty faks = new Faculty(facultyId, facultyDesc, facultyName);
                faculties.add(faks);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return faculties;

    }




    public Faculty getTechnicalFaculty(boolean tecnical){

        Connection conn = DbConection_Singleton_Pattern.getConnection();
        Statement stmt;
        ResultSet rst;
        Faculty faks = null;

        try {
            stmt = conn.createStatement();
            String sqlQuery = "SELECT name as faculyName from faculty  where tecnical = ";
            sqlQuery += tecnical;
            rst = stmt.executeQuery(sqlQuery);

            while (rst.next()) {
               boolean facultyTecnical = rst.getBoolean("tecnical");
                faks = new Faculty(facultyTecnical);

                return faks;

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return faks;

    }

    public List<Faculty> getFacultyCenter(String queryTerm){

        Connection conn = DbConection_Singleton_Pattern.getConnection();

        Statement stmt;
        ResultSet rst;

        List <Faculty> faculties = null;

        try{
            stmt = conn.createStatement();
            String sqlQuery = "SELECT name as facultyName,description,location from faculty where description or location like '%";
            sqlQuery+=queryTerm;
            sqlQuery+="'";
            rst = stmt.executeQuery(sqlQuery);

            while(rst.next()){
                String facultyName = rst.getString("facultyName");
                String facultyDescription = rst.getString("description");
                String facultyLocation = rst.getString("location");

                Faculty faks = new Faculty(facultyName,facultyDescription,facultyLocation);
                faculties = new ArrayList<Faculty>();
                faculties.add(faks);
            }
        }
        catch(Exception e){
                e.printStackTrace();
        } finally {
            try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return faculties;
    }

    public List <Faculty> getFacultiesPerUniversity(int id) throws SQLException {

        Connection conn = DbConection_Singleton_Pattern.getConnection();
        Statement stmt;
        ResultSet rst;
        List<Faculty> faculties = null;

        try {
            stmt = conn.createStatement();
            String sqlQuery = "SELECT * FROM education.faculty where universityID =  ";
            sqlQuery = sqlQuery+id;
            rst = stmt.executeQuery(sqlQuery);
            faculties = new ArrayList<Faculty>();
            while (rst.next()) {
                Long facultyId = rst.getLong("id");
                String facultyName = rst.getString("name");
                String facultyDesc = rst.getString("description");
                Faculty faks = new Faculty(facultyId,facultyName,facultyDesc);
                faculties.add(faks);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return faculties;
    }

}
