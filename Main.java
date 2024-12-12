package Applicacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[]args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidad-empresa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

//         Empleado emp= em.find(Empleado.class, 15);
//         System.out.println(em.createQuery("SELECT e from Empleado e").getResultList());
        tx.begin();
        Departamento dpto= em.find(Departamento.class, 11);
        //em.remove(dpto);

        System.out.println(em.createQuery("SELECT d from Departamento d").getResultList());

        Departamento dpto2= new Departamento();
        dpto2.setNombre("Informatica");
        em.persist(dpto2);
        tx.commit();
        System.out.println(em.createQuery("SELECT d from Departamento d").getResultList());
//        System.out.println(em.createQuery("SELECT e FROM Empleado AS e WHERE e.nombre = :nombre", Empleado.class).getResultList());
//        System.out.println(em.createNativeQuery("SELECT * FROM empleado", Empleado.class));

        //INSERT -> persist
        //UPDATE -> merge
        //SELECT -> find
        //DELETE -> remove
    }
}
