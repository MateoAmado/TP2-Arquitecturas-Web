import modelo.Carrera;
import modelo.Estudiante;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

        public class Main {
            public static void main(String[] args) {
                EntityManagerFactory emf= Persistence.createEntityManagerFactory("MySQL");
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                Carrera direccion = new Carrera("TUDAI");
                em.persist(direccion);
                Estudiante p = new Estudiante(46321984, "Juan", "Del Cabo", 25, "Hombre", "Tandil", 1);
                Estudiante p1 = new Estudiante(46321985, "Ana", "Parlucci", 22, "Mujer", "Tres Arroyos", 2);
                p1.setCarrera(direccion);
                em.persist(p);
                em.persist(p1);
                em.getTransaction().commit();
                em.close();
                emf.close();
            }
        }

