package clases;

public class Contrato {

	private String idContrato;
	private int tiPoContrato;
	private int idParticipante;
	private String  fecha;
	private String Descripcion;
	private String Resulucion;
	private String Estado ;
	// INCIALIZAMOS ENTRADAS
	public Contrato() {
		
	}
	public Contrato(String idContrato, int tiPoContrato, int idParticipante, String fecha, String descripcion,
			String resulucion, String estado) {
	
		this.idContrato = idContrato;
		this.tiPoContrato = tiPoContrato;
		this.idParticipante = idParticipante;
		this.fecha = fecha;
		this.Descripcion = descripcion;
		this.Resulucion = resulucion;
		this.Estado = estado;
	}
	public String getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(String idContrato) {
		this.idContrato = idContrato;
	}
	public int getTiPoContrato() {
		return tiPoContrato;
	}
	public void setTiPoContrato(int tiPoContrato) {
		this.tiPoContrato = tiPoContrato;
	}
	public int getIdParticipante() {
		return idParticipante;
	}
	public void setIdParticipante(int idParticipante) {
		this.idParticipante = idParticipante;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getResulucion() {
		return Resulucion;
	}
	public void setResulucion(String resulucion) {
		Resulucion = resulucion;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	
	
	
}
