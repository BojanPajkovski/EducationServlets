package Dao;

import connection.DbConection_Singleton_Pattern;
import model.University;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 08.11.2018.
 */
public class UniversityDAOIMPL {

    public void delete(int id) {

        Connection conn = DbConection_Singleton_Pattern.getConnection();
        Statement stmt;

        try {
            stmt = conn.createStatement();
            String sqlQuery = "DELETE from university  where university.id = ";
            sqlQuery += id;
            stmt.execute(sqlQuery);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }

    public void insert(University university) {

        Connection conn = DbConection_Singleton_Pattern.getConnection();
        PreparedStatement stmt;

        try {
            String sqlQuery = "INSERT INTO university (name , description,location) VALUES(?,?,?);";
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, university.getName());
            stmt.setString(2, university.getDescription());
            stmt.setString(3, university.getLocation());
            stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }

    }

    public void update(University university) {

        Connection conn = DbConection_Singleton_Pattern.getConnection();
        PreparedStatement stmt;
        try {
            String sqlQuery = "UPDATE university SET  name = ?,description = ?,location =? WHERE id = ? ";
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, university.getName());
            stmt.setString(2, university.getDescription());
            stmt.setString(3, university.getLocation());
            stmt.setInt(4, university.getId());
            stmt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }

    public University getById(int id) {

        Connection conn = DbConection_Singleton_Pattern.getConnection();
        Statement stmt;
        ResultSet rst;
        University university = null;
        try {
            stmt = conn.createStatement();
            String sqlQuery = "SELECt * from university as u where u.id = ";
            sqlQuery += id;
            rst = stmt.executeQuery(sqlQuery);
            while (rst.next()) {
                int universityID = rst.getInt("id");
                String universityName = rst.getString("name");
                String universityDesc = rst.getString("description");
                String universityLocation = rst.getString("location");
                university = new University(universityID,universityName, universityDesc, universityLocation);
                return university;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return university;
    }

    public List<University> getAll() {

        Connection conn = null;
        Statement stmt;
        ResultSet rst;

        List<University> universities = null;
        try {

            conn = DbConection_Singleton_Pattern.getConnection();
            stmt = conn.createStatement();
            String sqlQuery = "SELECt * from university";
            rst = stmt.executeQuery(sqlQuery);
            universities = new ArrayList<University>();
            while (rst.next()) {

                int universityID = rst.getInt("id");
                String universityDesc = rst.getString("description");
                String universityName = rst.getString("name");
                String universityLocation = rst.getString("location");
                University university = new University(universityID,universityName, universityDesc, universityLocation);
                universities.add(university);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return universities;
    }

}
