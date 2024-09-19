package dao;

public class DAOFactory {
    public static final String CARRERA="Carrera";
    public static final String ESTUDIANTE="Estudiante";
    public static final String INFORME_CARRERA="InformeCarrera";
    public static final CarreraDAO INSTANCE_CARRERA=new CarreraDAO();
    public static final EstudianteDAO INSTANCE_ESTUDIANTE=new EstudianteDAO();
    public static final InformeCarreraDAO INSTANCE_INFORME_CARRERA=new InformeCarreraDAO();
    public static DAOFactory instance= new DAOFactory();

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        return instance;
    }

    public static CarreraDAO getInstanceCarrera(){
        return INSTANCE_CARRERA;
    }

    public static EstudianteDAO getInstanceEstudiante(){
        return INSTANCE_ESTUDIANTE;
    }

    public static InformeCarreraDAO getInstanceInformeCarrera(){
        return INSTANCE_INFORME_CARRERA;
    }

    public Object getDAO(String dao){
        switch(dao){
            case CARRERA:
                return getInstanceCarrera();
            case ESTUDIANTE:
                return getInstanceEstudiante();
            case INFORME_CARRERA:
                return getInstanceInformeCarrera();
            default:
                return null;
        }

    }
}
