package modelo;

import javax.persistence.*;
import java.util.Date;


@Entity

public class Estudiante_Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Anio_ingreso")
    private Date anioInscripcion=null;

    @Column(name = "recibido")
    private boolean recibido=false;




}
