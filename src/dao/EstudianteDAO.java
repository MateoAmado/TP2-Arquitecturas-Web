package dao;

import modelo.Carrera;
import modelo.Estudiante;

import java.util.List;

import util.ConnectionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class EstudianteDAO {

    public static EntityManagerFactory emf;


    public EstudianteDAO(){
    }

    public void instance(EntityManagerFactory emf){
        this.emf=emf;
    }

    public void cargarEstudiante(Estudiante e){
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    public List<Estudiante> estudiantesOrdenadosApellido(){
        EntityManager em= emf.createEntityManager();
       Query sql = em.createQuery("SELECT e FROM Estudiante e ORDER BY e.apellido");
       List<Estudiante> estudiantes = sql.getResultList();
       em.close();
        if(estudiantes.size()!=0){
            return estudiantes;
        }
        else
            return null;
    }


    public Estudiante getEstudiantePorNroLibreta(int nroLibreta){
        EntityManager em= emf.createEntityManager();
        Estudiante estudiante=null;
        try{
            Query sql = em.createQuery("SELECT e FROM Estudiante e WHERE e.numeroLibretaUniversitaria = :nro", Estudiante.class);
            sql.setParameter("nro", nroLibreta);
            estudiante = (Estudiante) sql.getSingleResult();
        }
        catch (Exception e){
            estudiante=null;
        }
        em.close();
        return estudiante;
    }

    public List<Estudiante> getEstudiantesPorGenero(String genero){
        EntityManager em= emf.createEntityManager();
        Query sql= em.createQuery("SELECT e FROM Estudiante e WHERE e.genero= :gen");
        sql.setParameter("gen", genero);
        List<Estudiante> estudiantes=sql.getResultList();
        em.close();
        if(estudiantes.size()>0){
            return estudiantes;
        }
        else{
            return null;
        }

    }




    public List<Estudiante> estudiantesPorCarrerayFiltrado(String carrera, String ciudad){
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
       Query q = em.createQuery("SELECT e FROM Estudiante e JOIN e.carreras c WHERE e.ciudadResidencia = :ciudad AND c.nombre = :carrera");
       q.setParameter("ciudad", ciudad);
       q.setParameter("carrera", carrera);
        List<Estudiante> estudiantes = q.getResultList();

        em.getTransaction().commit();
        em.close();
        if(!estudiantes.isEmpty()){
            return estudiantes;
        }
       
      return null;
    }
}

