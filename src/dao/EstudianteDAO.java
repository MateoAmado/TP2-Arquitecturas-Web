package dao;

import modelo.Carrera;
import modelo.Estudiante;

import java.util.List;

import util.ConnectionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class EstudianteDAO {


    public EstudianteDAO(){
    }


    public void cargarEstudiante(Estudiante e){
        EntityManagerFactory emf= ConnectionFactory.getInstance().getConnection(ConnectionFactory.MySQL);
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
        ConnectionFactory.instance.disconnect();
    }

    public List<Estudiante> estudiantesOrdenadosApellido(){
        EntityManagerFactory emf= ConnectionFactory.getInstance().getConnection(ConnectionFactory.MySQL);
        EntityManager em= emf.createEntityManager();
       Query sql = em.createQuery("SELECT e FROM Estudiante e ORDER BY e.apellido");
       List<Estudiante> estudiantes = sql.getResultList();
       ConnectionFactory.getInstance().disconnect();
       em.close();
        if(estudiantes.size()!=0){
            return estudiantes;
        }
        else
            return null;
    }


    public Estudiante getEstudiantePorNroLibreta(int nroLibreta){
        EntityManagerFactory emf= ConnectionFactory.getInstance().getConnection(ConnectionFactory.MySQL);
        EntityManager em= emf.createEntityManager();
        Query sql = em.createQuery("SELECT e FROM Estudiante e WHERE e.numeroLibretaUniversitaria = :nro", Estudiante.class);
        sql.setParameter("nro", nroLibreta);
        Estudiante estudiante = (Estudiante) sql.getSingleResult();
        ConnectionFactory.getInstance().disconnect();
        em.close();
        if(estudiante!=null) {
            return estudiante;
        }
        return null;
    }

    public List<Estudiante> getEstudiantesPorGenero(String genero){
        EntityManagerFactory emf= ConnectionFactory.getInstance().getConnection(ConnectionFactory.MySQL);
        EntityManager em= emf.createEntityManager();
        Query sql= em.createQuery("SELECT e FROM Estudiante e WHERE e.genero= :gen");
        sql.setParameter("gen", genero);
        List<Estudiante> estudiantes=sql.getResultList();
        ConnectionFactory.getInstance().disconnect();
        em.close();
        if(estudiantes.size()>0){
            return estudiantes;
        }
        else{
            return null;
        }

    }




    public List<Estudiante> estudiantesPorCarrerayFiltrado(String carrera, String ciudad){
        EntityManagerFactory emf= ConnectionFactory.getInstance().getConnection(ConnectionFactory.MySQL);
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
       Query q = em.createQuery("SELECT e FROM Estudiante e JOIN e.carreras c WHERE e.ciudadResidencia = :ciudad AND c.nombre = :carrera");
       q.setParameter("ciudad", ciudad);
       q.setParameter("carrera", carrera);
        List<Estudiante> estudiantes = q.getResultList();

        em.getTransaction().commit();
        em.close();
        ConnectionFactory.getInstance().disconnect();

        if(!estudiantes.isEmpty()){
            return estudiantes;
        }
       
      return null;
    }
}

