package modelo;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Estudiante_Carrera {
    
    @Column(name = "Anio_ingreso")
    private Date anioInscripcion;

    @Column(name = "recibido")
    private boolean recibido;

    @ManyToMany(mappedBy = "carreras")
    private Set<Estudiante> estudiantes = new HashSet<>();

    @ManyToMany(mappedBy = "estudiantes")
    private Set<Carrera> carreras = new HashSet<>();
}
