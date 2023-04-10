package clases;

public class Perfil {

	// INCIALIZAMOS ENTRADAS
	private int idperfil;
	private String descipPerfil;
	//
	public Perfil() {
		
	}
	public Perfil(int idperfil, String descipPerfil) {
		super();
		this.idperfil = idperfil;
		this.descipPerfil = descipPerfil;
	}
	public int getIdperfil() {
		return idperfil;
	}
	public void setIdperfil(int idperfil) {
		this.idperfil = idperfil;
	}
	public String getDescipPerfil() {
		return descipPerfil;
	}
	public void setDescipPerfil(String descipPerfil) {
		this.descipPerfil = descipPerfil;
	}
	

}
