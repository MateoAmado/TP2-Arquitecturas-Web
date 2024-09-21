package dto;

import java.sql.Timestamp;
import java.time.LocalDate;

public class InformeCarreraDTO {

    private int id_carrera;
    private String carrera_nombre;

    private int estudiante_nroDocumento;
    private String nombre_estudiante;
    private String estudiante_genero;
    private int edad;
    private String estudiante_apellido;
    private String estudiante_ciudad;
    private int estudiante_libretaUniversitaria;
    private LocalDate fecha_inscripcion;

    private boolean graduado;


//c.idCarrera, c.nombre, e.numeroDocumento, e.nombre, e.apellido, e.ciudadResidencia, e.edad, e.genero, e.numeroLibretaUniversitaria

    public InformeCarreraDTO(int id_carrera, String carrera_nombre, int estudiante_nroDocumento, String nombre_estudiante, String estudiante_apellido, String estudiante_ciudad, int edad, String estudiante_genero, int estudiante_libretaUniversitaria, LocalDate fechaInscripcion, boolean graduado) {
        this.id_carrera = id_carrera;
        this.carrera_nombre = carrera_nombre;
        this.estudiante_nroDocumento = estudiante_nroDocumento;
        this.nombre_estudiante = nombre_estudiante;
        this.estudiante_genero = estudiante_genero;
        this.edad = edad;
        this.estudiante_apellido = estudiante_apellido;
        this.estudiante_ciudad = estudiante_ciudad;
        this.estudiante_libretaUniversitaria = estudiante_libretaUniversitaria;
        this.fecha_inscripcion=fechaInscripcion;
        this.graduado = graduado;
    }

    public int getId_carrera() {
        return id_carrera;
    }



    public String getCarrera_nombre() {
        return carrera_nombre;
    }

    public void setCarrera_nombre(String carrera_nombre) {
        this.carrera_nombre = carrera_nombre;
    }

    public int getEstudiante_nroDocumento() {
        return estudiante_nroDocumento;
    }



    public String getNombre_estudiante() {
        return nombre_estudiante;
    }

    public void setNombre_estudiante(String nombre_estudiante) {
        this.nombre_estudiante = nombre_estudiante;
    }

    public String getEstudiante_genero() {
        return estudiante_genero;
    }

    public void setEstudiante_genero(String estudiante_genero) {
        this.estudiante_genero = estudiante_genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstudiante_apellido() {
        return estudiante_apellido;
    }

    public void setEstudiante_apellido(String estudiante_apellido) {
        this.estudiante_apellido = estudiante_apellido;
    }

    public String getEstudiante_ciudad() {
        return estudiante_ciudad;
    }

    public void setEstudiante_ciudad(String estudiante_ciudad) {
        this.estudiante_ciudad = estudiante_ciudad;
    }

    public int getEstudiante_libretaUniversitaria() {
        return estudiante_libretaUniversitaria;
    }

    public void setEstudiante_libretaUniversitaria(int estudiante_libretaUniversitaria) {
        this.estudiante_libretaUniversitaria = estudiante_libretaUniversitaria;
    }


    @Override
    public String toString() {
        return "Informe de Carrera " +
                "id_carrera=" + id_carrera + '\n' +
                "- Carrera ='" + carrera_nombre + '\n' +
                "- DNI del Estudiante =" + estudiante_nroDocumento + '\n' +
                "- Nombre del Estudiante ='" + nombre_estudiante + '\n' +
                "- Genero del Estudiante ='" + estudiante_genero + '\n' +
                "- Edad del estudiante =" + edad + '\n' +
                "- Apellido del estudiante ='" + estudiante_apellido + '\n' +
                "- Ciudad del estudiante ='" + estudiante_ciudad + '\n' +
                "- Nro de libreta Universitaria=" + estudiante_libretaUniversitaria +'\n' +
                "- Fecha de inscripcion= "+fecha_inscripcion+  '\n' +
                "- Esta graduado? "+estaGraduado(graduado) + '\n' +
                '.';
    }

    public String estaGraduado(boolean graduado){
        if(graduado){
            return "SI";
        }
        return "NO";
    }
}
