/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import domain.persona;
import java.sql.PreparedStatement;
import java.util.List;
import static datos.Conexion.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author jonns
 */
public class personaDAO {

   
    private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido, email, telefono) VALUES (?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id_persona = ? ";
    private static final String SQL_SELECT = "SELECT * FROM persona";

    public List<persona> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet res = null;

        persona persona = null;
        List<persona> personas = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            prep = conn.prepareStatement(SQL_SELECT);
            res = prep.executeQuery();

            while (res.next()) {
                int idPersona = res.getInt("id_persona");
                String nombre = res.getString("nombre");
                String apellido = res.getString("apellido");
                String email = res.getString("email");
                String telefono = res.getString("telefono");

                persona = new persona(idPersona ,nombre, apellido, email, telefono);

                personas.add(persona);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                close(res);
                close(prep);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            Conexion.close(conn);
        }

        return personas;
    }

    public int insertar(persona persona) {
        Connection conn = null;
        PreparedStatement prep = null;
        int registros = 0;

        try {
            conn = getConnection();
            prep = conn.prepareStatement(SQL_INSERT);
            prep.setString(1, persona.getNombre());
            prep.setString(2, persona.getApellido());
            prep.setString(3, persona.getEmail());
            prep.setString(4, persona.getTelefono());

            registros = prep.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                try {
                    close(prep);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return registros;
    }
    
    
    
     public int Actializar(persona persona) {
        Connection conn = null;
        PreparedStatement prep = null;
        int registros = 0;

        try {
            conn = getConnection();
            prep = conn.prepareStatement(SQL_UPDATE);
            prep.setString(1, persona.getNombre());
            prep.setString(2, persona.getApellido());
            prep.setString(3, persona.getEmail());
            prep.setString(4, persona.getTelefono());
            prep.setInt(5, persona.getIdPersona());

            registros = prep.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                try {
                    close(prep);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return registros;
    }
     
     
      public int Borrar(persona persona) {
        Connection conn = null;
        PreparedStatement prep = null;
        int registros = 0;

        try {
            conn = getConnection();
            prep = conn.prepareStatement(SQL_DELETE);
          
            prep.setInt(1, persona.getIdPersona());

            registros = prep.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                try {
                    close(prep);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return registros;
    }
    
    

}
