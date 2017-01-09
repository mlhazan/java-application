package com.infiniteskills.data;

import java.util.Date;
import org.hibernate.Session;

import com.infiniteskills.data.entities.Bank;


public class Application2 {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		if (!session.beginTransaction().isActive()) {
			session.beginTransaction().begin();
		} 	
		Bank bank = new Bank();
		bank.setName("Federal Trust");
		bank.setAddressLine1("33 Wall Street");
		bank.setAddressLine2("Suite 233");
		bank.setCity("New York");
		bank.setState("NY");
		bank.setZipCode("12345");
		bank.setInternational(false);
		bank.setCreatedBy("Kevin");
		bank.setCreatedDate(new Date());
		bank.setLastUpdatedBy("Kevin");
		bank.setLastUpdatedDate(new Date());
//		bank.getContacts().put("MANAGER", "Joe");
//		bank.getContacts().put("TELLER", "Mary");
		session.save(bank);

		
		session.getTransaction().commit();
		session.close();
	}
}
