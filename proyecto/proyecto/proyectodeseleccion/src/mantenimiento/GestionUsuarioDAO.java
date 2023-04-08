package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

			String sql = " insert into tb_usuarios values(?,?,?,?,?,default,default)";

			pstm = con.prepareStatement(sql);

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

}
