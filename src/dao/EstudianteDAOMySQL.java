package dao;

import modelo.Estudiante;

import java.util.List;
import util.ConnectionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EstudianteDAOMySQL implements EstudianteDAO {
    private EntityManager em;

    public EstudianteDAOMySQL(EntityManager em) {
        this.em = em;
    }


    public void cargarEstudiante(Estudiante e){
        em=ConnectionFactory.instance.connection();
        em.persist(e);
        ConnectionFactory.instance.disconnect();
    }

    public List<Estudiante> estudiantesOrdenadosApellido(){
       Query sql = em.createQuery("SELECT e FROM Estudiante e ORDER BY e.apellido");
       List<Estudiante> estudiantes = sql.getResultList();
        if(estudiantes.size()!=0){
            return estudiantes;
        }
        else
            return null;
    }


    public Estudiante getEstudiantePorNroLibreta(int nroLibreta){
        Query sql = em.createQuery("SELECT e FROM Estudiante e WHERE e.numeroLibretaUniversitaria = :nro", Estudiante.class);
        sql.setParameter("nro", nroLibreta);
        Estudiante estudiante = (Estudiante) sql.getSingleResult();
        if(estudiante!=null) {
            return estudiante;
        }
        return null;
    }

    public List<Estudiante> getEstudiantesPorGenero(String genero){
        Query sql= em.createQuery("SELECT e FROM Estudiante e WHERE e.genero= :gen");
        sql.setParameter("gen", genero);
        List<Estudiante> estudiantes=sql.getResultList();
        if(estudiantes.size()>0){
            return estudiantes;
        }
        else{
            return null;
        }

    }




    public List<Estudiante> estudiantesPorCarrerayFiltrado(){

        return null;
    }
}

