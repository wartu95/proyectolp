package clases;

public class Observacion {

	// INCIALIZAMOS ENTRADAS
	private String codcontrato;
	private String codobservacion;
	private String fecha;
	private String descripcion;
	private String estado;

	public Observacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Observacion(String codcontrato, String codobservacion, String fecha, String descripcion, String estado) {
		super();
		this.codcontrato = codcontrato;
		this.codobservacion = codobservacion;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public String getCodcontrato() {
		return codcontrato;
	}

	public void setCodcontrato(String codcontrato) {
		this.codcontrato = codcontrato;
	}

	public String getCodobservacion() {
		return codobservacion;
	}

	public void setCodobservacion(String codobservacion) {
		this.codobservacion = codobservacion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
