package interfaces;

import java.util.ArrayList;

import clases.Usuario;

public interface UsuarioInterfaceDAO {
  
	//registrar usuario
	public int registrar(Usuario u);
	
	//eliminar usuario
	public int eliminar(String usuario);
	
	//actualizar usuario
	public int actualizar(Usuario u);
	
	//buscar Usuario por codigo
	public Usuario buscarUsuario(String usuario);
	//listar a los usuarios
	public ArrayList<Usuario> listarUsuarios();
	//listar usuario por tipo
	
	
	//validar el accesp al sistema
	public Usuario ValidarAcceso(String user, String clave);
	
	//
}
