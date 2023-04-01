package clases;

public class Usuario {
// 
	private String idUsuario;
	private String Contraseña;
	private String Nombre;
	private String Apellido;
	private int idCargo;
	private int idPerfil;
	//
	public Usuario() {
	
	}
	public Usuario(String idUsuario, String contraseña, String nombre, String apellido, int idCargo, int idPerfil) {
		super();
		this.idUsuario = idUsuario;
		this.Contraseña = contraseña;
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.idCargo = idCargo;
		this.idPerfil = idPerfil;
	}
	//get set
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getContraseña() {
		return Contraseña;
	}
	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public int getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}
	public int getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
	
}
