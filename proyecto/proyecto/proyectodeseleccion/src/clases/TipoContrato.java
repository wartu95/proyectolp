package clases;

public class TipoContrato {
   // 
	private int idTipoContrato;
	private String descripTipo;
	//
	public TipoContrato() {
		
	}
	public TipoContrato(int idTipoContrato, String descripTipo) {
		super();
		this.idTipoContrato = idTipoContrato;
		this.descripTipo = descripTipo;
	}
	//get / set
	public int getIdTipoContrato() {
		return idTipoContrato;
	}
	public void setIdTipoContrato(int idTipoContrato) {
		this.idTipoContrato = idTipoContrato;
	}
	public String getDescripTipo() {
		return descripTipo;
	}
	public void setDescripTipo(String descripTipo) {
		this.descripTipo = descripTipo;
	}
	
}
