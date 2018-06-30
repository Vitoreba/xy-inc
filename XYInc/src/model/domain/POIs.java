package model.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * Container for multiple POI
 */

@XmlRootElement(name="root")
public class POIs {

	public POIs() {
		super();
	}
	
	public POIs(List<POI> pois) {
		super();
		
		this.poiList = pois;
	}
	
	private List<POI> poiList;
	
	@XmlElement(name="poi")
	@XmlElementWrapper(name="poi-list")
	public List<POI> getPoiList() {
		return poiList;
	}
	public void setPoiList(List<POI> poiList) {
		this.poiList = poiList;
	}
	
	
	
}
