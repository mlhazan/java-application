
package com.eclipselink.service;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.eclipselink.entity.Employee;

public class FindEmployee {
   public static void main( String[ ] args ) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPA_EclipselinkPU" );
      EntityManager entitymanager = emfactory.createEntityManager();
      Employee employee = entitymanager.find( Employee.class, 101 );

      System.out.println("employee ID = " + employee.getId( ));
      System.out.println("employee NAME = " + employee.getEname( ));
      System.out.println("employee SALARY = " + employee.getSalary( ));
      System.out.println("employee DESIGNATION = " + employee.getDeg( ));
   }
}