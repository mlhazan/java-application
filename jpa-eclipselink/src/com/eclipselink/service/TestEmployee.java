
package com.eclipselink.service;

import com.eclipselink.entity.Employee;

public class TestEmployee {
     public static void main(String[] args) throws Exception {
          Employee employee = new Employee();
          employee.setId(1001);
          employee.setEname("Robert Frost");
          employee.setDeg("Proffessor");
          employee.setSalary(4000);
          
          LocalDAO dao = new LocalDAO();
          employee = dao.salvar(employee);//insert
          System.out.println("Employee "+employee.getId()+" "+ employee.getEname()+" "+employee.getDeg()+" "+ employee.getSalary());
          Employee e2 =dao.consultById(employee.getId());
          e2.setSalary(450000);
          e2 =dao.salvar(e2);//update
           System.out.println("Employee "+e2.getId()+" "+ e2.getEname()+" "+e2.getDeg()+" "+ e2.getSalary());
           //dao.remover(Long.valueOf(101));//delete
     }
}
