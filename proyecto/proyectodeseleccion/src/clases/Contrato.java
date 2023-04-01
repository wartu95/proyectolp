package clases;

public class Contrato {

	private String codigo;
	private String entidad;
	private String ruc;
	private int tipo;
	private int objeto;
	private String descripcion;
	private String  fecha;
	private String estado;
	

	public Contrato(String codigo, String entidad, String ruc, int tipo, int objeto, String descripcion,
			String fecha, String estado) {
		super();
		this.codigo = codigo;
		this.entidad = entidad;
		this.ruc = ruc;
		this.tipo = tipo;
		this.objeto = objeto;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.estado = estado;
	}

	public Contrato() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getObjeto() {
		return objeto;
	}

	public void setObjeto(int objeto) {
		this.objeto = objeto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
