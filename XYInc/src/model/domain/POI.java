package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "POI")
public class POI implements Entidade {
	
	private Integer id;
	private String nome;
	private Integer cordX;
	private Integer cordY;

	public POI() {
		super();
	}
	
	public POI(String nome, Integer x, Integer y) {
		super();
		
		this.nome = nome;
		this.cordX = x;
		this.cordY = y;
	}
	
	@XmlElement
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@XmlElement
	@Column(name = "NOME")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@XmlElement
	@Column(name = "CORD_X")
	public Integer getCordX() {
		return cordX;
	}
	public void setCordX(Integer cordX) {
		this.cordX = cordX;
	}
	
	@XmlElement
	@Column(name = "CORD_Y")
	public Integer getCordY() {
		return cordY;
	}
	public void setCordY(Integer cordY) {
		this.cordY = cordY;
	}
	
	/*
	 * Calcula via distancia Euclidiana a distancia entre dois Pontos de Interesse
	 */
	public static Float caldDist(POI poi1, POI poi2) {
		// Subtração cord x
		float aux1 = ((float)poi1.getCordX()) - ((float)poi2.getCordX());
		// Quadrado da subtração de x
		aux1 = (float)Math.pow(aux1, 2);
		
		// Subtração cord y
		float aux2 = ((float)poi1.getCordY()) - ((float)poi2.getCordY());
		// Quadrado da subtração de y
		aux2 = (float)Math.pow(aux2, 2);
		
		// Raiz quadrada da soma do quadrado das subtrações das coordenadas
		float result = (float) Math.sqrt(aux1 + aux2);
		
		return result;
	}
	
}
