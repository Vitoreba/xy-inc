package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.domain.POI;
import model.domain.POIs;

public class TestePOI {

	private static int HTTP_COD_SUCESSO = 200;
	 
    @SuppressWarnings("null")
	public static void main(String[] args) throws JAXBException {
 
        try {
        	URL url = null;
            HttpURLConnection con = null;
            
            int metodo = 2;
            switch(metodo) {
            	case 1:
            		url = new URL("http://localhost:8080/XYInc/poi/insere/Local/x/25/y/42");
            		con = (HttpURLConnection) url.openConnection();
            		con.setRequestMethod("POST");
            		con.setRequestProperty("Accept", "application/xml");
            		break;
            		
            	case 2:
            		url = new URL("http://localhost:8080/XYInc/poi/near/x/20/y/10/max/10");
            		con = (HttpURLConnection) url.openConnection();
            		con.setRequestMethod("GET");
            		con.setRequestProperty("Accept", "application/xml");
            		break;
            		
            	default:
            		url = new URL("http://localhost:8080/XYInc/poi/get");
            		con = (HttpURLConnection) url.openConnection();
            		con.setRequestMethod("GET");
            		con.setRequestProperty("Accept", "application/xml");
            		break;
            }
 
            if (con.getResponseCode() != HTTP_COD_SUCESSO) {
                throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
            }
 
            BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
                         
            JAXBContext jaxbContext = JAXBContext.newInstance(POIs.class);
 
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            POIs poiList = (POIs) jaxbUnmarshaller.unmarshal(br);
            
            int count = 1;
            for (POI poi : poiList.getPoiList()) {
                System.out.println("POI " + count + ": "+ poi.getNome() +" <"+ poi.getCordX() + ", " + poi.getCordY() + ">");
                count++;    
            }
 
            con.disconnect();
 
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
