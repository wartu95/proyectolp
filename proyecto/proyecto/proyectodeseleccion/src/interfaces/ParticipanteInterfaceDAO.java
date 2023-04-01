package interfaces;

import java.util.ArrayList;

import clases.Participante;

public interface ParticipanteInterfaceDAO {
	
	int registrar(Participante p);
	
	//REGISTRAR USUARIO
	
	//eliminar Participante
	public int eliminar(int idParticipante);
	
	//actualizar Participante
	public int actualizar(Participante u);
	
	//buscar Participante por codigo
	public Participante buscarParticipante(int idParticipante);
	
	//listar a los Participante
	public ArrayList<Participante> ListarParticipante();
	

}
