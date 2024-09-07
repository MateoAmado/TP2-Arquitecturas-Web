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
    private EntityManager em;
    private ConnectionFactory(){}

    public ConnectionFactory getInstance(){
        return instance;
    }

    public EntityManager getConnection(String tipo){
        if(tipo.equals(DERBY)){
            this.emf = Persistence.createEntityManagerFactory(DERBY);
            this.em = emf.createEntityManager();
        }
        if(tipo.equals(MySQL)){
            this.emf = Persistence.createEntityManagerFactory(MySQL);
            this.em = emf.createEntityManager();
        }

        return em;
    }

    public EntityManager connection(){
        return this.em;
    }

    public void disconnect(){
        this.em.close();
        this.emf.close();
    }
}

