package modelo;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "carrera")
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrera")
    private int idCarrera;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @ManyToMany(mappedBy = "carreras")
    private Set<modelo.Estudiante> estudiantes = new HashSet<>();

    private Long cant_alumnos=null;

    public Carrera(String nombre) {
        this.nombre = nombre;
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


    public void setCantInscriptos(Long cantInscriptos) {
        this.cant_alumnos=cantInscriptos;
    }
}
