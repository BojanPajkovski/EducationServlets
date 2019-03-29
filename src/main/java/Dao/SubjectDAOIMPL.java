package Dao;

import connection.DbConection_Singleton_Pattern;
import model.Student;
import model.Subject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 13.02.2019.
 */
public class SubjectDAOIMPL {

    public void delete(long id){

        Connection conn = DbConection_Singleton_Pattern.getConnection();
        Statement stmt;
        try{
            stmt = conn.createStatement();
            String sqlQuery = "DELETE from subject  where subject.id = ";
            sqlQuery +=id;
            stmt.execute(sqlQuery);
        }
        catch(Exception ex){
            ex.printStackTrace();
        } finally {
            try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }

    }

    public void insert (Subject subject) {

        Connection conn = DbConection_Singleton_Pattern.getConnection();
        PreparedStatement stmt;

        try {

            String sqlQuery = "INSERT INTO subject (name , credits, semestar) VALUES(?,?,?);";
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, subject.getName());
            stmt.setInt(2, subject.getCredits());
            stmt.setString(3, subject.getSemestar());
            stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }

    public void update(Subject subject){

        Connection conn = DbConection_Singleton_Pattern.getConnection();
        PreparedStatement stmt;

        try{
            String sqlQuery = "UPDATE subject SET  name = ?,credits =?, semestar = ? WHERE id = ? ";
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, subject.getName());
            stmt.setInt(2, subject.getCredits());
            stmt.setString(3, subject.getSemestar());
            stmt.setLong(4,subject.getId());
            stmt.execute();
        } catch(Exception ex){
            ex.printStackTrace();
        } finally {
            try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }

    }

    public Subject  getById (long id)  {

        Connection conn = DbConection_Singleton_Pattern.getConnection();
        Statement stmt ;
        ResultSet rst;
        Subject subject = null;

        try{
            stmt = conn.createStatement();
            String sqlQuery = "SELECt * from subject as s where s.id = ";
            sqlQuery +=id;
            rst = stmt.executeQuery(sqlQuery);

            while(rst.next()){

                Long subjectId = rst.getLong("id");
                String subjectName = rst.getString("name");
                int subjectCredits = rst.getInt("credits");
                String subjectSemestar = rst.getString("semestar");
                subject = new Subject(subjectId,subjectName,subjectCredits,subjectSemestar);
                return subject;

            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        } finally {
            try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return subject;
    }

    public List<Subject> getAll(){

        Connection conn = DbConection_Singleton_Pattern.getConnection();
        Statement stmt;
        ResultSet rst;

        List <Subject> subjects = null;
        try{
            stmt = conn.createStatement();
            String sqlQuery = "SELECt * from subject";
            rst = stmt.executeQuery(sqlQuery);
            subjects = new ArrayList<Subject>() ;
            while(rst.next()){

                Long subjectId = rst.getLong("id");
                String subjectName = rst.getString("name");
                int subjectCredits = rst.getInt("credits");
                String subjectSemestar = rst.getString("semestar");;
                Subject subject = new Subject(subjectId,subjectName,subjectCredits,subjectSemestar);
                subjects.add(subject);
            }
        } catch(Exception ex){
            ex.printStackTrace();
        } finally {
            try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return subjects;
    }

    public List<Subject> getSubjectsByCredits(){

        Connection conn = DbConection_Singleton_Pattern.getConnection();
        Statement stmt;
        ResultSet rst;

        List <Subject> subjects = null;

        try{
            stmt = conn.createStatement();
            String sqlQuery = "SELECT * FROM subject ORDER BY subject.credits DESC";
            rst = stmt.executeQuery(sqlQuery);
            subjects = new ArrayList<Subject>() ;
            while(rst.next()){
                Long subjectId = rst.getLong("id");
                String subjectName = rst.getString("name");
                int subjectCredits = rst.getInt("credits");
                String subjectSemestar = rst.getString("semestar");;
                Subject subject = new Subject(subjectId,subjectName,subjectCredits,subjectSemestar);
                subjects.add(subject);

            }
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return subjects;
    }

    public List<Subject> searchByNameAndCredits(String name, int credits){

        Connection conn = DbConection_Singleton_Pattern.getConnection();
        Statement stmt;
        ResultSet rst;

        List <Subject> subjects = null;

        try{
            stmt = conn.createStatement();
            String sqlQuery = "SELECT * FROM subject WHERE subject.name =";
            sqlQuery+="'"+name+"'";
            sqlQuery+=" AND subject.credits =";
            sqlQuery+="'"+credits+"'";
            rst = stmt.executeQuery(sqlQuery);
            subjects = new ArrayList<Subject>() ;
            while(rst.next()){

                Long subjectId = rst.getLong("id");
                String subjectName = rst.getString("name");
                int subjectCredits = rst.getInt("credits");
                String subjectSemestar = rst.getString("semestar");;
                Subject subject = new Subject(subjectId,subjectName,subjectCredits,subjectSemestar);
                subjects.add(subject);
            }

        }catch(Exception e){
            e.printStackTrace();
        } finally {
            try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }

        return subjects;
    }

}
