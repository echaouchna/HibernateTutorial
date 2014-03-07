package org.example.hibernate;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;

import org.example.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateTest {

	static private ServiceRegistry serviceRegistry;

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
//		user.setUserId(1L);
		user.setUserName(nextName());
		user.setAddress("1235");
		user.setJoinDate(new Date());
		user.setDescription("test");

		SessionFactory sessionFactory = createSessionFactory();

		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} finally {
			StandardServiceRegistryBuilder.destroy(serviceRegistry);
		}
	}

	public static SessionFactory createSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(serviceRegistry);

		return sessionFactory;
	}

	public static String nextName() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}

}
