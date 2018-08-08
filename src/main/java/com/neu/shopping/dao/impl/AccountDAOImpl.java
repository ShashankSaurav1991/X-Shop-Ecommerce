package com.neu.shopping.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.neu.shopping.dao.AccountDAO;
import com.neu.shopping.entity.Account;

//Transactional for Hibernate
@Transactional
public class AccountDAOImpl implements AccountDAO {
 
 @Autowired
 private SessionFactory sessionFactory;

 @Override
 public Account findAccount(String userName ) {
     Session session = sessionFactory.getCurrentSession();
     Criteria crit = session.createCriteria(Account.class);
     crit.add(Restrictions.eq("userName", userName));
     return (Account) crit.uniqueResult();
 }
 
 @Override
 public void register(Account user){
	     //Session session = sessionFactory.getCurrentSession();
	     //session.beginTransaction();
	     this.sessionFactory.getCurrentSession().persist(user);
	     //session.save(user);
	     //this.sessionFactory.getCurrentSession().save(newUser);
	     //this.sessionFactory.getCurrentSession().getTransaction().commit();
	    // session.getTransaction().commit();
	     //session.close();
		     
		     // If error in DB, Exceptions will be thrown out immediately
		 this.sessionFactory.getCurrentSession().flush();

	}

}
