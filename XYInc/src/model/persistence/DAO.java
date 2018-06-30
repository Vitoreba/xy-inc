package model.persistence;

import org.hibernate.Session;

import model.domain.Entidade;
import model.util.HibernateUtil;

public class DAO extends HibernateUtil {

	private Session session;

	public Entidade insert(Entidade entidade) {
		session = null;
		
		try {
        	session = HibernateUtil.getSessionFactory().openSession();
        	session.beginTransaction();
            session.save(entidade);
            session.getTransaction().commit();
            
        } catch (Throwable e) {
        	System.out.println("Erro ao excluir a pessoa. Mensagem: " + e.getMessage());
        } finally {
        	try {
        		if (session.isOpen()) {
        			session.close();
        		} 
        	} catch (Throwable e) {
            	System.out.println("Erro ao fechar a sessão. Mensagem: " + e.getMessage());
            }
        }
		
		return entidade;
	}
	
	public Entidade update(Entidade entidade) {
		session = null;
		
		try {
        	session = HibernateUtil.getSessionFactory().openSession();
        	session.beginTransaction();
            session.update(entidade);
            session.getTransaction().commit();
            
        } catch (Throwable e) {
        	System.out.println("Erro ao excluir a pessoa. Mensagem: " + e.getMessage());
        } finally {
        	try {
        		if (session.isOpen()) {
        			session.close();
        		} 
        	} catch (Throwable e) {
            	System.out.println("Erro ao fechar a sessão. Mensagem: " + e.getMessage());
            }
        }
		
		return entidade;
	}
	
	public void delete(Entidade entidade) {
		session = null;
		
		try {
        	session = HibernateUtil.getSessionFactory().openSession();
        	session.beginTransaction();
            session.delete(entidade);
            session.getTransaction().commit();
            
        } catch (Throwable e) {
        	System.out.println("Erro ao excluir a pessoa. Mensagem: " + e.getMessage());
        } finally {
        	try {
        		if (session.isOpen()) {
        			session.close();
        		} 
        	} catch (Throwable e) {
            	System.out.println("Erro ao fechar a sessão. Mensagem: " + e.getMessage());
            }
        }
	}
	
}
