import dto.InformeCarreraDTO;
import modelo.Carrera;
import modelo.Estudiante;
import dao.*;
import modelo.EstudianteCarreraId;
import modelo.Estudiante_Carrera;
import util.ConnectionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;


public class Main {
    public static CarreraDAO daoCarrera=(CarreraDAO) DAOFactory.getInstance().getDAO(DAOFactory.CARRERA);
    public static EstudianteDAO daoEstudiante=(EstudianteDAO) DAOFactory.getInstance().getDAO(DAOFactory.ESTUDIANTE);
    public static InformeCarreraDAO informeCarreraDao=(InformeCarreraDAO) DAOFactory.getInstance().getDAO(DAOFactory.INFORME_CARRERA);
    public static EntityManagerFactory emf= ConnectionFactory.getInstance().getConnection(ConnectionFactory.MySQL);
    public static void main(String[] args) {


                //Carreras para cargar
                Carrera direccion = new Carrera( "TUDAI");
                Carrera carrera = new Carrera( "Contador público");
                Carrera carrera_2 = new Carrera( "Tecnicatura en Logistica");
                Carrera carrera_3 = new Carrera( "Tecnicatura en Programación");
                Carrera carrera_4 = new Carrera( "Tecnicatura en Turismo");
                Carrera carrera_5 = new Carrera( "Profesorado en Matematica");
                Carrera carrera_6 = new Carrera( "Licenciatura en Administración");
                Carrera carrera_7 = new Carrera( "Enfermeria");
                Carrera carrera_8 = new Carrera( "Seguridad e higiene");


                Estudiante p = new Estudiante(46321984, "Juan", "Del Cabo", 25, "Hombre", "Tandil", 1);
                Estudiante p1 = new Estudiante(46321985, "Ana", "Parlucci", 22, "Mujer", "Tres Arroyos", 2);
                Estudiante p2 = new Estudiante(41258963, "Lucas", "Gonzalez", 24, "Hombre", "Buenos Aires", 3);
                Estudiante p3 = new Estudiante(39845612, "Martina", "Lopez", 21, "Mujer", "Mar del Plata", 4);
                Estudiante p4 = new Estudiante(42596314, "Joaquin", "Rodriguez", 23, "Hombre", "La Plata", 5);
                Estudiante p5 = new Estudiante(38745219, "Camila", "Martinez", 20, "Mujer", "Rosario", 6);
                Estudiante p6 = new Estudiante(43765982, "Valentina", "Perez", 22, "Mujer", "Córdoba", 7);
                Estudiante p7 = new Estudiante(41327894, "Mateo", "Sanchez", 25, "Hombre", "Mendoza", 8);
                Estudiante p8 = new Estudiante(39984567, "Sofia", "Ramirez", 21, "Mujer", "San Juan", 9);
                Estudiante p9 = new Estudiante(40217856, "Ignacio", "Fernandez", 23, "Hombre", "Neuquén", 10);
                Estudiante p10 = new Estudiante(38847521, "Julieta", "Diaz", 20, "Mujer", "Santa Fe", 11);


        /*
                daoCarrera.cargarCarrera(direccion);
                daoCarrera.cargarCarrera(carrera);
                daoCarrera.cargarCarrera(carrera_2);
                daoCarrera.cargarCarrera(carrera_3);
                daoCarrera.cargarCarrera(carrera_4);
                daoCarrera.cargarCarrera(carrera_5);
                daoCarrera.cargarCarrera(carrera_6);
                daoCarrera.cargarCarrera(carrera_7);
                daoCarrera.cargarCarrera(carrera_8);

                daoEstudiante.cargarEstudiante(p);
                daoEstudiante.cargarEstudiante(p1);
                daoEstudiante.cargarEstudiante(p2);
                daoEstudiante.cargarEstudiante(p3);
                daoEstudiante.cargarEstudiante(p4);
                daoEstudiante.cargarEstudiante(p5);
                daoEstudiante.cargarEstudiante(p6);
                daoEstudiante.cargarEstudiante(p7);
                daoEstudiante.cargarEstudiante(p8);
                daoEstudiante.cargarEstudiante(p9);
                daoEstudiante.cargarEstudiante(p10);


        EstudianteCarreraId id = crearId(p1, carrera_2);
        Estudiante_Carrera estudianteCarrera = new Estudiante_Carrera(id, p1, carrera_2, LocalDate.now(), false);

        EstudianteCarreraId id2=crearId(p3, direccion);
        Estudiante_Carrera ec2 = new Estudiante_Carrera(id2, p3, direccion, LocalDate.of(2007, 02, 21), true);

        EstudianteCarreraId id2_1=crearId(p3, carrera_6);
        Estudiante_Carrera ec2_1= new Estudiante_Carrera(id2_1, p3, carrera_6, LocalDate.of(2018, 11, 30), false);


        EstudianteCarreraId id3=crearId(p, direccion);
        Estudiante_Carrera ec3 = new Estudiante_Carrera(id3, p, direccion, LocalDate.of(2015, 12, 12), true);

        EstudianteCarreraId id4=crearId(p5, carrera_7);
        Estudiante_Carrera ec4= new Estudiante_Carrera(id4, p5, carrera_7, LocalDate.now(), false);

        EstudianteCarreraId id5=crearId(p2, carrera_3);
        Estudiante_Carrera ec5= new Estudiante_Carrera(id5, p2, carrera_3,LocalDate.of(2024, 01, 31), false);

        EstudianteCarreraId id6=crearId(p10, carrera_8);
        Estudiante_Carrera ec6= new Estudiante_Carrera(id6, p10, carrera_8, LocalDate.now(), false);

        crearRelacion(estudianteCarrera);
        crearRelacion(ec2);
        crearRelacion(ec2_1);
        crearRelacion(ec3);
        crearRelacion(ec4);
        crearRelacion(ec5);
        crearRelacion(ec6);

    */
                //EstudiantesOrdenadosPorApellido();

                //obtenerEstudiantePorNumeroDeLibreta();

                //obtenerEstudiantesInscriptos();

                //obtenerEstudiantesPorGenero();

                obtenerEstudiantePorCarreraYCiudad(direccion, "Tandil");
                //obtenerInformeCarreras();


            }

    private static EstudianteCarreraId crearId(Estudiante e, Carrera c) {
        EstudianteCarreraId id=new EstudianteCarreraId();
        id.setCarreraId(c);
        id.setEstudianteId(e);
        return id;
    }

    //merge –> para actualizar un objeto existente en la base de datos.
    public static void crearRelacion(Estudiante_Carrera ec){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Carrera carrera = ec.getCarrera();
        carrera = em.merge(carrera);
        ec.setCarrera(carrera);

        Estudiante estudiante = ec.getEstudiante();
        estudiante = em.merge(estudiante);
        ec.setEstudiante(estudiante);

        EstudianteCarreraId id = ec.getId();
        Estudiante_Carrera existingEC = em.find(Estudiante_Carrera.class, id);

        if (existingEC != null) {
            em.merge(ec);
        } else {
            em.persist(ec);
        }
        em.getTransaction().commit();
    }

    public static void obtenerEstudiantesPorGenero(){
        List<Estudiante> estudiantes=daoEstudiante.getEstudiantesPorGenero("Mujer");
        for(Estudiante e:estudiantes){
            System.out.println(e);
        }
    }
    private static void obtenerEstudiantesInscriptos() {
        List<Object> carreras = (List<Object>) daoCarrera.carreraEstudiantesInscriptos();
        for(int i=0; i<carreras.size(); i++){
            if(i%2==0 || i==0){
                System.out.println(carreras.get(i));
            }
            else{
                System.out.println("cantidad: "+ carreras.get(i));
            }}
    }

    //Estudiantes por apellido
    public static void EstudiantesOrdenadosPorApellido(){
        List<Estudiante> estudiantes = daoEstudiante.estudiantesOrdenadosApellido();
        for (Estudiante e : estudiantes) {
            System.out.println(e);
        }
    }

    public static void obtenerEstudiantePorNumeroDeLibreta(int numero){
        System.out.println(daoEstudiante.getEstudiantePorNroLibreta(numero));
    }

    public static void obtenerEstudiantePorCarreraYCiudad(Carrera c, String ciudad){
        List<Estudiante> estudiantes= daoEstudiante.estudiantesPorCarrerayFiltrado(c ,ciudad);
        for (Estudiante e : estudiantes) {
            System.out.println(e);
        }
    }
    public static void obtenerInformeCarreras(){
        List<InformeCarreraDTO> informe=informeCarreraDao.informeCarreras();
        System.out.println("Tamaño del reporte: "+informe.size());
        for(InformeCarreraDTO ca:informe){
            System.out.print(informe);
        }
    }

    public static void setearEstudianteCarerra(){
        EntityManagerFactory emf= ConnectionFactory.getInstance().getConnection(ConnectionFactory.MySQL);
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        Query sql = em.createQuery("SELECT ec from Estudiante_Carrera ec");
        List<Estudiante_Carrera> ecs = sql.getResultList();
        for(Estudiante_Carrera ec : ecs){
            ec.setFechaInscripcion(LocalDate.now());
            em.persist(ec);
        }
        em.getTransaction().commit();
        em.close();
        ConnectionFactory.getInstance().disconnect();
    }
        }

