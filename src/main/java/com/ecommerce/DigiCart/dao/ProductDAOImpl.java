package com.ecommerce.DigiCart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.DigiCart.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public boolean add(Product product) {
		boolean result =false;
		Session session =sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		int i=(int)session.save(product);
		transaction.commit();
		if(i!=0) {
			result=true;
		}
		return result;
	}

	@Override
	public List<Product> list() {
		Session session=sessionFactory.openSession();
		List<Product> list=session.createQuery("from Product").list();
		
		return list;
	}

	@Override
	public boolean update(Product product) {
		
		return false;
	}

	@Override
	public boolean delete(Product product) {
		boolean result=false;
		
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
			try {
				Product p=(Product)session.merge(product);
				session.remove(p);
				transaction.commit();
				result=true;
			}catch(Exception e) {
				System.out.println(e);
				result=false;
			}
		return result;
	}

}
