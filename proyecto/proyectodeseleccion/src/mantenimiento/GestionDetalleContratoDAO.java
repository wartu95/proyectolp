package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.DetalleContrato;
import interfaces.DetalleContratoDAO;
import utils.MySQLConexion8;

public class GestionDetalleContratoDAO implements DetalleContratoDAO {

	@Override
	public ArrayList<DetalleContrato> ListarDestalleContratoPorIdContrato(String id_contrato) {
		ArrayList<DetalleContrato> lista = new ArrayList<DetalleContrato>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		DetalleContrato detC = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_detallecontrato where id_contrato = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id_contrato);
			res = pstm.executeQuery();
			while (res.next()) {
				detC = new DetalleContrato();

				detC.setIdContrato(res.getString(1));
				detC.setIdVisado(res.getInt(2));
				detC.setIdUsuario(res.getString(3));
				detC.setEstado(res.getString(4));

				lista.add(detC);
			}

		} catch (SQLException e) {
			System.out.println("Error en la operacion de SQL " + e.getMessage());
		}

		return lista;
	}

}
