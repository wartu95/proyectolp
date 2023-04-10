package interfaces;

import java.util.ArrayList;

import clases.Participante;

public interface ParticipanteInterfaceDAO {
	
	//REGISTRAR PARTICIPANTE
	int registrar(Participante p);
	
	//eliminar Participante
	public int eliminar(int idParticipante);
	
	//actualizar Participante
	public int actualizar(Participante u);
	
	//buscar Participante por codigo
	public Participante buscarParticipante(int idParticipante);
	
	//listar a los Participante
	public ArrayList<Participante> ListarParticipante();
	
	//buscarxtipo
	public Participante  buscarxIdParticipante(int idParticipante);
	

}
