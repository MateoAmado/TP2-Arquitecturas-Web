package dao;
import modelo.Carrera;
import modelo.Estudiante;
import util.ConnectionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
public class CarreraDAOMySql implements CarreraDAO{


    public CarreraDAOMySql(){

    }

    public void insertar(Carrera carrera){
        EntityManagerFactory emf= ConnectionFactory.getInstance().getConnection(ConnectionFactory.MySQL);
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(carrera);
        em.getTransaction().commit();
        em.close();
        ConnectionFactory.getInstance().disconnect();
    }

    public void agregarEstudiante(Carrera carrera, Estudiante estudiante){
        EntityManagerFactory emf= ConnectionFactory.getInstance().getConnection(ConnectionFactory.MySQL);
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        Carrera c = em.find(Carrera.class, carrera.getIdCarrera());
        c.addEstudiante(estudiante);
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        ConnectionFactory.getInstance().disconnect();
    }

/*
       public List<Carrera> informeCarreras(){
        EntityManagerFactory emf= ConnectionFactory.getInstance().getConnection(ConnectionFactory.MySQL);
        EntityManager em= emf.createEntityManager();
        List<Carrera> cs= new ArrayList<>();
        Query sql = em.createQuery(
            "SELECT c.nombre, e.apellido, e.ciudadResidencia, e.edad, e.genero, e.numeroDocumento, e.numeroLibretaUniversitaria, COUNT(e.numeroDocumento) AS totalInscriptos " +
            "FROM Carrera c " +
            "JOIN c.estudiantes e " +
            "GROUP BY c.nombre, e.apellido " +
            "ORDER BY c.nombre ASC, e.apellido ASC"
        );
           List<Object[]> resultados = sql.getResultList();
           for (Object[] resultado : resultados) {
               String nombreCarrera = (String) resultado[0];
               String nombreAlumno = (String) resultado[1];
               Long totalInscriptos = (Long) resultado[2];

               Carrera carrera = carrerasMap.getOrDefault(nombreCarrera, new Carrera(nombreCarrera));
               carrera.addEstudiante(new Estudiante(nombreAlumno));
               cs.add(nombreCarrera, carrera);
           }

           // Devolver la lista de carreras
           return new ArrayList<>(carrerasMap.values());

        return null;}

*/

    public List<Carrera> carreraEstudiantesInscriptos(){
        EntityManagerFactory emf= ConnectionFactory.getInstance().getConnection(ConnectionFactory.MySQL);
        EntityManager em= emf.createEntityManager();
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
            ConnectionFactory.getInstance().disconnect();
            em.close();
        }

        return cs;
    }




}
