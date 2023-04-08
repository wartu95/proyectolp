package interfaces;

import clases.Usuario;

public interface UsuarioInterfaceDAO {
  
	//registrar usuario
	public int registrar(Usuario u);
	
	//validar el accesp al sistema
	public Usuario ValidarAcceso(String user, String clave);
}
