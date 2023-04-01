package clases;

public class Usuario {
// 
	private String idUsuario;
	private String Contrasena;
	private String Nombre;
	private String Apellido;
	private int idCargo;
	private int idPerfil;
	//
	public Usuario() {
	
	}
	public Usuario(String idUsuario, String contrasena, String nombre, String apellido, int idCargo, int idPerfil){
		super();
		this.idUsuario = idUsuario;
		this.Contrasena = contrasena;
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
	public String getContrase() {
		return Contrasena;
	}
	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
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
