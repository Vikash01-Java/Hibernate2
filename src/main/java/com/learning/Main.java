package com.learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.learning.config.HibernateConfig;
import com.learning.entity.Address;
import com.learning.entity.Address1;
import com.learning.entity.Employee;

public class Main {
    public static void getEmp(Session session) {
    	Employee as = session.get(Employee.class,1);
    	System.out.println(as);
        System.out.println(as.getAddress());

    }


    public static void getAdd(Session session) {
    	Address add = session.get(Address.class, 1);
        System.out.println(add);
      System.out.println(add.getEmployee());
    }

    public static void save(Session session) {
    	Address a = new Address("delhi", "UP");
		Employee e = new Employee("rakhi","female",50000,a);
		a.setEmployee(e);
		Transaction tx = session.beginTransaction();
		session.persist(e);
		session.persist(a);
		
		tx.commit();
    }

	

	public static void main(String[] args) {

		
		 	
		SessionFactory sf=  HibernateConfig.getSessionFactory();
		Session session =sf.openSession();
		
		save(session);
		getEmp(session);
		getAdd(session);

		
		
		}

}
