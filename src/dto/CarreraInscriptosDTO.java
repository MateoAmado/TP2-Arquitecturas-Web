package dto;

public class CarreraInscriptosDTO {

    private int idCarrera;

    private String nombre;

    private long cantInscriptos;


    public CarreraInscriptosDTO(int idCarrera, String nombre, long cantInscriptos) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.cantInscriptos = cantInscriptos;
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

    public long getCantInscriptos() {
        return cantInscriptos;
    }

    public void setCantInscriptos(long cantInscriptos) {
        this.cantInscriptos = cantInscriptos;
    }

    @Override
    public String toString() {
        return "Datos de la carrera{" +'\n'+
                "idCarrera =" + idCarrera+'\n' +
                ", Carrera ='" + nombre + '\n' +
                ", cantidad de Inscriptos =" + cantInscriptos +
                '}'+'\n';
    }
}
