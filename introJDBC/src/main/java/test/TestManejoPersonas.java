package test;

import datos.personaDAO;
import domain.persona;
import java.sql.SQLException;
import java.util.List;

public class TestManejoPersonas {
    public static void main(String[] args) throws SQLException {
        personaDAO dao = new personaDAO();

       
        
        
        //insertando un nuevo objeto
        
        persona personaNuneva = new persona("donpollo","galinodo", "danionicha@gmail.com","2313928389");
        dao.insertar(personaNuneva);
        
        
 
        //modificar un registro
        
        persona personaMOD = new persona(3, "galigaliano","dosnueve", "danionicha@gamil.com","909698698");
        dao.Actializar(personaMOD);
        
        //borrar registro
        persona personaEl = new persona(4);
        dao.Borrar(personaEl);
        
        
        //lista de personas
            List<persona> personas = dao.seleccionar();

        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
        
    }
}
