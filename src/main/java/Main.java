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

                Carrera direccion = new Carrera(0, "TUDAI");
                Estudiante p = new Estudiante(46321984, "Juan", "Del Cabo", 25, "Hombre", "Tandil", 1);
                Estudiante p1 = new Estudiante(46321985, "Ana", "Parlucci", 22, "Mujer", "Tres Arroyos", 2);
                p1.setCarrera(direccion);

                EstudianteDAOMySQL daoEstudiante=(EstudianteDAOMySQL) DAOFactory.getInstance().getDAO(DAOFactory.ESTUDIANTE);
                CarreraDAOMySql daoCarrera=(CarreraDAOMySql) DAOFactory.getInstance().getDAO(DAOFactory.CARRERA);

                daoEstudiante.cargarEstudiante(p);
                daoEstudiante.cargarEstudiante(p1);
                daoCarrera.insertar(direccion);
                EstudianteDAOMySQL es = new EstudianteDAOMySQL();
                CarreraDAOMySql c = new CarreraDAOMySql();


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


            }
        }

