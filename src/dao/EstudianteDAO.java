package dao;

import modelo.Estudiante;


import java.util.List;

public interface EstudianteDAO {


    public List<Estudiante> estudiantesOrdenadosApellido();

    public Estudiante getEstudiantePorNroLibreta(int nroLibreta);

    public List<Estudiante> getEstudiantesPorGenero(String genero);
}
