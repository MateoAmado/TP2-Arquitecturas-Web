package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;

public class ConnectionFactory {

    public static final String DERBY="Derby";
    public static final String MySQL="MySQL";
    public static ConnectionFactory instance=new ConnectionFactory();

    private Connection connection;
    private EntityManagerFactory emf;
    private ConnectionFactory(){}

    public static ConnectionFactory getInstance(){
        return instance;
    }

    public EntityManagerFactory getConnection(String tipo){
        if(tipo.equals(DERBY)){
            this.emf = Persistence.createEntityManagerFactory(DERBY);
        }
        if(tipo.equals(MySQL)){
            this.emf = Persistence.createEntityManagerFactory(MySQL);
        }

        return emf;
    }



    public void disconnect(){
        this.emf.close();
    }
}

