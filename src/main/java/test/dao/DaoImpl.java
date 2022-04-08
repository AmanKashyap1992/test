package test.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import test.bean.UserBean;
import test.model.User;
import test.util.HibernateUtil;



@Repository 
public class DaoImpl implements Dao{
 
	@Override
	public boolean saveData(UserBean user) {
		/*
		 * StandardServiceRegistry ssr = new
		 * StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		 * Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		 * 
		 * SessionFactory factory = meta.getSessionFactoryBuilder().build();
		 */
		Session session=null;
		Transaction t =null;
		boolean flag=false;
		try {
				session = HibernateUtil.getSessionFactory().openSession();  
				t = session.beginTransaction();  
				User u = new User();
				u.setuName(user.getuName());
				u.setuEmail(user.getuEmail());
				u.setPassword(user.getPassword());
				session.save(u); 
				flag=true;
		}catch(Exception e) {
			 flag=false;
			 session.getTransaction().rollback();
		}finally {
			t.commit();
		    System.out.println("successfully saved");    
		    session.close();
		}
		return flag;   
	}

	@Override
	public List<User> fetchUser() {
		List<User> list=null;
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("From User");
		list =query.list();
		System.out.println("sdd"+list.size());
		return list;
	}
	
}
