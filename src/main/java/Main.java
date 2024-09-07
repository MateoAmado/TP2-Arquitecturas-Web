import dao.EstudianteDAO;
import modelo.Carrera;
import modelo.Estudiante;
import dao.*;
import util.ConnectionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.util.List;


public class Main {
            public static void main(String[] args) {

                ConnectionFactory cf = ConnectionFactory.getInstance();
                EntityManagerFactory emf= Persistence.createEntityManagerFactory("MySQL");

                EntityManager em = cf.getConnection(ConnectionFactory.MySQL);

                em.getTransaction().begin();

/*
               //Para crear tablas y datos
                Carrera direccion = new Carrera("TUDAI");
                em.persist(direccion);
                Estudiante p = new Estudiante(46321984, "Juan", "Del Cabo", 25, "Hombre", "Tandil", 1);
                Estudiante p1 = new Estudiante(46321985, "Ana", "Parlucci", 22, "Mujer", "Tres Arroyos", 2);
                p1.setCarrera(direccion);
                em.persist(p);
                em.persist(p1);


                //Comentar hasta acá la parte de creación de Tablas.
*/

                EstudianteDAOMySQL es = new EstudianteDAOMySQL(em);
                CarreraDAOMySql c = new CarreraDAOMySql(em);
                //Estudiantes por apellido


                List<Estudiante> estudiantes = es.estudiantesOrdenadosApellido();
                for(Estudiante e: estudiantes){
                    System.out.println(e);
                }

                 System.out.println(es.getEstudiantePorNroLibreta(2));
                 List<Carrera> carreras = (List<Carrera>) c.carreraEstudiantesInscriptos();
                 for(Carrera ca:carreras){
                     System.out.println(ca);
                 }

                em.getTransaction().commit();
                em.close();
                emf.close();
            }
        }

