package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Admin;
import utils.MySQLConexion8;

public class AdminDAO {

	public int registrarAdmin(Admin com) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "insert into tb_cep_pedido values (?,?,?,?,?,?,?)";
			pstm = con.prepareStatement(sql);

			
			pstm.setString(1, com.getCodContrato());
			pstm.setString(2, com.getCodAdmin());
			pstm.setString(3, com.getApellido());
			pstm.setString(4, com.getNombre());
			pstm.setString(5, com.getDni());
			pstm.setString(6, com.getArea());
			pstm.setString(7, com.getCargo());

			res = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en la instruccion 'ComiteDAO' " + e.getMessage());
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

	public int actualizarAdmin(Admin com) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "update tb_cep_pedido set nombre_miembroCEP = ?, apellido_miemborCEP = ?, dni_miembroCEP = ?, funcion_miembroCEP = ?, dependencia_miembroCEP = ?"
					+ "where id_ped = ? and id_miembroCEP = ? ";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, com.getCodContrato());
			pstm.setString(2, com.getCodAdmin());
			pstm.setString(3, com.getApellido());
			pstm.setString(4, com.getNombre());
			pstm.setString(5, com.getDni());
			pstm.setString(6, com.getArea());
			pstm.setString(7, com.getCargo());

			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en la instruccion" + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstm != null)
					pstm.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return res;
	}

	public int eliminarAdmin(String idContrato, String idAdmin) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "delete from tb_cep_pedido where id_ped = ? and id_miembroCEP = ?";
			pstm = con.prepareStatement(sql);

			pstm.setString(1, idContrato);
			pstm.setString(2, idAdmin);

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

	public ArrayList<Admin> listarAdmin() {
		ArrayList<Admin> list = new ArrayList<Admin>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_cep_pedido";
			pstm = con.prepareStatement(sql);
			res = pstm.executeQuery();

			while (res.next()) {
				Admin ad = new Admin(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
						res.getString(5), res.getString(6), res.getString(7));
				list.add(ad);
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

	public ArrayList<Admin> buscarXIdAdmin(String idAdmin) {
		ArrayList<Admin> list = new ArrayList<Admin>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_cep_pedido" + " where id_miembroCEP = ? ";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, idAdmin);
			res = pstm.executeQuery();

			while (res.next()) {
				Admin ad = new Admin(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
						res.getString(5), res.getString(6), res.getString(7));
				list.add(ad);
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
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return list;
	}

	public ArrayList<Admin> listarAdminXContrato(String idContrato) {
		ArrayList<Admin> list = new ArrayList<Admin>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_cep_pedido where id_ped = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, idContrato);
			res = pstm.executeQuery();

			while (res.next()) {
				Admin ad = new Admin(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
						res.getString(5), res.getString(6), res.getString(7));
				list.add(ad);
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
}
