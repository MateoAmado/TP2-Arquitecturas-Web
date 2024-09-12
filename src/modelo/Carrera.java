package modelo;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "carrera")
public class Carrera {

    @Id
    @Column(name = "id_carrera")
    private int idCarrera;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @ManyToMany(mappedBy = "carreras", fetch = FetchType.LAZY)
    private Set<modelo.Estudiante> estudiantes;

    private Long cant_alumnos=null;

    public Carrera(int id,String nombre) {
        this.idCarrera=id;
        this.nombre = nombre;
        estudiantes = new HashSet<>();
    }



    public Carrera() {

    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public Long getCant_alumnos(){
        return this.cant_alumnos;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Set<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        if(this.cant_alumnos!=null)
        {
            return "Carrera{ " +
                    "idCarrera=" + idCarrera +
                    ", nombre='" + nombre + '\'' +
                    ", cantidad inscriptos:" + cant_alumnos +
                    '}';
        }
        return "Carrera{ " +
                "idCarrera=" + idCarrera +
                ", nombre='" + nombre + '\'' +
                '}';

    }

    public void addEstudiante(Estudiante estudiante){
        if(estudiante != null){
            estudiantes.add(estudiante);
        }
    }


    public void setCantInscriptos(Long cantInscriptos) {
        this.cant_alumnos=cantInscriptos;
    }
}
