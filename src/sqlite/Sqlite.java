/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author socamporomani
 */
public class Sqlite {

    /**
     * @param args the command line arguments
*/
     
    public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:almendra.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
     public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:almendra.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS DNI (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	capacity real\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args)  {
String num;
        num=JOptionPane.showInputDialog("numero");


        switch(num) {
  case "1":
connect();    break;
  case "2":
      connect();
   createNewTable();
    
  default:
      connect();
   createNewTable();
}        
        

    
    }

}
