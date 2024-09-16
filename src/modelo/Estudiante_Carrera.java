package modelo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "estudiante_carrera")
public class Estudiante_Carrera {

    @EmbeddedId
    private EstudianteCarreraId id;

    @ManyToOne
    @MapsId("estudianteNumeroDocumento")
    @JoinColumn(name = "estudiante_numero_documento")
    private Estudiante estudiante;

    @ManyToOne
    @MapsId("carreraIdCarrera")
    @JoinColumn(name = "carrera_id_carrera")
    private Carrera carrera;

    @Column(name = "fecha_inscripcion")
    private LocalDate fechaInscripcion;

    // Constructor, getters y setters
}
