package modelo;
import modelo.Carrera;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @Column(name = "numero_documento")
    private int numeroDocumento;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "apellido", length = 100)
    private String apellido;

    @Column(name = "edad")
    private int edad;

    @Column(name = "genero", length = 100)
    private String genero;

    @Column(name = "ciudad_residencia", length = 100)
    private String ciudadResidencia;

    @Column(name = "numero_libreta_universitaria")
    private int numeroLibretaUniversitaria;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "estudiante_carrera",
            joinColumns = @JoinColumn(name = "estudiante_numero_documento"),
            inverseJoinColumns = @JoinColumn(name = "carrera_id_carrera")
    )
    private Set<Carrera> carreras = new HashSet<>();

    public Estudiante(int numeroDocumento, String nombre, String apellido, int edad, String genero, String ciudadResidencia, int numeroLibretaUniversitaria) {
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudadResidencia = ciudadResidencia;
        this.numeroLibretaUniversitaria = numeroLibretaUniversitaria;
    }

    public Estudiante() {

    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public int getNumeroLibretaUniversitaria() {
        return numeroLibretaUniversitaria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public Set<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(Set<Carrera> carreras) {
        this.carreras = carreras;
    }

    public void setCarrera(Carrera carrera) {
        this.carreras.add(carrera);
    }

    @Override
    public String toString() {
        return "Estudiante " +'\n'+
                "- Numero de documento = " + numeroDocumento +'\n'+
                "- Nombre = " + nombre +'\n'+
                "- Apellido = " + apellido + '\n' +
                "- Edad = " + edad +'\n'+
                "- Genero = " + genero + '\n' +
                "- Ciudad de residencia = " + ciudadResidencia + '\n' +
                "- Numero de libreta universitaria = " + numeroLibretaUniversitaria +'\n'+
                '.';
    }
}
