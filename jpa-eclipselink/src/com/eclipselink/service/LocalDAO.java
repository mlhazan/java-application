package com.eclipselink.service;

import com.eclipselink.entity.Employee;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LocalDAO {

     public EntityManager getEM() {
          EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_EclipselinkPU");
          return factory.createEntityManager();
     }

     public Employee salvar(Employee local) throws Exception {
          EntityManager em = getEM();
          try {
               em.getTransaction().begin();
               if (local.getId() == null) {
                    em.persist(local); //exec insert
               } else {
//                    if (!em.contains(local)) {
//                         if (em.find(Employee.class, local.getId()) == null) {
//                              throw new Exception("Not Found");
//                         }
//                    }
                    local = em.merge(local);//exec update
               }
               em.getTransaction().commit();
          } finally {
               em.close();
          }
          return local;
     }

     public void remover(Long id) throws Exception {
          EntityManager em = getEM();
          Employee local = em.find(Employee.class, id);
          try {
               em.getTransaction().begin();
               em.remove(local);
               em.getTransaction().commit();
          } finally {
               em.close();
          }
     }

     public Employee consultById(Long id) throws Exception {
          EntityManager em = getEM();
          Employee local = null;

          try {
               local = em.find(Employee.class, id);

          } finally {
               em.close();
          }
          return local;
     }
}
