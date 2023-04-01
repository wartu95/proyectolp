package clases;

public class Participante {

	private int idParticipante;
	private String Apellido;
	private String Nombre;
	private String Dni;
	private int Telefono;
	private String Correo;
	
	
	
	public Participante() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Participante(int idParticipante, String apellido, String nombre, String dni, int telefono, String correo) {
		super();
		this.idParticipante = idParticipante;
		Apellido = apellido;
		Nombre = nombre;
		Dni = dni;
		Telefono = telefono;
		Correo = correo;
	}



	public int getIdParticipante() {
		return idParticipante;
	}



	public void setIdParticipante(int idParticipante) {
		this.idParticipante = idParticipante;
	}



	public String getApellido() {
		return Apellido;
	}



	public void setApellido(String apellido) {
		Apellido = apellido;
	}



	public String getNombre() {
		return Nombre;
	}



	public void setNombre(String nombre) {
		Nombre = nombre;
	}



	public String getDni() {
		return Dni;
	}



	public void setDni(String dni) {
		Dni = dni;
	}



	public int getTelefono() {
		return Telefono;
	}



	public void setTelefono(int telefono) {
		Telefono = telefono;
	}



	public String getCorreo() {
		return Correo;
	}



	public void setCorreo(String correo) {
		Correo = correo;
	}
	
	
	
}
	