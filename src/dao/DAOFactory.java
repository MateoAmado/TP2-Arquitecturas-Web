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
                //if(tipo.equals(ConnectionFactory.MySQL)){
                    return new CarreraDAOMySql();
                     /*}
                if(tipo.equals(ConnectionFactory.DERBY)){
                    return new CarreraDAODerby();
                }*/

            case ESTUDIANTE:
                //if(tipo.equals(ConnectionFactory.MySQL)){
                    return new EstudianteDAOMySQL();

            default:
                return null;
        }
                /*if(tipo.equals(ConnectionFactory.DERBY)){
                    return new EstudianteDAODerby();
                }*/

        /*            case CARRERADERBY:
                if(tipo.equals(ConnectionFactory.DERBY)){
                    return new EstudianteDAOMySQL();
                }
     */
    }
}
