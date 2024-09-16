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

    @ManyToMany(mappedBy = "carreras", fetch = FetchType.LAZY)
    private Set<modelo.Estudiante> estudiantes;


    public Carrera(String nombre) {
        this.nombre = nombre;
        estudiantes = new HashSet<>();
    }



    public Carrera() {

    }

    public int getIdCarrera() {
        return idCarrera;
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
}
