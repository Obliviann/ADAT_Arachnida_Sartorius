package model;
//1. solo habrá statics en el main
//2. accedo a todos los obj con métodos (i.e. getters y setters) no con obj.propiedad
//3. todos los att de una clase son privados ECAPSULACIÓN Y OCULTAMIENTO

public class Arachnida {

	private int id;
	private String order; 	//Araneae
	private String suborder;//Mesothelae & Opisthothelae
	private String infraorder; 			// Mygalomorphae & Araneomorphae
										// vertical fangs	fangs like pincers
	public Arachnida() {
		
	}
	
	public Arachnida(int id, String order, String suborder, String infraorder) {
		this.id = id;
		this.order = order;
		this.suborder = suborder;
		this.infraorder = infraorder;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSuborder() {
		return suborder;
	}

	public void setSuborder(String suborder) {
		this.suborder = suborder;
	}

	public String getInfraorder() {
		return infraorder;
	}

	public void setInfraorder(String infraorder) {
		this.infraorder = infraorder;
	}

	//Para comprobar:
	@Override
	public String toString() {
		return "Arachnida [id=" + id + ", order=" + order + ", suborder=" + suborder + ", infraorder=" + infraorder+ "]";
	}

}
