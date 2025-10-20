/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.*;

public class Conexion {
    
    private static final String url = "jdbc:postgresql://localhost:5432/CRUD";
    private static final String user = "postgres";
    private static final String password = "2007";
    
    public static Connection getConnection() throws SQLException {
       return DriverManager.getConnection(url, user, password);
    }
    
    public static void close (ResultSet res) throws SQLException{
        res.close();
    }
    
    public static void close(Statement stm) throws SQLException{
        stm.close();
    }
    
    public static void close(PreparedStatement prep) throws SQLException{
        prep.close();
    }
    
    public static void close (Connection conn) throws SQLException{
        conn.close();
    }
    
    
    
}
