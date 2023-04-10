package clases;

public class Cargo {

	// INCIALIZAMOS ENTRADAS
	
	private int idCargo;
	private String descripCargo;
	
	// CONSTRUCTOR
	public Cargo() {
		
	}
	public Cargo(int idCargo, String descripCargo) {
		super();
		this.idCargo = idCargo;
		this.descripCargo = descripCargo;
		
		//set - get
	}
	public int getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}
	public String getDescripCargo() {
		return descripCargo;
	}
	public void setDescripCargo(String descripCargo) {
		this.descripCargo = descripCargo;
	}
	
	//set - get
	
}