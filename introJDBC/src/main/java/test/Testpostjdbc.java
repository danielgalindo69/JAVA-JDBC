package test;

import java.sql.*;

public class Testpostjdbc {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/CRUD";
        String user = "postgres";
        String password = "2007";
        
        try {
            Connection conexion = DriverManager.getConnection(url, user, password);
            Statement instruccion = conexion.createStatement();
            var sql = "SELECT * FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
             
            while (resultado.next()) {
                System.out.print("id persona: " + resultado.getInt("id_persona"));
                System.out.print(" nombre"+ resultado.getString("nombre"));
                System.out.print("apellido" + resultado.getString("apellido"));
            }
            
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
