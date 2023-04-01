package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.*;
import utils.MySQLConexion8;

public class ParticipanteDAO {

	public int registrarParticipante(Participante part) {

		int res = 0;

		Connection con = null;
		PreparedStatement pstm = null;

		try {

			con = MySQLConexion8.getConexion();

			String sql = "insert into tb_participante values (?,?,?,?,?,?,?)";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, part.getIdContrato());
			pstm.setString(2, part.getIdParticipante());
			pstm.setString(3, part.getApellido());
			pstm.setString(4, part.getNombre());
			pstm.setString(5, part.getDni());
			pstm.setInt(6, part.getTelefono());
			pstm.setString(7, part.getDireccion());
			pstm.setString(8, part.getCorreo());
			pstm.setString(9, part.getFecha());
			pstm.setString(10, part.getEstado());

			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en la instruccion" + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstm != null)
					pstm.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la base de datos" + e.getMessage());
			}
		}

		return res;

	}

	public int actualizarPartcipante(Participante part) {
		int res = 0;

		Connection con = null;
		PreparedStatement pstm = null;

		try {

			con = MySQLConexion8.getConexion();

			String sql = "update tb_participante" + " set empresa_parti = ?,"
					+ "ruc_parti=?, correo_parti = ?, telefono_parti=?," + " estado_parti=?"
					+ "where id_ped = ? and codigo_parti = ? ";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, part.getIdContrato());
			pstm.setString(2, part.getIdParticipante());
			pstm.setString(3, part.getApellido());
			pstm.setString(4, part.getNombre());
			pstm.setString(5, part.getDni());
			pstm.setInt(6, part.getTelefono());
			pstm.setString(7, part.getDireccion());
			pstm.setString(8, part.getCorreo());
			pstm.setString(9, part.getFecha());
			pstm.setString(10, part.getEstado());

			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en la instruccion" + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstm != null)
					pstm.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la base de datos" + e.getMessage());
			}
		}

		return res;
	}

	public int eliminarParticipante(String idContrato, String idParticipante) {
		int res = 0;

		Connection con = null;
		PreparedStatement pstm = null;

		try {

			con = MySQLConexion8.getConexion();

			String sql = "delete from tb_participante where id_ped = ? and codigo_parti = ?";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, idContrato);
			pstm.setString(2, idParticipante);

			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en la instruccion" + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstm != null)
					pstm.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la base de datos" + e.getMessage());
			}
		}

		return res;
	}

	public ArrayList<Participante> listarParticipante() {
		ArrayList<Participante> list = new ArrayList<Participante>();
		;

		Connection con = null;
		PreparedStatement pstm = null;

		ResultSet res = null;

		try {

			con = MySQLConexion8.getConexion();

			String sql = "select * from tb_participante group by codigo_parti";

			pstm = con.prepareStatement(sql);

			res = pstm.executeQuery();

			while (res.next()) {
				Participante cont = new Participante(res.getString(1), res.getString(2), res.getString(3),
						res.getString(4), res.getString(5), res.getInt(6), res.getString(7),res.getString(8),
						res.getString(9),res.getString(10)

				);

				list.add(cont);
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

		return list;
	}

	// Varios participante dentro de un pedido por eso un array list

	public ArrayList<Participante> buscarXPedido(String id_cont) {

		ArrayList<Participante> list = new ArrayList<Participante>();

		Connection con = null;
		PreparedStatement pstm = null;

		ResultSet res = null;

		try {

			con = MySQLConexion8.getConexion();

			String sql = "select * from tb_participante" + " where id_ped = ?";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, id_cont);

			res = pstm.executeQuery();

			while (res.next()) {
				Participante cont = new Participante(res.getString(1), res.getString(2), res.getString(3),
						res.getString(4), res.getString(5), res.getInt(6), res.getString(7),res.getString(8),
						res.getString(9),res.getString(10)

				);

				list.add(cont);
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

		return list;

	}

	// Un participante por cada ID por eso solo un objeto del tipo participante

	public Participante buscarXIdParticipante(String idParticipante) {

		Participante part = null;

		Connection con = null;
		PreparedStatement pstm = null;

		ResultSet res = null;

		try {

			con = MySQLConexion8.getConexion();

			String sql = "select * from tb_participante" + " where codigo_parti = ?";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, idParticipante);

			res = pstm.executeQuery();

			while (res.next()) {
				part = new Participante(res.getString(1), res.getString(2), res.getString(3),
						res.getString(4), res.getString(5), res.getInt(6), res.getString(7),res.getString(8),
						res.getString(9),res.getString(10)

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

}
