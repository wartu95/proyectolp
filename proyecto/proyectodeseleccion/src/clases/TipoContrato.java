package clases;

public class TipoContrato {

	private int idTipoContrato;
	private String desTipoContrato;

	public TipoContrato(int idTipoContrato, String desTipoContrato) {
		
		this.idTipoContrato = idTipoContrato;
		this.desTipoContrato = desTipoContrato;
	}

	public int getIdTipoContrato() {
		return idTipoContrato;
	}

	public void setIdTipoContrato(int idTipoContrato) {
		this.idTipoContrato = idTipoContrato;
	}

	public String getDesTipoContrato() {
		return desTipoContrato;
	}

	public void setDesTipoContrato(String desTipoContrato) {
		this.desTipoContrato = desTipoContrato;
	}

}
