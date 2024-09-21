package dao;
import modelo.Carrera;
import modelo.Estudiante;
import util.ConnectionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
public class CarreraDAO {


    public CarreraDAO(){

    }

    public void cargarCarrera(Carrera carrera){
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


/*    public List<Carrera> informeCarreras() {

            int idCarrera = (Integer) resultado[0];
            String nombreCarrera = (String) resultado[1];
            int numeroDocumento = (Integer) resultado[2];
            String nombreEstudiante = (String) resultado[3];
            String apellidoEstudiante = (String) resultado[4];
            String ciudadResidencia = (String) resultado[5];
            int edadEstudiante = (Integer) resultado[6];
            String generoEstudiante = (String) resultado[7];
            int numeroLibretaUniversitaria = (Integer) resultado[8];

            // Buscar si la carrera ya está en la lista
            Carrera carrera = null;
            for (Carrera c : listaCarreras) {
                if (c.getIdCarrera() == idCarrera) {
                    carrera = c;
                    break;
                }
            }

            // Si la carrera no existe en la lista, crearla y agregarla
            if (carrera == null) {
                carrera = new Carrera(nombreCarrera);
                listaCarreras.add(carrera);
            }

            // Crear el estudiante y agregarlo a la carrera
            Estudiante estudiante = new Estudiante(
                    numeroDocumento,
                    nombreEstudiante,
                    apellidoEstudiante,
                    edadEstudiante,
                    generoEstudiante,
                    ciudadResidencia,
                    numeroLibretaUniversitaria
            );
            carrera.addEstudiante(estudiante); // Agregar el estudiante a la carrera
        }

        // Devolver la lista de carreras
        return listaCarreras;
    }
*/



    public List<Object> carreraEstudiantesInscriptos(){
        EntityManagerFactory emf= ConnectionFactory.getInstance().getConnection(ConnectionFactory.MySQL);
        EntityManager em= emf.createEntityManager();
        List<Object> cs= new ArrayList<>();
        Query sql = em.createQuery("SELECT c, COUNT(e) AS cant_inscriptos " +
                "FROM Carrera c " +
                "JOIN c.estudiantes e " +
                "GROUP BY c.id " +
                "ORDER BY COUNT(e) DESC");
        List<Object[]> carreras = sql.getResultList();
        for (Object[] c  : carreras) {
            Carrera carrera = (Carrera) c[0]; // La entidad Carrera
            Long cantInscriptos = (Long) c[1]; // El valor del conteo

            cs.add(carrera);
            cs.add(cantInscriptos);
        }
        ConnectionFactory.getInstance().disconnect();
        em.close();
    if(!cs.isEmpty()){
        return cs;
    }
        return null;
    }




}
