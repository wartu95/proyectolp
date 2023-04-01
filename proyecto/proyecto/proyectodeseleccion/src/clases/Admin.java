package clases;

public class Admin {

	// INCIALIZAMOS ENTRADAS
	
	private String codContrato;
	private String codAdmin;
	private String apellido;
	private String nombre;
	private String area;
	private String dni;
	private String cargo;

	// CONSTRUCTOR
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String codContrato, String codAdmin, String apellido, String nombre, String area, String dni,
			String cargo) {
		super();
		this.codContrato = codContrato;
		this.codAdmin = codAdmin;
		this.apellido = apellido;
		this.nombre = nombre;
		this.area = area;
		this.dni = dni;
		this.cargo = cargo;
	}

	public String getCodContrato() {
		return codContrato;
	}

	public void setCodContrato(String codContrato) {
		this.codContrato = codContrato;
	}

	public String getCodAdmin() {
		return codAdmin;
	}

	public void setCodAdmin(String codAdmin) {
		this.codAdmin = codAdmin;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	
}
