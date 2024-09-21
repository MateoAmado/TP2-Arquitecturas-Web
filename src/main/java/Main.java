import dto.CarreraInscriptosDTO;
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

        daoCarrera.instance(emf);
        daoEstudiante.instance(emf);
        informeCarreraDao.instance(emf);
/*
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
        Carrera carrera_9 = new Carrera("Ingeniería Civil");
        Carrera carrera_10 = new Carrera("Arquitectura");


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


        daoCarrera.cargarCarrera(direccion);
        daoCarrera.cargarCarrera(carrera);
        daoCarrera.cargarCarrera(carrera_2);
        daoCarrera.cargarCarrera(carrera_3);
        daoCarrera.cargarCarrera(carrera_4);
        daoCarrera.cargarCarrera(carrera_5);
        daoCarrera.cargarCarrera(carrera_6);
        daoCarrera.cargarCarrera(carrera_7);
        daoCarrera.cargarCarrera(carrera_8);
        daoCarrera.cargarCarrera(carrera_9);
        daoCarrera.cargarCarrera(carrera_10);

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


        EstudianteCarreraId id34=crearId(p10, carrera_9);
        Estudiante_Carrera ec34 = new Estudiante_Carrera(id34, p10, carrera_9, LocalDate.of(2019, 1, 1), false);

        // Juan Del Cabo (p) - varias carreras
        EstudianteCarreraId id3=crearId(p, direccion);
        Estudiante_Carrera ec3 = new Estudiante_Carrera(id3, p, direccion, LocalDate.of(2015, 12, 12), true);

        EstudianteCarreraId id12 = crearId(p, carrera);
        Estudiante_Carrera ec12 = new Estudiante_Carrera(id12, p, carrera, LocalDate.of(2021, 8, 25), false);

        EstudianteCarreraId id13 = crearId(p, carrera_5);
        Estudiante_Carrera ec13 = new Estudiante_Carrera(id13, p, carrera_5, LocalDate.of(2018, 9, 14), true);

        // Ana Parlucci (p1) - varias carreras
        EstudianteCarreraId id = crearId(p1, carrera_2);
        Estudiante_Carrera estudianteCarrera = new Estudiante_Carrera(id, p1, carrera_2, LocalDate.now(), false);

        EstudianteCarreraId id14 = crearId(p1, direccion);
        Estudiante_Carrera ec14 = new Estudiante_Carrera(id14, p1, direccion, LocalDate.of(2022, 7, 10), true);

        EstudianteCarreraId id15 = crearId(p1, carrera_5);
        Estudiante_Carrera ec15 = new Estudiante_Carrera(id15, p1, carrera_5, LocalDate.now(), false);

        // Lucas Gonzalez (p2) - varias carreras
        EstudianteCarreraId id5=crearId(p2, carrera_3);
        Estudiante_Carrera ec5= new Estudiante_Carrera(id5, p2, carrera_3,LocalDate.of(2024, 01, 31), false);

        EstudianteCarreraId id16 = crearId(p2, direccion);
        Estudiante_Carrera ec16 = new Estudiante_Carrera(id16, p2, direccion, LocalDate.of(2020, 5, 20), true);

        EstudianteCarreraId id17 = crearId(p2, carrera_4);
        Estudiante_Carrera ec17 = new Estudiante_Carrera(id17, p2, carrera_4, LocalDate.of(2023, 12, 1), false);

        // Martina Lopez (p3) - varias carreras

        EstudianteCarreraId id2=crearId(p3, direccion);
        Estudiante_Carrera ec2 = new Estudiante_Carrera(id2, p3, direccion, LocalDate.of(2007, 02, 21), true);

        EstudianteCarreraId id18 = crearId(p3, carrera);
        Estudiante_Carrera ec18 = new Estudiante_Carrera(id18, p3, carrera, LocalDate.of(2020, 11, 15), true);

        EstudianteCarreraId id19 = crearId(p3, carrera_4);
        Estudiante_Carrera ec19 = new Estudiante_Carrera(id19, p3, carrera_4, LocalDate.of(2022, 4, 22), false);

        // Joaquin Rodriguez (p4) - varias carreras
        EstudianteCarreraId id20 = crearId(p4, carrera_2);
        Estudiante_Carrera ec20 = new Estudiante_Carrera(id20, p4, carrera_2, LocalDate.of(2021, 3, 5), true);

        EstudianteCarreraId id21 = crearId(p4, carrera_7);
        Estudiante_Carrera ec21 = new Estudiante_Carrera(id21, p4, carrera_7, LocalDate.of(2022, 9, 9), false);

        // Camila Martinez (p5) - varias carreras

        EstudianteCarreraId id4=crearId(p5, carrera_7);
        Estudiante_Carrera ec4= new Estudiante_Carrera(id4, p5, carrera_7, LocalDate.now(), false);

        EstudianteCarreraId id22 = crearId(p5, carrera);
        Estudiante_Carrera ec22 = new Estudiante_Carrera(id22, p5, carrera, LocalDate.of(2021, 8, 30), true);

        EstudianteCarreraId id23 = crearId(p5, carrera_4);
        Estudiante_Carrera ec23 = new Estudiante_Carrera(id23, p5, carrera_4, LocalDate.of(2020, 6, 16), false);

        // Valentina Perez (p6) - varias carreras
        EstudianteCarreraId id24 = crearId(p6, carrera_6);
        Estudiante_Carrera ec24 = new Estudiante_Carrera(id24, p6, carrera_6, LocalDate.of(2019, 10, 10), true);

        EstudianteCarreraId id25 = crearId(p6, carrera_8);
        Estudiante_Carrera ec25 = new Estudiante_Carrera(id25, p6, carrera_8, LocalDate.of(2021, 2, 14), false);

        // Mateo Sanchez (p7) - varias carreras
        EstudianteCarreraId id26 = crearId(p7, direccion);
        Estudiante_Carrera ec26 = new Estudiante_Carrera(id26, p7, direccion, LocalDate.of(2017, 7, 17), true);

        EstudianteCarreraId id27 = crearId(p7, carrera_5);
        Estudiante_Carrera ec27 = new Estudiante_Carrera(id27, p7, carrera_5, LocalDate.of(2023, 10, 5), false);

        // Sofia Ramirez (p8) - varias carreras
        EstudianteCarreraId id28 = crearId(p8, carrera_3);
        Estudiante_Carrera ec28 = new Estudiante_Carrera(id28, p8, carrera_3, LocalDate.of(2024, 1, 15), false);

        EstudianteCarreraId id29 = crearId(p8, carrera_6);
        Estudiante_Carrera ec29 = new Estudiante_Carrera(id29, p8, carrera_6, LocalDate.of(2022, 6, 20), true);

        // Ignacio Fernandez (p9) - varias carreras
        EstudianteCarreraId id30 = crearId(p9, carrera_7);
        Estudiante_Carrera ec30 = new Estudiante_Carrera(id30, p9, carrera_7, LocalDate.of(2023, 11, 30), false);

        EstudianteCarreraId id31 = crearId(p9, carrera_2);
        Estudiante_Carrera ec31 = new Estudiante_Carrera(id31, p9, carrera_2, LocalDate.of(2020, 8, 18), true);

        // Julieta Diaz (p10) - varias carreras
        EstudianteCarreraId id32 = crearId(p10, carrera);
        Estudiante_Carrera ec32 = new Estudiante_Carrera(id32, p10, carrera, LocalDate.of(2019, 4, 12), true);

        EstudianteCarreraId id33 = crearId(p10, carrera_3);
        Estudiante_Carrera ec33 = new Estudiante_Carrera(id33, p10, carrera_3, LocalDate.now(), false);

        EstudianteCarreraId id6=crearId(p10, carrera_8);
        Estudiante_Carrera ec6= new Estudiante_Carrera(id6, p10, carrera_8, LocalDate.now(), false);

        crearRelacion(estudianteCarrera);
        crearRelacion(ec2);
        crearRelacion(ec3);
        crearRelacion(ec4);
        crearRelacion(ec5);
        crearRelacion(ec6);
        crearRelacion(ec12);
        crearRelacion(ec13);
        crearRelacion(ec14);
        crearRelacion(ec15);
        crearRelacion(ec16);
        crearRelacion(ec17);
        crearRelacion(ec18);
        crearRelacion(ec19);
        crearRelacion(ec20);
        crearRelacion(ec21);
        crearRelacion(ec22);
        crearRelacion(ec23);
        crearRelacion(ec24);
        crearRelacion(ec25);
        crearRelacion(ec26);
        crearRelacion(ec27);
        crearRelacion(ec28);
        crearRelacion(ec29);
        crearRelacion(ec30);
        crearRelacion(ec31);
        crearRelacion(ec32);
        crearRelacion(ec33);
        crearRelacion(ec34);

*/
        EstudiantesOrdenadosPorApellido();

        obtenerEstudiantePorNumeroDeLibreta(2);

        obtenerEstudiantesInscriptos();

        obtenerEstudiantesPorGenero("Mujer");

        obtenerEstudiantePorCarreraYCiudad("Geografia", "Rosario");

        obtenerInformeCarreras();

        emf.close();

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
        if(em.find(Carrera.class, carrera.getIdCarrera()) != null){
           carrera = em.merge(carrera);
        }
        else{
            em.persist(carrera);
        }
        ec.setCarrera(carrera);

        Estudiante estudiante = ec.getEstudiante();
        if(em.find(Estudiante.class, estudiante.getNumeroDocumento()) != null){
            estudiante = em.merge(estudiante);
        }
        else{
            em.persist(estudiante);
        }
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

    public static void obtenerEstudiantesPorGenero(String genero){
        List<Estudiante> estudiantes=daoEstudiante.getEstudiantesPorGenero(genero);
        if(estudiantes!=null){
            for(Estudiante e:estudiantes){
                System.out.println(e);
            }
        }
        else{
            System.out.println("No hay estudiantes que esten registrados con el género: "+genero+".");
        }

    }
    private static void obtenerEstudiantesInscriptos() {
        List<CarreraInscriptosDTO> dtos = daoCarrera.carreraEstudiantesInscriptos();
        for(CarreraInscriptosDTO dto: dtos) {
            System.out.println(dto);
        }
    }

    //Estudiantes por apellido
    public static void EstudiantesOrdenadosPorApellido(){
        List<Estudiante> estudiantes = daoEstudiante.estudiantesOrdenadosApellido();
        for (Estudiante e : estudiantes) {
            System.out.println(e);
        }
    }

    public static void obtenerEstudiantePorNumeroDeLibreta(int numero){
        Estudiante e = daoEstudiante.getEstudiantePorNroLibreta(numero);
        if(e != null) {
            System.out.println(daoEstudiante.getEstudiantePorNroLibreta(numero));
        }else{
            System.out.println("No se encontro el estudiante!!!");
        }
    }

    public static void obtenerEstudiantePorCarreraYCiudad(String c, String ciudad){
        List<Estudiante> estudiantes= daoEstudiante.estudiantesPorCarrerayFiltrado(c ,ciudad);
        if(estudiantes!=null){
            for (Estudiante e : estudiantes) {
                System.out.println(e);
            }
        }
        else{
            System.out.println("No hay estudiantes que estudien: "+c+" que residan en: "+ciudad+".");
        }

    }
    public static void obtenerInformeCarreras(){
        List<InformeCarreraDTO> informe=informeCarreraDao.informeCarreras();
        System.out.println("Tamaño del reporte: "+informe.size());
        for(InformeCarreraDTO ca:informe){
            System.out.println(ca);
        }
    }
}

