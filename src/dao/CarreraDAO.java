package dao;
import modelo.Carrera;
import modelo.Estudiante;

import java.util.List;
public interface CarreraDAO {

    public List<Carrera> carreraEstudiantesInscriptos();

    public void insertar(Carrera carrera);

    public void agregarEstudiante(Carrera carrera, Estudiante e);

}
