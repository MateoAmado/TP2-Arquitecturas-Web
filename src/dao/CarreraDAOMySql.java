package dao;
import modelo.Carrera;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
public class CarreraDAOMySql implements CarreraDAO{

   private EntityManager em;
    public CarreraDAOMySql(EntityManager em){
        this.em = em;
    }

    public List<Carrera> carreraEstudiantesInscriptos(){
        List<Carrera> cs= new ArrayList<>();
        Query sql = em.createQuery("SELECT c, COUNT(e) AS cant_inscriptos " +
                "FROM Carrera c " +
                "JOIN c.estudiantes e " +
                "GROUP BY c.id");
        List<Object[]> carreras = sql.getResultList();
        for (Object[] c  : carreras) {
            Carrera carrera = (Carrera) c[0]; // La entidad Carrera
            Long cantInscriptos = (Long) c[1]; // El valor del conteo

            carrera.setCantInscriptos(cantInscriptos);
            cs.add(carrera);
        }

        return cs;
    }




}
