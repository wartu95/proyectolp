package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping;

import java.sql.ResultSet;

import clases.Usuario;
import interfaces.UsuarioInterfaceDAO;
import utils.MySQLConexion8;

public class GestionUsuarioDAO implements UsuarioInterfaceDAO {

	private Usuario user;

	@Override
	public int registrar(Usuario u) {

		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null; // ejecutar la instucciones SQL
		try {

			con = MySQLConexion8.getConexion();

			String sql = "insert into tb_usuario values (?,?,?,?,?,null);";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, u.getUsuario());
			pstm.setString(2, u.getClave());
			pstm.setString(3, u.getNombre());
			pstm.setString(4, u.getApellido());
			pstm.setInt(5, u.getCargo());
			

			// paso 5:ejecutar la instruccion SQL
			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("ERROR EN LA INSTRUCCION DE LA BD" + e.getMessage());
		} finally {
			try {

				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();

			} catch (SQLException e2) {
				System.out.println("ERROR AL CERRAR LAS CONEXIONES" + e2.getMessage());

			}
		}

		return res;
	}

	@Override
	public Usuario ValidarAcceso(String user, String clave) {
		Usuario usuario = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			// Paso1 --> conectar a la BD
			con = MySQLConexion8.getConexion();
			// Paso2 --> Establecer la instruccion SQL - consulta de usuario por codigo
			String sql = "{call ups_validarAcceso(?,?)}";
			// Paso3 --> Enviar la instruccion SQL al objeto pstm
			pstm = con.prepareStatement(sql);
			// Paso4 --> parametros
			pstm.setString(1, user);
			pstm.setString(2, clave);
			// Paso5 --> ejecutar la cosulta
			res = pstm.executeQuery();
			// Paso6 --> Setear lo valores
			if (res.next()) {
				usuario = new Usuario(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
						res.getInt(5), res.getInt(6));
			}
		} catch (Exception e) {
			System.out.println("Erro en la consulta de validacion" + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (res != null)
					res.close();
				if (con != null)
					con.close();

			} catch (SQLException e2) {
				System.out.println("Erro al cerrar la base de datos");
			}
		}
		return usuario;
	}

	@Override
	public int eliminar(String usuario) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			// paso 1 --> conexion a la base de datos
			con = MySQLConexion8.getConexion();
			// paso 2 --->establecer la instruccion SQL - ELIMINAR
			String sql = "delete from tb_usuario where id_usuario = ?";
			// paso 3 --> enviar la instruccion al objeto pstm --> para obtener los comandos
			// SQL
			pstm = con.prepareStatement(sql);
			// paso 4 --> obtener los parametro
			pstm.setString(1, usuario);
			// paso 5 ---> ejecutar la instruccion SQL
			res = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en la instruccin SQL - eliminar" + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();

			} catch (Exception e2) {
				System.out.println("Erro al cerrar la base de datos" + e2.getMessage());
			}
		}
		return res;
	}

	@Override
	public int actualizar(Usuario u) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			// paso 1 --> conexion a la base de datos
			con = MySQLConexion8.getConexion();
			// paso 2 --->establecer la instruccion SQL
			String sql = "update tb_usuario set contraseña = ?, nombre = ?, apelido = ? where id_usuario = ? ";
			// paso 3 --> enviar la instruccion al objeto pstm --> para obtener los comandos
			// SQL
			// SQL
			pstm = con.prepareStatement(sql);
			// paso 4 --> obtener los parametro e
			pstm.setString(1, u.getNombre());
			pstm.setString(2, u.getApellido());
			pstm.setString(3, u.getClave());
			pstm.setString(4, u.getUsuario());
			// paso 5 ---> ejecutar la instruccion SQL
			res = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en la instruccion SQL - Actualizar" + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();

			} catch (SQLException e2) {
				System.out.println("Error al cerra la base de datos" + e2.getMessage());
			}
		}
		return res;
	}

	@Override
	public Usuario buscarUsuario(String usuario) {
		Usuario user = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			// Paso1 --> conectar a la BD
			con = MySQLConexion8.getConexion();
			// Paso2 --> Establecer la instruccion SQL - consulta de usuario por codigo
			String sql = "select * from tb_usuario where id_usuario = ?";
			// Paso3 --> Enviar la instruccion SQL al objeto pstm
			pstm = con.prepareStatement(sql);
			// Paso4 --> parametros
			pstm.setString(1, usuario);
			// Paso5 --> ejecutar la cosulta
			res = pstm.executeQuery();
			// Paso6 --> Setear lo valores
			if (res.next()) {
				user = new Usuario(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
						res.getInt(5), res.getInt(6));
			}

		} catch (Exception e) {
			System.out.println("Erro en la consulta de b�squedad" + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (res != null)
					res.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				System.out.println("Erro al cerrar la base de datos");
			}
		}
		return user;
	}

	@Override
	public ArrayList<Usuario> listarUsuarios() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();// NULL
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Usuario user = null;
		try {
			// Paso1 --> conectar a la BD
			con = MySQLConexion8.getConexion();
			// Paso2 --> Establecer la instruccion SQL - consulta de usuario por codigo
			String sql = "select * from tb_usuario";
			// Paso3 --> Enviar la instruccion SQL al objeto pstm
			pstm = con.prepareStatement(sql);
			// Paso4 --> parametros -- no hay

			// Paso5 --> ejecutar la cosulta
			res = pstm.executeQuery();
			// Paso6 --> Setear lo valores
			while (res.next()) {
				// CREAR UN OBJETO DE TIPO "USUARIO"
				user = new Usuario();
				// SETEAR/ASIGNAR LOS VALORES A LOS ATRIBUTOS PRIVADOS
				user.setUsuario(res.getString(1));
				user.setClave(res.getString(2));
				user.setNombre(res.getNString(3));
				user.setApellido(res.getString(4));
				user.setCargo(res.getInt(5));
				user.setPerfil(res.getInt(6));
				// paso7 --> A�adir el usuario a la lista
				lista.add(user);
			}
		} catch (Exception e) {
			System.out.println("Erro en la instruccion SQL - LISTAR USUARIOS" + e.getMessage());

		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (res != null)
					res.close();
				if (con != null)
					con.close();

			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}

		return lista;
	}

}
