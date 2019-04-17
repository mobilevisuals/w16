/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w16;

import dfdf.Family;
import dfdf.Person;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Admin
 */
public class W16 {

    private EntityManagerFactory emf;

    public static void main(String[] args) {
        // TODO code application logic here
        W16 w = new W16();
        w.startup();
    }

    void startup() {
        emf = Persistence.createEntityManagerFactory("W16PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query q = em.createQuery("select m from Person m");
        int size = q.getResultList().size();
        Family f = new Family();
     //   if (size < 1) 
        {
            
            f.setDescription("sdfsdfsdf");
Set<Person> members=new HashSet();
            for (int i = 0; i < 40; i++) {
                Person p = new Person();
                p.setFname("sdfsdf" + i);
                p.setLname("fsdfsdf" + i);
                p.setFamily(f);
                
                members.add(p);
            em.persist(p);    
            }
         f.setMembers(members);
            em.persist(f);
        }

        em.getTransaction().commit();
        System.out.println(f);
    }
    
    

}
