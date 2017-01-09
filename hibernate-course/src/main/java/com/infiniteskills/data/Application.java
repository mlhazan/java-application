package com.infiniteskills.data;

import java.util.Date;
import org.hibernate.Session;

import com.infiniteskills.data.entities.Address;
import com.infiniteskills.data.entities.User;

public class Application {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		if (!session.beginTransaction().isActive()) {
			session.beginTransaction().begin();
		} 	
		User user = new User();
		Address address = new Address();
		user.setBirthDate(new Date());
		user.setCreatedBy("Mevin");
		user.setCreatedDate(new Date());
		user.setEmailAddress("kmb385@yahoo.com");
		user.setFirstName("Mevin");
		user.setLastName("Bowersox");
		user.setLastUpdatedBy("kevin");
		user.setLastUpdatedDate(new Date());
		
		address.setAddressLine1("Line 1");
		address.setAddressLine2("Line 2");
		address.setCity("Philadelphia");
		address.setState("PA");
		address.setZipCode("12345");
		
		user.setAddress(address);
		session.save(user);		
		session.getTransaction().commit();
		session.close();
	}
}
