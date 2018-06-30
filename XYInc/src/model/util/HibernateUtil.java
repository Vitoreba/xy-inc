package model.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static
	{
		try{
	         Configuration cfg = new Configuration();
	         cfg.configure("hibernate.cfg.xml");
	         sessionFactory = cfg.buildSessionFactory();
	         
	         }catch (Throwable e){
	           System.out.println("Erro:" + e);
	           throw new ExceptionInInitializerError(e);
	         }
	}
	
	public static SessionFactory getSessionFactory(){
        return sessionFactory;
	}
}
