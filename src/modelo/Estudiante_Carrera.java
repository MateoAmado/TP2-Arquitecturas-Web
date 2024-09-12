package modelo;

import javax.persistence.*;
import java.util.Date;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Estudiante_Carrera {

    @Id
    @Column(name = "Anio_ingreso")
    private Date anioInscripcion;

    @Column(name = "recibido")
    private boolean recibido;


}
