package dao;
import modelo.Carrera;
import modelo.Estudiante;
import util.ConnectionFactory;
import dto.CarreraInscriptosDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
public class CarreraDAO {

    public static EntityManagerFactory emf;

    public CarreraDAO(){

    }

    public void instance(EntityManagerFactory emf){
        this.emf=emf;
    }

    public void cargarCarrera(Carrera carrera){
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(carrera);
        em.getTransaction().commit();
        em.close();
    }

    public void agregarEstudiante(Carrera carrera, Estudiante estudiante){
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        Carrera c = em.find(Carrera.class, carrera.getIdCarrera());
        c.addEstudiante(estudiante);
        em.persist(c);
        em.getTransaction().commit();
        em.close();
    }


    public List<CarreraInscriptosDTO> carreraEstudiantesInscriptos() {
        EntityManager em = emf.createEntityManager();
        Query sql = em.createQuery("SELECT new dto.CarreraInscriptosDTO(c.id, c.nombre, COUNT(e))" +
                "FROM Carrera c " +
                "JOIN c.estudiantes e " +
                "GROUP BY c.id, c.nombre " +
                "ORDER BY COUNT(e) DESC");
        List<CarreraInscriptosDTO> carreras = sql.getResultList();
        em.close();
        return carreras;
    }
}
