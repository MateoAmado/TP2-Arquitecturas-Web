package dao;

import util.ConnectionFactory;

public class DAOFactory {
    public static final String CARRERA="Carrera";
    public static final String ESTUDIANTE="Estudiante";
    public static DAOFactory instance= new DAOFactory();

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        return instance;
    }

    public Object getDAO(String dao){
        switch(dao){
            case CARRERA:
                    return new CarreraDAOMySql();
            case ESTUDIANTE:
                    return new EstudianteDAOMySQL();
            default:
                return null;
        }

    }
}
