package clases;

public class Participante {

	private int idParticipante;
	private String Apellido;
	private String Nombre;
	private String Dni;
	private int Felefono;
	private String Correo;
	//
	public Participante() {
		
	}
	public Participante(int idParticipante, String apellido, String nombre, String dni, int felefono, String correo) {
		super();
		this.idParticipante = idParticipante;
		this.Apellido = apellido;
		this.Nombre = nombre;
		this.Dni = dni;
		this.Felefono = felefono;
		this.Correo = correo;
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
	public int getFelefono() {
		return Felefono;
	}
	public void setFelefono(int felefono) {
		Felefono = felefono;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}

}
	