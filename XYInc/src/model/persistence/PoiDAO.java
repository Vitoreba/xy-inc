package model.persistence;

import java.util.ArrayList;

import org.hibernate.Session;

import model.domain.POI;
import model.util.HibernateUtil;

public class PoiDAO extends DAO {
	
	public POI getById(int id) {
		POI p = null;
		Session session = null;
		
        try {
        	session = HibernateUtil.getSessionFactory().openSession();
            p = (POI) session.get(POI.class, id);
        } catch (Throwable e) {
        	System.out.println("Erro ao recuperar a pessoa. Mensagem: " + e.getMessage());
        } finally {
        	try {
        		if (session.isOpen()) {
        			session.close();
        		} 
        	} catch (Throwable e) {
            	System.out.println("Erro ao fechar a sessão. Mensagem: " + e.getMessage());
            }
        }
        
        return p;
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<POI> getAll() {
		ArrayList<POI> pois = null;
		Session session = null;
		
        try {
        	session = HibernateUtil.getSessionFactory().openSession();
        	pois = (ArrayList<POI>) session.createQuery("from POI").list();
        } catch (Throwable e) {
        	System.out.println("Erro ao recuperar a pessoa. Mensagem: " + e.getMessage());
        } finally {
        	try {
        		if (session.isOpen()) {
        			session.close();
        		} 
        	} catch (Throwable e) {
            	System.out.println("Erro ao fechar a sessão. Mensagem: " + e.getMessage());
            }
        }
        
		return pois;
	}

}
