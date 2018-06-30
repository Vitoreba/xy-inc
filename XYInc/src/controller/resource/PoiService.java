package controller.resource;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.domain.POI;
import model.domain.POIs;
import model.persistence.PoiDAO;

@Path("/poi")
public class PoiService {
	
	@GET
    @Path("/test")
    @Produces("text/plain")
	public String teste() {
		return "Webservice online!";
	}
	
	@GET
    @Path("/get")
    @Produces("application/xml")
	public POIs getAll() {
		PoiDAO dao = new PoiDAO();
		
		return new POIs(dao.getAll());
	}
	
	@POST
    @Path("/insere/{nome}/x/{cordX}/y/{cordY}")
    @Produces("application/xml")
	public POIs inserePOI(@PathParam("nome") String nome,
			@PathParam("cordX") Integer cordX,
			@PathParam("cordY") Integer cordY) {
		PoiDAO dao = new PoiDAO();
		ArrayList<POI> result = new ArrayList<POI>();
		POI novo = (POI) dao.insert(new POI(nome, cordX, cordY));
		result.add(novo);
		
		return new POIs(result);
	}
	
	@DELETE
    @Path("/delete/{codigo}")
    @Produces("text/plain")
	public String deletePOI(@PathParam("codigo") Integer codigo) {
		PoiDAO dao = new PoiDAO();
		POI excluir = dao.getById(codigo);
		dao.delete(excluir);;
		
		return "Remoção feita com sucesso do POI: " + excluir.getNome();
	}
	
	@GET
    @Path("/get/{codigo}")
    @Produces("application/xml")
	public POIs getPoi(@PathParam("codigo") Integer codigo) {
		PoiDAO dao = new PoiDAO();
		ArrayList<POI> result = new ArrayList<POI>();
		result.add(dao.getById(codigo));
		
		return new POIs(result);
	}
	
	@GET
    @Path("/near/x/{cordX}/y/{cordY}/max/{distMax}")
    @Produces("application/xml")
	public POIs getPOIsByMaxDistance(@PathParam("cordX") Integer cordX,
			@PathParam("cordY") Integer cordY, @PathParam("distMax") Float distMax) {
		PoiDAO dao = new PoiDAO();
		ArrayList<POI> pois = dao.getAll();
		
		POI localAtual = new POI("Local", cordX, cordY);
		
		ArrayList<POI> result = new ArrayList<POI>();
		for (POI poi : pois) {
			if(POI.caldDist(localAtual, poi) <= distMax)
				result.add(poi);
		}
		
		return new POIs(result);
	}
	
}
