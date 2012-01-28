/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package communicator.DB;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author flyhigh
 */
public class DBConnect {

    private static final String accessDBURLPrefix = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
    private static final String accessDBURLSuffix = ";DriverID=22;READONLY=false}";
    Connection con;
    Statement stmt;
    public DBConnect() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch(ClassNotFoundException e) {
            System.err.println("JdbcOdbc Bridge Driver not found!");
        }
        try {
            con = DBConnect.getAccessDBConnection("db.mdb");
            stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Connection getAccessDBConnection(String filename) throws SQLException {
        filename = filename.trim();
        String databaseURL = accessDBURLPrefix + filename + accessDBURLSuffix;
        return DriverManager.getConnection(databaseURL, "", "");
    }
    public void close(){
        try {
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

