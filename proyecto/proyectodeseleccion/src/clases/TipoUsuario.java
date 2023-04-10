package clases;

public class TipoUsuario {

	// atributos privados
	private int idcargo;
	private String descripCargo;

	// constructores
	public TipoUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoUsuario(int idcargo, String descripCargo) {
		super();
		this.idcargo = idcargo;
		this.descripCargo = descripCargo;
	}

	public int getIdcargo() {
		return idcargo;
	}

	public void setIdcargo(int idcargo) {
		this.idcargo = idcargo;
	}

	public String getDescripCargo() {
		return descripCargo;
	}

	public void setDescripCargo(String descripCargo) {
		this.descripCargo = descripCargo;
	}
}
