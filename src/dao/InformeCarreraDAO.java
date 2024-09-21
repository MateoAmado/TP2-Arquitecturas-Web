package dao;

import dto.InformeCarreraDTO;
import modelo.Carrera;
import util.ConnectionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

public class InformeCarreraDAO {
    public static EntityManagerFactory emf;


    public InformeCarreraDAO(){

    }
    public void instance(EntityManagerFactory emf){
        this.emf=emf;
    }

    public List<InformeCarreraDTO> informeCarreras() {
        EntityManager em = emf.createEntityManager();
        Query sql = em.createQuery(
                "SELECT new dto.InformeCarreraDTO(c.idCarrera, c.nombre, e.numeroDocumento, e.nombre, e.apellido, e.ciudadResidencia, e.edad, e.genero, e.numeroLibretaUniversitaria, ec.fechaInscripcion, ec.graduado) " +
                        "FROM Estudiante_Carrera ec " +
                        "JOIN ec.estudiante e " +
                        "JOIN  ec.carrera c " +
                        "ORDER BY  ec.fechaInscripcion, c.nombre ASC"
        );
        List<InformeCarreraDTO> i = sql.getResultList();

        return i;
    }





}
