
package com.eclipselink.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO) 	
   private Long id;
   private String ename;
   private double salary;
   private String deg;
   
   public Employee(Long id, String ename, double salary, String deg) {
      this.id = id;
      this.ename = ename;
      this.salary = salary;
      this.deg = deg;
   }

   public Employee( ) {
        super();
   }

   public Long getId( ) {
      return id;
   }
   
   public void setId(long id) {
      this.id = id;
   }
   
   public String getEname( ) {
      return ename;
   }
   
   public void setEname(String ename) {
      this.ename = ename;
   }

   public double getSalary( ) {
      return salary;
   }
   
   public void setSalary(double salary) {
      this.salary = salary;
   }

   public String getDeg( ) {
      return deg;
   }
   
   public void setDeg(String deg) {
      this.deg = deg;
   }
   
   @Override
   public String toString() {
      return "Employee [id=" + id + ", ename=" + ename + ", salary=" + salary + ", deg=" + deg + "]";
   }
}