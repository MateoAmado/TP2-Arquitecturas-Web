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


    public InformeCarreraDAO(){

    }

    public List<InformeCarreraDTO> informeCarreras() {
        EntityManagerFactory emf = ConnectionFactory.getInstance().getConnection(ConnectionFactory.MySQL);
        EntityManager em = emf.createEntityManager();

        Query sql = em.createQuery(
                "SELECT new dto.InformeCarreraDTO(c.idCarrera, c.nombre, e.numeroDocumento, e.nombre, e.apellido, e.ciudadResidencia, e.edad, e.genero, e.numeroLibretaUniversitaria, ec.fechaInscripcion) " +
                        "FROM Carrera c " +
                        "JOIN c.estudiantes e " +
                        "JOIN Estudiante_Carrera ec " +
                        "ORDER BY c.nombre ASC"
        );
        List<InformeCarreraDTO> i = sql.getResultList();

        return i;
    }





}
