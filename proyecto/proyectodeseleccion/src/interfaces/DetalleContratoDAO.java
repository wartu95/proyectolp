package interfaces;

import java.util.ArrayList;

import clases.DetalleContrato;

public interface DetalleContratoDAO {

	//DEDATELLE CONTRATO
	public ArrayList<DetalleContrato> ListarDestalleContratoPorIdContrato(String id_contrato);
	
}
