package clase;

import java.util.Date;

public class Comprobante {
	private String idVenta;
	private String idCliente;
	private Date fechaVenc;
	private double total;
	//
	public Comprobante () {}
	
	public Comprobante(String idVenta, String idCliente, Date fechaVenc, double total) {
		super();
		this.idVenta = idVenta;
		this.idCliente = idCliente;
		this.fechaVenc = fechaVenc;
		this.total = total;
	}
	//
	public String getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(String idVenta) {
		this.idVenta = idVenta;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public Date getFechaVenc() {
		return fechaVenc;
	}
	public void setFechaVenc(Date fechaVenc) {
		this.fechaVenc = fechaVenc;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
}
