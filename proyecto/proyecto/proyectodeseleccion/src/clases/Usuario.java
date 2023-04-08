package clases;

public class Usuario {
// 
	private String usuario;
	private String clave;
	private String nombre;
	private String apellido;
	private int cargo;
	private int Perfil;
	
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Usuario(String usuario, String clave, String nombre, String apellido, int cargo, int perfil) {
		super();
		this.usuario = usuario;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cargo = cargo;
		Perfil = perfil;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getCargo() {
		return cargo;
	}


	public void setCargo(int cargo) {
		this.cargo = cargo;
	}


	public int getPerfil() {
		return Perfil;
	}


	public void setPerfil(int perfil) {
		Perfil = perfil;
	}
	
	
}
	
