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
}
