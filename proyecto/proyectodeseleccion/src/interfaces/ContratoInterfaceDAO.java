package interfaces;

import java.util.ArrayList;

import clases.Contrato;

public interface ContratoInterfaceDAO {
	//registrar contrato
		public int registrar (Contrato cont);
	//actualizar contrato 
		public int actualizarContrato(Contrato cont);
	//eliminar contrato
		public int eliminarContrato(String idContrato);
	//lista de contratos
		public ArrayList<Contrato> listarContrato();
    //lista de contratos por participantes
		public ArrayList <Contrato> listarContratoConParticipantes ();
    //cod de contrato
		public String codContrato();
		
	// 	lista de contractos por fecha
		public ArrayList<Contrato> listarContratoxFecha(String fech);
}
