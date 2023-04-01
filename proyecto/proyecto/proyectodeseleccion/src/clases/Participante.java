package clases;

public class Participante {

	private String idContrato;
	private String idParticipante;
	private String apellido;
	private String nombre;
	private String Dni;
	private int telefono;
	private String direccion;
	private String  correo;
	private String  fecha;
	private String estado;
	
	public Participante() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Participante(String idContrato, String idParticipante, String apellido, String nombre,String Dni, int telefono,
			String direccion, String correo, String fecha, String estado) {
		super();
		this.idContrato = idContrato;
		this.idParticipante = idParticipante;
		this.apellido = apellido;
		this.nombre = nombre;
		this.Dni = Dni;
		this.telefono = telefono;
		this.direccion = direccion;
		this.correo = correo;
		this.fecha = fecha;
		this.estado = estado;
	}
	
	public String getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(String idContrato) {
		this.idContrato = idContrato;
	}
	
	public String getIdParticipante() {
		return idParticipante;
	}
	public void setIdParticipante(String idParticipante) {
		this.idParticipante = idParticipante;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
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
	public String getDni() {
		return Dni;
	}
	public void setDni(String dni) {
		this.Dni = dni;
	}

	
	}


	