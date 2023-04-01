package clases;

public class DetalleContrato {
	//
	private String idContrato;
	private int idVisado;
	private String idUsuario;
	private String Estado;
	//
	public DetalleContrato() {
		
	}
	public DetalleContrato(String idContrato, int idVisado, String idUsuario, String estado) {
		super();
		this.idContrato = idContrato;
		this.idVisado = idVisado;
		this.idUsuario = idUsuario;
		this.Estado = estado;
	}
	// get - set
	public String getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(String idContrato) {
		this.idContrato = idContrato;
	}
	public int getIdVisado() {
		return idVisado;
	}
	public void setIdVisado(int idVisado) {
		this.idVisado = idVisado;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	
	
	
}
