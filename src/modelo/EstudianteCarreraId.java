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

    public void setEstudianteId(Estudiante p1) {
        this.estudianteNumeroDocumento=p1.getNumeroDocumento();
    }

    public void setCarreraId(Carrera carrera) {
        this.carreraIdCarrera=carrera.getIdCarrera();
    }

    public int getCarreraId(){
        return carreraIdCarrera;
    }

    public int getEstudianteNumeroDocumento(){
        return estudianteNumeroDocumento;
    }

}
