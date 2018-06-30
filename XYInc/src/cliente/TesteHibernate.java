package cliente;

import java.util.ArrayList;

import model.domain.POI;
import model.persistence.PoiDAO;

public class TesteHibernate {

	public static void main(String[] args) {
		PoiDAO dao = new PoiDAO();
		ArrayList<POI> list = dao.getAll();
		System.out.println("Numero de itens no banco: " + list.size());
		
		POI poi0 = dao.getById(1);
		System.out.println(poi0.getNome());
	}

}
