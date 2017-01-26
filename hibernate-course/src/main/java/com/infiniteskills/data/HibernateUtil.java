package com.infiniteskills.data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.infiniteskills.data.entities.Account;
import com.infiniteskills.data.entities.Bank;
import com.infiniteskills.data.entities.Credential;
import com.infiniteskills.data.entities.Transaction;
import com.infiniteskills.data.entities.User;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory(){
		try{ 
			Configuration configuration = new Configuration();	
			configuration.addAnnotatedClass(Credential.class);
			configuration.addAnnotatedClass(User.class);
			configuration.addAnnotatedClass(Credential.class);
			configuration.addAnnotatedClass(Account.class);
			configuration.addAnnotatedClass(Transaction.class);
			return configuration
					.buildSessionFactory(new StandardServiceRegistryBuilder()
							.applySettings(configuration.getProperties())
							.build());
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("There was an error building the session factory");
		}
				
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
		
	}
}
