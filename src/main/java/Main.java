import modelo.Carrera;
import modelo.Estudiante;
import dao.*;

import java.util.List;
import java.util.Set;


public class Main {
            public static void main(String[] args) {
                CarreraDAOMySql daoCarrera=(CarreraDAOMySql) DAOFactory.getInstance().getDAO(DAOFactory.CARRERA);
                EstudianteDAOMySQL daoEstudiante=(EstudianteDAOMySQL) DAOFactory.getInstance().getDAO(DAOFactory.ESTUDIANTE);

                Carrera direccion = new Carrera( "TUDAI");
                Estudiante p = new Estudiante(46321984, "Juan", "Del Cabo", 25, "Hombre", "Tandil", 1);
                Estudiante p1 = new Estudiante(46321985, "Ana", "Parlucci", 22, "Mujer", "Tres Arroyos", 2);
                p1.setCarrera(direccion);


                daoCarrera.cargarCarrera(direccion);
                daoEstudiante.cargarEstudiante(p);
                daoEstudiante.cargarEstudiante(p1);

                EstudianteDAOMySQL es = new EstudianteDAOMySQL();
                CarreraDAOMySql c = new CarreraDAOMySql();


                //Estudiantes por apellido
                List<Estudiante> estudiantes = es.estudiantesOrdenadosApellido();
                for(Estudiante e: estudiantes){
                    System.out.println(e);
                }

                 System.out.println(es.getEstudiantePorNroLibreta(2));
                 List<Object> carreras = (List<Object>) c.carreraEstudiantesInscriptos();
               for(int i=0; i<carreras.size(); i++){
                   if(i%2==0 || i==0){
                        System.out.println(carreras.get(i));
                   }
                   else{
                       System.out.println("cantidad: "+ carreras.get(i));
               }}

                 List<Carrera> informe=daoCarrera.informeCarreras();
               System.out.println("Tamaño del reporte: "+informe.size());
                 for(Carrera ca:informe){
                     System.out.println(ca);
                     Set<Estudiante> estudiantesC =  ca.getEstudiantes();
                     for(Estudiante e:estudiantesC){
                         System.out.println(e);
                     }
                 }


            }
        }

