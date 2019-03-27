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
        Statement stmt = null;
        ResultSet rst = null;



        try{


            stmt = conn.createStatement();
            String sqlQuery = "DELETE from subject  where subject.id = ";
            sqlQuery +=id;
            stmt.execute(sqlQuery);

        }
        catch(Exception ex){
            ex.printStackTrace();
        }


    }

    public void insert (Subject subject) {

        Connection conn = DbConection_Singleton_Pattern.getConnection();
        PreparedStatement stmt = null;
        ResultSet rst = null;



        try {

            String sqlQuery = "INSERT INTO subject (name , credits, semestar) VALUES(?,?,?);";


            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, subject.getName());
            stmt.setInt(2, subject.getCredits());
            stmt.setString(3, subject.getSemestar());

            stmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();


        }
    }

    public void update(Subject subject){

        Connection conn = DbConection_Singleton_Pattern.getConnection();
        PreparedStatement stmt = null;
        ResultSet rst = null;


        try{


            String sqlQuery = "UPDATE subject SET  name = ?,credits =?, semestar = ? WHERE id = ? ";

            //UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";

            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, subject.getName());
            stmt.setInt(2, subject.getCredits());
            stmt.setString(3, subject.getSemestar());
            stmt.setLong(4,subject.getId());

            // TREBA DA SE STAI I ID ??

            stmt.execute();

        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }

    public Subject  getById (long id)  {


        Connection conn = DbConection_Singleton_Pattern.getConnection();
        Statement stmt = null;
        ResultSet rst = null;


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


                Subject subject = new Subject(subjectId,subjectName,subjectCredits,subjectSemestar);

                System.out.println(subject.getName());

                return subject;



            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public List<Subject> getAll(){

        Connection conn = DbConection_Singleton_Pattern.getConnection();
        Statement stmt = null;
        ResultSet rst = null;

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
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return subjects;

    }

    public List<Subject> getSubjectsByCredits(){

        Connection conn = DbConection_Singleton_Pattern.getConnection();
        Statement stmt = null;
        ResultSet rst = null;

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
        }

        return subjects;
    }

    public List<Subject> searchByNameAndCredits(String name, int credits){

        Connection conn = DbConection_Singleton_Pattern.getConnection();
        Statement stmt = null;
        ResultSet rst = null;

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
        }

        return subjects;
    }


}
