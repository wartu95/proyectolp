package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Participante;
import interfaces.ParticipanteInterfaceDAO;
import utils.MySQLConexion8;

public class ParticipanteDAO implements ParticipanteInterfaceDAO {



	@Override
	public int registrar(Participante p) {
		// declaracion de variables
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null; // ejecutar la instruccion SQL
		try {
			// Paso1 = Establecer la conexion con la BD
			con = MySQLConexion8.getConexion();
			// Paso 2 : Establecer la instruccion SQL -- Registrar

			String sql = "insert into tb_paciente values (?,?,?,?,?,?);";
			// paso 3 : Crear el objeto pstm y enviar la variable sql
			pstm = con.prepareStatement(sql); // obtener comandos SQL
			// paso 4 obtener los parametros para la instruccion SQL
			pstm.setInt(1, p.getIdParticipante());
			pstm.setString(2, p.getApellido());
			pstm.setString(3, p.getNombre());
			pstm.setString(4, p.getDni());
			pstm.setString(5, p.getTelefono());
			pstm.setString(6, p.getCorreo());

			// paso 5 : ejecutar la instruccion SQL
			res = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println(">>>>>> Error en la instruccion SQL - registrar " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				System.out.println("\">>>>>> Error al cerrar la base de datos " + e2.getMessage());
			}
		}
		return res;
	}

	@Override
	public int eliminar(int idParticipante) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			// paso1 --> conecxion a la base de datos
			con = MySQLConexion8.getConexion();
			// paso 2 -->> establecer la instrucccion SQL- PARA ELIMINAR
			String sql = "delete from tb_paciente where codigo = ?";
			// PASO 3 --> enviar la instruccion al objeto pstm -->obtener los comandos sql
			pstm = con.prepareStatement(sql);
			// paso 4 --> obtener el parametro
			pstm.setInt(1, idParticipante);
			// paso 5 --> ejecutar la instruccion SQL
			res = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en la instruccion SQL - Eliminar" + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base datos" + e2.getMessage());

			}
		}

		return res;
	}

	@Override
	public int actualizar(Participante u) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			// paso 1 --> conexion a la base de datos
			con = MySQLConexion8.getConexion();

			// paso2 .--> establecer la instruccion SQL
			String sql = "update tb_paciente set nombre = ?,apellido = ?,dni = ?,fecha_nac = ? ,edad = ? where codigo = ?";

			// paso 3 --> enviar la instruccion SQL al objeto "pstm" para obtner los
			// comandos SQL
			pstm = con.prepareStatement(sql);

			// PASO 4 --> obtener los parametros
			pstm.setInt(1, u.getIdParticipante());
			pstm.setString(2, u.getApellido());
			pstm.setString(3, u.getNombre());
			pstm.setString(4, u.getDni());
			pstm.setString(5, u.getTelefono());
			pstm.setString(6, u.getCorreo());

			// paso 5 --> ejecutar la instruccion SQL
			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("Erro en la instruccion SQL-Actualizar" + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();

			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return res;
	}

	@Override
	public Participante buscarParticipante(int idParticipante) {
		Participante par = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;

		try {

			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_paciente where codigo = ?;";

			pstm = con.prepareStatement(sql);

			pstm.setInt(1, idParticipante);

			res = pstm.executeQuery();

			if (res.next()) {
				par = new Participante(res.getInt(1), res.getString(2), res.getString(3), res.getString(4),
						res.getString(5), res.getString(6));

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return par;
	}

	@Override
	public ArrayList<Participante> ListarParticipante() {
		ArrayList<Participante> lista = new ArrayList<Participante>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Participante par = null;
		try {
			// paso 1 --> conectar a la base de datos
			con = MySQLConexion8.getConexion();
			// paso -->> establecer la instruccion SQL -- este caso es una consulta a
			// tb_usuarios
			String sql = "select * from tb_paciente;";
			// paso3 --> Enviar la instruccion sql al objeto ""pstm"
			pstm = con.prepareStatement(sql);
			// paso4 --> parametros

			// paso5 --> ejecutar la instruccion SQL
			res = pstm.executeQuery();
			// paso6 --> bluce para realizar el recorrido al opbjeto "res"
			while (res.next()) {
				// crear un objeto de tipo "Usuario"
				par = new Participante();
				// setear(asignar los valores a los atributos privados)

				par.setIdParticipante(res.getInt(1));
				par.setApellido(res.getString(2));
				par.setNombre(res.getString(3));
				par.setDni(res.getString(4));
				par.setTelefono(res.getString(5));
				par.setCorreo(res.getString(6));

				// paso7 --> añadir el usuario a la lista

				lista.add(par);
			}

		} catch (Exception e) {
			System.out.println("Error en la instruccion SQL -LISTAR PARTICIPANTE" + e.getMessage());
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

	public Participante buscarXIdParticipante(int idParticipante) {

		Participante part = null;

		Connection con = null;
		PreparedStatement pstm = null;

		ResultSet res = null;

		try {

			con = MySQLConexion8.getConexion();

			String sql = "select * from tb_participante" + " where codigo_parti = ?";

			pstm = con.prepareStatement(sql);

			pstm.setInt(1, idParticipante);

			res = pstm.executeQuery();

			while (res.next()) {
				part = new Participante(res.getInt(1), 
						res.getString(2), res.getString(3),
						res.getString(4),
						res.getString(5),
						res.getString(6)
				);

			}

		} catch (Exception e) {
			System.out.println("Error en la instruccion" + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstm != null)
					pstm.close();
				if (res != null)
					res.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la base de datos" + e.getMessage());
			}
		}

		return part;

	}

	@Override
	public Participante buscarxIdParticipante(int idParticipante) {
		// TODO Auto-generated method stub
		return null;
	}

}
