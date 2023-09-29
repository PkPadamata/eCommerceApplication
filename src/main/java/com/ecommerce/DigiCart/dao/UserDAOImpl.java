package com.ecommerce.DigiCart.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ecommerce.DigiCart.model.User;


@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean register(User user) {
		boolean result=false;
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
         int id=(int)session.save(user);
         transaction.commit();
		if(id !=0 ) {
			result=true;
		}else {
			result=false;
		}
		return result;
	}

	
	public boolean logIn(User user) {

		boolean result=false;
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		String HQLQuery="select password from User where username=:username";
		@SuppressWarnings("deprecation")
		Query query=session.createQuery(HQLQuery);
		
		query.setParameter("username",user.getUsername());
		transaction.commit();
		
		String pass=query.getSingleResult().toString();
		if(user.getPassword().contentEquals(pass)) {
			result=true;
		}else {
			result=false;
		}
		return result;
	}
}
