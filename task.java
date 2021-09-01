package sqlite3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class task {
	 public static void createNewTable() {
	        // SQLite connection string
	        String url = "jdbc:sqlite:C://sqlite/db/tests.db";
	        
	        // SQL statement for creating a new table
	        String sql = "CREATE TABLE movies (\n"
	                + "	id integer PRIMARY KEY,\n"
	                + "	name text NOT NULL,\n"
	                + "	actor text real\n"
	                + "	actress text real\n"
	                + "	director text real\n"
	                +"year_of_release integer,\n"
	                + ");";
	        
	        try (Connection conn = DriverManager.getConnection(url);
	                Statement stmt = conn.createStatement()) {
	            // create a new table
	            stmt.execute(sql);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	 public static void selectAll(){
	        String sql = "SELECT id, name,actor,actress,director,year_of_release FROM movies";
	        String url = "jdbc:sqlite:C://sqlite/db/tests.db";
	        try (Connection conn = DriverManager.getConnection(url);
	             Statement stmt  = conn.createStatement();
	             ResultSet rs    = stmt.executeQuery(sql)){
	            
	            // loop through the result set
	            while (rs.next()) {
	                System.out.println(rs.getInt("id") +  "\t" + 
	                                   rs.getString("name") + "\t" +
	                                   rs.getString("actor") + "\t" +
	                                   rs.getString("actress") + "\t" +
	                                   rs.getString("director") + "\t" +
	                                   rs.getInt("year_of_release"));
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	 public static void movie_actor(){
	        String sql = "SELECT name,actor FROM movies";
	        String url = "jdbc:sqlite:C://sqlite/db/tests.db";
	        try (Connection conn = DriverManager.getConnection(url);
	             Statement stmt  = conn.createStatement();
	             ResultSet rs    = stmt.executeQuery(sql)){
	            
	            // loop through the result set
	            while (rs.next()) {
	                System.out.println(
	                                   rs.getString("name") + "\t" +
	                                   rs.getString("actor") + "\t" );
	                                   
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	   
	    public static void main(String[] args) {
	        createNewTable();
	        selectAll();
	        movie_actor();
	    }

	}