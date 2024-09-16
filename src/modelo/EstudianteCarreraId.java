package modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EstudianteCarreraId implements Serializable {


    @Column(name = "estudiante_numero_documento")
    private int estudianteNumeroDocumento;

    @Column(name = "id_carrera")
    private int carreraIdCarrera;

    // Constructor, equals() y hashCode()
}
